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
	public GameObject[] treesMapChunkThree = new NatureObject[86];
	public GameObject[] treesMapChunkFour  = new NatureObject[77];

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
		row                    = 45;
		treesMapChunkThree[60] = new NatureObject(startXPosition + 25, row);
		treesMapChunkThree[61] = new NatureObject(startXPosition + 26, row);
		treesMapChunkThree[62] = new NatureObject(startXPosition + 27, row);
		treesMapChunkThree[63] = new NatureObject(startXPosition + 28, row);
		treesMapChunkThree[64] = new NatureObject(startXPosition + 29, row);
		treesMapChunkThree[65] = new NatureObject(startXPosition + 35, row);
		treesMapChunkThree[66] = new NatureObject(startXPosition + 36, row);
		treesMapChunkThree[67] = new NatureObject(startXPosition + 46, row);
		treesMapChunkThree[68] = new NatureObject(startXPosition + 47, row);
		treesMapChunkThree[69] = new NatureObject(startXPosition + 48, row);
		treesMapChunkThree[70] = new NatureObject(startXPosition + 58, row);
		treesMapChunkThree[71] = new NatureObject(startXPosition + 59, row);
		treesMapChunkThree[72] = new NatureObject(startXPosition + 60, row);
		treesMapChunkThree[73] = new NatureObject(startXPosition + 67, row);
		treesMapChunkThree[74] = new NatureObject(startXPosition + 68, row);
		row 				   = 50;
		treesMapChunkThree[75] = new NatureObject(startXPosition + 28, row);
		treesMapChunkThree[76] = new NatureObject(startXPosition + 29, row);
		treesMapChunkThree[77] = new NatureObject(startXPosition + 30, row);
		treesMapChunkThree[78] = new NatureObject(startXPosition + 33, row);
		treesMapChunkThree[79] = new NatureObject(startXPosition + 34, row);
		treesMapChunkThree[80] = new NatureObject(startXPosition + 47, row);
		treesMapChunkThree[81] = new NatureObject(startXPosition + 48, row);
		treesMapChunkThree[82] = new NatureObject(startXPosition + 49, row);
		treesMapChunkThree[83] = new NatureObject(startXPosition + 55, row);
		treesMapChunkThree[84] = new NatureObject(startXPosition + 58, row);
		treesMapChunkThree[85] = new NatureObject(startXPosition + 66, row);
		
		// MapChunkFourTrees.
		startXPosition		   = 204;
		row 				   = 1;
		treesMapChunkFour[0]   = new NatureObject(startXPosition, row);
		treesMapChunkFour[1]   = new NatureObject(startXPosition + 1, row);
		treesMapChunkFour[2]   = new NatureObject(startXPosition + 2, row);
		treesMapChunkFour[3]   = new NatureObject(startXPosition + 3, row);
		treesMapChunkFour[4]   = new NatureObject(startXPosition + 4, row);
		treesMapChunkFour[5]   = new NatureObject(startXPosition + 5, row);
		treesMapChunkFour[6]   = new NatureObject(startXPosition + 6, row);
		treesMapChunkFour[7]   = new NatureObject(startXPosition + 7, row);
		treesMapChunkFour[8]   = new NatureObject(startXPosition + 8, row);
		treesMapChunkFour[9]   = new NatureObject(startXPosition + 9, row);
		treesMapChunkFour[10]  = new NatureObject(startXPosition + 20, row);
		treesMapChunkFour[11]  = new NatureObject(startXPosition + 21, row);
		treesMapChunkFour[12]  = new NatureObject(startXPosition + 22, row);
		treesMapChunkFour[13]  = new NatureObject(startXPosition + 23, row);
		treesMapChunkFour[14]  = new NatureObject(startXPosition + 24, row);
		treesMapChunkFour[15]  = new NatureObject(startXPosition + 25, row);
		treesMapChunkFour[16]  = new NatureObject(startXPosition + 26, row);
		treesMapChunkFour[17]  = new NatureObject(startXPosition + 27, row);
		treesMapChunkFour[18]  = new NatureObject(startXPosition + 28, row);
		treesMapChunkFour[19]  = new NatureObject(startXPosition + 29, row);
		treesMapChunkFour[20]  = new NatureObject(startXPosition + 40, row);
		treesMapChunkFour[21]  = new NatureObject(startXPosition + 41, row);
		treesMapChunkFour[22]  = new NatureObject(startXPosition + 42, row);
		treesMapChunkFour[23]  = new NatureObject(startXPosition + 43, row);
		treesMapChunkFour[24]  = new NatureObject(startXPosition + 44, row);
		treesMapChunkFour[25]  = new NatureObject(startXPosition + 45, row);
		treesMapChunkFour[26]  = new NatureObject(startXPosition + 46, row);
		treesMapChunkFour[27]  = new NatureObject(startXPosition + 47, row);
		treesMapChunkFour[28]  = new NatureObject(startXPosition + 48, row);
		treesMapChunkFour[29]  = new NatureObject(startXPosition + 49, row);
		treesMapChunkFour[30]  = new NatureObject(startXPosition + 50, row);
		treesMapChunkFour[31]  = new NatureObject(startXPosition + 51, row);
		treesMapChunkFour[32]  = new NatureObject(startXPosition + 52, row);
		treesMapChunkFour[33]  = new NatureObject(startXPosition + 53, row);
		treesMapChunkFour[34]  = new NatureObject(startXPosition + 54, row);
		treesMapChunkFour[35]  = new NatureObject(startXPosition + 55, row);
		treesMapChunkFour[36]  = new NatureObject(startXPosition + 56, row);
		treesMapChunkFour[37]  = new NatureObject(startXPosition + 57, row);
		treesMapChunkFour[38]  = new NatureObject(startXPosition + 58, row);
		treesMapChunkFour[39]  = new NatureObject(startXPosition + 59, row);
		treesMapChunkFour[40]  = new NatureObject(startXPosition + 60, row);
		treesMapChunkFour[41]  = new NatureObject(startXPosition + 61, row);
		treesMapChunkFour[42]  = new NatureObject(startXPosition + 62, row);
		treesMapChunkFour[43]  = new NatureObject(startXPosition + 63, row);
		treesMapChunkFour[44]  = new NatureObject(startXPosition + 64, row);
		treesMapChunkFour[45]  = new NatureObject(startXPosition + 65, row);
		treesMapChunkFour[46]  = new NatureObject(startXPosition + 66, row);
		treesMapChunkFour[47]  = new NatureObject(startXPosition + 67, row);
		row 				   = 2;
		treesMapChunkFour[48]  = new NatureObject(startXPosition + 3, row);
		treesMapChunkFour[49]  = new NatureObject(startXPosition + 4, row);
		treesMapChunkFour[50]  = new NatureObject(startXPosition + 5, row);
		treesMapChunkFour[51]  = new NatureObject(startXPosition + 6, row);
		treesMapChunkFour[52]  = new NatureObject(startXPosition + 20, row);
		treesMapChunkFour[53]  = new NatureObject(startXPosition + 40, row);
		treesMapChunkFour[54]  = new NatureObject(startXPosition + 45, row);
		row 				   = 3;
		treesMapChunkFour[55]  = new NatureObject(startXPosition + 20, row);
		treesMapChunkFour[56]  = new NatureObject(startXPosition + 40, row);
		treesMapChunkFour[57]  = new NatureObject(startXPosition + 45, row);
		row 				   = 4;
		treesMapChunkFour[58]  = new NatureObject(startXPosition + 20, row);
		treesMapChunkFour[59]  = new NatureObject(startXPosition + 40, row);
		treesMapChunkFour[60]  = new NatureObject(startXPosition + 45, row);
		row 				   = 5;
		treesMapChunkFour[61]  = new NatureObject(startXPosition + 20, row);
		treesMapChunkFour[62]  = new NatureObject(startXPosition + 21, row);
		treesMapChunkFour[63]  = new NatureObject(startXPosition + 22, row);
		treesMapChunkFour[64]  = new NatureObject(startXPosition + 23, row);
		treesMapChunkFour[65]  = new NatureObject(startXPosition + 24, row);
		treesMapChunkFour[66]  = new NatureObject(startXPosition + 40, row);
		treesMapChunkFour[67]  = new NatureObject(startXPosition + 45, row);
		treesMapChunkFour[68]  = new NatureObject(startXPosition + 46, row);
		treesMapChunkFour[69]  = new NatureObject(startXPosition + 47, row);
		treesMapChunkFour[70]  = new NatureObject(startXPosition + 48, row);
		treesMapChunkFour[71]  = new NatureObject(startXPosition + 49, row);
		row 				   = 9;
		treesMapChunkFour[72]   = new NatureObject(startXPosition, row);
		treesMapChunkFour[73]   = new NatureObject(startXPosition + 1, row);
		treesMapChunkFour[74]   = new NatureObject(startXPosition + 2, row);
		treesMapChunkFour[75]   = new NatureObject(startXPosition + 3, row);
		treesMapChunkFour[76]   = new NatureObject(startXPosition + 7, row);
	
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
		for (int i = 0; i < treesMapChunkFour.length; i++) {
			gameObjectList.add(treesMapChunkFour[i]);
		}
		gameObjectList.add(chest);
	}
}
