package maps;

import java.util.ArrayList;

import maps.mapchunks.MapChunk;
import maps.mapchunks.MapChunkEight;
import maps.mapchunks.MapChunkEighteen;
import maps.mapchunks.MapChunkEleven;
import maps.mapchunks.MapChunkFifteen;
import maps.mapchunks.MapChunkFive;
import maps.mapchunks.MapChunkFour;
import maps.mapchunks.MapChunkFourteen;
import maps.mapchunks.MapChunkNine;
import maps.mapchunks.MapChunkNineteen;
import maps.mapchunks.MapChunkOne;
import maps.mapchunks.MapChunkSeven;
import maps.mapchunks.MapChunkSeventeen;
import maps.mapchunks.MapChunkSix;
import maps.mapchunks.MapChunkSixteen;
import maps.mapchunks.MapChunkTen;
import maps.mapchunks.MapChunkThirteen;
import maps.mapchunks.MapChunkThree;
import maps.mapchunks.MapChunkTwelve;
import maps.mapchunks.MapChunkTwenty;
import maps.mapchunks.MapChunkTwentyFive;
import maps.mapchunks.MapChunkTwentyFour;
import maps.mapchunks.MapChunkTwentyOne;
import maps.mapchunks.MapChunkTwentySeven;
import maps.mapchunks.MapChunkTwentySix;
import maps.mapchunks.MapChunkTwentyThree;
import maps.mapchunks.MapChunkTwentyTwo;
import maps.mapchunks.MapChunkTwo;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class MapHandler {
	
	public MapChunkOne mapChunkOne                 = new MapChunkOne();
	public MapChunkTwo mapChunkTwo                 = new MapChunkTwo();
	public MapChunkThree mapChunkThree             = new MapChunkThree();
	public MapChunkFour mapChunkFour               = new MapChunkFour();
	public MapChunkFive mapChunkFive               = new MapChunkFive();
	public MapChunkSix mapChunkSix                 = new MapChunkSix();
	public MapChunkSeven mapChunkSeven             = new MapChunkSeven();
	public MapChunkEight mapChunkEight             = new MapChunkEight();
	public MapChunkNine mapChunkNine               = new MapChunkNine();
	public MapChunkTen mapChunkTen                 = new MapChunkTen();
	public MapChunkEleven mapChunkEleven           = new MapChunkEleven();
	public MapChunkTwelve mapChunkTwelve           = new MapChunkTwelve();
	public MapChunkThirteen mapChunkThirteen       = new MapChunkThirteen();
	public MapChunkFourteen mapChunkFourteen       = new MapChunkFourteen();
	public MapChunkFifteen mapChunkFifteen         = new MapChunkFifteen();
	public MapChunkSixteen mapChunkSixteen         = new MapChunkSixteen();
	public MapChunkSeventeen mapChunkSeventeen     = new MapChunkSeventeen();
	public MapChunkEighteen mapChunkEighteen       = new MapChunkEighteen();
	public MapChunkNineteen mapChunkNineteen       = new MapChunkNineteen();
	public MapChunkTwenty mapChunkTwenty           = new MapChunkTwenty();
	public MapChunkTwentyOne mapChunkTwentyOne     = new MapChunkTwentyOne();
	public MapChunkTwentyTwo mapChunkTwentyTwo     = new MapChunkTwentyTwo();
	public MapChunkTwentyThree mapChunkTwentyThree = new MapChunkTwentyThree();
	public MapChunkTwentyFour mapChunkTwentyFour   = new MapChunkTwentyFour();
	public MapChunkTwentyFive mapChunkTwentyFive   = new MapChunkTwentyFive();
	public MapChunkTwentySix mapChunkTwentySix     = new MapChunkTwentySix();
	public MapChunkTwentySeven mapChunkTwentySeven = new MapChunkTwentySeven();
	
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
	}
}
