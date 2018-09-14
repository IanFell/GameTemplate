package maps.mapchunks;

import maps.MapInformationHolder;
import tiles.Tile;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class MapChunk {	
	// Tile maps refers to "chunks".  The game world is split up into 64 different chunks.
	public final Tile[][] tileMap = new Tile[MapInformationHolder.CHUNK_WIDTH][MapInformationHolder.CHUNK_HEIGHT];
}
