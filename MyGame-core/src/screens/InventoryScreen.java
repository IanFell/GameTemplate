package screens;

import com.mygdx.mygame.MyGame;

import helpers.GameAttributeHelper;
import inventory.Inventory;

/**
 * Currently this class is not used.
 * 
 * @author Fabulous Fellini
 *
 */
public class InventoryScreen extends Screens {

	/**
	 * 
	 * @param MyGame myGame
	 */
	public InventoryScreen(final MyGame myGame) {
		super(myGame);
		GameAttributeHelper.gameState = Screens.INVENTORY_SCREEN;
		Inventory.allInventoryShouldBeRendered = true;
		/*
		camera = new OrthographicCamera(viewportWidth, verticalHeight);
		camera.setToOrtho(true, viewportWidth, verticalHeight);
		camera.position.x = myGame.getGameObject(GameObject.PLAYER_ONE).getX();
		camera.position.y = myGame.getGameObject(GameObject.PLAYER_ONE).getY();  */
		camera.update();
	}

	/**
	 * 
	 * @param float delta
	 */
	@Override
	public void render(float delta) {
		clearScreenAndSetScreenColor(GameAttributeHelper.gameState, null);
		updateCamera();
		myGame.renderer.batch.begin();
		myGame.renderer.batch.draw(
				myGame.imageLoader.inventoryLabel, 
				Screens.cameraX + Screens.camera.viewportWidth / 2 - 210, 
				Screens.cameraY + Screens.camera.viewportHeight / 2 + 100, 
				200, 
				100
				);

		myGame.renderer.batch.end();
	}
}
