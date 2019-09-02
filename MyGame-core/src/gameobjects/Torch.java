package gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import controllers.PlayerController;
import loaders.ImageLoader;
import maps.MapHandler;
import physics.Lighting.Fire;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Torch extends GameObject {

	private Fire fire;

	/**
	 * 
	 * @param float x
	 * @param float y
	 */
	public Torch(float x, float y) {
		this.x      = x;
		this.y      = y;
		this.width  = 0.5f;
		this.height = 1.5f;
		fire        = new Fire(x, y, width, height, "Player", false);
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		fire.setX(PlayerController.getCurrentPlayer(myGame).getX());
		fire.setY(PlayerController.getCurrentPlayer(myGame).getY() - 1);
		fire.updateObject(myGame, mapHandler);
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ImageLoader imageLoader) {
		fire.renderObject(batch, imageLoader);
	}
}
