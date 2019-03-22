package maps;

import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import maps.mapchunks.MapChunk;
import physics.CollisionHandler;
import tiles.Tile;

/**
 * Renders tile maps for game world.
 * 
 * @author Fabulous Fellini
 *
 */
public class MapRenderer {

	/**
	 * Used to determine which water tile to draw for animation.
	 */
	private int timer = 0;

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
		Tile chunkElement    = mapChunk.tileMap[arrayElement][arrayElement]; 
		if (
				playerX < chunkElement.getX() + MapInformationHolder.CHUNK_WIDTH + chunkOuterBounds &&
				playerX > chunkElement.getX() - chunkOuterBounds &&
				playerY < chunkElement.getY() + MapInformationHolder.CHUNK_HEIGHT + chunkOuterBounds &&
				playerY > chunkElement.getY() - chunkOuterBounds
				) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	public void renderMapOfChunks(MyGame myGame, MapHandler mapHandler) { 
		timer++;
		if (timer > 60) {
			timer = 0;
		}
		//GameObject player = PlayerController.getCurrentPlayer(myGame);
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
						animateWaterTiles(i, myGame, x, z);
						// Might need to make this method take a certain player, other wise its slow as shit.
						//if (GameObjectLoader.gameObjectList.contains(myGame.getGameObject(GameObject.PLAYER_ONE))) {
						CollisionHandler.checkIfPlayerHasCollidedWithSolidTile(
								myGame.getGameObject(GameObject.PLAYER_ONE), 
								mapHandler, 
								MapHandler.mapChunks.get(i).tileMap[x][z]
								);
						CollisionHandler.checkIfPlayerHasCollidedWithSandOrWaterTile(
								myGame.getGameObject(GameObject.PLAYER_ONE), 
								mapHandler, 
								MapHandler.mapChunks.get(i).tileMap[x][z]
								);
					}
				}
			}
		}

		// Uncomment this to draw entire game world.
		//Debugger.drawEntireGameWorldAllChunksAtOnce(myGame, mapHandler, totalChunkCount, chunkWidth, chunkHeight);
	}

	/**
	 * Animate tiles to the right.
	 * 
	 * @param int    tileNumber
	 * @param MyGame myGame
	 * @param int    row
	 * @param int    column
	 */
	private void animateWaterTiles(int tileNumber, MyGame myGame, int row, int column) {
		Tile tile = MapHandler.mapChunks.get(tileNumber).tileMap[row][column];
		if (tile.getName().equals("Water")) {
			if (
					(timer > 0 && timer < 10) ||
					(timer >= 30 && timer < 40)
					) {
				tile.setTexture(myGame.imageLoader.waterTileOne);
			} else if (
					(timer >= 10 && timer < 20) ||
					(timer >= 40 && timer < 50)
					) {
				tile.setTexture(myGame.imageLoader.waterTileTwo);
			} else {
				tile.setTexture(myGame.imageLoader.waterTileThree);
			}
		}
	}
}
