package maps;

import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;

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
		// Quandrant One.
		if (playerIsWithinQuadrantBoundaries(
				mapEditor.tileMap2026[0][0].getX(),
				mapEditor.solidSandTileMap1927[19][19].getX() + mapEditor.solidSandTileMap1927[19][19].getWidth(),
				mapEditor.solidSandTileMap1927[0][0].getY(),
				mapEditor.tileMap2026[19][19].getY(),
				myGame
				)) {
			drawQuandrantOne(myGame, mapEditor);
		} 
		// Quandrant Two.
		else if (playerIsWithinQuadrantBoundaries(
				mapEditor.solidWaterTileMapAnimated2024[0][0].getX(),
				mapEditor.solidWaterTileMapAnimated2025[19][19].getX() + mapEditor.solidWaterTileMapAnimated2025[19][19].getWidth(),
				mapEditor.tileMap1925[0][0].getY(),
				mapEditor.solidWaterTileMapAnimated2024[19][19].getY(),
				myGame
				)) {
			drawQuandrantTwo(myGame, mapEditor);
		}
		
		
		/*
		// Alternate tile maps to simulate water movement.
		if (timer > 50) {
			for(int z = 0; z < mapEditor.worldMap2027.length; z++) {
				for(int x = 0; x < mapEditor.worldMap2027[z].length; x++) {
					//mapEditor.tileMap2027[x][z].draw(myGame.renderer.batch);
					//mapEditor.tileMap2026[x][z].draw(myGame.renderer.batch);
					//mapEditor.tileMap1925[x][z].draw(myGame.renderer.batch);
					mapEditor.tileMap1827[x][z].draw(myGame.renderer.batch);
					//mapEditor.solidWaterTileMap2025[x][z].draw(myGame.renderer.batch);
					//mapEditor.solidWaterTileMap2024[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap2023[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap2022[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap2021[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap2020[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap2019[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap1820[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap1720[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap1620[x][z].draw(myGame.renderer.batch);
					//mapEditor.solidWaterTileMap1924[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap1520[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap1420[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap1320[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap1220[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap1120[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap1020[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap0920[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap0820[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap0720[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap0620[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap0520[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap0420[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap0320[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap0220[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap0120[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap0119[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap0219[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap0319[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap0419[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap0519[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap0619[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap0719[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap0819[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap0919[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap1019[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap1219[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap1319[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap1419[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap1519[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap1619[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap1719[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap1819[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap1919[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap1920[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap2119[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap2219[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap2319[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap2018[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap2017[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap2016[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap2015[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap2014[x][z].draw(myGame.renderer.batch);
				}
			}
		} else {
			for(int z = 0; z < mapEditor.worldMapAnimated2027.length; z++) {
				for(int x = 0; x < mapEditor.worldMapAnimated2027[z].length; x++) {
					//mapEditor.tileMapAnimated2027[x][z].draw(myGame.renderer.batch);
					//mapEditor.tileMapAnimated2026[x][z].draw(myGame.renderer.batch);
					//mapEditor.tileMapAnimated1925[x][z].draw(myGame.renderer.batch);
					mapEditor.tileMapAnimated1827[x][z].draw(myGame.renderer.batch);
					//mapEditor.solidWaterTileMapAnimated2025[x][z].draw(myGame.renderer.batch);
					//mapEditor.solidWaterTileMapAnimated2024[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated2023[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated2022[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated2021[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated2020[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated2019[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated1820[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated1720[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated1620[x][z].draw(myGame.renderer.batch);
					//mapEditor.solidWaterTileMapAnimated1924[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated1520[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated1420[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated1320[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated1220[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated1120[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated1020[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated0920[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated0820[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated0720[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated0620[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated0520[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated0420[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated0320[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated0220[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated0120[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated0119[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated0219[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated0319[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated0419[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated0519[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated0619[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated0719[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated0819[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated0919[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated1019[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated1219[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated1319[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated1419[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated1519[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated1619[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated1719[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated1819[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated1919[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated1920[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated2119[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated2219[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated2319[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated2018[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated2017[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated2016[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated2015[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated2014[x][z].draw(myGame.renderer.batch);
				}
			}
		}
		
		for(int z = 0; z < mapEditor.solidSandWorldMap.length; z++) {
			for(int x = 0; x < mapEditor.solidSandWorldMap[z].length; x++) {
				//mapEditor.solidSandTileMap1927[x][z].draw(myGame.renderer.batch);
				//mapEditor.solidSandTileMap1926[x][z].draw(myGame.renderer.batch);
				mapEditor.solidSandTileMap1826[x][z].draw(myGame.renderer.batch);
				mapEditor.solidSandTileMap1825[x][z].draw(myGame.renderer.batch);
			}
		}*/
	}
	
	/**
	 * Checks if player is within given quandrant coordinates.
	 * If he is, we will draw quandrant.
	 * 
	 * @param float  leftBoundary
	 * @param float  rightBoundary
	 * @param float  topBoundary
	 * @param float  bottomBoundary
	 * @param MyGame myGame
	 * @return
	 */
	private boolean playerIsWithinQuadrantBoundaries(
			float leftBoundary, 
			float rightBoundary, 
			float topBoundary, 
			float bottomBoundary,
			MyGame myGame) {
		if (
				myGame.getGameObject(GameObject.PLAYER_ONE).getX() > leftBoundary && 
				myGame.getGameObject(GameObject.PLAYER_ONE).getX() < rightBoundary &&
				myGame.getGameObject(GameObject.PLAYER_ONE).getY() > topBoundary &&
				myGame.getGameObject(GameObject.PLAYER_ONE).getY() < bottomBoundary
				) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @param MyGame    myGame
	 * @param MapEditor mapEditor
	 */
	private void drawQuandrantOne(MyGame myGame, MapEditor mapEditor) {
		if (timer > 50) {
			for(int z = 0; z < mapEditor.worldMap2027.length; z++) {
				for(int x = 0; x < mapEditor.worldMap2027[z].length; x++) {
					mapEditor.tileMap2027[x][z].draw(myGame.renderer.batch);
					mapEditor.tileMap2026[x][z].draw(myGame.renderer.batch);
				}
			}
		} else {
			for(int z = 0; z < mapEditor.worldMapAnimated2027.length; z++) {
				for(int x = 0; x < mapEditor.worldMapAnimated2027[z].length; x++) {
					mapEditor.tileMapAnimated2027[x][z].draw(myGame.renderer.batch);
					mapEditor.tileMapAnimated2026[x][z].draw(myGame.renderer.batch);
				}
			}
		}
		
		for(int z = 0; z < mapEditor.solidSandWorldMap.length; z++) {
			for(int x = 0; x < mapEditor.solidSandWorldMap[z].length; x++) {
				mapEditor.solidSandTileMap1927[x][z].draw(myGame.renderer.batch);
				mapEditor.solidSandTileMap1926[x][z].draw(myGame.renderer.batch);
			}
		}
	}
	
	/**
	 * 
	 * @param MyGame    myGame
	 * @param MapEditor mapEditor
	 */
	private void drawQuandrantTwo(MyGame myGame, MapEditor mapEditor) {
		if (timer > 50) {
			for(int z = 0; z < mapEditor.worldMap2027.length; z++) {
				for(int x = 0; x < mapEditor.worldMap2027[z].length; x++) {
					mapEditor.solidWaterTileMap1924[x][z].draw(myGame.renderer.batch);
					mapEditor.tileMap1925[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap2024[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMap2025[x][z].draw(myGame.renderer.batch);
				}
			}
		} else {
			for(int z = 0; z < mapEditor.worldMapAnimated2027.length; z++) {
				for(int x = 0; x < mapEditor.worldMapAnimated2027[z].length; x++) {
					mapEditor.solidWaterTileMapAnimated1924[x][z].draw(myGame.renderer.batch);
					mapEditor.tileMapAnimated1925[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated2024[x][z].draw(myGame.renderer.batch);
					mapEditor.solidWaterTileMapAnimated2025[x][z].draw(myGame.renderer.batch);
				}
			}
		}
	}
}
