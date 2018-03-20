package tiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.mygame.MyGame;

/**
 * Tile objects.
 * 
 * @author Fabulous Fellini
 *
 */
public class Tile extends Sprite {
	
	/**
	 * Texture for tile one.
	 */
	public static Texture textureOne;
	
	/**
	 * Texture for tile two.
	 */
	public static Texture textureTwo;
	
	/**
	 * Texture for tile three.
	 */
	public static Texture textureThree;
	
	/**
	 * Determines if tile is solid.
	 */
	private boolean isSolid;
	
	/**
	 * Determines if player has collided with tile.
	 */
	private boolean tileHasBeenHit = false;
	
	/**
	 * Contstructor.
	 * 
	 * @param Texture texture
	 */
	public Tile(Texture texture, boolean isSolid) {
		super(texture);
		this.isSolid = isSolid;
	}
	
	/**
	 * Initializes tile textures.
	 * 
	 * @param MyGame myGame
	 */
	public static void initializeTileTextures(MyGame myGame) {
		textureOne   = myGame.imageLoader.fakeTileOne;
		textureTwo   = myGame.imageLoader.fakeTileTwo;
		textureThree = myGame.imageLoader.fakeTileThree;
	}
}
