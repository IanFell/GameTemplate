package input.computer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.mygame.MyGame;

import controllers.GameStateController;
import controllers.PlayerController;
import gameobjects.GameObject;
import gameobjects.gamecharacters.Player;
import helpers.GameAttributeHelper;
import loaders.GameObjectLoader;
import screens.GameScreen;
import screens.Screens;

/**
 * Handles mouse input.
 * 
 * @author Fabulous Fellini
 *
 */
public class Mouse extends ComputerInput {

	/**
	 * 
	 * @param MyGame myGame
	 */
	@Override
	public void handleInput(MyGame myGame) {
		GameObject player = PlayerController.getCurrentPlayer(myGame);
		switch (GameAttributeHelper.gameState) {
		case Screens.SPLASH_SCREEN:
			if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
				GameStateController.switchGameStates(myGame, Screens.TITLE_SCREEN);
			}
			break;
		case Screens.TITLE_SCREEN:
			if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
				GameStateController.switchGameStates(myGame, Screens.GAME_SCREEN);
			}
			break;
		case Screens.GAME_SCREEN:
			// If user presses the T button to use turbo.
			int turboSpeed    = 3;
			float playerSpeed = Player.PLAYER_SPEED;
			if (Gdx.input.isKeyPressed(Input.Keys.T)) {
				System.out.println("Player is using turbo!  Going fast!");
				playerSpeed = Player.PLAYER_SPEED * turboSpeed;
			}

			if(GameObjectLoader.gameObjectList.contains(player)) {
				System.out.println(Gdx.input.getX());
				if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
					int mouseToWorldMiddleCoordinate = 260;
					if (Gdx.input.getX() > GameScreen.cameraX + mouseToWorldMiddleCoordinate) {
						player.translateX(playerSpeed);
						player.setDirection(Player.DIRECTION_RIGHT);
						Player.playerIsMoving = true;
						System.out.println("Player is moving right");
					}  
					else if (Gdx.input.getX() <= GameScreen.cameraX + mouseToWorldMiddleCoordinate) {
						player.translateX(-playerSpeed);
						player.setDirection(Player.DIRECTION_LEFT);
						Player.playerIsMoving = true;
						System.out.println("Player is moving left");
					}
				}
				if (Gdx.input.isButtonPressed(Input.Buttons.RIGHT)) {
					int mouseToWorldMiddleCoordinate = 206;
					if (Gdx.input.getY() > GameScreen.cameraY + mouseToWorldMiddleCoordinate) {
						player.translateY(playerSpeed);
						player.setDirection(Player.DIRECTION_DOWN);
						Player.playerIsMoving = true;
						System.out.println("Player is moving down");
					}  
					if (Gdx.input.getY() <= GameScreen.cameraY + mouseToWorldMiddleCoordinate) {
						player.translateY(-playerSpeed);
						player.setDirection(Player.DIRECTION_UP);
						Player.playerIsMoving = true;
						System.out.println("Player is moving up");
					}
				}
			}
			break;
		}
	}
}
