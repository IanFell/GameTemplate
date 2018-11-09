package loaders.TreeLoaders;

import maps.MapInformationHolder;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class MapChunkTreeLoader {
	
	protected int startXPosition;
	protected int row;
	protected int chunkWidth             = MapInformationHolder.CHUNK_WIDTH;
	protected int verticalRowIncrement   = MapInformationHolder.CHUNK_HEIGHT;
	protected  int rowOneStartPosition   = 1;
	protected  int rowTwoStartPosition   = rowOneStartPosition + verticalRowIncrement;
	protected  int rowThreeStartPosition = rowTwoStartPosition + verticalRowIncrement;
	protected  int rowFourStartPosition  = rowThreeStartPosition + verticalRowIncrement;
	protected  int rowFiveStartPosition  = rowFourStartPosition + verticalRowIncrement;
	
	protected void addGameObjectsToGameObjectArrayList() {}
}
