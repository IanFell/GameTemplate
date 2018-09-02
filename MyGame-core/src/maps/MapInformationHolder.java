package maps;

import tiles.Tile;

/**
 * Holds information pertaining to maps.
 * 
 * @author Fabulous Fellini
 *
 */
public class MapInformationHolder {

	protected static final int WaterTileOne = 0;
	protected static final int WaterTileTwo = 1;
	protected static final int SandTile     = 2;
	
	protected final static int CHUNK_WIDTH  = 68;
	protected final static int CHUNK_HEIGHT = 50;
	
	// Tile maps refers to "chunks".  The game world is split up into 64 different chunks.
	public final Tile[][] tileMap = new Tile[CHUNK_WIDTH][CHUNK_HEIGHT];
}
