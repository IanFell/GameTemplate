package maps;

import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import maps.mapchunks.MapChunk;

/**
 * Renders tile maps for game world.
 * 
 * @author Fabulous Fellini
 *
 */
public class MapRenderer {

	/**
	 * Used to determine when to switch grass animations.
	 */
	private int timer = 0;
	
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
	 * Renders map.
	 * 
	 * @param MyGame    myGame
	 * @param MapHandler mapHandler
	 */
	public void renderMap(MyGame myGame, MapHandler mapHandler) { 
		timer++;
		if (timer > 100) {
			timer = 0;
		}
		int chunkWidth = mapHandler.mapChunkOne.worldMap.length;
		for (int i = 0; i < MapHandler.mapChunks.size(); i++) {
			for(int z = 0; z < chunkWidth; z++) {
				for(int x = 0; x < MapInformationHolder.CHUNK_WIDTH; x++) {
					if (playerIsWithinBoundsOfRenderingChunk(
							myGame,
							MapHandler.mapChunks.get(i), 
							x, 
							z
							)
							) {
						MapHandler.mapChunks.get(i).tileMap[x][z].draw(myGame.renderer.batch);
					}
				}
			}
		}
		
		// Uncomment this to draw entire game world.
		//drawEntireGameWorldAkaAllChunksAtOnce(myGame, mapHandler);
	}
	
	/**
	 * This method is for debugging purposes.  
	 * It draws the entire game world at once.
	 * Note: If this is activated, the game runs at about 5 frames per second.
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	private void drawEntireGameWorldAkaAllChunksAtOnce(MyGame myGame, MapHandler mapHandler) {
		for(int z = 0; z < mapHandler.mapChunkOne.worldMap.length; z++) {
			for(int x = 0; x < mapHandler.mapChunkOne.worldMap[z].length; x++) {
				mapHandler.mapChunkOne.tileMap[x][z].draw(myGame.renderer.batch);
				mapHandler.mapChunkTwo.tileMap[x][z].draw(myGame.renderer.batch);
				mapHandler.mapChunkThree.tileMap[x][z].draw(myGame.renderer.batch);
				mapHandler.mapChunkFour.tileMap[x][z].draw(myGame.renderer.batch);
				mapHandler.mapChunkFive.tileMap[x][z].draw(myGame.renderer.batch);
				mapHandler.mapChunkSix.tileMap[x][z].draw(myGame.renderer.batch);
				mapHandler.mapChunkSeven.tileMap[x][z].draw(myGame.renderer.batch);
				mapHandler.mapChunkEight.tileMap[x][z].draw(myGame.renderer.batch);
				mapHandler.mapChunkNine.tileMap[x][z].draw(myGame.renderer.batch);
				mapHandler.mapChunkTen.tileMap[x][z].draw(myGame.renderer.batch);
				mapHandler.mapChunkEleven.tileMap[x][z].draw(myGame.renderer.batch);
				mapHandler.mapChunkTwelve.tileMap[x][z].draw(myGame.renderer.batch);
				mapHandler.mapChunkThirteen.tileMap[x][z].draw(myGame.renderer.batch);
				mapHandler.mapChunkFourteen.tileMap[x][z].draw(myGame.renderer.batch);
				mapHandler.mapChunkFifteen.tileMap[x][z].draw(myGame.renderer.batch);
				mapHandler.mapChunkSixteen.tileMap[x][z].draw(myGame.renderer.batch);
				mapHandler.mapChunkSeventeen.tileMap[x][z].draw(myGame.renderer.batch);
				mapHandler.mapChunkEighteen.tileMap[x][z].draw(myGame.renderer.batch);
				mapHandler.mapChunkNineteen.tileMap[x][z].draw(myGame.renderer.batch);
				mapHandler.mapChunkTwenty.tileMap[x][z].draw(myGame.renderer.batch);
				mapHandler.mapChunkTwentyOne.tileMap[x][z].draw(myGame.renderer.batch);
				mapHandler.mapChunkTwentyTwo.tileMap[x][z].draw(myGame.renderer.batch);
				mapHandler.mapChunkTwentyThree.tileMap[x][z].draw(myGame.renderer.batch);
				mapHandler.mapChunkTwentyFour.tileMap[x][z].draw(myGame.renderer.batch);
				mapHandler.mapChunkTwentyFive.tileMap[x][z].draw(myGame.renderer.batch);
				mapHandler.mapChunkTwentySix.tileMap[x][z].draw(myGame.renderer.batch);
				mapHandler.mapChunkTwentySeven.tileMap[x][z].draw(myGame.renderer.batch);
				mapHandler.mapChunkTwentyEight.tileMap[x][z].draw(myGame.renderer.batch);
				mapHandler.mapChunkTwentyNine.tileMap[x][z].draw(myGame.renderer.batch);
				mapHandler.mapChunkThirty.tileMap[x][z].draw(myGame.renderer.batch);
				mapHandler.mapChunkThirtyOne.tileMap[x][z].draw(myGame.renderer.batch);
				mapHandler.mapChunkThirtyTwo.tileMap[x][z].draw(myGame.renderer.batch);
				mapHandler.mapChunkThirtyThree.tileMap[x][z].draw(myGame.renderer.batch);
			}
		}
	}
}
