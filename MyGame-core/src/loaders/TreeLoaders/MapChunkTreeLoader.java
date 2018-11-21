package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;
import loaders.GameObjectLoader;
import maps.MapInformationHolder;

/**
 * 
 * @author Fabulous Fellini
 *
 */ 
public abstract class MapChunkTreeLoader {
	protected int startXPosition;
	protected int startYPosition;
	protected int row;
	protected final int chunkWidth = MapInformationHolder.CHUNK_WIDTH;
	
	/**
	 * 
	 * @param GameObject[] gameObject
	 */
	protected void addGameObjectsToGameObjectArrayList(GameObject[] tree) {
		for (int i = 0; i < tree.length; i++) {
			GameObjectLoader.gameObjectList.add(tree[i]);
		}
	}
	
	protected abstract void loadTrees();
	
	/**
	 * 
	 * @param GameObject tree
	 * @param int        startXPosition
	 * @param int        rowStartPosition
	 */
	protected void placeTreesForAllSandChunk(GameObject[] tree, int startXPosition, int rowStartPosition) {
		row       = rowStartPosition;
		tree[0]   = new NatureObject(startXPosition, row);
		tree[1]   = new NatureObject(startXPosition + 1, row);
		tree[2]   = new NatureObject(startXPosition + 2, row);
		tree[3]   = new NatureObject(startXPosition + 3, row);
		tree[4]   = new NatureObject(startXPosition + 4, row);
		tree[5]   = new NatureObject(startXPosition + 5, row);
		tree[6]   = new NatureObject(startXPosition + 6, row);
		tree[7]   = new NatureObject(startXPosition + 7, row);
		tree[8]   = new NatureObject(startXPosition + 8, row);
		tree[9]   = new NatureObject(startXPosition + 9, row);
		tree[10]  = new NatureObject(startXPosition + 20, row);
		tree[11]  = new NatureObject(startXPosition + 21, row);
		tree[12]  = new NatureObject(startXPosition + 22, row);
		tree[13]  = new NatureObject(startXPosition + 23, row);
		tree[14]  = new NatureObject(startXPosition + 24, row);
		tree[15]  = new NatureObject(startXPosition + 25, row);
		tree[16]  = new NatureObject(startXPosition + 26, row);
		tree[17]  = new NatureObject(startXPosition + 27, row);
		tree[18]  = new NatureObject(startXPosition + 28, row);
		tree[19]  = new NatureObject(startXPosition + 29, row);
		tree[20]  = new NatureObject(startXPosition + 40, row);
		tree[21]  = new NatureObject(startXPosition + 41, row);
		tree[22]  = new NatureObject(startXPosition + 42, row);
		tree[23]  = new NatureObject(startXPosition + 43, row);
		tree[24]  = new NatureObject(startXPosition + 44, row);
		tree[25]  = new NatureObject(startXPosition + 45, row);
		tree[26]  = new NatureObject(startXPosition + 46, row);
		tree[27]  = new NatureObject(startXPosition + 47, row);
		tree[28]  = new NatureObject(startXPosition + 48, row);
		tree[29]  = new NatureObject(startXPosition + 49, row);
		tree[30]  = new NatureObject(startXPosition + 50, row);
		tree[31]  = new NatureObject(startXPosition + 51, row);
		tree[32]  = new NatureObject(startXPosition + 52, row);
		tree[33]  = new NatureObject(startXPosition + 53, row);
		tree[34]  = new NatureObject(startXPosition + 54, row);
		tree[35]  = new NatureObject(startXPosition + 55, row);
		tree[36]  = new NatureObject(startXPosition + 56, row);
		tree[37]  = new NatureObject(startXPosition + 57, row);
		tree[38]  = new NatureObject(startXPosition + 58, row);
		tree[39]  = new NatureObject(startXPosition + 59, row);
		tree[40]  = new NatureObject(startXPosition + 60, row);
		tree[41]  = new NatureObject(startXPosition + 61, row);
		tree[42]  = new NatureObject(startXPosition + 62, row);
		tree[43]  = new NatureObject(startXPosition + 63, row);
		tree[44]  = new NatureObject(startXPosition + 64, row);
		tree[45]  = new NatureObject(startXPosition + 65, row);
		tree[46]  = new NatureObject(startXPosition + 66, row);
		tree[47]  = new NatureObject(startXPosition + 67, row);
		row 	  = rowStartPosition + 1;
		tree[48]  = new NatureObject(startXPosition + 3, row);
		tree[49]  = new NatureObject(startXPosition + 4, row);
		tree[50]  = new NatureObject(startXPosition + 5, row);
		tree[51]  = new NatureObject(startXPosition + 6, row);
		tree[52]  = new NatureObject(startXPosition + 20, row);
		tree[53]  = new NatureObject(startXPosition + 40, row);
		tree[54]  = new NatureObject(startXPosition + 45, row);
		row 	  = rowStartPosition + 2;
		tree[55]  = new NatureObject(startXPosition + 20, row);
		tree[56]  = new NatureObject(startXPosition + 40, row);
		tree[57]  = new NatureObject(startXPosition + 45, row);
		row 	  = rowStartPosition + 3;
		tree[58]  = new NatureObject(startXPosition + 20, row);
		tree[59]  = new NatureObject(startXPosition + 40, row);
		tree[60]  = new NatureObject(startXPosition + 45, row);
		row 	  = rowStartPosition + 4;
		tree[61]  = new NatureObject(startXPosition + 20, row);
		tree[62]  = new NatureObject(startXPosition + 21, row);
		tree[63]  = new NatureObject(startXPosition + 22, row);
		tree[64]  = new NatureObject(startXPosition + 23, row);
		tree[65]  = new NatureObject(startXPosition + 24, row);
		tree[66]  = new NatureObject(startXPosition + 40, row);
		tree[67]  = new NatureObject(startXPosition + 45, row);
		tree[68]  = new NatureObject(startXPosition + 46, row);
		tree[69]  = new NatureObject(startXPosition + 47, row);
		tree[70]  = new NatureObject(startXPosition + 48, row);
		tree[71]  = new NatureObject(startXPosition + 49, row);
		row       = rowStartPosition + 8;
		tree[72]  = new NatureObject(startXPosition, row);
		tree[73]  = new NatureObject(startXPosition + 1, row);
		tree[74]  = new NatureObject(startXPosition + 2, row);
		tree[75]  = new NatureObject(startXPosition + 3, row);
		tree[76]  = new NatureObject(startXPosition + 7, row);
		tree[77]  = new NatureObject(startXPosition + 10, row);
		tree[78]  = new NatureObject(startXPosition + 15, row);
		tree[79]  = new NatureObject(startXPosition + 20, row);
		tree[80]  = new NatureObject(startXPosition + 25, row);
		tree[81]  = new NatureObject(startXPosition + 30, row);
		tree[82]  = new NatureObject(startXPosition + 35, row);
		tree[83]  = new NatureObject(startXPosition + 50, row);
		tree[84]  = new NatureObject(startXPosition + 51, row);
		tree[85]  = new NatureObject(startXPosition + 52, row);
		tree[86]  = new NatureObject(startXPosition + 53, row);
		tree[87]  = new NatureObject(startXPosition + 63, row);
		tree[88]  = new NatureObject(startXPosition + 64, row);
		tree[89]  = new NatureObject(startXPosition + 65, row);
		row 	  = rowStartPosition + 9;
		tree[90]  = new NatureObject(startXPosition + 3, row);
		tree[91]  = new NatureObject(startXPosition + 8, row);
		tree[92]  = new NatureObject(startXPosition + 14, row);
		tree[93]  = new NatureObject(startXPosition + 28, row);
		tree[94]  = new NatureObject(startXPosition + 29, row);
		tree[95]  = new NatureObject(startXPosition + 30, row);
		tree[96]  = new NatureObject(startXPosition + 40, row);
		tree[97]  = new NatureObject(startXPosition + 41, row);
		tree[98]  = new NatureObject(startXPosition + 50, row);
		tree[99]  = new NatureObject(startXPosition + 60, row);
		row       = rowStartPosition + 10;
		tree[100] = new NatureObject(startXPosition, row);
		tree[101] = new NatureObject(startXPosition + 4, row);
		tree[102] = new NatureObject(startXPosition + 7, row);
		tree[103] = new NatureObject(startXPosition + 10, row);
		tree[104] = new NatureObject(startXPosition + 13, row);
		tree[105] = new NatureObject(startXPosition + 37, row);
		tree[106] = new NatureObject(startXPosition + 38, row);
		row       = rowStartPosition + 19;
		tree[107] = new NatureObject(startXPosition + 20, row);
		tree[108] = new NatureObject(startXPosition + 25, row);
		tree[109] = new NatureObject(startXPosition + 30, row);
		tree[110] = new NatureObject(startXPosition + 40, row);
		tree[111] = new NatureObject(startXPosition + 50, row);
		tree[112] = new NatureObject(startXPosition + 67, row);
		row       = rowStartPosition + 20;
		tree[113] = new NatureObject(startXPosition + 67, row);
		row 	  = rowStartPosition + 21;
		tree[114] = new NatureObject(startXPosition + 67, row);
		row 	  = rowStartPosition + 22;
		tree[115] = new NatureObject(startXPosition + 67, row);
		row 	  = rowStartPosition + 24;
		tree[116] = new NatureObject(startXPosition + 5, row);
		tree[117] = new NatureObject(startXPosition + 14, row);
		tree[118] = new NatureObject(startXPosition + 26, row);
		tree[119] = new NatureObject(startXPosition + 33, row);
		tree[120] = new NatureObject(startXPosition + 64, row);
		tree[121] = new NatureObject(startXPosition + 65, row);
		tree[122] = new NatureObject(startXPosition + 66, row);
		tree[123] = new NatureObject(startXPosition + 67, row);
		row 	  = rowStartPosition + 34;
		tree[124] = new NatureObject(startXPosition + 7, row);
		tree[125] = new NatureObject(startXPosition + 15, row);
		tree[126] = new NatureObject(startXPosition + 16, row);
		tree[127] = new NatureObject(startXPosition + 24, row);
		tree[128] = new NatureObject(startXPosition + 36, row);
		tree[129] = new NatureObject(startXPosition + 46, row);
		tree[130] = new NatureObject(startXPosition + 56, row);
		tree[131] = new NatureObject(startXPosition + 66, row);
		row 	  = rowStartPosition + 49;
		tree[132] = new NatureObject(startXPosition + 7, row);
		tree[133] = new NatureObject(startXPosition + 15, row);
		tree[134] = new NatureObject(startXPosition + 16, row);
		tree[135] = new NatureObject(startXPosition + 24, row);
		tree[136] = new NatureObject(startXPosition + 36, row);
		tree[137] = new NatureObject(startXPosition + 46, row);
		tree[138] = new NatureObject(startXPosition + 56, row);
		tree[139] = new NatureObject(startXPosition + 66, row);
	}
}
