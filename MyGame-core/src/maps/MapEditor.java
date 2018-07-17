package maps;

import tiles.Tile;

/**
 * Class to edit level maps.
 * 
 * @author Fabulous Fellini
 *
 */
public class MapEditor {

	public static final int SolidTile                  = 0;
	public static final int GrassTileOne               = 1;
	public static final int GrassTileTwo               = 2;
	public static final int SandTile                   = 3;
	public static final int WaterTileOne               = 4;
	public static final int WaterTileTwo               = 5;
	public static final int WaterLowerLeftHalfAndHalf  = 6;
	public static final int WaterUpperLeftHalfAndHalf  = 7;
	public static final int WaterLowerRightHalfAndHalf = 8;
	public static final int WaterUpperRightHalfAndHalf = 9;
	public static final int WaterUpperLeftCurved       = 10;

	private final int WORLD_WIDTH  = 21;
	private final int WORLD_HEIGHT = 21;
	
	/**
	 * Grid:
	 * 20, 27
	 */
	public final Tile[][] tileMap2027 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public int[][] worldMap2027       = 
			{
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 0, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 0, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{4, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{4, 4, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{4, 4, 4, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{4, 4, 4, 4, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{4, 4, 4, 4, 4, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{4, 4, 4, 4, 4, 4, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}
			};
	
	/**
	 * Grid:
	 * 20, 27 (Animated).
	 */
	public final Tile[][] tileMapAnimated2027 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public int[][] worldMapAnimated2027       = 
		{
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 0, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 0, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{5, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{5, 5, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{5, 5, 5, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{5, 5, 5, 5, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{5, 5, 5, 5, 5, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{5, 5, 5, 5, 5, 5, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}
		};
	
	/**
	 * Currently this signifies these grids in our world:
	 * 19, 27
	 * 19, 26
	 * 18, 26
	 * 18, 25
	 */
	public final Tile[][] solidSandTileMap1927 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidSandTileMap1926 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidSandTileMap1826 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidSandTileMap1825 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public int[][] solidSandWorldMap           = 
		{
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}
		};
	
	/**
	 * Grid:
	 * 20, 26
	 */
	public final Tile[][] tileMap2026 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public int[][] worldMap2026       = 
			{
				{7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{4, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{4, 4, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{4, 4, 4, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{4, 4, 4, 4, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{4, 4, 4, 4, 4, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{4, 4, 4, 4, 4, 4, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{4, 4, 4, 4, 4, 4, 4, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{4, 4, 4, 4, 4, 4, 4, 4, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{4, 4, 4, 4, 4, 4, 4, 4, 4, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 7, 3, 3, 3, 3, 3, 3, 3, 3},
				{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 7, 3, 3, 3, 3, 3, 3, 3},
				{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
				{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
				{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
				{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
				{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
				{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
				{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}
			};
	
	/**
	 * Grid:
	 * 20, 26 (Animated
	 */
	public final Tile[][] tileMapAnimated2026 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public int[][] worldMapAnimated2026       = 
			{
				{7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{5, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{5, 5, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{5, 5, 5, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{5, 5, 5, 5, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{5, 5, 5, 5, 5, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{5, 5, 5, 5, 5, 5, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{5, 5, 5, 5, 5, 5, 5, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{5, 5, 5, 5, 5, 5, 5, 5, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{5, 5, 5, 5, 5, 5, 5, 5, 5, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7, 3, 3, 3, 3, 3, 3, 3, 3},
				{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7, 3, 3, 3, 3, 3, 3, 3},
				{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
				{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
				{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
				{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
				{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
				{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
				{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}
			};
	
	/**
	 * Solid water.
	 * 20, 25
	 * 20, 24
	 * 20, 23
	 * 20, 22
	 * 20, 21
	 * 20, 20
	 * 20, 19
	 * 19, 24
	 * 18, 20
	 * 17, 20
	 * 16, 20
	 * 15, 20
	 * 14, 20
	 * 13, 20
	 * 12, 20
	 * 11, 20
	 * 10, 20
	 * 09, 20
	 * 08, 20
	 * 07, 20
	 * 06, 20
	 * 05, 20
	 * 04, 20
	 * 03, 20
	 * 02, 20
	 * 01, 20
	 * 01, 19
	 * 02, 19
	 * 03, 19
	 * 04, 19
	 * 05, 19
	 * 06, 19
	 * 07, 19
	 * 08, 19
	 * 09, 19
	 * 10, 19
	 * 12, 19
	 * 13, 19
	 * 14, 19
	 * 15, 19
	 * 16, 19
	 * 17, 19
	 * 18, 19
	 * 19, 19
	 * 20, 19
	 * 21, 19
	 * 22, 19
	 * 23, 19
	 * 20, 18
	 * 20, 17
	 * 20, 16
	 * 20, 15
	 * 20, 14
	 */
	public final Tile[][] solidWaterTileMap2025 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap2024 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap2023 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap2022 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap2021 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap2020 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap2019 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap1924 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap1820 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap1720 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap1620 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap1520 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap1420 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap1320 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap1220 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap1120 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap1020 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap0920 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap0820 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap0720 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap0620 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap0520 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap0420 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap0320 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap0220 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap0120 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap0119 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap0219 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap0319 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap0419 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap0519 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap0619 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap0719 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap0819 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap0919 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap1019 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap1219 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap1319 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap1419 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap1519 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap1619 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap1719 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap1819 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap1919 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap1920 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap2119 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap2219 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap2319 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap2018 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap2017 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap2016 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap2015 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMap2014 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public int[][] solidWaterWorldMap           = 
		{
				{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
				{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
				{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
				{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
				{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
				{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
				{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
				{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
				{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
				{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
				{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
				{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
				{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
				{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
				{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
				{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
				{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
				{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
				{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
				{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}
		};
	
	/**
	 * Solid water (Animated).
	 * 20, 25
	 * 20, 24
	 * 20, 23
	 * 20, 22
	 * 20, 21
	 * 20, 20
	 * 20, 19
	 * 19, 24
	 * 18, 20
	 * 17, 20
	 * 16, 20
	 * 15, 20
	 * 14, 20
	 * 13, 20
	 * 12, 20
	 * 11, 20
	 * 10, 20
	 * 09, 20
	 * 08, 20
	 * 07, 20
	 * 06, 20
	 * 05, 20
	 * 04, 20
	 * 03, 20
	 * 02, 20
	 * 01, 20
	 * 01, 19
	 * 02, 19
	 * 03, 19
	 * 04, 19
	 * 05, 19
	 * 06, 19
	 * 07, 19
	 * 08, 19
	 * 09, 19
	 * 10, 19
	 * 12, 19
	 * 13, 19
	 * 14, 19
	 * 15, 19
	 * 16, 19
	 * 17, 19
	 * 18, 19
	 * 19, 19
	 * 20, 19
	 * 21, 19
	 * 22, 19
	 * 23, 19
	 * 20, 18
	 * 20, 17
	 * 20, 16
	 * 20, 15
	 * 20, 14
	 */
	public final Tile[][] solidWaterTileMapAnimated2025 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated2024 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated2023 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated2022 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated2021 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated2020 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated2019 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated1924 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated1820 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated1720 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated1620 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated1520 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated1420 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated1320 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated1220 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated1120 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated1020 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated0920 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated0820 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated0720 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated0620 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated0520 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated0420 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated0320 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated0220 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated0120 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated0119 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated0219 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated0319 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated0419 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated0519 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated0619 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated0719 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated0819 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated0919 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated1019 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated1219 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated1319 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated1419 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated1519 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated1619 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated1719 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated1819 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated1919 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated1920 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated2119 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated2219 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated2319 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated2018 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated2017 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated2016 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated2015 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public final Tile[][] solidWaterTileMapAnimated2014 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public int[][] solidWaterWorldMapAnimated           = 
		{
				{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
				{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
				{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
				{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
				{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
				{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
				{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
				{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
				{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
				{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
				{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
				{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
				{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
				{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
				{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
				{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
				{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
				{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
				{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
				{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}
		};
	
	/**
	 * Grid:
	 * 19, 25
	 */
	public final Tile[][] tileMap1925 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public int[][] worldMap1925       = 
		{
			{7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
			{4, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
			{4, 4, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
			{4, 4, 4, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
			{4, 4, 4, 4, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
			{4, 4, 4, 4, 4, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
			{4, 4, 4, 4, 4, 4, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
			{4, 4, 4, 4, 4, 4, 4, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
			{4, 4, 4, 4, 4, 4, 4, 4, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
			{4, 4, 4, 4, 4, 4, 4, 4, 4, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
			{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3},
			{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 7, 3, 3, 3, 3, 3, 3, 3, 3},
			{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 7, 3, 3, 3, 3, 3, 3, 3},
			{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 7, 3, 3, 3, 3, 3, 3},
			{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 7, 3, 3, 3, 3, 3},
			{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 7, 3, 3, 3, 3},
			{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 7, 3, 3, 3},
			{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 7, 3, 3},
			{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 7, 3},
			{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 7}
		};
	
	/**
	 * Grid:
	 * 19, 25 (Animated).
	 */
	public final Tile[][] tileMapAnimated1925 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public int[][] worldMapAnimated1925       = 
		{
			{7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
			{5, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
			{5, 5, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
			{5, 5, 5, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
			{5, 5, 5, 5, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
			{5, 5, 5, 5, 5, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
			{5, 5, 5, 5, 5, 5, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
			{5, 5, 5, 5, 5, 5, 5, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
			{5, 5, 5, 5, 5, 5, 5, 5, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
			{5, 5, 5, 5, 5, 5, 5, 5, 5, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
			{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3},
			{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7, 3, 3, 3, 3, 3, 3, 3, 3},
			{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7, 3, 3, 3, 3, 3, 3, 3},
			{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7, 3, 3, 3, 3, 3, 3},
			{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7, 3, 3, 3, 3, 3},
			{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7, 3, 3, 3, 3},
			{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7, 3, 3, 3},
			{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7, 3, 3},
			{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7, 3},
			{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7}
		};
	
	/**
	 * Grid:
	 * 18, 27
	 */
	public final Tile[][] tileMap1827 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public int[][] worldMap1827       = 
		{
			{8, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
			{3, 8, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
			{3, 3, 8, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
			{3, 3, 3, 8, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
			{3, 3, 3, 3, 8, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
			{3, 3, 3, 3, 3, 8, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
			{3, 3, 3, 3, 3, 3, 8, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
			{3, 3, 3, 3, 3, 3, 3, 8, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
			{3, 3, 3, 3, 3, 3, 3, 3, 8, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 8, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 8, 4, 4, 4, 4, 4, 4, 4, 4, 4},
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 8, 4, 4, 4, 4, 4, 4, 4, 4},
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 8, 4, 4, 4, 4, 4, 4, 4},
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 8, 4, 4, 4, 4, 4, 4},
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 8, 4, 4, 4, 4, 4},
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 8, 4, 4, 4, 4},
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 8, 4, 4, 4},
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 8, 4, 4},
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 8, 4},
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 8}
		};
	
	/**
	 * Grid:
	 * 18, 27
	 */
	public final Tile[][] tileMapAnimated1827 = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public int[][] worldMapAnimated1827       = 
		{
			{8, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
			{3, 8, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
			{3, 3, 8, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
			{3, 3, 3, 8, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
			{3, 3, 3, 3, 8, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
			{3, 3, 3, 3, 3, 8, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
			{3, 3, 3, 3, 3, 3, 8, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
			{3, 3, 3, 3, 3, 3, 3, 8, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
			{3, 3, 3, 3, 3, 3, 3, 3, 8, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 8, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 8, 5, 5, 5, 5, 5, 5, 5, 5, 5},
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 8, 5, 5, 5, 5, 5, 5, 5, 5},
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 8, 5, 5, 5, 5, 5, 5, 5},
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 8, 5, 5, 5, 5, 5, 5},
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 8, 5, 5, 5, 5, 5},
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 8, 5, 5, 5, 5},
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 8, 5, 5, 5},
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 8, 5, 5},
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 8, 5},
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 8}
		};
}
