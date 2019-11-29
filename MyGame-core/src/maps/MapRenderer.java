package maps;

import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import handlers.CollisionHandler;
import maps.mapchunks.MapChunk;
import screens.GameScreen;
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
	private float timer = 0;

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
		float playerX          = myGame.getGameObject(GameObject.PLAYER_ONE).getX();
		float playerY          = myGame.getGameObject(GameObject.PLAYER_ONE).getY();
		float chunkOuterBounds = 13.5f;
		int arrayElement       = 0;
		Tile chunkElement      = mapChunk.tileMap[arrayElement][arrayElement]; 
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
						if (gameObjectIsWithinScreenBounds(MapHandler.mapChunks.get(i).tileMap[x][z])) {
							MapHandler.mapChunks.get(i).tileMap[x][z].draw(myGame.renderer.batch);
							animateWaterTiles(i, myGame, x, z);
						}
						/*
						CollisionHandler.checkIfPlayerHasCollidedWithSolidTile(
								myGame.getGameObject(GameObject.PLAYER_ONE), 
								mapHandler, 
								MapHandler.mapChunks.get(i).tileMap[x][z]
								); */
						CollisionHandler.checkIfPlayerHasCollidedWithSandOrWaterTile(
								myGame.getGameObject(GameObject.PLAYER_ONE), 
								mapHandler, 
								MapHandler.mapChunks.get(i).tileMap[x][z]
								);
						/**
						 * This slows the game down.  Maybe we don't need it as enemies will always follow player anyway.
						 * 
						 * Take this out for now and make enemies swim after player.
						 */
						/*
						for (int k = 0; k < myGame.gameScreen.enemyHandler.enemySpawner.length; k++) {
							if (myGame.gameScreen.enemyHandler.enemySpawner[k].enemies != null) {
								for (int enemy = 0; enemy < myGame.gameScreen.enemyHandler.enemySpawner[k].enemies.size(); enemy++) {
									if (myGame.gameScreen.enemyHandler.enemySpawner[k].enemies.get(enemy) != null) {
										CollisionHandler.checkIfNPCHasCollidedWithSandOrWaterTile(
												myGame.gameScreen.enemyHandler.enemySpawner[k].enemies.get(enemy), 
												mapHandler, 
												MapHandler.mapChunks.get(i).tileMap[x][z]
												);
									}
								}
							}
						} */
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
		timer += 0.005f;
		if (timer > 50) {
			timer = 0;
		}
		Tile tile = MapHandler.mapChunks.get(tileNumber).tileMap[row][column];
		if (tile.getName().equals("Water")) {
			if (
					(timer > 0 && timer < 10) ||
					(timer >= 30 && timer < 40)
					) {
				tile.setTexture(myGame.imageLoader.waterTileThree);
			} else if (
					(timer >= 10 && timer < 20) ||
					(timer >= 40 && timer < 50)
					) {
				tile.setTexture(myGame.imageLoader.waterTileTwo);
			} else {
				tile.setTexture(myGame.imageLoader.waterTileOne);
			}
		}
	}

	/**
	 * Determines if game object is rendering bounds.
	 * 
	 * @param Tile gameObject
	 * @return boolean
	 */
	public static boolean gameObjectIsWithinScreenBounds(Tile gameObject) {
		float cameraXPosition   = GameScreen.camera.position.x;
		float cameraYPosition   = GameScreen.camera.position.y;
		float playerXPosition   = gameObject.getX();
		float playerYPosition   = gameObject.getY();
		float screenBoundOffset = 15.0f;
		if (
				playerXPosition < cameraXPosition + screenBoundOffset &&
				playerXPosition > cameraXPosition - screenBoundOffset &&
				playerYPosition < cameraYPosition + screenBoundOffset &&
				playerYPosition > cameraYPosition - screenBoundOffset
				) {
			return true;
		}
		return false;
	}
}
