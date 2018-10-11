package loaders;

import java.util.ArrayList;

import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import gameobjects.StationaryGameObjects.NatureObject;

/**
 * Creates are game objects and initializes them.
 * 
 * @author Fabulous Fellini
 *
 */
public class GameObjectLoader {

	public GameObject playerOne;
	public GameObject playerTwo;
	public GameObject playerThree;
	public GameObject chest;
	public GameObject[] treesMapChunkTwo   = new NatureObject[45];
	public GameObject[] treesMapChunkThree = new NatureObject[60];

	/**
	 * This holds all game objects, for the purpose of drawing order.
	 */
	public static ArrayList <GameObject> gameObjectList = new ArrayList<GameObject>();

	/**
	 * 
	 * @param MyGame myGame
	 */
	public void createObjects(MyGame myGame) {
		playerOne   = myGame.gameObjectFactory.getObject("player", 0, 0);
		playerTwo   = myGame.gameObjectFactory.getObject("player", 0, 0);
		playerThree = myGame.gameObjectFactory.getObject("player", 0, 0);

		// MapChunkTwo trees.  
		int startXPosition   = 100;
		int row   		     = 1;
		treesMapChunkTwo[0]  = new NatureObject(startXPosition + 2, row);
		treesMapChunkTwo[1]  = new NatureObject(startXPosition + 3, row);
		treesMapChunkTwo[2]  = new NatureObject(startXPosition + 4, row);
		treesMapChunkTwo[3]  = new NatureObject(startXPosition + 5, row);
		treesMapChunkTwo[4]  = new NatureObject(startXPosition + 6, row);
		treesMapChunkTwo[5]  = new NatureObject(startXPosition + 12, row);
		treesMapChunkTwo[6]  = new NatureObject(startXPosition + 13, row);
		treesMapChunkTwo[7]  = new NatureObject(startXPosition + 14, row);
		treesMapChunkTwo[8]  = new NatureObject(startXPosition + 15, row);
		treesMapChunkTwo[9]  = new NatureObject(startXPosition + 16, row);
		treesMapChunkTwo[10] = new NatureObject(startXPosition + 23, row);
		treesMapChunkTwo[11] = new NatureObject(startXPosition + 24, row);
		treesMapChunkTwo[12] = new NatureObject(startXPosition + 25, row);
		treesMapChunkTwo[13] = new NatureObject(startXPosition + 26, row);
		treesMapChunkTwo[14] = new NatureObject(startXPosition + 27, row);
		treesMapChunkTwo[15] = new NatureObject(startXPosition + 33, row);
		treesMapChunkTwo[16] = new NatureObject(startXPosition + 34, row);
		treesMapChunkTwo[17] = new NatureObject(startXPosition + 35, row);
		row                  = 4;
		treesMapChunkTwo[18] = new NatureObject(startXPosition + 7, row);
		treesMapChunkTwo[19] = new NatureObject(startXPosition + 8, row);
		treesMapChunkTwo[20] = new NatureObject(startXPosition + 9, row);
		treesMapChunkTwo[21] = new NatureObject(startXPosition + 10, row);
		treesMapChunkTwo[22] = new NatureObject(startXPosition + 11, row);
		treesMapChunkTwo[23] = new NatureObject(startXPosition + 33, row);
		treesMapChunkTwo[24] = new NatureObject(startXPosition + 34, row);
		treesMapChunkTwo[25] = new NatureObject(startXPosition + 35, row);
		row                  = 7;
		treesMapChunkTwo[26] = new NatureObject(startXPosition + 16, row);
		treesMapChunkTwo[27] = new NatureObject(startXPosition + 26, row);
		treesMapChunkTwo[28] = new NatureObject(startXPosition + 32, row);
		row                  = 10;
		treesMapChunkTwo[29] = new NatureObject(startXPosition + 22, row);
		treesMapChunkTwo[30] = new NatureObject(startXPosition + 32, row);
		treesMapChunkTwo[31] = new NatureObject(startXPosition + 35, row);
		row                  = 14;
		treesMapChunkTwo[32] = new NatureObject(startXPosition + 18, row);
		treesMapChunkTwo[33] = new NatureObject(startXPosition + 19, row);
		treesMapChunkTwo[34] = new NatureObject(startXPosition + 22, row);
		treesMapChunkTwo[35] = new NatureObject(startXPosition + 23, row);
		treesMapChunkTwo[36] = new NatureObject(startXPosition + 30, row);
		row                  = 19;
		treesMapChunkTwo[37] = new NatureObject(startXPosition + 30, row);
		treesMapChunkTwo[38] = new NatureObject(startXPosition + 31, row);
		treesMapChunkTwo[39] = new NatureObject(startXPosition + 32, row);
		row                  = 23;
		treesMapChunkTwo[40] = new NatureObject(startXPosition + 34, row);
		treesMapChunkTwo[41] = new NatureObject(startXPosition + 35, row);
		row                  = 27;
		treesMapChunkTwo[42] = new NatureObject(startXPosition + 30, row);
		treesMapChunkTwo[43] = new NatureObject(startXPosition + 34, row);
		row                  = 31;
		treesMapChunkTwo[44] = new NatureObject(startXPosition + 35, row);

		// MapChunkThree trees.
		startXPosition         = 135;
		row                    = 1;
		treesMapChunkThree[0]  = new NatureObject(startXPosition + 5, row);
		treesMapChunkThree[1]  = new NatureObject(startXPosition + 15, row);
		treesMapChunkThree[2]  = new NatureObject(startXPosition + 16, row);
		treesMapChunkThree[3]  = new NatureObject(startXPosition + 17, row);
		treesMapChunkThree[4]  = new NatureObject(startXPosition + 18, row);
		treesMapChunkThree[5]  = new NatureObject(startXPosition + 19, row);
		treesMapChunkThree[6]  = new NatureObject(startXPosition + 29, row);
		treesMapChunkThree[7]  = new NatureObject(startXPosition + 30, row);
		treesMapChunkThree[8]  = new NatureObject(startXPosition + 31, row);
		treesMapChunkThree[9]  = new NatureObject(startXPosition + 32, row);
		treesMapChunkThree[10] = new NatureObject(startXPosition + 33, row);
		row                    = 6;
		treesMapChunkThree[11] = new NatureObject(startXPosition + 7, row);
		treesMapChunkThree[12] = new NatureObject(startXPosition + 8, row);
		treesMapChunkThree[13] = new NatureObject(startXPosition + 9, row);
		row                    = 15;
		treesMapChunkThree[14] = new NatureObject(startXPosition + 20, row);
		treesMapChunkThree[15] = new NatureObject(startXPosition + 21, row);
		treesMapChunkThree[16] = new NatureObject(startXPosition + 22, row);
		treesMapChunkThree[17] = new NatureObject(startXPosition + 30, row);
		treesMapChunkThree[18] = new NatureObject(startXPosition + 31, row);
		treesMapChunkThree[19] = new NatureObject(startXPosition + 32, row);
		treesMapChunkThree[20] = new NatureObject(startXPosition + 45, row);
		treesMapChunkThree[21] = new NatureObject(startXPosition + 46, row);
		treesMapChunkThree[22] = new NatureObject(startXPosition + 47, row);
		treesMapChunkThree[23] = new NatureObject(startXPosition + 48, row);
		treesMapChunkThree[24] = new NatureObject(startXPosition + 49, row);
		treesMapChunkThree[25] = new NatureObject(startXPosition + 64, row);
		treesMapChunkThree[26] = new NatureObject(startXPosition + 65, row);
		treesMapChunkThree[27] = new NatureObject(startXPosition + 66, row);
		treesMapChunkThree[28] = new NatureObject(startXPosition + 67, row);
		treesMapChunkThree[29] = new NatureObject(startXPosition + 68, row);
		row                    = 20;
		treesMapChunkThree[30] = new NatureObject(startXPosition + 5, row);
		treesMapChunkThree[31] = new NatureObject(startXPosition + 6, row);
		treesMapChunkThree[32] = new NatureObject(startXPosition + 10, row);
		treesMapChunkThree[33] = new NatureObject(startXPosition + 11, row);
		treesMapChunkThree[34] = new NatureObject(startXPosition + 12, row);
		treesMapChunkThree[35] = new NatureObject(startXPosition + 23, row);
		treesMapChunkThree[36] = new NatureObject(startXPosition + 24, row);
		treesMapChunkThree[37] = new NatureObject(startXPosition + 25, row);
		treesMapChunkThree[38] = new NatureObject(startXPosition + 33, row);
		treesMapChunkThree[39] = new NatureObject(startXPosition + 34, row);
		treesMapChunkThree[40] = new NatureObject(startXPosition + 45, row);
		treesMapChunkThree[41] = new NatureObject(startXPosition + 46, row);
		treesMapChunkThree[42] = new NatureObject(startXPosition + 47, row);
		row                    = 27;
		treesMapChunkThree[43] = new NatureObject(startXPosition + 16, row);
		treesMapChunkThree[44] = new NatureObject(startXPosition + 17, row);
		treesMapChunkThree[45] = new NatureObject(startXPosition + 18, row);
		treesMapChunkThree[46] = new NatureObject(startXPosition + 35, row);
		treesMapChunkThree[47] = new NatureObject(startXPosition + 36, row);
		treesMapChunkThree[48] = new NatureObject(startXPosition + 37, row);
		treesMapChunkThree[49] = new NatureObject(startXPosition + 55, row);
		treesMapChunkThree[50] = new NatureObject(startXPosition + 56, row);
		row                    = 37;
		treesMapChunkThree[51] = new NatureObject(startXPosition + 15, row);
		treesMapChunkThree[52] = new NatureObject(startXPosition + 25, row);
		treesMapChunkThree[53] = new NatureObject(startXPosition + 35, row);
		treesMapChunkThree[54] = new NatureObject(startXPosition + 55, row);
		treesMapChunkThree[55] = new NatureObject(startXPosition + 56, row);
		treesMapChunkThree[56] = new NatureObject(startXPosition + 57, row);
		treesMapChunkThree[57] = new NatureObject(startXPosition + 58, row);
		treesMapChunkThree[58] = new NatureObject(startXPosition + 67, row);
		treesMapChunkThree[59] = new NatureObject(startXPosition + 68, row);

		chest = myGame.gameObjectFactory.getObject("chest", 0, 0);

		addGameObjectsToGameObjectArrayList();
	}

	private void addGameObjectsToGameObjectArrayList() {
		gameObjectList.add(playerOne);
		gameObjectList.add(playerTwo);
		gameObjectList.add(playerThree);
		for (int i = 0; i < treesMapChunkTwo.length; i++) {
			gameObjectList.add(treesMapChunkTwo[i]);
		}
		for (int i = 0; i < treesMapChunkThree.length; i++) {
			gameObjectList.add(treesMapChunkThree[i]);
		}
		gameObjectList.add(chest);
	}
}
