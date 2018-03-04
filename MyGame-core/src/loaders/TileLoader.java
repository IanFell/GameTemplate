package loaders;

import java.util.ArrayList;

import com.mygdx.mygame.MyGame;

import tiles.Tile;

/**
 * Creates and holds our tile objects.
 * 
 * @author Fabulous Fellini.
 *
 */
public class TileLoader {
	
	/**
	 * ArrayList to hold our tile objects.
	 */
	public ArrayList<Tile> tiles = new ArrayList<Tile>();

	/**
	 * Creates our tile objects.
	 * 
	 * @param MyGame myGame
	 * @param String tileType
	 * @param float  x
	 * @param float  y
	 */
	public void createObjects(MyGame myGame, String tileType, float x, float y) {
		if (tileType.equalsIgnoreCase("tileTypeOne")) {
			tiles.add(myGame.tileFactory.getObject("tileTypeOne", x , y));
		}
		if (tileType.equalsIgnoreCase("tileTypeTwo")) {
			tiles.add(myGame.tileFactory.getObject("tileTypeTwo", x, y));
		}
	}
	
	/**
	 * Initializes our tile objects.
	 * 
	 * @param ImageLoader imageLoader
	 */
	public void init(ImageLoader imageLoader) {
		for (int i = 0; i < tiles.size(); i++) {
			tiles.get(i).init(imageLoader);
		}
	}
}
