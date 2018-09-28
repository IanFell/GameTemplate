package maps;

import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import maps.mapchunks.MapChunk;
import physics.CollisionHandler;

/**
 * Renders tile maps for game world.
 * 
 * @author Fabulous Fellini
 *
 */
public class MapRenderer {

	private int chunkWidth  = MapInformationHolder.CHUNK_WIDTH;
	private int chunkHeight = MapInformationHolder.CHUNK_HEIGHT;
	
	/**
	 * Represents all chunks in the grid.  The grid is 8 x 8.
	 */
	private int totalChunkCount = 64;
	
	/**
	 * 
	 * @param MyGame   myGame
	 * @param MapChunk mapChunk
	 * @param int      x
	 * @param int      z
	 * @return boolean
	 */
	private boolean playerIsWithinBoundsOfRenderingChunk(MyGame myGame, MapChunk mapChunk, int x, int z) {
		float playerX        = myGame.getGameObject(GameObject.PLAYER_ONE).getX();
		float playerY        = myGame.getGameObject(GameObject.PLAYER_ONE).getY();
		int chunkOuterBounds = 10;
		int arrayElement     = 0;
		if (
				playerX < mapChunk.tileMap[arrayElement][arrayElement].getX() + MapInformationHolder.CHUNK_WIDTH + chunkOuterBounds &&
				playerX > mapChunk.tileMap[arrayElement][arrayElement].getX() - chunkOuterBounds &&
				playerY < mapChunk.tileMap[arrayElement][arrayElement].getY() + MapInformationHolder.CHUNK_HEIGHT + chunkOuterBounds &&
				playerY > mapChunk.tileMap[arrayElement][arrayElement].getY() - chunkOuterBounds
				) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @param MyGame    myGame
	 * @param MapHandler mapHandler
	 */
	public void renderMapOfChunks(MyGame myGame, MapHandler mapHandler) { 
		for (int i = 0; i < totalChunkCount; i++) {
			for(int z = 0; z < chunkHeight; z++) {
				for(int x = 0; x < chunkWidth; x++) {
					if (playerIsWithinBoundsOfRenderingChunk(
							myGame,
							MapHandler.mapChunks.get(i), 
							x, 
							z
							)
							) {
						MapHandler.mapChunks.get(i).tileMap[x][z].draw(myGame.renderer.batch);
						CollisionHandler.checkIfPlayerHasCollidedWithASolidTile(myGame, mapHandler, MapHandler.mapChunks.get(i).tileMap[x][z]);
					}
				}
			}
		}
		
		// Uncomment this to draw entire game world.
		//Debugger.drawEntireGameWorldAllChunksAtOnce(myGame, mapHandler, totalChunkCount, chunkWidth, chunkHeight);
	}
}
