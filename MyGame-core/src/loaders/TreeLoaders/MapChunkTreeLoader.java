package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;
import maps.MapInformationHolder;

/**
 * 
 * @author Fabulous Fellini
 *
 */ 
public abstract class MapChunkTreeLoader {
	protected int startXPosition;
	protected int row;
	protected int chunkWidth            = MapInformationHolder.CHUNK_WIDTH;
	protected int verticalRowIncrement  = MapInformationHolder.CHUNK_HEIGHT;
	protected int rowOneStartPosition   = 1;
	protected int rowTwoStartPosition   = rowOneStartPosition + verticalRowIncrement;
	protected int rowThreeStartPosition = rowTwoStartPosition + verticalRowIncrement;
	protected int rowFourStartPosition  = rowThreeStartPosition + verticalRowIncrement;
	protected int rowFiveStartPosition  = rowFourStartPosition + verticalRowIncrement;
	protected int rowSixStartPosition   = rowFiveStartPosition + verticalRowIncrement;
	protected int rowSevenStartPosition = rowSixStartPosition + verticalRowIncrement;
	
	protected abstract void addGameObjectsToGameObjectArrayList();
	
	protected abstract void loadTrees();
	
	/**
	 * 
	 * @param GameObject gameObject
	 * @param int        startXPosition
	 * @param int        rowStartPosition
	 */
	protected void placeTreesForAllSandChunk(GameObject[] gameObject, int startXPosition, int rowStartPosition) {
		int row         = rowStartPosition;
		gameObject[0]   = new NatureObject(startXPosition, row);
		gameObject[1]   = new NatureObject(startXPosition + 1, row);
		gameObject[2]   = new NatureObject(startXPosition + 2, row);
		gameObject[3]   = new NatureObject(startXPosition + 3, row);
		gameObject[4]   = new NatureObject(startXPosition + 4, row);
		gameObject[5]   = new NatureObject(startXPosition + 5, row);
		gameObject[6]   = new NatureObject(startXPosition + 6, row);
		gameObject[7]   = new NatureObject(startXPosition + 7, row);
		gameObject[8]   = new NatureObject(startXPosition + 8, row);
		gameObject[9]   = new NatureObject(startXPosition + 9, row);
		gameObject[10]  = new NatureObject(startXPosition + 20, row);
		gameObject[11]  = new NatureObject(startXPosition + 21, row);
		gameObject[12]  = new NatureObject(startXPosition + 22, row);
		gameObject[13]  = new NatureObject(startXPosition + 23, row);
		gameObject[14]  = new NatureObject(startXPosition + 24, row);
		gameObject[15]  = new NatureObject(startXPosition + 25, row);
		gameObject[16]  = new NatureObject(startXPosition + 26, row);
		gameObject[17]  = new NatureObject(startXPosition + 27, row);
		gameObject[18]  = new NatureObject(startXPosition + 28, row);
		gameObject[19]  = new NatureObject(startXPosition + 29, row);
		gameObject[20]  = new NatureObject(startXPosition + 40, row);
		gameObject[21]  = new NatureObject(startXPosition + 41, row);
		gameObject[22]  = new NatureObject(startXPosition + 42, row);
		gameObject[23]  = new NatureObject(startXPosition + 43, row);
		gameObject[24]  = new NatureObject(startXPosition + 44, row);
		gameObject[25]  = new NatureObject(startXPosition + 45, row);
		gameObject[26]  = new NatureObject(startXPosition + 46, row);
		gameObject[27]  = new NatureObject(startXPosition + 47, row);
		gameObject[28]  = new NatureObject(startXPosition + 48, row);
		gameObject[29]  = new NatureObject(startXPosition + 49, row);
		gameObject[30]  = new NatureObject(startXPosition + 50, row);
		gameObject[31]  = new NatureObject(startXPosition + 51, row);
		gameObject[32]  = new NatureObject(startXPosition + 52, row);
		gameObject[33]  = new NatureObject(startXPosition + 53, row);
		gameObject[34]  = new NatureObject(startXPosition + 54, row);
		gameObject[35]  = new NatureObject(startXPosition + 55, row);
		gameObject[36]  = new NatureObject(startXPosition + 56, row);
		gameObject[37]  = new NatureObject(startXPosition + 57, row);
		gameObject[38]  = new NatureObject(startXPosition + 58, row);
		gameObject[39]  = new NatureObject(startXPosition + 59, row);
		gameObject[40]  = new NatureObject(startXPosition + 60, row);
		gameObject[41]  = new NatureObject(startXPosition + 61, row);
		gameObject[42]  = new NatureObject(startXPosition + 62, row);
		gameObject[43]  = new NatureObject(startXPosition + 63, row);
		gameObject[44]  = new NatureObject(startXPosition + 64, row);
		gameObject[45]  = new NatureObject(startXPosition + 65, row);
		gameObject[46]  = new NatureObject(startXPosition + 66, row);
		gameObject[47]  = new NatureObject(startXPosition + 67, row);
		row 			= rowStartPosition + 1;
		gameObject[48]  = new NatureObject(startXPosition + 3, row);
		gameObject[49]  = new NatureObject(startXPosition + 4, row);
		gameObject[50]  = new NatureObject(startXPosition + 5, row);
		gameObject[51]  = new NatureObject(startXPosition + 6, row);
		gameObject[52]  = new NatureObject(startXPosition + 20, row);
		gameObject[53]  = new NatureObject(startXPosition + 40, row);
		gameObject[54]  = new NatureObject(startXPosition + 45, row);
		row 	        = rowStartPosition + 2;
		gameObject[55]  = new NatureObject(startXPosition + 20, row);
		gameObject[56]  = new NatureObject(startXPosition + 40, row);
		gameObject[57]  = new NatureObject(startXPosition + 45, row);
		row 		    = rowStartPosition + 3;
		gameObject[58]  = new NatureObject(startXPosition + 20, row);
		gameObject[59]  = new NatureObject(startXPosition + 40, row);
		gameObject[60]  = new NatureObject(startXPosition + 45, row);
		row 	        = rowStartPosition + 4;
		gameObject[61]  = new NatureObject(startXPosition + 20, row);
		gameObject[62]  = new NatureObject(startXPosition + 21, row);
		gameObject[63]  = new NatureObject(startXPosition + 22, row);
		gameObject[64]  = new NatureObject(startXPosition + 23, row);
		gameObject[65]  = new NatureObject(startXPosition + 24, row);
		gameObject[66]  = new NatureObject(startXPosition + 40, row);
		gameObject[67]  = new NatureObject(startXPosition + 45, row);
		gameObject[68]  = new NatureObject(startXPosition + 46, row);
		gameObject[69]  = new NatureObject(startXPosition + 47, row);
		gameObject[70]  = new NatureObject(startXPosition + 48, row);
		gameObject[71]  = new NatureObject(startXPosition + 49, row);
		row 			= rowStartPosition + 8;
		gameObject[72]  = new NatureObject(startXPosition, row);
		gameObject[73]  = new NatureObject(startXPosition + 1, row);
		gameObject[74]  = new NatureObject(startXPosition + 2, row);
		gameObject[75]  = new NatureObject(startXPosition + 3, row);
		gameObject[76]  = new NatureObject(startXPosition + 7, row);
		gameObject[77]  = new NatureObject(startXPosition + 10, row);
		gameObject[78]  = new NatureObject(startXPosition + 15, row);
		gameObject[79]  = new NatureObject(startXPosition + 20, row);
		gameObject[80]  = new NatureObject(startXPosition + 25, row);
		gameObject[81]  = new NatureObject(startXPosition + 30, row);
		gameObject[82]  = new NatureObject(startXPosition + 35, row);
		gameObject[83]  = new NatureObject(startXPosition + 50, row);
		gameObject[84]  = new NatureObject(startXPosition + 51, row);
		gameObject[85]  = new NatureObject(startXPosition + 52, row);
		gameObject[86]  = new NatureObject(startXPosition + 53, row);
		gameObject[87]  = new NatureObject(startXPosition + 63, row);
		gameObject[88]  = new NatureObject(startXPosition + 64, row);
		gameObject[89]  = new NatureObject(startXPosition + 65, row);
		row 		    = rowStartPosition + 9;
		gameObject[90]  = new NatureObject(startXPosition + 3, row);
		gameObject[91]  = new NatureObject(startXPosition + 8, row);
		gameObject[92]  = new NatureObject(startXPosition + 14, row);
		gameObject[93]  = new NatureObject(startXPosition + 28, row);
		gameObject[94]  = new NatureObject(startXPosition + 29, row);
		gameObject[95]  = new NatureObject(startXPosition + 30, row);
		gameObject[96]  = new NatureObject(startXPosition + 40, row);
		gameObject[97]  = new NatureObject(startXPosition + 41, row);
		gameObject[98]  = new NatureObject(startXPosition + 50, row);
		gameObject[99]  = new NatureObject(startXPosition + 60, row);
		row 			= rowStartPosition + 10;
		gameObject[100] = new NatureObject(startXPosition, row);
		gameObject[101] = new NatureObject(startXPosition + 4, row);
		gameObject[102] = new NatureObject(startXPosition + 7, row);
		gameObject[103] = new NatureObject(startXPosition + 10, row);
		gameObject[104] = new NatureObject(startXPosition + 13, row);
		gameObject[105] = new NatureObject(startXPosition + 37, row);
		gameObject[106] = new NatureObject(startXPosition + 38, row);
		row 			= rowStartPosition + 19;
		gameObject[107] = new NatureObject(startXPosition + 20, row);
		gameObject[108] = new NatureObject(startXPosition + 25, row);
		gameObject[109] = new NatureObject(startXPosition + 30, row);
		gameObject[110] = new NatureObject(startXPosition + 40, row);
		gameObject[111] = new NatureObject(startXPosition + 50, row);
		gameObject[112] = new NatureObject(startXPosition + 67, row);
		row 			= rowStartPosition + 20;
		gameObject[113] = new NatureObject(startXPosition + 67, row);
		row 			= rowStartPosition + 21;
		gameObject[114] = new NatureObject(startXPosition + 67, row);
		row 		    = rowStartPosition + 22;
		gameObject[115] = new NatureObject(startXPosition + 67, row);
		row 			= rowStartPosition + 24;
		gameObject[116] = new NatureObject(startXPosition + 5, row);
		gameObject[117] = new NatureObject(startXPosition + 14, row);
		gameObject[118] = new NatureObject(startXPosition + 26, row);
		gameObject[119] = new NatureObject(startXPosition + 33, row);
		gameObject[120] = new NatureObject(startXPosition + 64, row);
		gameObject[121] = new NatureObject(startXPosition + 65, row);
		gameObject[122] = new NatureObject(startXPosition + 66, row);
		gameObject[123] = new NatureObject(startXPosition + 67, row);
		row 			= rowStartPosition + 34;
		gameObject[124] = new NatureObject(startXPosition + 7, row);
		gameObject[125] = new NatureObject(startXPosition + 15, row);
		gameObject[126] = new NatureObject(startXPosition + 16, row);
		gameObject[127] = new NatureObject(startXPosition + 24, row);
		gameObject[128] = new NatureObject(startXPosition + 36, row);
		gameObject[129] = new NatureObject(startXPosition + 46, row);
		gameObject[130] = new NatureObject(startXPosition + 56, row);
		gameObject[131] = new NatureObject(startXPosition + 66, row);
		row 		    = rowStartPosition + 49;
		gameObject[132] = new NatureObject(startXPosition + 7, row);
		gameObject[133] = new NatureObject(startXPosition + 15, row);
		gameObject[134] = new NatureObject(startXPosition + 16, row);
		gameObject[135] = new NatureObject(startXPosition + 24, row);
		gameObject[136] = new NatureObject(startXPosition + 36, row);
		gameObject[137] = new NatureObject(startXPosition + 46, row);
		gameObject[138] = new NatureObject(startXPosition + 56, row);
		gameObject[139] = new NatureObject(startXPosition + 66, row);
	}
}
