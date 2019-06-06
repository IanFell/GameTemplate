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
import screens.Screens;

/**
 * Handles mouse input.
 * 
 * @author Fabulous Fellini
 *
 */
public class Mouse extends ComputerInput {

	/**
	 * Constructor.
	 */
	public Mouse() {
		super();
	}

	/**
	 * 
	 * @param MyGame myGame
	 */
	@Override
	public void handleInput(MyGame myGame) {

		//System.out.println("Mouse Coordinate X: " + Gdx.input.getX());
		//System.out.println("Mouse Coordinate Y: " + Gdx.input.getY());

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
			if (Inventory.allInventoryShouldBeRendered) {
				// Inventory menu buttons.
				if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
					for (int i = 0; i < ((Player) player).getInventory().inventory.size(); i++) {
						if (inventoryButtons[i].contains(Gdx.input.getX(), Gdx.input.getY())) {
							selectAlternateInventoryObject(i, player);
						}
					}
				} else {
					Inventory.mouseIsClickingOnInventoryObject = false;
					for (int i = 0; i < inventoryButtonIsPressed.length; i++) {
						inventoryButtonIsPressed[i] = false;
					}
				}
			} else {
				if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
					Player.playerIsPerformingAttack = true;
				} else {
					Player.playerIsPerformingAttack = false;
				}
			}
		}
	}
}
