package screens;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import gameobjects.gamecharacters.Player;
import helpers.GameAttributeHelper;
import helpers.ImageHelper;
import inventory.Inventory;

/**
 * Fabulous Fellini logo screen.
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
		camera = new OrthographicCamera(viewportWidth, verticalHeight);
		camera.setToOrtho(true, viewportWidth, verticalHeight);
		camera.position.x = myGame.getGameObject(GameObject.PLAYER_ONE).getX();
		camera.position.y = myGame.getGameObject(GameObject.PLAYER_ONE).getY();  
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
		myGame.getGameObject(Player.PLAYER_ONE).renderObject(myGame.renderer.batch, myGame.renderer.shapeRenderer, myGame.imageLoader);
		/*
		ImageHelper.drawImageInMiddleOfScreen(
				myGame.renderer.batch, 
				myGame.imageLoader.splashScreenLogo, 
				GameAttributeHelper.SCREEN_WIDTH, 
				GameAttributeHelper.SCREEN_HEIGHT
				);*/
		myGame.renderer.batch.end();
	}
}
