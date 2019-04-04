package input.computer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.mygame.MyGame;

import controllers.GameStateController;
import controllers.PlayerController;
import gameobjects.GameObject;
import gameobjects.gamecharacters.Player;
import helpers.GameAttributeHelper;
import inventory.Inventory;
import loaders.GameObjectLoader;
import physics.Lighting.LightHandler;
import screens.GameScreen;
import screens.Screens;

/**
 * Handles keyboard input.
 * 
 * @author Fabulous Fellini
 *
 */
public class Keyboard extends ComputerInput {

	/**
	 * 
	 * @param MyGame myGame
	 */
	@Override
	public void handleInput(MyGame myGame) {
		GameObject player = PlayerController.getCurrentPlayer(myGame);
		switch (GameAttributeHelper.gameState) {
		case Screens.SPLASH_SCREEN:
			if(Gdx.input.isKeyPressed(Input.Keys.ENTER)){ 
				GameStateController.switchGameStates(myGame, Screens.TITLE_SCREEN);
			}
			break;

		case Screens.TITLE_SCREEN:
			if(Gdx.input.isKeyPressed(Input.Keys.ENTER)){ 
				GameStateController.switchGameStates(myGame, Screens.GAME_SCREEN);
			}
			break;

		case Screens.GAME_SCREEN:	
			handleKeyboardDirectionalButtons(myGame, "arrows", player);
			//handleKeyboardDirectionalButtons(myGame, "wasd");

			if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
				Player.isJumping = true;
			}

			// Execute screenshake.
			if (Gdx.input.isKeyPressed(Input.Keys.R)) { 
				GameScreen.screenShake.shake(0.3f, 3);
			}

			/**
			 * Perform operations on lighting.  
			 * This will make the light texture grow,
			 * then shrink back to normal size when key is released.
			 */
			if (Gdx.input.isKeyPressed(Input.Keys.L)) { 
				LightHandler.isGrowing = true;
			} else {
				LightHandler.isGrowing = false;
			}

			float cameraZoomAmount = 1.0f;
			// Zoom camera out.
			if (Gdx.input.isKeyPressed(Input.Keys.Z) && Gdx.input.isKeyPressed(Input.Keys.O)) {
				GameScreen.camera.zoom += cameraZoomAmount;
			}

			// Zoom camera in.
			if (Gdx.input.isKeyPressed(Input.Keys.Z) && Gdx.input.isKeyPressed(Input.Keys.I)) {
				GameScreen.camera.zoom -= cameraZoomAmount;
			}

			if (Gdx.input.isKeyPressed(Input.Keys.F)) {
				Player.hasTorch = !Player.hasTorch;
			}

			if (Gdx.input.isKeyPressed(Input.Keys.A)) {
				Player.playerIsPerformingAttack = true;
			}

			if (Gdx.input.isKeyPressed(Input.Keys.I)) {
				((Player) player).getInventory().setInventoryIsEquipped(!((Player) player).getInventory().getInventoryIsEquipped());
			}

			if (Gdx.input.isKeyPressed(Input.Keys.M)) {
				if (Inventory.currentlySelectedInventoryObject < ((Player) player).getInventory().inventory.size() - 1) {
					Inventory.currentlySelectedInventoryObject++;
				}
			}

			if (Gdx.input.isKeyPressed(Input.Keys.N)) {
				if (Inventory.currentlySelectedInventoryObject > 0) {
					Inventory.currentlySelectedInventoryObject--;
				}
			}

			// Display all inventory.
			if (Gdx.input.isKeyPressed(Input.Keys.D)) {
				Inventory.allInventoryShouldBeRendered = true;
			} else {
				Inventory.allInventoryShouldBeRendered = false;
			}

			if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
				System.exit(0);
			}
		}
	}

	/**
	 * Handles arrows and WASD.
	 * 
	 * @param GameObject player
	 * @param String     directions
	 */
	private void handleKeyboardDirectionalButtons(MyGame myGame, String directions, GameObject player) {
		
		System.out.println("Keyboard directional controls: " + directions);

		// If user presses the T button to use turbo.
		int turboSpeed    = 3;
		float playerSpeed = Player.PLAYER_SPEED;
		if (Gdx.input.isKeyPressed(Input.Keys.T)) {
			System.out.println("Player is using turbo!  Going fast!");
			playerSpeed = Player.PLAYER_SPEED * turboSpeed;
		}

		int up;
		int down;
		int left;
		int right;

		if (directions.equalsIgnoreCase("arrows")) {
			up    = Input.Keys.UP;
			down  = Input.Keys.DOWN;
			left  = Input.Keys.LEFT;
			right = Input.Keys.RIGHT;
		} else {
			up    = Input.Keys.W;
			down  = Input.Keys.S;
			left  = Input.Keys.A;
			right = Input.Keys.D;
		}

		if(GameObjectLoader.gameObjectList.contains(player)) {
			if (Gdx.input.isKeyPressed(left)) {
				player.translateX(-playerSpeed);
				player.setDirection(Player.DIRECTION_LEFT);
				Player.playerIsMoving = true;
				System.out.println("Player is moving left");
			}
			else if (Gdx.input.isKeyPressed(right)) {
				player.translateX(playerSpeed);
				player.setDirection(Player.DIRECTION_RIGHT);
				Player.playerIsMoving = true;
				System.out.println("Player is moving right");
			}
			else if (Gdx.input.isKeyPressed(up)) {
				player.translateY(-playerSpeed);
				player.setDirection(Player.DIRECTION_UP);
				Player.playerIsMoving = true;
				System.out.println("Player is moving up");
			}
			else if (Gdx.input.isKeyPressed(down)) {
				player.translateY(playerSpeed);
				player.setDirection(Player.DIRECTION_DOWN);
				Player.playerIsMoving = true;
				System.out.println("Player is moving down");
			}
			else {
				player.stopPlayer();
				Player.playerIsMoving = false;
			}
		}
	}
}
