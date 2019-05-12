package maps;

import com.mygdx.mygame.MyGame;

import tiles.Tile;

/**
 * Instantiates and sets tiles for chunks.
 * 
 * @author Fabulous Fellini
 *
 */
public class MapLoader {

	private boolean isSolid = true;

	/**
	 * Creates and initializes tiles for map.
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	public void loadMap(MyGame myGame, MapHandler mapHandler) { 
		Tile.initializeTileTextures(myGame); 
		int tileSize          = 1;
		int chunkOffsetXValue = MapInformationHolder.CHUNK_WIDTH;
		int chunkOffsetYValue = MapInformationHolder.CHUNK_HEIGHT;
		for(int z = 0; z < MapInformationHolder.CHUNK_HEIGHT; z++) {
			for(int x = 0; x < mapHandler.mapChunkOne.worldMap[z].length; x++) {
				loadTile(mapHandler.mapChunkOne.worldMap, mapHandler.mapChunkOne.tileMap, x, z);
				setTile(mapHandler.mapChunkOne.tileMap, x, z, tileSize, x, z);

				loadTile(mapHandler.mapChunkTwo.worldMap, mapHandler.mapChunkTwo.tileMap, x, z);
				setTile(mapHandler.mapChunkTwo.tileMap, x, z, tileSize, x + chunkOffsetXValue, z);

				loadTile(mapHandler.mapChunkThree.worldMap, mapHandler.mapChunkThree.tileMap, x, z);
				setTile(mapHandler.mapChunkThree.tileMap, x, z, tileSize, x + chunkOffsetXValue * 2, z);

				loadTile(mapHandler.mapChunkFour.worldMap, mapHandler.mapChunkFour.tileMap, x, z);
				setTile(mapHandler.mapChunkFour.tileMap, x, z, tileSize, x + chunkOffsetXValue * 3, z);

				loadTile(mapHandler.mapChunkFive.worldMap, mapHandler.mapChunkFive.tileMap, x, z);
				setTile(mapHandler.mapChunkFive.tileMap, x, z, tileSize, x + chunkOffsetXValue * 4, z);

				loadTile(mapHandler.mapChunkSix.worldMap, mapHandler.mapChunkSix.tileMap, x, z);
				setTile(mapHandler.mapChunkSix.tileMap, x, z, tileSize, x + chunkOffsetXValue * 5, z);

				loadTile(mapHandler.mapChunkSeven.worldMap, mapHandler.mapChunkSeven.tileMap, x, z);
				setTile(mapHandler.mapChunkSeven.tileMap, x, z, tileSize, x + chunkOffsetXValue * 6, z);

				loadTile(mapHandler.mapChunkEight.worldMap, mapHandler.mapChunkEight.tileMap, x, z);
				setTile(mapHandler.mapChunkEight.tileMap, x, z, tileSize, x + chunkOffsetXValue * 7, z);

				loadTile(mapHandler.mapChunkNine.worldMap, mapHandler.mapChunkNine.tileMap, x, z);
				setTile(mapHandler.mapChunkNine.tileMap, x, z, tileSize, x, z + chunkOffsetYValue);

				loadTile(mapHandler.mapChunkTen.worldMap, mapHandler.mapChunkTen.tileMap, x, z);
				setTile(mapHandler.mapChunkTen.tileMap, x, z, tileSize, x + chunkOffsetXValue, z + chunkOffsetYValue);

				loadTile(mapHandler.mapChunkEleven.worldMap, mapHandler.mapChunkEleven.tileMap, x, z);
				setTile(mapHandler.mapChunkEleven.tileMap, x, z, tileSize, x + chunkOffsetXValue * 2, z + chunkOffsetYValue);

				loadTile(mapHandler.mapChunkTwelve.worldMap, mapHandler.mapChunkTwelve.tileMap, x, z);
				setTile(mapHandler.mapChunkTwelve.tileMap, x, z, tileSize, x + chunkOffsetXValue * 3, z + chunkOffsetYValue);

				loadTile(mapHandler.mapChunkThirteen.worldMap, mapHandler.mapChunkThirteen.tileMap, x, z);
				setTile(mapHandler.mapChunkThirteen.tileMap, x, z, tileSize, x + chunkOffsetXValue * 4, z + chunkOffsetYValue);

				loadTile(mapHandler.mapChunkFourteen.worldMap, mapHandler.mapChunkFourteen.tileMap, x, z);
				setTile(mapHandler.mapChunkFourteen.tileMap, x, z, tileSize, x + chunkOffsetXValue * 5, z + chunkOffsetYValue);

				loadTile(mapHandler.mapChunkFifteen.worldMap, mapHandler.mapChunkFifteen.tileMap, x, z);
				setTile(mapHandler.mapChunkFifteen.tileMap, x, z, tileSize, x + chunkOffsetXValue * 6, z + chunkOffsetYValue);

				loadTile(mapHandler.mapChunkSixteen.worldMap, mapHandler.mapChunkSixteen.tileMap, x, z);
				setTile(mapHandler.mapChunkSixteen.tileMap, x, z, tileSize, x + chunkOffsetXValue * 7, z + chunkOffsetYValue);

				loadTile(mapHandler.mapChunkSeventeen.worldMap, mapHandler.mapChunkSeventeen.tileMap, x, z);
				setTile(mapHandler.mapChunkSeventeen.tileMap, x, z, tileSize, x, z + chunkOffsetYValue * 2);

				int yPositionRowDistance = 2;
				loadTile(mapHandler.mapChunkEighteen.worldMap, mapHandler.mapChunkEighteen.tileMap, x, z);
				setTile(mapHandler.mapChunkEighteen.tileMap, x, z, tileSize, x + chunkOffsetXValue, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkNineteen.worldMap, mapHandler.mapChunkNineteen.tileMap, x, z);
				setTile(mapHandler.mapChunkNineteen.tileMap, x, z, tileSize, x + chunkOffsetXValue * 2, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkTwenty.worldMap, mapHandler.mapChunkTwenty.tileMap, x, z);
				setTile(mapHandler.mapChunkTwenty.tileMap, x, z, tileSize, x + chunkOffsetXValue * 3, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkTwentyOne.worldMap, mapHandler.mapChunkTwentyOne.tileMap, x, z);
				setTile(mapHandler.mapChunkTwentyOne.tileMap, x, z, tileSize, x + chunkOffsetXValue * 4, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkTwentyTwo.worldMap, mapHandler.mapChunkTwentyTwo.tileMap, x, z);
				setTile(mapHandler.mapChunkTwentyTwo.tileMap, x, z, tileSize, x + chunkOffsetXValue * 5, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkTwentyThree.worldMap, mapHandler.mapChunkTwentyThree.tileMap, x, z);
				setTile(mapHandler.mapChunkTwentyThree.tileMap, x, z, tileSize, x + chunkOffsetXValue * 6, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkTwentyFour.worldMap, mapHandler.mapChunkTwentyFour.tileMap, x, z);
				setTile(mapHandler.mapChunkTwentyFour.tileMap, x, z, tileSize, x + chunkOffsetXValue * 7, z + chunkOffsetYValue * yPositionRowDistance);

				yPositionRowDistance = 3;
				loadTile(mapHandler.mapChunkTwentyFive.worldMap, mapHandler.mapChunkTwentyFive.tileMap, x, z);
				setTile(mapHandler.mapChunkTwentyFive.tileMap, x, z, tileSize, x, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkTwentySix.worldMap, mapHandler.mapChunkTwentySix.tileMap, x, z);
				setTile(mapHandler.mapChunkTwentySix.tileMap, x, z, tileSize, x + chunkOffsetXValue, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkTwentySeven.worldMap, mapHandler.mapChunkTwentySeven.tileMap, x, z);
				setTile(mapHandler.mapChunkTwentySeven.tileMap, x, z, tileSize, x + chunkOffsetXValue * 2, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkTwentyEight.worldMap, mapHandler.mapChunkTwentyEight.tileMap, x, z);
				setTile(mapHandler.mapChunkTwentyEight.tileMap, x, z, tileSize, x + chunkOffsetXValue * 3, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkTwentyNine.worldMap, mapHandler.mapChunkTwentyNine.tileMap, x, z);
				setTile(mapHandler.mapChunkTwentyNine.tileMap, x, z, tileSize, x + chunkOffsetXValue * 4, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkThirty.worldMap, mapHandler.mapChunkThirty.tileMap, x, z);
				setTile(mapHandler.mapChunkThirty.tileMap, x, z, tileSize, x + chunkOffsetXValue * 5, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkThirtyOne.worldMap, mapHandler.mapChunkThirtyOne.tileMap, x, z);
				setTile(mapHandler.mapChunkThirtyOne.tileMap, x, z, tileSize, x + chunkOffsetXValue * 6, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkThirtyTwo.worldMap, mapHandler.mapChunkThirtyTwo.tileMap, x, z);
				setTile(mapHandler.mapChunkThirtyTwo.tileMap, x, z, tileSize, x + chunkOffsetXValue * 7, z + chunkOffsetYValue * yPositionRowDistance);

				yPositionRowDistance = 4;
				loadTile(mapHandler.mapChunkThirtyThree.worldMap, mapHandler.mapChunkThirtyThree.tileMap, x, z);
				setTile(mapHandler.mapChunkThirtyThree.tileMap, x, z, tileSize, x, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkThirtyFour.worldMap, mapHandler.mapChunkThirtyFour.tileMap, x, z);
				setTile(mapHandler.mapChunkThirtyFour.tileMap, x, z, tileSize, x + chunkOffsetXValue, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkThirtyFive.worldMap, mapHandler.mapChunkThirtyFive.tileMap, x, z);
				setTile(mapHandler.mapChunkThirtyFive.tileMap, x, z, tileSize, x + chunkOffsetXValue * 2, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkThirtySix.worldMap, mapHandler.mapChunkThirtySix.tileMap, x, z);
				setTile(mapHandler.mapChunkThirtySix.tileMap, x, z, tileSize, x + chunkOffsetXValue * 3, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkThirtySeven.worldMap, mapHandler.mapChunkThirtySeven.tileMap, x, z);
				setTile(mapHandler.mapChunkThirtySeven.tileMap, x, z, tileSize, x + chunkOffsetXValue * 4, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkThirtyEight.worldMap, mapHandler.mapChunkThirtyEight.tileMap, x, z);
				setTile(mapHandler.mapChunkThirtyEight.tileMap, x, z, tileSize, x + chunkOffsetXValue * 5, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkThirtyNine.worldMap, mapHandler.mapChunkThirtyNine.tileMap, x, z);
				setTile(mapHandler.mapChunkThirtyNine.tileMap, x, z, tileSize, x + chunkOffsetXValue * 6, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkFourty.worldMap, mapHandler.mapChunkFourty.tileMap, x, z);
				setTile(mapHandler.mapChunkFourty.tileMap, x, z, tileSize, x + chunkOffsetXValue * 7, z + chunkOffsetYValue * yPositionRowDistance);

				yPositionRowDistance = 5;
				loadTile(mapHandler.mapChunkFourtyOne.worldMap, mapHandler.mapChunkFourtyOne.tileMap, x, z);
				setTile(mapHandler.mapChunkFourtyOne.tileMap, x, z, tileSize, x, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkFourtyTwo.worldMap, mapHandler.mapChunkFourtyTwo.tileMap, x, z);
				setTile(mapHandler.mapChunkFourtyTwo.tileMap, x, z, tileSize, x + chunkOffsetXValue, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkFourtyThree.worldMap, mapHandler.mapChunkFourtyThree.tileMap, x, z);
				setTile(mapHandler.mapChunkFourtyThree.tileMap, x, z, tileSize, x + chunkOffsetXValue * 2, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkFourtyFour.worldMap, mapHandler.mapChunkFourtyFour.tileMap, x, z);
				setTile(mapHandler.mapChunkFourtyFour.tileMap, x, z, tileSize, x + chunkOffsetXValue * 3, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkFourtyFive.worldMap, mapHandler.mapChunkFourtyFive.tileMap, x, z);
				setTile(mapHandler.mapChunkFourtyFive.tileMap, x, z, tileSize, x + chunkOffsetXValue * 4, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkFourtySix.worldMap, mapHandler.mapChunkFourtySix.tileMap, x, z);
				setTile(mapHandler.mapChunkFourtySix.tileMap, x, z, tileSize, x + chunkOffsetXValue * 5, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkFourtySeven.worldMap, mapHandler.mapChunkFourtySeven.tileMap, x, z);
				setTile(mapHandler.mapChunkFourtySeven.tileMap, x, z, tileSize, x + chunkOffsetXValue * 6, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkFourtyEight.worldMap, mapHandler.mapChunkFourtyEight.tileMap, x, z);
				setTile(mapHandler.mapChunkFourtyEight.tileMap, x, z, tileSize, x + chunkOffsetXValue * 7, z + chunkOffsetYValue * yPositionRowDistance);

				yPositionRowDistance = 6;
				loadTile(mapHandler.mapChunkFourtyNine.worldMap, mapHandler.mapChunkFourtyNine.tileMap, x, z);
				setTile(mapHandler.mapChunkFourtyNine.tileMap, x, z, tileSize, x, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkFifty.worldMap, mapHandler.mapChunkFifty.tileMap, x, z);
				setTile(mapHandler.mapChunkFifty.tileMap, x, z, tileSize, x + chunkOffsetXValue, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkFiftyOne.worldMap, mapHandler.mapChunkFiftyOne.tileMap, x, z);
				setTile(mapHandler.mapChunkFiftyOne.tileMap, x, z, tileSize, x + chunkOffsetXValue * 2, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkFiftyTwo.worldMap, mapHandler.mapChunkFiftyTwo.tileMap, x, z);
				setTile(mapHandler.mapChunkFiftyTwo.tileMap, x, z, tileSize, x + chunkOffsetXValue * 3, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkFiftyThree.worldMap, mapHandler.mapChunkFiftyThree.tileMap, x, z);
				setTile(mapHandler.mapChunkFiftyThree.tileMap, x, z, tileSize, x + chunkOffsetXValue * 4, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkFiftyFour.worldMap, mapHandler.mapChunkFiftyFour.tileMap, x, z);
				setTile(mapHandler.mapChunkFiftyFour.tileMap, x, z, tileSize, x + chunkOffsetXValue * 5, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkFiftyFive.worldMap, mapHandler.mapChunkFiftyFive.tileMap, x, z);
				setTile(mapHandler.mapChunkFiftyFive.tileMap, x, z, tileSize, x + chunkOffsetXValue * 6, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkFiftySix.worldMap, mapHandler.mapChunkFiftySix.tileMap, x, z);
				setTile(mapHandler.mapChunkFiftySix.tileMap, x, z, tileSize, x + chunkOffsetXValue * 7, z + chunkOffsetYValue * yPositionRowDistance);

				yPositionRowDistance = 7;
				loadTile(mapHandler.mapChunkFiftySeven.worldMap, mapHandler.mapChunkFiftySeven.tileMap, x, z);
				setTile(mapHandler.mapChunkFiftySeven.tileMap, x, z, tileSize, x, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkFiftyEight.worldMap, mapHandler.mapChunkFiftyEight.tileMap, x, z);
				setTile(mapHandler.mapChunkFiftyEight.tileMap, x, z, tileSize, x + chunkOffsetXValue, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkFiftyNine.worldMap, mapHandler.mapChunkFiftyNine.tileMap, x, z);
				setTile(mapHandler.mapChunkFiftyNine.tileMap, x, z, tileSize, x + chunkOffsetXValue * 2, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkSixty.worldMap, mapHandler.mapChunkSixty.tileMap, x, z);
				setTile(mapHandler.mapChunkSixty.tileMap, x, z, tileSize, x + chunkOffsetXValue * 3, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkSixtyOne.worldMap, mapHandler.mapChunkSixtyOne.tileMap, x, z);
				setTile(mapHandler.mapChunkSixtyOne.tileMap, x, z, tileSize, x + chunkOffsetXValue * 4, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkSixtyTwo.worldMap, mapHandler.mapChunkSixtyTwo.tileMap, x, z);
				setTile(mapHandler.mapChunkSixtyTwo.tileMap, x, z, tileSize, x + chunkOffsetXValue * 5, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkSixtyThree.worldMap, mapHandler.mapChunkSixtyThree.tileMap, x, z);
				setTile(mapHandler.mapChunkSixtyThree.tileMap, x, z, tileSize, x + chunkOffsetXValue * 6, z + chunkOffsetYValue * yPositionRowDistance);

				loadTile(mapHandler.mapChunkSixtyFour.worldMap, mapHandler.mapChunkSixtyFour.tileMap, x, z);
				setTile(mapHandler.mapChunkSixtyFour.tileMap, x, z, tileSize, x + chunkOffsetXValue * 7, z + chunkOffsetYValue * yPositionRowDistance);
			}
		}
	}

	/**
	 * 
	 * @param Tile[][] tile
	 * @param int      x
	 * @param int      z
	 * @param int      size
	 * @param int      xPosition
	 * @param int      zPosition
	 */
	private void setTile(Tile[][] tile, int x, int z, int size, int xPosition, int zPosition) {
		tile[x][z].setPosition(xPosition, zPosition);
		tile[x][z].setSize(size, size);
	}

