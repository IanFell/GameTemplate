package tiles;

import com.mygdx.mygame.MyGame;

/**
 * Draws a grid of 2 x 2 tiles.
 * 
 * @author Fabulous Felini 
 *
 */
public class Chunk {
	
	public static final int CHUNK_TYPE_REVERSE_L = 0;
	public static final int CHUNK_TYPE_WATER = 1;
	
	private int chunkType;
	
	private WaterTile waterTile;
	private SandTile sandTile;
	private SandTopRightTile sandTopRightTile;
	
	public Chunk(int chunkType) {
		this.chunkType = chunkType;
	}
	
	/**
	 * 
	 * @param MyGame myGame
	 */
	public void init(MyGame myGame) {
		Tile.initializeTileTextures(myGame);
		
		waterTile = new WaterTile(Tile.waterTextureOne, false);
		waterTile.init(myGame, 0);
		
		sandTile = new SandTile(Tile.sandTexture, false);
		sandTile.init(myGame, 0);
		
		sandTopRightTile = new SandTopRightTile(Tile.sandTexture, false);
		sandTopRightTile.init(myGame, 0);
	}
	
	/**
	 * 
	 * @param MyGame myGame
	 * @param int    xOffset
	 * @param int    yOffset
	 */
	public void render(MyGame myGame, int xOffset, int yOffset) {
		switch (chunkType) {
		case CHUNK_TYPE_REVERSE_L:
			renderChunkTypeReverseL(myGame, xOffset, yOffset);
			break;
		case CHUNK_TYPE_WATER:
			renderChunkTypeWater(myGame, xOffset, yOffset);
			break;
		}
	}
	
	private void renderChunkTypeReverseL(MyGame myGame, int xOffset, int yOffset) {
		sandTile.render(myGame, 21 - xOffset, 21 - yOffset);
		sandTile.render(myGame, 0 - xOffset, 21 - yOffset);
		sandTile.render(myGame, 0 - xOffset, 0 - yOffset);
		sandTile.render(myGame, 21 - xOffset, 0 - yOffset);
	}
	
	private void renderChunkTypeWater(MyGame myGame, int xOffset, int yOffset) {
		waterTile.render(myGame, 21 - xOffset, 21 - yOffset);
		waterTile.render(myGame, 0 - xOffset, 21 - yOffset);
		waterTile.render(myGame, 0 - xOffset, 0 - yOffset);
		waterTile.render(myGame, 21 - xOffset, 0 - yOffset);
	}
}
