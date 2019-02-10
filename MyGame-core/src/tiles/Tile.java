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
	public static Texture grassTextureTwo;
	public static Texture buildingTexture;
	public static Texture sandTexture;
	public static Texture waterTextureOne;
	
	protected static final int SolidTile     = 0;
	protected static final int GrassTileOne  = 1;
	protected static final int GrassTileTwo  = 2;
	protected static final int SandTile      = 3;
	protected static final int WaterTileOne  = 4;
	
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
		grassTextureOne = myGame.imageLoader.grassTileOne;
		grassTextureTwo = myGame.imageLoader.grassTileTwo;
		buildingTexture = myGame.imageLoader.solidTile;
		sandTexture     = myGame.imageLoader.sandTile;
		waterTextureOne = myGame.imageLoader.waterTileOne;
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