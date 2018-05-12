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
	 * Used to determine when to switch grass animations.
	 */
	private int timer = 0;
	
	/**
	 * Renders map.
	 * 
	 * @param MyGame    myGame
	 * @param MapEditor mapEditor
	 */
	public void renderMap(MyGame myGame, MapEditor mapEditor) { 
		timer++;
		if (timer > 100) {
			timer = 0;
		}
		if (timer < 50) {
			for(int z = 0; z < mapEditor.grassMapOne.length; z++) {
				for(int x = 0; x < mapEditor.grassMapOne[z].length; x++) {
					mapEditor.grassTilesOne[x][z].draw(myGame.renderer.batch);
				}
			}
		} else {
			for(int z = 0; z < mapEditor.grassMapTwo.length; z++) {
				for(int x = 0; x < mapEditor.grassMapTwo[z].length; x++) {
					mapEditor.grassTilesTwo[x][z].draw(myGame.renderer.batch);
				}
			}
		}
	}
}
