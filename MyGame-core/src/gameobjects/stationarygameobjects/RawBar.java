package gameobjects.stationarygameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import loaders.ImageLoader;
import maps.MapHandler;
import physics.CollisionHandler;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class RawBar extends GamePlayObject {

	/**
	 * 
	 * @param int x
	 * @param int y
	 */
	public RawBar(int x, int y) {
		super(x, y);
		this.width            = 7;
		this.height           = 6;
		this.rectangle.width  = width;
		this.rectangle.height = height;
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shaperender
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		batch.draw(imageLoader.rawbar, x, y, width, -height);
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		super.updateObject(myGame, mapHandler);
		CollisionHandler.checkIfPlayerHasCollidedWithStructure(
				myGame.getGameObject(GameObject.PLAYER_ONE),
				this,
				"Raw Bar",
				myGame
				);
	}

}
