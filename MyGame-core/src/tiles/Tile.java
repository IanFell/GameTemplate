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
	 * Contstructor.
	 * 
	 * @param Texture texture
	 */
	public Tile(Texture texture) {
		super(texture);
	}
	
	/**
	 * Initializes tile textures.
	 * 
	 * @param MyGame myGame
	 */
	public static void initializeTileTextures(MyGame myGame) {
		textureOne = myGame.imageLoader.fakeTile;
		textureTwo = myGame.imageLoader.fakeTileAlternate;
	}
}
