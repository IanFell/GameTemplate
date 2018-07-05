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
	public static Texture buildingTexture;
	public static Texture sandTexture;
	public static Texture waterTextureOne;
	public static Texture waterTextureTwo;
	public static Texture waterLowerLeftHalfAndHalfTexture;
	public static Texture waterUpperLeftHalfAndHalfTexture;
	public static Texture waterLowerRightHalfAndHalfTexture;
	public static Texture waterUpperRightHalfAndHalfTexture;

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
		grassTextureOne                  = myGame.imageLoader.grassTileOne;
		grassTextureTwo                  = myGame.imageLoader.grassTileTwo;
		buildingTexture                  = myGame.imageLoader.solidTile;
		sandTexture                      = myGame.imageLoader.sandTile;
		waterTextureOne                  = myGame.imageLoader.waterTileOne;
		waterTextureTwo                  = myGame.imageLoader.waterTileTwo;
		waterLowerLeftHalfAndHalfTexture = myGame.imageLoader.waterLowerLeftHalfAndHalfTile;
		waterUpperLeftHalfAndHalfTexture = myGame.imageLoader.waterUpperLeftHalfAndHalfTile;
		waterLowerRightHalfAndHalfTexture = myGame.imageLoader.waterLowerRightHalfAndHalfTile;
		waterUpperRightHalfAndHalfTexture = myGame.imageLoader.waterUpperRightHalfAndHalfTile;
	}

	/**
	 * 
	 * @return boolean
	 */
	public boolean isSolid() {
		return isSolid;
	}
}
