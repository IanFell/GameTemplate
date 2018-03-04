package maps;

import com.mygdx.mygame.MyGame;

/**
 * Renders tile maps for levels, based off the MapEditor class.
 * 
 * @author Fabulous Fellini
 *
 */
public class MapRenderer {
	
	/**
	 * Renders map.
	 * 
	 * @param MyGame myGame
	 * @param array  map
	 */
	public void renderMap(MyGame myGame, int[][] map) { 
		int row = map.length - 1;
		int col = map[0].length;
		for (int y = row; y > 0; y--) {
	        for (int x = 0; x < col; x++) {
	        	for (int i = 0; i < myGame.tileLoader.tiles.size(); i++) {
	        		myGame.tileLoader.tiles.get(i).drawTile(
	        				myGame.renderer.batch, 
	        				myGame.tileLoader.tiles.get(i).getX(), 
	        				myGame.tileLoader.tiles.get(i).getY(), 
	        				myGame
	        		);
	        		myGame.tileLoader.tiles.get(i).rectangle.x = myGame.tileLoader.tiles.get(i).getX();
	        		myGame.tileLoader.tiles.get(i).rectangle.y = myGame.tileLoader.tiles.get(i).getY();
	        	}
	        }
		}
	}
}
