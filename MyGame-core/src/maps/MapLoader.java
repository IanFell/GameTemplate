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
		for(int z = 0; z < mapEditor.map.length; z++) {
			for(int x = 0; x < mapEditor.map[z].length; x++) {
				if (mapEditor.map[z][x] == 0) {  
					mapEditor.tiles[x][z] = new Tile(Tile.textureOne, false);
				}
				if (mapEditor.map[z][x] == 1) {  
					mapEditor.tiles[x][z] = new Tile(Tile.textureOne, false);
				}
				if (mapEditor.map[z][x] == 2) {
					mapEditor.tiles[x][z] = new Tile(Tile.textureTwo, false);
				}
				if (mapEditor.map[z][x] == 3) {
					mapEditor.tiles[x][z] = new Tile(Tile.textureThree, true);
				}
				mapEditor.tiles[x][z].setPosition(x, z);
				int tileSize = 1;
				mapEditor.tiles[x][z].setSize(tileSize, tileSize); 
			}
		}
	}
}
