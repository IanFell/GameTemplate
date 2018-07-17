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
			mapEditor.solidWaterTileMap1820[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap1720[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap1620[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap1520[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap1420[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap1320[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap1220[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap1120[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap1020[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap0920[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap0820[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap0720[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap0620[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap0520[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap0420[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap0320[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap0220[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap0120[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap0119[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap0219[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap0319[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap0419[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap0519[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap0619[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap0719[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap0819[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap0919[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap1019[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap1219[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap1319[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap1419[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap1519[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap1619[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap1719[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap1819[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap1919[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap1920[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap2119[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap2219[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap2319[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap2018[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap2017[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap2016[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap2015[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
			mapEditor.solidWaterTileMap2014[x][z] = new Tile(Tile.waterTextureOne, !isSolid);
		}
		setTile(mapEditor.solidWaterTileMap1924, x, z, tileSize, x - gridOffset * 3, z - gridOffset);
		setTile(mapEditor.solidWaterTileMap2025, x, z, tileSize, x - gridOffset * 2, z);
		setTile(mapEditor.solidWaterTileMap2024, x, z, tileSize, x - gridOffset * 3, z);
		setTile(mapEditor.solidWaterTileMap2023, x, z, tileSize, x - gridOffset * 4, z);
		setTile(mapEditor.solidWaterTileMap2022, x, z, tileSize, x - gridOffset * 5, z);
		setTile(mapEditor.solidWaterTileMap2021, x, z, tileSize, x - gridOffset * 6, z);
		setTile(mapEditor.solidWaterTileMap2020, x, z, tileSize, x - gridOffset * 7, z);
		setTile(mapEditor.solidWaterTileMap2019, x, z, tileSize, x - gridOffset * 8, z);
		setTile(mapEditor.solidWaterTileMap1820, x, z, tileSize, x - gridOffset * 9, z);
		setTile(mapEditor.solidWaterTileMap1720, x, z, tileSize, x - gridOffset * 10, z);
		setTile(mapEditor.solidWaterTileMap1620, x, z, tileSize, x - gridOffset * 11, z);
		setTile(mapEditor.solidWaterTileMap1520, x, z, tileSize, x - gridOffset * 12, z);
		setTile(mapEditor.solidWaterTileMap1420, x, z, tileSize, x - gridOffset * 13, z);
		setTile(mapEditor.solidWaterTileMap1320, x, z, tileSize, x - gridOffset * 14, z);
		setTile(mapEditor.solidWaterTileMap1220, x, z, tileSize, x - gridOffset * 15, z);
		setTile(mapEditor.solidWaterTileMap1120, x, z, tileSize, x - gridOffset * 16, z);
		setTile(mapEditor.solidWaterTileMap1020, x, z, tileSize, x - gridOffset * 17, z);
		setTile(mapEditor.solidWaterTileMap0920, x, z, tileSize, x - gridOffset * 18, z);
		setTile(mapEditor.solidWaterTileMap0820, x, z, tileSize, x - gridOffset * 19, z);
		setTile(mapEditor.solidWaterTileMap0720, x, z, tileSize, x - gridOffset * 20, z);
		setTile(mapEditor.solidWaterTileMap0620, x, z, tileSize, x - gridOffset * 21, z);
		setTile(mapEditor.solidWaterTileMap0520, x, z, tileSize, x - gridOffset * 22, z);
		setTile(mapEditor.solidWaterTileMap0420, x, z, tileSize, x - gridOffset * 23, z);
		setTile(mapEditor.solidWaterTileMap0320, x, z, tileSize, x - gridOffset * 24, z);
		setTile(mapEditor.solidWaterTileMap0220, x, z, tileSize, x - gridOffset * 25, z);
		setTile(mapEditor.solidWaterTileMap0120, x, z, tileSize, x - gridOffset * 26, z);
		setTile(mapEditor.solidWaterTileMap0119, x, z, tileSize, x - gridOffset * 26, z - gridOffset);
		setTile(mapEditor.solidWaterTileMap0219, x, z, tileSize, x - gridOffset * 25, z - gridOffset);
		setTile(mapEditor.solidWaterTileMap0319, x, z, tileSize, x - gridOffset * 24, z - gridOffset);
		setTile(mapEditor.solidWaterTileMap0419, x, z, tileSize, x - gridOffset * 23, z - gridOffset);
		setTile(mapEditor.solidWaterTileMap0519, x, z, tileSize, x - gridOffset * 22, z - gridOffset);
		setTile(mapEditor.solidWaterTileMap0619, x, z, tileSize, x - gridOffset * 21, z - gridOffset);
		setTile(mapEditor.solidWaterTileMap0719, x, z, tileSize, x - gridOffset * 20, z - gridOffset);
		setTile(mapEditor.solidWaterTileMap0819, x, z, tileSize, x - gridOffset * 19, z - gridOffset);
		setTile(mapEditor.solidWaterTileMap0919, x, z, tileSize, x - gridOffset * 18, z - gridOffset);
		setTile(mapEditor.solidWaterTileMap1019, x, z, tileSize, x - gridOffset * 17, z - gridOffset);
		setTile(mapEditor.solidWaterTileMap1219, x, z, tileSize, x - gridOffset * 15, z - gridOffset);
		setTile(mapEditor.solidWaterTileMap1319, x, z, tileSize, x - gridOffset * 14, z - gridOffset);
		setTile(mapEditor.solidWaterTileMap1419, x, z, tileSize, x - gridOffset * 13, z - gridOffset);
		setTile(mapEditor.solidWaterTileMap1519, x, z, tileSize, x - gridOffset * 12, z - gridOffset);
		setTile(mapEditor.solidWaterTileMap1619, x, z, tileSize, x - gridOffset * 11, z - gridOffset);
		setTile(mapEditor.solidWaterTileMap1719, x, z, tileSize, x - gridOffset * 10, z - gridOffset);
		setTile(mapEditor.solidWaterTileMap1819, x, z, tileSize, x - gridOffset * 9, z - gridOffset);
		setTile(mapEditor.solidWaterTileMap1919, x, z, tileSize, x - gridOffset * 8, z - gridOffset);
		setTile(mapEditor.solidWaterTileMap1920, x, z, tileSize, x - gridOffset * 7, z - gridOffset);
		setTile(mapEditor.solidWaterTileMap2119, x, z, tileSize, x - gridOffset * 6, z - gridOffset);
		setTile(mapEditor.solidWaterTileMap2219, x, z, tileSize, x - gridOffset * 5, z - gridOffset);
		setTile(mapEditor.solidWaterTileMap2319, x, z, tileSize, x - gridOffset * 4, z - gridOffset);
		setTile(mapEditor.solidWaterTileMap2018, x, z, tileSize, x - gridOffset * 8, z - gridOffset * 2);
		setTile(mapEditor.solidWaterTileMap2017, x, z, tileSize, x - gridOffset * 9, z - gridOffset * 2);
		setTile(mapEditor.solidWaterTileMap2016, x, z, tileSize, x - gridOffset * 10, z - gridOffset * 2);
		setTile(mapEditor.solidWaterTileMap2015, x, z, tileSize, x - gridOffset * 11, z - gridOffset * 2);
		setTile(mapEditor.solidWaterTileMap2014, x, z, tileSize, x - gridOffset * 12, z - gridOffset * 2);
		
		if (mapEditor.solidWaterWorldMapAnimated[z][x] == MapEditor.WaterTileTwo) {
			mapEditor.solidWaterTileMapAnimated1924[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated2025[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated2024[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated2023[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated2022[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated2021[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated2020[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated2019[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated1820[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated1720[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated1620[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated1520[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated1420[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated1320[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated1220[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated1120[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated1020[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated0920[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated0820[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated0720[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated0620[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated0520[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated0420[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated0320[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated0220[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated0120[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated0119[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated0219[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated0319[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated0419[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated0519[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated0619[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated0719[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated0819[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated0919[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated1019[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated1219[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated1319[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated1419[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated1519[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated1619[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated1719[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated1819[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated1919[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated1920[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated2119[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated2219[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated2319[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated2018[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated2017[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated2016[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated2015[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
			mapEditor.solidWaterTileMapAnimated2014[x][z] = new Tile(Tile.waterTextureTwo, !isSolid);
		}
		setTile(mapEditor.solidWaterTileMapAnimated1924, x, z, tileSize, x - gridOffset * 3, z - gridOffset);
		setTile(mapEditor.solidWaterTileMapAnimated2025, x, z, tileSize, x - gridOffset * 2, z);
		setTile(mapEditor.solidWaterTileMapAnimated2024, x, z, tileSize, x - gridOffset * 3, z);
		setTile(mapEditor.solidWaterTileMapAnimated2023, x, z, tileSize, x - gridOffset * 4, z);
		setTile(mapEditor.solidWaterTileMapAnimated2022, x, z, tileSize, x - gridOffset * 5, z);
		setTile(mapEditor.solidWaterTileMapAnimated2021, x, z, tileSize, x - gridOffset * 6, z);
		setTile(mapEditor.solidWaterTileMapAnimated2020, x, z, tileSize, x - gridOffset * 7, z);
		setTile(mapEditor.solidWaterTileMapAnimated2019, x, z, tileSize, x - gridOffset * 8, z);
		setTile(mapEditor.solidWaterTileMapAnimated1820, x, z, tileSize, x - gridOffset * 9, z);
		setTile(mapEditor.solidWaterTileMapAnimated1720, x, z, tileSize, x - gridOffset * 10, z);
		setTile(mapEditor.solidWaterTileMapAnimated1620, x, z, tileSize, x - gridOffset * 11, z);
		setTile(mapEditor.solidWaterTileMapAnimated1520, x, z, tileSize, x - gridOffset * 12, z);
		setTile(mapEditor.solidWaterTileMapAnimated1420, x, z, tileSize, x - gridOffset * 13, z);
		setTile(mapEditor.solidWaterTileMapAnimated1320, x, z, tileSize, x - gridOffset * 14, z);
		setTile(mapEditor.solidWaterTileMapAnimated1220, x, z, tileSize, x - gridOffset * 15, z);
		setTile(mapEditor.solidWaterTileMapAnimated1120, x, z, tileSize, x - gridOffset * 16, z);
		setTile(mapEditor.solidWaterTileMapAnimated1020, x, z, tileSize, x - gridOffset * 17, z);
		setTile(mapEditor.solidWaterTileMapAnimated0920, x, z, tileSize, x - gridOffset * 18, z);
		setTile(mapEditor.solidWaterTileMapAnimated0820, x, z, tileSize, x - gridOffset * 19, z);
		setTile(mapEditor.solidWaterTileMapAnimated0720, x, z, tileSize, x - gridOffset * 20, z);
		setTile(mapEditor.solidWaterTileMapAnimated0620, x, z, tileSize, x - gridOffset * 21, z);
		setTile(mapEditor.solidWaterTileMapAnimated0520, x, z, tileSize, x - gridOffset * 22, z);
		setTile(mapEditor.solidWaterTileMapAnimated0420, x, z, tileSize, x - gridOffset * 23, z);
		setTile(mapEditor.solidWaterTileMapAnimated0320, x, z, tileSize, x - gridOffset * 24, z);
		setTile(mapEditor.solidWaterTileMapAnimated0220, x, z, tileSize, x - gridOffset * 25, z);
		setTile(mapEditor.solidWaterTileMapAnimated0120, x, z, tileSize, x - gridOffset * 26, z);
		setTile(mapEditor.solidWaterTileMapAnimated0119, x, z, tileSize, x - gridOffset * 26, z - gridOffset);
		setTile(mapEditor.solidWaterTileMapAnimated0219, x, z, tileSize, x - gridOffset * 25, z - gridOffset);
		setTile(mapEditor.solidWaterTileMapAnimated0319, x, z, tileSize, x - gridOffset * 24, z - gridOffset);
		setTile(mapEditor.solidWaterTileMapAnimated0419, x, z, tileSize, x - gridOffset * 23, z - gridOffset);
		setTile(mapEditor.solidWaterTileMapAnimated0519, x, z, tileSize, x - gridOffset * 22, z - gridOffset);
		setTile(mapEditor.solidWaterTileMapAnimated0619, x, z, tileSize, x - gridOffset * 21, z - gridOffset);
		setTile(mapEditor.solidWaterTileMapAnimated0719, x, z, tileSize, x - gridOffset * 20, z - gridOffset);
		setTile(mapEditor.solidWaterTileMapAnimated0819, x, z, tileSize, x - gridOffset * 19, z - gridOffset);
		setTile(mapEditor.solidWaterTileMapAnimated0919, x, z, tileSize, x - gridOffset * 18, z - gridOffset);
		setTile(mapEditor.solidWaterTileMapAnimated1019, x, z, tileSize, x - gridOffset * 17, z - gridOffset);
		setTile(mapEditor.solidWaterTileMapAnimated1219, x, z, tileSize, x - gridOffset * 15, z - gridOffset);
		setTile(mapEditor.solidWaterTileMapAnimated1319, x, z, tileSize, x - gridOffset * 14, z - gridOffset);
		setTile(mapEditor.solidWaterTileMapAnimated1419, x, z, tileSize, x - gridOffset * 13, z - gridOffset);
		setTile(mapEditor.solidWaterTileMapAnimated1519, x, z, tileSize, x - gridOffset * 12, z - gridOffset);
		setTile(mapEditor.solidWaterTileMapAnimated1619, x, z, tileSize, x - gridOffset * 11, z - gridOffset);
		setTile(mapEditor.solidWaterTileMapAnimated1719, x, z, tileSize, x - gridOffset * 10, z - gridOffset);
		setTile(mapEditor.solidWaterTileMapAnimated1819, x, z, tileSize, x - gridOffset * 9, z - gridOffset);
		setTile(mapEditor.solidWaterTileMapAnimated1919, x, z, tileSize, x - gridOffset * 8, z - gridOffset);
		setTile(mapEditor.solidWaterTileMapAnimated1920, x, z, tileSize, x - gridOffset * 7, z - gridOffset);
		setTile(mapEditor.solidWaterTileMapAnimated2119, x, z, tileSize, x - gridOffset * 6, z - gridOffset);
		setTile(mapEditor.solidWaterTileMapAnimated2219, x, z, tileSize, x - gridOffset * 5, z - gridOffset);
		setTile(mapEditor.solidWaterTileMapAnimated2319, x, z, tileSize, x - gridOffset * 4, z - gridOffset);
		setTile(mapEditor.solidWaterTileMapAnimated2018, x, z, tileSize, x - gridOffset * 8, z - gridOffset * 2);
		setTile(mapEditor.solidWaterTileMapAnimated2017, x, z, tileSize, x - gridOffset * 9, z - gridOffset * 2);
		setTile(mapEditor.solidWaterTileMapAnimated2016, x, z, tileSize, x - gridOffset * 10, z - gridOffset * 2);
		setTile(mapEditor.solidWaterTileMapAnimated2015, x, z, tileSize, x - gridOffset * 11, z - gridOffset * 2);
		setTile(mapEditor.solidWaterTileMapAnimated2014, x, z, tileSize, x - gridOffset * 12, z - gridOffset * 2);
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
