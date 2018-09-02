package maps;

import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;

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
		int visibleChunkOffsetValue = 10;
		int rowOneChunkYHeight      = mapHandler.mapChunkOne.tileMap[MapInformationHolder.CHUNK_HEIGHT].length + visibleChunkOffsetValue;
		int chunkWidth              = mapHandler.mapChunkOne.worldMap.length;
		float playerX               = myGame.getGameObject(GameObject.PLAYER_ONE).getX();
		float playerY               = myGame.getGameObject(GameObject.PLAYER_ONE).getY();
		
		// Draw chunk one.
		if (
				playerX < mapHandler.mapChunkTwo.tileMap.length + visibleChunkOffsetValue &&
				playerY < rowOneChunkYHeight
				) {
			for(int z = 0; z < chunkWidth; z++) {
				for(int x = 0; x < mapHandler.mapChunkOne.worldMap[z].length; x++) {
					mapHandler.mapChunkOne.tileMap[x][z].draw(myGame.renderer.batch);
				}
			}
		}

		// Draw chunk two.
		if (
				playerX > mapHandler.mapChunkOne.tileMap.length - visibleChunkOffsetValue &&
				playerX < mapHandler.mapChunkTwo.tileMap.length * 2 + visibleChunkOffsetValue &&
				playerY < rowOneChunkYHeight
				) {
			for(int z = 0; z < chunkWidth; z++) {
				for(int x = 0; x < mapHandler.mapChunkTwo.worldMap[z].length; x++) {
					mapHandler.mapChunkTwo.tileMap[x][z].draw(myGame.renderer.batch);
				}
			}
		}

		// Draw chunk three.
		if (
				playerX > mapHandler.mapChunkTwo.tileMap.length * 2 - visibleChunkOffsetValue &&
				playerX < mapHandler.mapChunkThree.tileMap.length * 3 + visibleChunkOffsetValue &&
				playerY < rowOneChunkYHeight
				) {
			for(int z = 0; z < chunkWidth; z++) {
				for(int x = 0; x < mapHandler.mapChunkThree.worldMap[z].length; x++) {
					mapHandler.mapChunkThree.tileMap[x][z].draw(myGame.renderer.batch);
				}
			}
		}

		// Draw chunk four.
		if (
				playerX > mapHandler.mapChunkThree.tileMap.length * 3 - visibleChunkOffsetValue &&
				playerX < mapHandler.mapChunkFour.tileMap.length * 4 + visibleChunkOffsetValue &&
				playerY < rowOneChunkYHeight
				) {
			for(int z = 0; z < chunkWidth; z++) {
				for(int x = 0; x < mapHandler.mapChunkThree.worldMap[z].length; x++) {
					mapHandler.mapChunkFour.tileMap[x][z].draw(myGame.renderer.batch);
				}
			}
		}

		// Draw chunk five.
		if (
				playerX > mapHandler.mapChunkFour.tileMap.length * 4 - visibleChunkOffsetValue &&
				playerX < mapHandler.mapChunkFive.tileMap.length * 5 + visibleChunkOffsetValue &&
				playerY < rowOneChunkYHeight
				) {
			for(int z = 0; z < chunkWidth; z++) {
				for(int x = 0; x < mapHandler.mapChunkFive.worldMap[z].length; x++) {
					mapHandler.mapChunkFive.tileMap[x][z].draw(myGame.renderer.batch);
				}
			}
		}

		// Draw chunk six.
		if (
				playerX > mapHandler.mapChunkFive.tileMap.length * 5 - visibleChunkOffsetValue &&
				playerX < mapHandler.mapChunkSix.tileMap.length * 6 + visibleChunkOffsetValue &&
				playerY < rowOneChunkYHeight
				) {
			for(int z = 0; z < chunkWidth; z++) {
				for(int x = 0; x < mapHandler.mapChunkSix.worldMap[z].length; x++) {
					mapHandler.mapChunkSix.tileMap[x][z].draw(myGame.renderer.batch);
				}
			}
		}

		// Draw chunk seven.
		if (
				playerX > mapHandler.mapChunkSix.tileMap.length * 6 - visibleChunkOffsetValue &&
				playerX < mapHandler.mapChunkSeven.tileMap.length * 7 + visibleChunkOffsetValue &&
				playerY < rowOneChunkYHeight
				) {
			for(int z = 0; z < chunkWidth; z++) {
				for(int x = 0; x < mapHandler.mapChunkSeven.worldMap[z].length; x++) {
					mapHandler.mapChunkSeven.tileMap[x][z].draw(myGame.renderer.batch);
				}
			}
		}

		// Draw chunk eight.
		if (
				playerX > mapHandler.mapChunkSeven.tileMap.length * 7 - visibleChunkOffsetValue &&
				playerX < mapHandler.mapChunkEight.tileMap.length * 8 + visibleChunkOffsetValue &&
				playerY < rowOneChunkYHeight
				) {
			for(int z = 0; z < chunkWidth; z++) {
				for(int x = 0; x < mapHandler.mapChunkEight.worldMap[z].length; x++) {
					mapHandler.mapChunkEight.tileMap[x][z].draw(myGame.renderer.batch);
				}
			}
		}

		// Draw chunk nine.
		if (
				playerX < mapHandler.mapChunkTwo.tileMap.length + visibleChunkOffsetValue && 
				playerY > mapHandler.mapChunkOne.tileMap[MapInformationHolder.CHUNK_HEIGHT].length - visibleChunkOffsetValue &&
				playerY < mapHandler.mapChunkSeventeen.tileMap[MapInformationHolder.CHUNK_HEIGHT].length * 2 + visibleChunkOffsetValue
				
				) {
			for(int z = 0; z < chunkWidth; z++) {
				for(int x = 0; x < mapHandler.mapChunkNine.worldMap[z].length; x++) {
					mapHandler.mapChunkNine.tileMap[x][z].draw(myGame.renderer.batch);
				}
			}
		}
		
		// Draw chunk ten.
				if (
						playerY > mapHandler.mapChunkOne.tileMap[MapInformationHolder.CHUNK_HEIGHT].length - visibleChunkOffsetValue &&
						playerX > mapHandler.mapChunkTwo.tileMap.length - visibleChunkOffsetValue &&
						playerX < mapHandler.mapChunkThree.tileMap[0].length * 3 + visibleChunkOffsetValue
						) {
					for(int z = 0; z < chunkWidth; z++) {
						for(int x = 0; x < mapHandler.mapChunkTen.worldMap[z].length; x++) {
							mapHandler.mapChunkTen.tileMap[x][z].draw(myGame.renderer.batch);
						}
					}
				}
				
				// Draw chunk eleven.
				if (
						playerY > mapHandler.mapChunkOne.tileMap[MapInformationHolder.CHUNK_HEIGHT].length - visibleChunkOffsetValue &&
						playerX > mapHandler.mapChunkThree.tileMap.length * 2 - visibleChunkOffsetValue &&
						playerX < mapHandler.mapChunkFour.tileMap[0].length * 4 + visibleChunkOffsetValue
						) {
					for(int z = 0; z < chunkWidth; z++) {
						for(int x = 0; x < mapHandler.mapChunkEleven.worldMap[z].length; x++) {
							mapHandler.mapChunkEleven.tileMap[x][z].draw(myGame.renderer.batch);
						}
					}
				}
				
				// Draw chunk twelve.
				if (
						playerY > mapHandler.mapChunkOne.tileMap[MapInformationHolder.CHUNK_HEIGHT].length - visibleChunkOffsetValue &&
						playerX > mapHandler.mapChunkFour.tileMap.length * 3 - visibleChunkOffsetValue &&
						playerX < mapHandler.mapChunkFive.tileMap[0].length * 5 + visibleChunkOffsetValue * 3
						) {
					for(int z = 0; z < chunkWidth; z++) {
						for(int x = 0; x < mapHandler.mapChunkTwelve.worldMap[z].length; x++) {
							mapHandler.mapChunkTwelve.tileMap[x][z].draw(myGame.renderer.batch);
						}
					}
				}
				
				
				
				// fucked up here.
				
				
				
				// Draw chunk thirteen.
				if (
						playerY > mapHandler.mapChunkOne.tileMap[MapInformationHolder.CHUNK_HEIGHT].length - visibleChunkOffsetValue &&
						playerX > mapHandler.mapChunkSix.tileMap.length * 4 - visibleChunkOffsetValue &&
						playerX < mapHandler.mapChunkSix.tileMap[0].length * 6 + visibleChunkOffsetValue * 5
						) {
					for(int z = 0; z < chunkWidth; z++) {
						for(int x = 0; x < mapHandler.mapChunkThirteen.worldMap[z].length; x++) {
							mapHandler.mapChunkThirteen.tileMap[x][z].draw(myGame.renderer.batch);
						}
					}
				}
				
				// Draw chunk fourteen.
				if (
						playerY > mapHandler.mapChunkOne.tileMap[MapInformationHolder.CHUNK_HEIGHT].length - visibleChunkOffsetValue &&
						playerX > mapHandler.mapChunkSix.tileMap.length * 5 - visibleChunkOffsetValue &&
						playerX < mapHandler.mapChunkSix.tileMap[0].length * 7 + visibleChunkOffsetValue * 6
						) {
					for(int z = 0; z < chunkWidth; z++) {
						for(int x = 0; x < mapHandler.mapChunkFourteen.worldMap[z].length; x++) {
							mapHandler.mapChunkFourteen.tileMap[x][z].draw(myGame.renderer.batch);
						}
					}
				}
				
				// Draw chunk fifteen.
				if (
						playerY > mapHandler.mapChunkOne.tileMap[MapInformationHolder.CHUNK_HEIGHT].length - visibleChunkOffsetValue &&
						playerX > mapHandler.mapChunkSix.tileMap.length * 6 - visibleChunkOffsetValue &&
						playerX < mapHandler.mapChunkSix.tileMap[0].length * 8 + visibleChunkOffsetValue * 8
						) {
					for(int z = 0; z < chunkWidth; z++) {
						for(int x = 0; x < mapHandler.mapChunkFourteen.worldMap[z].length; x++) {
							mapHandler.mapChunkFifteen.tileMap[x][z].draw(myGame.renderer.batch);
						}
					}
				}
				
				// Draw chunk sixteen.
				if (
						playerY > mapHandler.mapChunkOne.tileMap[MapInformationHolder.CHUNK_HEIGHT].length - visibleChunkOffsetValue &&
						playerX > mapHandler.mapChunkSix.tileMap.length * 7 - visibleChunkOffsetValue &&
						playerX < mapHandler.mapChunkSix.tileMap[0].length * 9 + visibleChunkOffsetValue * 10
						) {
					for(int z = 0; z < chunkWidth; z++) {
						for(int x = 0; x < mapHandler.mapChunkFourteen.worldMap[z].length; x++) {
							mapHandler.mapChunkSixteen.tileMap[x][z].draw(myGame.renderer.batch);
						}
					}
				}
				
				// Draw chunk seventeen.
				if (
						playerX < mapHandler.mapChunkTwo.tileMap.length + visibleChunkOffsetValue && 
						playerY > mapHandler.mapChunkNine.tileMap[MapInformationHolder.CHUNK_HEIGHT].length * 2 - visibleChunkOffsetValue 
						
						) {
					for(int z = 0; z < chunkWidth; z++) {
						for(int x = 0; x < mapHandler.mapChunkNine.worldMap[z].length; x++) {
							mapHandler.mapChunkSeventeen.tileMap[x][z].draw(myGame.renderer.batch);
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
			}
		}
	}
}
