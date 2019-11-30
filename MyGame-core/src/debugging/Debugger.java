package debugging;

import com.mygdx.mygame.MyGame;

import maps.MapHandler;

/**
 * Debugs various scenarios.
 * 
 * @author Fabulous Fellini
 *
 */
public class Debugger {

	/**
	 * This method is for debugging purposes in order to see the entire game world.  
	 * Note: If this is activated, the game runs at about 5 frames per second.
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 * @param int        totalChunkCount
	 * @param int        chunkWidth
	 * @param int        chunkHeight
	 */
	public static void drawEntireGameWorldAllChunksAtOnce(
			MyGame myGame, 
			MapHandler mapHandler, 
			int totalChunkCount, 
			int chunkWidth, 
			int chunkHeight
			) {
		for (int i = 0; i < totalChunkCount; i++) {
			for(int z = 0; z < chunkHeight; z++) {
				for(int x = 0; x < chunkWidth; x++) {
					MapHandler.mapChunks.get(i).tileMap[x][z].draw(myGame.renderer.batch);
				}
			}
		}
	}

	public static void printGettingHereStatement() {
		System.out.print("GETTING HERE");
	}
}
