package gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
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

	protected int width  = 1;
	protected int height = 3;

	/**
	 * 
	 * @param float x
	 * @param float y
	 */
	public Torch(float x, float y) {
		this.x = x;
		this.y = y;
		fire   = new Fire(x, y, width, height, "Player", false);
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
	 * @param ShapeRenderer shaperender
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		fire.renderObject(batch, shapeRenderer, imageLoader);
	}
}