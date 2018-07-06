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
			for(int z = 0; z < mapEditor.worldMap2027.length; z++) {
				for(int x = 0; x < mapEditor.worldMap2027[z].length; x++) {
					mapEditor.tileMap2027[x][z].draw(myGame.renderer.batch);
					mapEditor.tileMap2026[x][z].draw(myGame.renderer.batch);
					mapEditor.tileMap1925[x][z].draw(myGame.renderer.batch);
					mapEditor.tileMap1827[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap2025[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap2024[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap2023[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap2022[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap2021[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap2020[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap2019[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap1924[x][z].draw(myGame.renderer.batch);
				}
			}
		} else {
			for(int z = 0; z < mapEditor.worldMapAnimated2027.length; z++) {
				for(int x = 0; x < mapEditor.worldMapAnimated2027[z].length; x++) {
					mapEditor.tileMapAnimated2027[x][z].draw(myGame.renderer.batch);
					mapEditor.tileMapAnimated2026[x][z].draw(myGame.renderer.batch);
					mapEditor.tileMapAnimated1925[x][z].draw(myGame.renderer.batch);
					mapEditor.tileMapAnimated1827[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated2025[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated2024[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated2023[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated2022[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated2021[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated2020[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated2019[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated1924[x][z].draw(myGame.renderer.batch);
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
