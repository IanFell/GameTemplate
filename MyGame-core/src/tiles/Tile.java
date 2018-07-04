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

	public static Texture grassTextureOne;
	public static Texture grassTextureTwo;
	public static Texture solidTile;
	public static Texture sandTexture;

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
		grassTextureOne  = myGame.imageLoader.grassTileOne;
		grassTextureTwo  = myGame.imageLoader.grassTileTwo;
		solidTile        = myGame.imageLoader.solidTile;
		sandTexture      = myGame.imageLoader.sandTile;
	}

	/**
	 * 
	 * @return boolean
	 */
	public boolean isSolid() {
		return isSolid;
	}
}
