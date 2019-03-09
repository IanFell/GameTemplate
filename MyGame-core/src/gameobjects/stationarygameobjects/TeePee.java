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
public class TeePee extends GamePlayObject {

	private String name;

	/**
	 * Constructor.
	 * 
	 * @param int    x
	 * @param int    y
	 * @param String name
	 */
	public TeePee(int x, int y, String name) {
		super(x, y);
		this.width  = 3;
		this.height = 4;
		this.name   = name;
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shaperender
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		batch.draw(imageLoader.teePee, x, y, width, -height);
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		super.updateObject(myGame, mapHandler);
		CollisionHandler.checkIfPlayerHasCollidedWithStructure(
				myGame.getGameObject(GameObject.PLAYER_ONE),
				this,
				"Tee Pee"
				);
	}
}
