package tiles;

import com.mygdx.mygame.MyGame;

/**
 * Draws world map in terms of chunks.  
 * Each chuck contains 4 Tiles.
 * Each tile contains a 20 x 20 grid of smaller tiles.
 * Only draw chunk if it is within player's vision.
 * 
 * @author Fabulous Fellini
 *
 */
public class Map {
	
	private static final int WORLD_SIZE = 2;
	
	public final Chunk[][] chunk = new Chunk[2][2];
	public int[][] chunkMap      = 
		{
				{0, 0},
				{1, 0}
		};

	/**
	 * 
	 * @param MyGame myGame
	 */
	public void init(MyGame myGame) {
		for(int z = 0; z < chunk.length; z++) {
			for(int x = 0; x < chunk[z].length; x++) {
				if (chunkMap[z][x] == Chunk.CHUNK_TYPE_REVERSE_L) {
					chunk[z][x] = new Chunk(Chunk.CHUNK_TYPE_REVERSE_L);
				}
				if (chunkMap[z][x] == Chunk.CHUNK_TYPE_WATER) {
					chunk[z][x] = new Chunk(Chunk.CHUNK_TYPE_WATER);
				}
				chunk[z][x].init(myGame);
			}
		}
	}
	
	/**
	 * 
	 * @param MyGame myGame
	 */
	public void render(MyGame myGame) {
		int offset = -42;
		
		// Bottom row, rendered right to left.
		chunk[1][1].render(myGame, 0, 0);
		chunk[1][0].render(myGame, offset, 0);
		
		// Top row, rendered right to left.
		chunk[0][1].render(myGame, 0, offset);
		chunk[0][0].render(myGame, offset, offset);
		
		
		//chunk[0][3].render(myGame, offset * 3, 0);
		//chunk[1][0].render(myGame, 0, offset);
		//chunk[1][1].render(myGame, offset, offset);
		//chunk[1][2].render(myGame, offset * 2, offset);
		//chunk[1][3].render(myGame, offset * 3, offset);
	}
}
