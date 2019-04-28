package gameobjects.gamecharacters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import loaders.ImageLoader;
import maps.MapHandler;
import physics.Lighting.Fire;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Enemy extends GameObject {

	// How long fire animation plays after enemy has been killed.
	private final int MAX_DEATH_ANIMATION_VALUE = 100;

	private Texture texture;
	private int timer;
	private Fire fire;
	public static boolean playSound;
	public static boolean dead;

	/**
	 * Constructor.
	 * 
	 * @param float   x
	 * @param float   y
	 * @param int     width
	 * @param int     height
	 * @param Texture texture
	 */
	public Enemy(float x, float y, int width, int height, Texture texture) {
		this.x           = x;
		this.y           = y;
		this.width       = width;
		this.height      = height;
		this.texture     = texture;
		rectangle.width  = width;
		rectangle.height = height;
		timer            = 0;
		fire             = new Fire(0, 0, width, height, null, false);
		playSound        = false;
		dead             = false;
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shaperender
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		if (!dead) {
			batch.draw(texture, x, y, width, -height);
		} else {
			if (timer < MAX_DEATH_ANIMATION_VALUE) {
				fire.renderObject(batch, shapeRenderer, imageLoader);
			}
		}
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		super.updateObject(myGame, mapHandler);
		rectangle.x = x;
		rectangle.y = y;
		fire.updateObject(myGame, mapHandler);
		if (dead) {
			if (timer < MAX_DEATH_ANIMATION_VALUE) {
				timer++;
			}
			fire.setX(x);
			fire.setY(y);
		}
	}
}
