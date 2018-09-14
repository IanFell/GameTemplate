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
		for(int z = 0; z < mapHandler.mapChunkOne.worldMap.length; z++) {
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
			}
		}
	}

	/**
	 * 
	 * @param Tile tile
	 * @param int  x
	 * @param int  z
	 * @param int  size
	 * @param int  xPosition
	 * @param int  zPosition
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
			tileMap[x][z] = new Tile(Tile.sandTexture, !isSolid);
		}
		if (worldMap[z][x] == MapInformationHolder.WaterTileOne) {  
			tileMap[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
		}
		if (worldMap[z][x] == MapInformationHolder.WaterTileTwo) {  
			tileMap[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
		}
	}
}
