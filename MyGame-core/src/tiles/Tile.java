package tiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.mygame.MyGame;

import physics.Weather.NightAndDayCycle;
import screens.GameScreen;

/**
 * Tile objects.
 * 
 * @author Fabulous Fellini
 *
 */
public class Tile extends Sprite {

	private static final int WORLD_SIZE = 21;

	protected final static int WORLD_WIDTH  = WORLD_SIZE;
	protected final static int WORLD_HEIGHT = WORLD_SIZE;

	public boolean isSolid;
	public boolean isWater;

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
	public static Texture nightTimeTexture;

	protected static final int SolidTile              = 0;
	protected static final int GrassTileOne           = 1;
	protected static final int SandTile               = 3;
	protected static final int WaterTileOne           = 4;
	protected static final int SandTileHorizontalPath = 5;
	protected static final int SandTileLeftDownPath   = 6;
	protected static final int SandTileVerticalPath   = 7;
	protected static final int SandTileTopRightPath   = 8;
	protected static final int SandTileCrossPath      = 9;

	/**
	 * 
	 * @param Texture texture
	 * @param boolean isSolid
	 * @param String  name
	 * @param boolean isWater
	 */
	public Tile(Texture texture, boolean isSolid, String name, boolean isWater) {
		super(texture);
		this.isSolid = isSolid;
		this.name    = name;
		this.isWater = isWater;
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
		sandTexture               = myGame.imageLoader.sandTile;
		waterTextureOne           = myGame.imageLoader.waterTileOne;
		sandTextureHorizontalPath = myGame.imageLoader.sandTileHorizontalPath;
		sandTextureLeftDownPath   = myGame.imageLoader.sandTileLeftDownPath;
		sandTextureVerticalPath   = myGame.imageLoader.sandTileVerticalPath;
		sandTextureTopRightPath   = myGame.imageLoader.sandTileTopRightPath;
		sandTextureCrossPath      = myGame.imageLoader.sandTileCrossPath;
		nightTimeTexture          = myGame.imageLoader.nightTimeShader;
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
	 * @return boolean
	 */
	public boolean isWater() {
		return isWater;
	}

	/**
	 * 
	 * @param Batch batch
	 */
	@Override
	public void draw (Batch batch) {
		super.draw(batch);
		// If it is night time, draw a transparant black shader over the tile.
		if (!NightAndDayCycle.isDayTime()) {
			if (isWithinScreenBounds()) {
				batch.draw(nightTimeTexture, getX(), getY(), getWidth(), getHeight());
			}
		}
	}

	private  boolean isWithinScreenBounds() {
		float cameraXPosition             = GameScreen.camera.position.x;
		float cameraYPosition             = GameScreen.camera.position.y;
		float playerXPosition             = getX();
		float playerYPosition             = getY();
		float screenOffset                = 0.5f;
		float yPositionOffset             = 1.5f;
		float withinBoundsPerimeterOffset = 15.5f;
		if (
				playerXPosition < cameraXPosition + withinBoundsPerimeterOffset - screenOffset &&
				playerXPosition > cameraXPosition - withinBoundsPerimeterOffset + screenOffset &&
				playerYPosition < cameraYPosition + withinBoundsPerimeterOffset / yPositionOffset - screenOffset &&
				playerYPosition > cameraYPosition - withinBoundsPerimeterOffset / yPositionOffset + screenOffset
				) {
			return true;
		}
		return false;
	}
}