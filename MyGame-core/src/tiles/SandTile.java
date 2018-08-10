package tiles;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.mygame.MyGame;

/**
 * Water tile consists of a grid of 20 x 20 tiles.
 * 
 * @author Fabulous Fellini
 *
 */
public class SandTile extends Tile {

	/**
	 * Constructor.
	 * 
	 * @param Texture texture
	 * @param boolean isSolid
	 */
	public SandTile(Texture texture, boolean isSolid) {
		super(texture, isSolid);
	}
	
	public final Tile[][] solidSandTile = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public int[][] solidSandMap           = 
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
	 * 
	 * @param MyGame myGame
	 * @param int    offset
	 */
	public void init(MyGame myGame, int offset) {
		int tileSize = 1;
		for(int z = 0; z < solidSandTile.length; z++) {
			for(int x = 0; x < solidSandTile[z].length; x++) {
				solidSandTile[x][z] = new SandTile(Tile.sandTexture, false);
				solidSandTile[x][z].setPosition(x - offset, z);
				solidSandTile[x][z].setSize(tileSize, tileSize);
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
		for(int z = 0; z < solidSandTile.length; z++) {
			for(int x = 0; x < solidSandTile[z].length; x++) {
				solidSandTile[x][z].setPosition(x - xOffset, z - yOffset);
				solidSandTile[x][z].draw(myGame.renderer.batch);
			}
		}
	}

}
