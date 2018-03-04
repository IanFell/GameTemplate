package maps;

import com.mygdx.mygame.MyGame;

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
	 * @param MyGame myGame
	 * @param array  map
	 */
	public void loadMap(MyGame myGame, int[][] map) { 
		int startX   = 0;
		int startY   = 0;
		int distance = 32;
		int row      = map.length - 1;
		int col      = map[0].length;
		
		// Create our tiles depending on the given map's parameters.
		for (int y = row; y > 0; y--) {
	        for (int x = 0; x < col; x++) {
	            if(map[y][x] == 1) {
	            	myGame.tileLoader.createObjects(myGame, "tileTypeOne", startX, startY);
	            }
	            if(map[y][x] == 2) {
	            	myGame.tileLoader.createObjects(myGame, "tileTypeTwo", startX, startY);
	            }
	            startX += distance;
	        }
	        startY += distance;
	        startX = 0;
	    }
		
		// Print all tile's x, y positions to verify they were set at their correct coordinates on the map.
		for(int i = 0; i < myGame.tileLoader.tiles.size(); i++) {
			System.out.println(
					"Tile #" 
					+ i + " X, Y position: " 
					+ myGame.tileLoader.tiles.get(i).getX()
					+ ", " 
					+ myGame.tileLoader.tiles.get(i).getY());
		}
		
		// Initialize newly created tiles.
		myGame.tileLoader.init(myGame.imageLoader);
	}
}
