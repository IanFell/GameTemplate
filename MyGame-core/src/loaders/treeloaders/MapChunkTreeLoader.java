package loaders.treeloaders;

import gameobjects.GameObject;
import gameobjects.nature.trees.PalmTree;
import loaders.ClassObjectLoader;
import maps.MapInformationHolder;

/**
 * 
 * @author Fabulous Fellini
 *
 */ 
public class MapChunkTreeLoader extends ClassObjectLoader {

	protected GameObject[] trees;

	protected int startXPosition;
	protected int startYPosition;
	protected int row;
	protected final int chunkWidth = MapInformationHolder.CHUNK_WIDTH;

	protected void loadTrees() {}

	/**
	 * 
	 * @param GameObject tree
	 * @param int        startXPosition
	 * @param int        rowStartPosition
	 */
	protected void placeTreesForAllSandChunk(GameObject[] tree, int startXPosition, int rowStartPosition) {
		row       = rowStartPosition;
		tree[0]   = new PalmTree(startXPosition, row);
		tree[1]   = new PalmTree(startXPosition + 1, row);
		tree[2]   = new PalmTree(startXPosition + 2, row);
		tree[3]   = new PalmTree(startXPosition + 3, row);
		tree[4]   = new PalmTree(startXPosition + 4, row);
		tree[5]   = new PalmTree(startXPosition + 5, row);
		tree[6]   = new PalmTree(startXPosition + 6, row);
		tree[7]   = new PalmTree(startXPosition + 7, row);
		tree[8]   = new PalmTree(startXPosition + 8, row);
		tree[9]   = new PalmTree(startXPosition + 9, row);
		tree[10]  = new PalmTree(startXPosition + 20, row);
		tree[11]  = new PalmTree(startXPosition + 21, row);
		tree[12]  = new PalmTree(startXPosition + 22, row);
		tree[13]  = new PalmTree(startXPosition + 23, row);
		tree[14]  = new PalmTree(startXPosition + 24, row);
		tree[15]  = new PalmTree(startXPosition + 25, row);
		tree[16]  = new PalmTree(startXPosition + 26, row);
		tree[17]  = new PalmTree(startXPosition + 27, row);
		tree[18]  = new PalmTree(startXPosition + 28, row);
		tree[19]  = new PalmTree(startXPosition + 29, row);
		tree[20]  = new PalmTree(startXPosition + 40, row);
		tree[21]  = new PalmTree(startXPosition + 41, row);
		tree[22]  = new PalmTree(startXPosition + 42, row);
		tree[23]  = new PalmTree(startXPosition + 43, row);
		tree[24]  = new PalmTree(startXPosition + 44, row);
		tree[25]  = new PalmTree(startXPosition + 45, row);
		tree[26]  = new PalmTree(startXPosition + 46, row);
		tree[27]  = new PalmTree(startXPosition + 47, row);
		tree[28]  = new PalmTree(startXPosition + 48, row);
		tree[29]  = new PalmTree(startXPosition + 49, row);
		tree[30]  = new PalmTree(startXPosition + 50, row);
		tree[31]  = new PalmTree(startXPosition + 51, row);
		tree[32]  = new PalmTree(startXPosition + 52, row);
		tree[33]  = new PalmTree(startXPosition + 53, row);
		tree[34]  = new PalmTree(startXPosition + 54, row);
		tree[35]  = new PalmTree(startXPosition + 55, row);
		tree[36]  = new PalmTree(startXPosition + 56, row);
		tree[37]  = new PalmTree(startXPosition + 57, row);
		tree[38]  = new PalmTree(startXPosition + 58, row);
		tree[39]  = new PalmTree(startXPosition + 59, row);
		tree[40]  = new PalmTree(startXPosition + 60, row);
		tree[41]  = new PalmTree(startXPosition + 61, row);
		tree[42]  = new PalmTree(startXPosition + 62, row);
		tree[43]  = new PalmTree(startXPosition + 63, row);
		tree[44]  = new PalmTree(startXPosition + 64, row);
		tree[45]  = new PalmTree(startXPosition + 65, row);
		tree[46]  = new PalmTree(startXPosition + 66, row);
		tree[47]  = new PalmTree(startXPosition + 67, row);
		row 	  = rowStartPosition + 1;
		tree[48]  = new PalmTree(startXPosition + 3, row);
		tree[49]  = new PalmTree(startXPosition + 4, row);
		tree[50]  = new PalmTree(startXPosition + 5, row);
		tree[51]  = new PalmTree(startXPosition + 6, row);
		tree[52]  = new PalmTree(startXPosition + 20, row);
		tree[53]  = new PalmTree(startXPosition + 40, row);
		tree[54]  = new PalmTree(startXPosition + 45, row);
		row 	  = rowStartPosition + 2;
		tree[55]  = new PalmTree(startXPosition + 20, row);
		tree[56]  = new PalmTree(startXPosition + 40, row);
		tree[57]  = new PalmTree(startXPosition + 45, row);
		row 	  = rowStartPosition + 3;
		tree[58]  = new PalmTree(startXPosition + 20, row);
		tree[59]  = new PalmTree(startXPosition + 40, row);
		tree[60]  = new PalmTree(startXPosition + 45, row);
		row 	  = rowStartPosition + 4;
		tree[61]  = new PalmTree(startXPosition + 20, row);
		tree[62]  = new PalmTree(startXPosition + 21, row);
		tree[63]  = new PalmTree(startXPosition + 22, row);
		tree[64]  = new PalmTree(startXPosition + 23, row);
		tree[65]  = new PalmTree(startXPosition + 24, row);
		tree[66]  = new PalmTree(startXPosition + 40, row);
		tree[67]  = new PalmTree(startXPosition + 45, row);
		tree[68]  = new PalmTree(startXPosition + 46, row);
		tree[69]  = new PalmTree(startXPosition + 47, row);
		tree[70]  = new PalmTree(startXPosition + 48, row);
		tree[71]  = new PalmTree(startXPosition + 49, row);
		row       = rowStartPosition + 8;
		tree[72]  = new PalmTree(startXPosition, row);
		tree[73]  = new PalmTree(startXPosition + 1, row);
		tree[74]  = new PalmTree(startXPosition + 2, row);
		tree[75]  = new PalmTree(startXPosition + 3, row);
		tree[76]  = new PalmTree(startXPosition + 7, row);
		tree[77]  = new PalmTree(startXPosition + 10, row);
		tree[78]  = new PalmTree(startXPosition + 15, row);
		tree[79]  = new PalmTree(startXPosition + 20, row);
		tree[80]  = new PalmTree(startXPosition + 25, row);
		tree[81]  = new PalmTree(startXPosition + 30, row);
		tree[82]  = new PalmTree(startXPosition + 35, row);
		tree[83]  = new PalmTree(startXPosition + 50, row);
		tree[84]  = new PalmTree(startXPosition + 51, row);
		tree[85]  = new PalmTree(startXPosition + 52, row);
		tree[86]  = new PalmTree(startXPosition + 53, row);
		tree[87]  = new PalmTree(startXPosition + 63, row);
		tree[88]  = new PalmTree(startXPosition + 64, row);
		tree[89]  = new PalmTree(startXPosition + 65, row);
		row 	  = rowStartPosition + 9;
		tree[90]  = new PalmTree(startXPosition + 3, row);
		tree[91]  = new PalmTree(startXPosition + 8, row);
		tree[92]  = new PalmTree(startXPosition + 14, row);
		tree[93]  = new PalmTree(startXPosition + 28, row);
		tree[94]  = new PalmTree(startXPosition + 29, row);
		tree[95]  = new PalmTree(startXPosition + 30, row);
		tree[96]  = new PalmTree(startXPosition + 40, row);
		tree[97]  = new PalmTree(startXPosition + 41, row);
		tree[98]  = new PalmTree(startXPosition + 50, row);
		tree[99]  = new PalmTree(startXPosition + 60, row);
		row       = rowStartPosition + 10;
		tree[100] = new PalmTree(startXPosition, row);
		tree[101] = new PalmTree(startXPosition + 4, row);
		tree[102] = new PalmTree(startXPosition + 7, row);
		tree[103] = new PalmTree(startXPosition + 10, row);
		tree[104] = new PalmTree(startXPosition + 13, row);
		tree[105] = new PalmTree(startXPosition + 37, row);
		tree[106] = new PalmTree(startXPosition + 38, row);
		row       = rowStartPosition + 19;
		tree[107] = new PalmTree(startXPosition + 20, row);
		tree[108] = new PalmTree(startXPosition + 25, row);
		tree[109] = new PalmTree(startXPosition + 30, row);
		tree[110] = new PalmTree(startXPosition + 40, row);
		tree[111] = new PalmTree(startXPosition + 50, row);
		tree[112] = new PalmTree(startXPosition + 67, row);
		row       = rowStartPosition + 20;
		tree[113] = new PalmTree(startXPosition + 67, row);
		row 	  = rowStartPosition + 21;
		tree[114] = new PalmTree(startXPosition + 67, row);
		row 	  = rowStartPosition + 22;
		tree[115] = new PalmTree(startXPosition + 67, row);
		row 	  = rowStartPosition + 24;
		tree[116] = new PalmTree(startXPosition + 5, row);
		tree[117] = new PalmTree(startXPosition + 14, row);
		tree[118] = new PalmTree(startXPosition + 26, row);
		tree[119] = new PalmTree(startXPosition + 33, row);
		tree[120] = new PalmTree(startXPosition + 64, row);
		tree[121] = new PalmTree(startXPosition + 65, row);
		tree[122] = new PalmTree(startXPosition + 66, row);
		tree[123] = new PalmTree(startXPosition + 67, row);
		row 	  = rowStartPosition + 34;
		tree[124] = new PalmTree(startXPosition + 7, row);
		tree[125] = new PalmTree(startXPosition + 15, row);
		tree[126] = new PalmTree(startXPosition + 16, row);
		tree[127] = new PalmTree(startXPosition + 24, row);
		tree[128] = new PalmTree(startXPosition + 36, row);
		tree[129] = new PalmTree(startXPosition + 46, row);
		tree[130] = new PalmTree(startXPosition + 56, row);
		tree[131] = new PalmTree(startXPosition + 66, row);
		row 	  = rowStartPosition + 49;
		tree[132] = new PalmTree(startXPosition + 7, row);
		tree[133] = new PalmTree(startXPosition + 15, row);
		tree[134] = new PalmTree(startXPosition + 16, row);
		tree[135] = new PalmTree(startXPosition + 24, row);
		tree[136] = new PalmTree(startXPosition + 36, row);
		tree[137] = new PalmTree(startXPosition + 46, row);
		tree[138] = new PalmTree(startXPosition + 56, row);
		tree[139] = new PalmTree(startXPosition + 66, row);
	}
}
