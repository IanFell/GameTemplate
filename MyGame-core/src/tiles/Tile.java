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
	public static Texture waterUpperLeftCurvedTexture;
	
	protected static final int SolidTile                  = 0;
	protected static final int GrassTileOne               = 1;
	protected static final int GrassTileTwo               = 2;
	protected static final int SandTile                   = 3;
	protected static final int WaterTileOne               = 4;
	protected static final int WaterTileTwo               = 5;
	protected static final int WaterLowerLeftHalfAndHalf  = 6;
	protected static final int WaterUpperLeftHalfAndHalf  = 7;
	protected static final int WaterLowerRightHalfAndHalf = 8;
	protected static final int WaterUpperRightHalfAndHalf = 9;
	protected static final int WaterUpperLeftCurved       = 10;
	
	protected final int WORLD_WIDTH  = 21;
	protected final int WORLD_HEIGHT = 21;
	
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
		grassTextureOne                   = myGame.imageLoader.grassTileOne;
		grassTextureTwo                   = myGame.imageLoader.grassTileTwo;
		buildingTexture                   = myGame.imageLoader.solidTile;
		sandTexture                       = myGame.imageLoader.sandTile;
		waterTextureOne                   = myGame.imageLoader.waterTileOne;
		waterTextureTwo                   = myGame.imageLoader.waterTileTwo;
		waterLowerLeftHalfAndHalfTexture  = myGame.imageLoader.waterLowerLeftHalfAndHalfTile;
		waterUpperLeftHalfAndHalfTexture  = myGame.imageLoader.waterUpperLeftHalfAndHalfTile;
		waterLowerRightHalfAndHalfTexture = myGame.imageLoader.waterLowerRightHalfAndHalfTile;
		waterUpperRightHalfAndHalfTexture = myGame.imageLoader.waterUpperRightHalfAndHalfTile;
		waterUpperLeftCurvedTexture       = myGame.imageLoader.waterUpperLeftCurvedTile;
	}

	/**
	 * 
	 * @return boolean
	 */
	public boolean isSolid() {
		return isSolid;
	}
}
