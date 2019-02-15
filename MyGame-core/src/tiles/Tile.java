package tiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.mygame.MyGame;

/**
 * Tile objects.
 * 
 * @author Fabulous Fellini
 *
 */
public class Tile extends Sprite {

	public boolean isSolid;
	
	protected final String name;
	
	public static Texture grassTextureOne;
	public static Texture buildingTexture;
	public static Texture sandTexture;
	public static Texture sandTextureHorizontalPath;
	public static Texture sandTextureLeftDownPath;
	public static Texture sandTextureVerticalPath;
	public static Texture sandTextureTopRightPath;
	public static Texture sandTextureCrossPath;
	public static Texture waterTextureOne;
	
	protected static final int SolidTile              = 0;
	protected static final int GrassTileOne           = 1;
	protected static final int SandTile               = 3;
	protected static final int WaterTileOne           = 4;
	protected static final int SandTileHorizontalPath = 5;
	protected static final int SandTileLeftDownPath   = 6;
	protected static final int SandTileVerticalPath   = 7;
	protected static final int SandTileTopRightPath   = 8;
	protected static final int SandTileCrossPath      = 9;
	
	
	protected final static int WORLD_WIDTH  = 21;
	protected final static int WORLD_HEIGHT = 21;
	
	/**
	 * 
	 * @param Texture texture
	 * @param boolean isSolid
	 * @param String  name
	 */
	public Tile(Texture texture, boolean isSolid, String name) {
		super(texture);
		this.isSolid = isSolid;
		this.name    = name;
	}
	
	/**
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param MyGame myGame
	 */
	public static void initializeTileTextures(MyGame myGame) {
		grassTextureOne           = myGame.imageLoader.grassTileOne;
		buildingTexture           = myGame.imageLoader.solidTile;
		sandTexture               = myGame.imageLoader.sandTile;
		waterTextureOne           = myGame.imageLoader.waterTileOne;
		sandTextureHorizontalPath = myGame.imageLoader.sandTileHorizontalPath;
		sandTextureLeftDownPath   = myGame.imageLoader.sandTileLeftDownPath;
		sandTextureVerticalPath   = myGame.imageLoader.sandTileVerticalPath;
		sandTextureTopRightPath   = myGame.imageLoader.sandTileTopRightPath;
		sandTextureCrossPath      = myGame.imageLoader.sandTileCrossPath;
	}

	/**
	 * 
	 * @return boolean
	 */
	public boolean isSolid() {
		return isSolid;
	}
	
	/**
	 * 
	 * @param Batch batch
	 */
	@Override
	public void draw (Batch batch) {
		super.draw(batch);
	}
}