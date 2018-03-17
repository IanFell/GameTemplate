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
	 * @param MapEditor mapEditor
	 */
	public void renderMap(MyGame myGame, MapEditor mapEditor) { 
		for(int z = 0; z < mapEditor.map.length; z++) {
			for(int x = 0; x < mapEditor.map[z].length; x++) {
				mapEditor.sprites[x][z].draw(myGame.renderer.batch);
			}
		}
	}
}
