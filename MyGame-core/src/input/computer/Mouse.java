package input.computer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;
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
	 * Inventory buttons reside here because it is easier to translate mouse to world coordinates.
	 */
	private static int maxNumberOfInventoryObjects   = 12;
	private Rectangle[] inventoryButtons             = new Rectangle[maxNumberOfInventoryObjects];
	public static boolean[] inventoryButtonIsPressed = new boolean[maxNumberOfInventoryObjects];

	/**
	 * Constructor.
	 */
	public Mouse() {
		for (int i = 0; i < inventoryButtons.length; i++) {
			inventoryButtons[i] = new Rectangle(0, 0, 0, 0);
			inventoryButtonIsPressed[i] = false;

			// Full screen coordinates.
			inventoryButtons[i].width   = 200;
			inventoryButtons[i].height  = 185;
			// Phone screen coordinates.
			//inventoryButtons[i].width   = 90;
			//inventoryButtons[i].height  = 125;
		}

		// Full screen button positions.
		int yStartPositionTopRow      = 245;
		int yStartPositionBottomRow   = 470;
		int xStartPositionColumnOne   = 90;
		int xStartPositionColumnTwo   = 305;
		int xStartPositionColumnThree = 495;
		int xStartPositionColumnFour  = 695;
		int xStartPositionColumnFive  = 900;
		int xStartPositionColumnSix   = 1095;

		// Phone screen button positions.
		/*
		int yStartPositionTopRow      = 95;
		int yStartPositionBottomRow   = 240;
		int xStartPositionColumnOne   = 65;
		int xStartPositionColumnTwo   = 165;
		int xStartPositionColumnThree = 250;
		int xStartPositionColumnFour  = 350;
		int xStartPositionColumnFive  = 440;
		int xStartPositionColumnSix   = 530; */

		inventoryButtons[0].x      = xStartPositionColumnOne;
		inventoryButtons[0].y      = yStartPositionTopRow;

		inventoryButtons[1].x      = xStartPositionColumnTwo;
		inventoryButtons[1].y      = yStartPositionTopRow;

		inventoryButtons[2].x      = xStartPositionColumnThree;
		inventoryButtons[2].y      = yStartPositionTopRow;

		inventoryButtons[3].x      = xStartPositionColumnFour;
		inventoryButtons[3].y      = yStartPositionTopRow;

		inventoryButtons[4].x      = xStartPositionColumnFive;
		inventoryButtons[4].y      = yStartPositionTopRow;

		inventoryButtons[5].x      = xStartPositionColumnSix;
		inventoryButtons[5].y      = yStartPositionTopRow;

		inventoryButtons[6].x      = xStartPositionColumnOne;
		inventoryButtons[6].y      = yStartPositionBottomRow;

		inventoryButtons[7].x      = xStartPositionColumnTwo;
		inventoryButtons[7].y      = yStartPositionBottomRow;

		inventoryButtons[8].x      = xStartPositionColumnThree;
		inventoryButtons[8].y      = yStartPositionBottomRow;

		inventoryButtons[9].x      = xStartPositionColumnFour;
		inventoryButtons[9].y      = yStartPositionBottomRow;

		inventoryButtons[10].x      = xStartPositionColumnFive;
		inventoryButtons[10].y      = yStartPositionBottomRow;

		inventoryButtons[11].x      = xStartPositionColumnSix;
		inventoryButtons[11].y      = yStartPositionBottomRow;
	}

	/**
	 * 
	 * @param MyGame myGame
	 */
	@Override
	public void handleInput(MyGame myGame) {

		System.out.println("Mouse Coordinate X: " + Gdx.input.getX());
		System.out.println("Mouse Coordinate Y: " + Gdx.input.getY());

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
			System.out.println(Inventory.inventoryIsEquipped);
			if (Inventory.allInventoryShouldBeRendered) {
				// Inventory menu buttons.
				if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
					for (int i = 0; i < ((Player) player).getInventory().inventory.size(); i++) {
						if (inventoryButtons[i].contains(Gdx.input.getX(), Gdx.input.getY())) {
							inventoryButtonIsPressed[i]                = true;
							Inventory.mouseIsClickingOnInventoryObject = true;
							Inventory.currentlySelectedInventoryObject = i;
							((Player) player).getInventory().setInventoryIsEquipped(true);
							Inventory.playClickSound                   = true;
							System.out.println("Inventory Button " + i + "pressed");
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
