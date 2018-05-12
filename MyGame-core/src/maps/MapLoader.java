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
	
	/**
	 * Creates and initializes tiles for map.
	 * 
	 * @param MyGame    myGame
	 * @param MapEditor mapEditor
	 */
	public void loadMap(MyGame myGame, MapEditor mapEditor) { 
		Tile.initializeTileTextures(myGame);
		for(int z = 0; z < mapEditor.grassMapOne.length; z++) {
			for(int x = 0; x < mapEditor.grassMapOne[z].length; x++) {
				loadGrassMaps(mapEditor, x, z);
			}
		}
	}
	
	/**
	 * Loads all grass maps.  There are two at the moment, and alternate back and forth to simulate wind.
	 * 
	 * @param MapEditor mapEditor
	 * @param int       x
	 * @param int       z
	 */
	private void loadGrassMaps(MapEditor mapEditor, int x, int z) {
		int tileSize    = 1;
		boolean isSolid = true;
		// "Left side" grass map.
		if (mapEditor.grassMapOne[z][x] == MapEditor.SolidTile) {  
			mapEditor.grassTilesOne[x][z] = new Tile(Tile.solidTile, isSolid);
		}
		if (mapEditor.grassMapOne[z][x] == MapEditor.GrassTileOne) {  
			mapEditor.grassTilesOne[x][z] = new Tile(Tile.grassTextureOne, !isSolid);
		}
		mapEditor.grassTilesOne[x][z].setPosition(x, z);
		mapEditor.grassTilesOne[x][z].setSize(tileSize, tileSize); 
	
		// "Right side" grass map.
		if (mapEditor.grassMapTwo[z][x] == MapEditor.SolidTile) {  
			mapEditor.grassTilesTwo[x][z] = new Tile(Tile.solidTile, isSolid);
		}
		if (mapEditor.grassMapTwo[z][x] == MapEditor.GrassTileTwo) {  
			mapEditor.grassTilesTwo[x][z] = new Tile(Tile.grassTextureTwo, !isSolid);
		}
		mapEditor.grassTilesTwo[x][z].setPosition(x, z);
		mapEditor.grassTilesTwo[x][z].setSize(tileSize, tileSize); 
	}
}