	/**
	 * 
	 * @param int[][]  worldMap
	 * @param Tile[][] tileMap
	 * @param int      x
	 * @param int      z
	 */
	private void loadTile(int[][] worldMap, Tile[][] tileMap, int x, int z) {
		if (worldMap[z][x] == MapInformationHolder.SandTile) {  
			tileMap[x][z] = new Tile(Tile.sandTexture, !isSolid, "Sand", false);
		}
		if (worldMap[z][x] == MapInformationHolder.WaterTileOne) {  
			tileMap[x][z] = new Tile(Tile.waterTextureOne, !isSolid, "Water", true);
		}
		if (worldMap[z][x] == MapInformationHolder.SolidTile) {  
			tileMap[x][z] = new Tile(Tile.sandTexture, isSolid, "Solid", false);
		}
		if (worldMap[z][x] == MapInformationHolder.GrassTile) {  
			tileMap[x][z] = new Tile(Tile.grassTextureOne, !isSolid, "Grass", false);
		}
		if (worldMap[z][x] == MapInformationHolder.SandTileHorizontalPath) {  
			tileMap[x][z] = new Tile(Tile.sandTextureHorizontalPath, !isSolid, "SandTileHorizontalPath", false);
		}
		if (worldMap[z][x] == MapInformationHolder.SandTileLeftDownPath) {  
			tileMap[x][z] = new Tile(Tile.sandTextureLeftDownPath, !isSolid, "SandTileLeftDownPath", false);
		}
		if (worldMap[z][x] == MapInformationHolder.SandTileVerticalPath) {  
			tileMap[x][z] = new Tile(Tile.sandTextureVerticalPath, !isSolid, "SandTileVerticalPath", false);
		}
		if (worldMap[z][x] == MapInformationHolder.SandTileTopRightPath) {  
			tileMap[x][z] = new Tile(Tile.sandTextureTopRightPath, !isSolid, "SandTileTopRightPath", false);
		}
		if (worldMap[z][x] == MapInformationHolder.SandTileCrossPath) {  
			tileMap[x][z] = new Tile(Tile.sandTextureCrossPath, !isSolid, "SandTileCrossPath", false);
		}
	}
}
