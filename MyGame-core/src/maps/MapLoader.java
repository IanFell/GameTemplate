package maps;

import com.mygdx.mygame.MyGame;

import tiles.Tile;

/**
 * Loads level maps / creates tiles for level maps.
 * 
 * @author Fabulous Fellini
 *
 */
public class MapLoader {
	
	private boolean isSolid = true;

	/**
	 * Creates and initializes tiles for map.
	 * 
	 * @param MyGame    myGame
	 * @param MapEditor mapEditor
	 */
	public void loadMap(MyGame myGame, MapEditor mapEditor) { 
		Tile.initializeTileTextures(myGame);
		for(int z = 0; z < mapEditor.worldMap2027.length; z++) {
			for(int x = 0; x < mapEditor.worldMap2027[z].length; x++) {
				loadWorldMaps(mapEditor, x, z);
			}
		}
	}

	/**
	 * Loads all world maps.  
	 * 
	 * @param MapEditor mapEditor
	 * @param int       x
	 * @param int       z
	 */
	private void loadWorldMaps(MapEditor mapEditor, int x, int z) {
		int tileSize    = 1;
		int gridOffset  = 20;
		
		loadTile(mapEditor.worldMap2027, mapEditor.tileMap2027, x, z);
		setTile(mapEditor.tileMap2027, x, z, tileSize, x, z);
		
		loadTile(mapEditor.worldMapAnimated2027, mapEditor.tileMapAnimated2027, x, z);
		setTile(mapEditor.tileMapAnimated2027, x, z, tileSize, x, z);
		
		loadTile(mapEditor.worldMap2026, mapEditor.tileMap2026, x, z);
		setTile(mapEditor.tileMap2026, x, z, tileSize, x - gridOffset, z);
		
		loadTile(mapEditor.worldMapAnimated2026, mapEditor.tileMapAnimated2026, x, z);
		setTile(mapEditor.tileMapAnimated2026, x, z, tileSize, x - gridOffset, z);
		
		loadTile(mapEditor.worldMap1925, mapEditor.tileMap1925, x, z);
		setTile(mapEditor.tileMap1925, x, z, tileSize, x - gridOffset * 2, z - gridOffset);
		
		loadTile(mapEditor.worldMapAnimated1925, mapEditor.tileMapAnimated1925, x, z);
		setTile(mapEditor.tileMapAnimated1925, x, z, tileSize, x - gridOffset * 2, z - gridOffset);
		
		loadTile(mapEditor.worldMap1827, mapEditor.tileMap1827, x, z);
		setTile(mapEditor.tileMap1827, x, z, tileSize, x, z - gridOffset * 2);
		
		loadTile(mapEditor.worldMapAnimated1827, mapEditor.tileMapAnimated1827, x, z);
		setTile(mapEditor.tileMapAnimated1827, x, z, tileSize, x, z - gridOffset * 2);
		
		// Solid sand map.
		if (mapEditor.solidSandWorldMap[z][x] == MapEditor.SolidTile) {  
			mapEditor.solidSandTileMap1927[x][z] = new Tile(Tile.buildingTexture, isSolid);
			mapEditor.solidSandTileMap1926[x][z] = new Tile(Tile.buildingTexture, isSolid);
			mapEditor.solidSandTileMap1826[x][z] = new Tile(Tile.buildingTexture, isSolid);
			mapEditor.solidSandTileMap1825[x][z] = new Tile(Tile.buildingTexture, isSolid);
		}
		if (mapEditor.solidSandWorldMap[z][x] == MapEditor.SandTile) {  
			mapEditor.solidSandTileMap1927[x][z] = new Tile(Tile.sandTexture, !isSolid);
			mapEditor.solidSandTileMap1926[x][z] = new Tile(Tile.sandTexture, !isSolid);
			mapEditor.solidSandTileMap1826[x][z] = new Tile(Tile.sandTexture, !isSolid);
			mapEditor.solidSandTileMap1825[x][z] = new Tile(Tile.sandTexture, !isSolid);
		}
		setTile(mapEditor.solidSandTileMap1927, x, z, tileSize, x, z - gridOffset);
		setTile(mapEditor.solidSandTileMap1926, x, z, tileSize, x - gridOffset, z - gridOffset);
		setTile(mapEditor.solidSandTileMap1826, x, z, tileSize, x - gridOffset, z - gridOffset * 2);
		setTile(mapEditor.solidSandTileMap1825, x, z, tileSize, x - gridOffset * 2, z - gridOffset * 2);
		
		// Solid water map.
		if (mapEditor.solidWaterWorldMap[z][x] == MapEditor.WaterTileOne) {
			mapEditor.solidWaterTileMap1924[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap2025[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap2024[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap2023[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap2022[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap2021[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap2020[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap2019[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
		}
		setTile(mapEditor.solidWaterTileMap1924, x, z, tileSize, x - gridOffset * 3, z - gridOffset);
		setTile(mapEditor.solidWaterTileMap2025, x, z, tileSize, x - gridOffset * 2, z);
		setTile(mapEditor.solidWaterTileMap2024, x, z, tileSize, x - gridOffset * 3, z);
		setTile(mapEditor.solidWaterTileMap2023, x, z, tileSize, x - gridOffset * 4, z);
		setTile(mapEditor.solidWaterTileMap2022, x, z, tileSize, x - gridOffset * 5, z);
		setTile(mapEditor.solidWaterTileMap2021, x, z, tileSize, x - gridOffset * 6, z);
		setTile(mapEditor.solidWaterTileMap2020, x, z, tileSize, x - gridOffset * 7, z);
		setTile(mapEditor.solidWaterTileMap2019, x, z, tileSize, x - gridOffset * 8, z);
		
		if (mapEditor.solidWaterWorldMapAnimated[z][x] == MapEditor.WaterTileTwo) {
			mapEditor.solidWaterTileMapAnimated1924[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated2025[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated2024[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated2023[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated2022[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated2021[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated2020[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated2019[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
		}
		setTile(mapEditor.solidWaterTileMapAnimated1924, x, z, tileSize, x - gridOffset * 3, z - gridOffset);
		setTile(mapEditor.solidWaterTileMapAnimated2025, x, z, tileSize, x - gridOffset * 2, z);
		setTile(mapEditor.solidWaterTileMapAnimated2024, x, z, tileSize, x - gridOffset * 3, z);
		setTile(mapEditor.solidWaterTileMapAnimated2023, x, z, tileSize, x - gridOffset * 4, z);
		setTile(mapEditor.solidWaterTileMapAnimated2022, x, z, tileSize, x - gridOffset * 5, z);
		setTile(mapEditor.solidWaterTileMapAnimated2021, x, z, tileSize, x - gridOffset * 6, z);
		setTile(mapEditor.solidWaterTileMapAnimated2020, x, z, tileSize, x - gridOffset * 7, z);
		setTile(mapEditor.solidWaterTileMapAnimated2019, x, z, tileSize, x - gridOffset * 8, z);
	}
	
	/**
	 * 
	 * @param int[][]  worldMap
	 * @param Tile[][] tileMap
	 * @param int      x
	 * @param int      z
	 */
	private void loadTile(int[][] worldMap, Tile[][] tileMap, int x, int z) {
		if (worldMap[z][x] == MapEditor.SolidTile) {  
			tileMap[x][z] = new Tile(Tile.buildingTexture, isSolid);
		}
		if (worldMap[z][x] == MapEditor.SandTile) {  
			tileMap[x][z] = new Tile(Tile.sandTexture, !isSolid);
		}
		if (worldMap[z][x] == MapEditor.GrassTileOne) {  
			tileMap[x][z] = new Tile(Tile.grassTextureOne, !isSolid);
		}
		if (worldMap[z][x] == MapEditor.WaterTileOne) {  
			tileMap[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
		}
		if (worldMap[z][x] == MapEditor.WaterTileTwo) {  
			tileMap[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
		}
		if (worldMap[z][x] == MapEditor.WaterLowerLeftHalfAndHalf) {  
			tileMap[x][z] = new Tile(Tile.waterLowerLeftHalfAndHalfTexture, !isSolid);
		}
		if (worldMap[z][x] == MapEditor.WaterUpperLeftHalfAndHalf) {  
			tileMap[x][z] = new Tile(Tile.waterUpperLeftHalfAndHalfTexture, !isSolid);
		}
		if (worldMap[z][x] == MapEditor.WaterLowerRightHalfAndHalf) {  
			tileMap[x][z] = new Tile(Tile.waterLowerRightHalfAndHalfTexture, !isSolid);
		}
		if (worldMap[z][x] == MapEditor.WaterUpperRightHalfAndHalf) {  
			tileMap[x][z] = new Tile(Tile.waterUpperRightHalfAndHalfTexture, !isSolid);
		}
		if (worldMap[z][x] == MapEditor.WaterUpperLeftCurved) {  
			tileMap[x][z] = new Tile(Tile.waterUpperLeftCurvedTexture, !isSolid);
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
}
