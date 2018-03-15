package factories;

import tiles.Tile;

/**
 * Factory for creating tiles.
 * 
 * @author Fabulous Fellini
 *
 */
public class TileFactory {
	
	/**
	 * Creates tile objects.
	 * 
	 * @param String tileType
	 * @param float  x
	 * @param float  y
	 * @return Tile
	 */
	public Tile getObject(String tileType, float x, float y) {
		if (tileType == null) {
			return null;
		}
		if (tileType.equalsIgnoreCase("tileTypeOne")) {
			return new Tile("tileTypeOne", x, y);
		}
		if (tileType.equalsIgnoreCase("tileTypeTwo")) {
			return new Tile("tileTypeTwo", x, y);
		}
		return null;
	}
}
