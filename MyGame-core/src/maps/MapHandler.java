package maps;

import java.util.ArrayList;

import maps.mapchunks.AllSandChunk;
import maps.mapchunks.AllWaterChunk;
import maps.mapchunks.MapChunk;
import maps.mapchunks.MapChunkEighteen;
import maps.mapchunks.MapChunkEleven;
import maps.mapchunks.MapChunkNineteen;
import maps.mapchunks.MapChunkTen;
import maps.mapchunks.MapChunkThree;
import maps.mapchunks.MapChunkTwenty;
import maps.mapchunks.MapChunkTwentyEight;
import maps.mapchunks.MapChunkTwentySix;
import maps.mapchunks.MapChunkTwo;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class MapHandler {
	
	public AllWaterChunk mapChunkOne               = new AllWaterChunk();
	public MapChunkTwo mapChunkTwo                 = new MapChunkTwo();
	public MapChunkThree mapChunkThree             = new MapChunkThree();
	public AllSandChunk mapChunkFour               = new AllSandChunk();
	public AllSandChunk mapChunkFive               = new AllSandChunk();
	public AllSandChunk mapChunkSix                = new AllSandChunk();
	public AllSandChunk mapChunkSeven              = new AllSandChunk();
	public AllSandChunk mapChunkEight              = new AllSandChunk();
	public AllWaterChunk mapChunkNine              = new AllWaterChunk();
	public MapChunkTen mapChunkTen                 = new MapChunkTen();
	public MapChunkEleven mapChunkEleven           = new MapChunkEleven();
	public AllSandChunk mapChunkTwelve             = new AllSandChunk();
	public AllSandChunk mapChunkThirteen           = new AllSandChunk();
	public AllSandChunk mapChunkFourteen           = new AllSandChunk();
	public AllSandChunk mapChunkFifteen            = new AllSandChunk();
	public AllSandChunk mapChunkSixteen            = new AllSandChunk();
	public AllWaterChunk mapChunkSeventeen         = new AllWaterChunk();
	public MapChunkEighteen mapChunkEighteen       = new MapChunkEighteen();
	public MapChunkNineteen mapChunkNineteen       = new MapChunkNineteen();
	public MapChunkTwenty mapChunkTwenty           = new MapChunkTwenty();
	public AllSandChunk mapChunkTwentyOne          = new AllSandChunk();
	public AllSandChunk mapChunkTwentyTwo          = new AllSandChunk();
	public AllSandChunk mapChunkTwentyThree        = new AllSandChunk();
	public AllSandChunk mapChunkTwentyFour         = new AllSandChunk();
	public AllWaterChunk mapChunkTwentyFive        = new AllWaterChunk();
	public MapChunkTwentySix mapChunkTwentySix     = new MapChunkTwentySix();
	public AllWaterChunk mapChunkTwentySeven       = new AllWaterChunk();
	public MapChunkTwentyEight mapChunkTwentyEight = new MapChunkTwentyEight();
	public AllSandChunk mapChunkTwentyNine         = new AllSandChunk();
	public AllSandChunk mapChunkThirty             = new AllSandChunk();
	public AllSandChunk mapChunkThirtyOne          = new AllSandChunk();
	public AllSandChunk mapChunkThirtyTwo          = new AllSandChunk();
	public AllWaterChunk mapChunkThirtyThree       = new AllWaterChunk();
	
	public static ArrayList<MapChunk> mapChunks = new ArrayList<MapChunk>();
	
	public MapHandler() {
		mapChunks.add(mapChunkOne);
		mapChunks.add(mapChunkTwo);
		mapChunks.add(mapChunkThree);
		mapChunks.add(mapChunkFour);
		mapChunks.add(mapChunkFive);
		mapChunks.add(mapChunkSix);
		mapChunks.add(mapChunkSeven);
		mapChunks.add(mapChunkEight);
		mapChunks.add(mapChunkNine);
		mapChunks.add(mapChunkTen);
		mapChunks.add(mapChunkEleven);
		mapChunks.add(mapChunkTwelve);
		mapChunks.add(mapChunkThirteen);
		mapChunks.add(mapChunkFourteen);
		mapChunks.add(mapChunkFifteen);
		mapChunks.add(mapChunkSixteen);
		mapChunks.add(mapChunkSeventeen);
		mapChunks.add(mapChunkEighteen);
		mapChunks.add(mapChunkNineteen);
		mapChunks.add(mapChunkTwenty);
		mapChunks.add(mapChunkTwentyOne);
		mapChunks.add(mapChunkTwentyTwo);
		mapChunks.add(mapChunkTwentyThree);
		mapChunks.add(mapChunkTwentyFour);
		mapChunks.add(mapChunkTwentyFive);
		mapChunks.add(mapChunkTwentySix);
		mapChunks.add(mapChunkTwentySeven);
		mapChunks.add(mapChunkTwentyEight);
		mapChunks.add(mapChunkTwentyNine);
		mapChunks.add(mapChunkThirty);
		mapChunks.add(mapChunkThirtyOne);
		mapChunks.add(mapChunkThirtyTwo);
		mapChunks.add(mapChunkThirtyThree);
	}
}