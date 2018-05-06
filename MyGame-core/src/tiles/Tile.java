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
	
	private boolean isSolid;
	
	public static Texture textureOne;
	
	public static Texture textureTwo;
	
	/**
	 * 
	 * @param Texture texture
	 * @param boolean isSolid
	 */
	public Tile(Texture texture, boolean isSolid) {
		super(texture);
		this.isSolid = isSolid;
	}
	
	/**
	 * 
	 * @param MyGame myGame
	 */
	public static void initializeTileTextures(MyGame myGame) {
		textureOne  = myGame.imageLoader.fakeTileOne;
		textureTwo  = myGame.imageLoader.fakeTileTwo;
	}

	/**
	 * 
	 * @return boolean
	 */
	public boolean isSolid() {
		return isSolid;
	}
}
