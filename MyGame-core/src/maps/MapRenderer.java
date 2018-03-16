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
	 * @param MyGame    myGame
	 * @param MapLoader mapLoader
	 */
	public void renderMap(MyGame myGame, MapLoader mapLoader) { 
		for(int z = 0; z < 10; z++) {
			for(int x = 0; x < 10; x++) {
				mapLoader.sprites[x][z].draw(myGame.renderer.batch);
			}
		}
	}
}
