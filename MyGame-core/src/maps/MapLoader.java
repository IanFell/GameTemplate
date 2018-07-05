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
		for(int z = 0; z < mapEditor.worldMap.length; z++) {
			for(int x = 0; x < mapEditor.worldMap[z].length; x++) {
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
		
		loadTile(mapEditor.worldMap, mapEditor.tileMap, x, z);
		setTile(mapEditor.tileMap, x, z, tileSize, x, z);
		
		loadTile(mapEditor.worldMapAnimated, mapEditor.tileMapAnimated, x, z);
		setTile(mapEditor.tileMapAnimated, x, z, tileSize, x, z);
		
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
		int gridOffset = 20;
		setTile(mapEditor.solidSandTileMap1927, x, z, tileSize, x, z - gridOffset);
		setTile(mapEditor.solidSandTileMap1926, x, z, tileSize, x - gridOffset, z - gridOffset);
		setTile(mapEditor.solidSandTileMap1826, x, z, tileSize, x - gridOffset, z - gridOffset * 2);
		setTile(mapEditor.solidSandTileMap1825, x, z, tileSize, x - gridOffset * 2, z - gridOffset * 2);
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
