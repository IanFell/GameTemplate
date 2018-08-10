package tiles;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.mygame.MyGame;

/**
 * Water tile consists of a grid of 20 x 20 tiles.
 * 
 * @author Fabulous Fellini
 *
 */
public class WaterTile extends Tile {

	/**
	 * Constructor.
	 * 
	 * @param Texture texture
	 * @param boolean isSolid
	 */
	public WaterTile(Texture texture, boolean isSolid) {
		super(texture, isSolid);
	}
	
	public final Tile[][] solidWaterTile = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public int[][] solidWaterMap         = 
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
	 * 
	 * @param MyGame myGame
	 * @param int    offset
	 */
	public void init(MyGame myGame, int offset) {
		int tileSize = 1;
		for(int z = 0; z < solidWaterTile.length; z++) {
			for(int x = 0; x < solidWaterTile[z].length; x++) {
				solidWaterTile[x][z] = new WaterTile(Tile.waterTextureOne, false);
				solidWaterTile[x][z].setPosition(x - offset, z);
				solidWaterTile[x][z].setSize(tileSize, tileSize);
			}
		}
	}
	
	/**
	 * 
	 * @param MyGame myGame
	 * @param int    xOffset
	 * @param int    yOffset
	 */
	public void render(MyGame myGame, int xOffset, int yOffset) {
		for(int z = 0; z < solidWaterTile.length; z++) {
			for(int x = 0; x < solidWaterTile[z].length; x++) {
				solidWaterTile[x][z].setPosition(x - xOffset, z - yOffset);
				solidWaterTile[x][z].draw(myGame.renderer.batch);
			}
		}
	}
}
