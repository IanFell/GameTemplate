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
		
		// Alternate tile maps to simulate water movement.
		if (timer > 50) {
			for(int z = 0; z < mapEditor.worldMap.length; z++) {
				for(int x = 0; x < mapEditor.worldMap[z].length; x++) {
					mapEditor.tileMap[x][z].draw(myGame.renderer.batch);
				}
			}
		} else {
			for(int z = 0; z < mapEditor.worldMapAnimated.length; z++) {
				for(int x = 0; x < mapEditor.worldMapAnimated[z].length; x++) {
					mapEditor.tileMapAnimated[x][z].draw(myGame.renderer.batch);
				}
			}
		}
		
		for(int z = 0; z < mapEditor.solidSandWorldMap.length; z++) {
			for(int x = 0; x < mapEditor.solidSandWorldMap[z].length; x++) {
				mapEditor.solidSandTileMap1927[x][z].draw(myGame.renderer.batch);
				mapEditor.solidSandTileMap1926[x][z].draw(myGame.renderer.batch);
				mapEditor.solidSandTileMap1826[x][z].draw(myGame.renderer.batch);
				mapEditor.solidSandTileMap1825[x][z].draw(myGame.renderer.batch);
			}
		}
	}
}
