package physics.Lighting;

import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;

/**
 * Handles ALL in game lighting.
 * 
 * @author Fabulous Fellini
 *
 */
public class LightingHandler {

	public LightHandler lightHandler;
	public ShadowHandler shadowHandler;

	/**
	 * Constructor.
	 */
	public LightingHandler() {
		lightHandler  = new LightHandler();
		shadowHandler = new ShadowHandler();
	}
	
	/**
	 * 
	 * @param MyGame myGame
	 */
	public void renderShadows(MyGame myGame) {
		// If we want shadows to dissapear from players at night time, use this if statement.
		//if (NightAndDayCycle.isDayTime()) {
			shadowHandler.renderLighting(
					myGame.renderer.batch, 
					myGame.imageLoader, 
					myGame.getGameObject(GameObject.PLAYER_ONE)
					);
			shadowHandler.renderLighting(
					myGame.renderer.batch, 
					myGame.imageLoader, 
					myGame.getGameObject(GameObject.PLAYER_TWO)
					);
			shadowHandler.renderLighting(
					myGame.renderer.batch, 
					myGame.imageLoader, 
					myGame.getGameObject(GameObject.PLAYER_THREE)
					);
		//}
	}
}
