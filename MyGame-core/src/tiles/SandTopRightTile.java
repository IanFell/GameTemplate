package tiles;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.mygame.MyGame;


/**
 * Water tile consists of a grid of tiles.
 * 
 * @author Fabulous Fellini
 *
 */
public class SandTopRightTile extends Tile {

	public SandTopRightTile(Texture texture, boolean isSolid) {
		super(texture, isSolid);
	}
	
	public final Tile[][] sandTopRightTile = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	public int[][] sandTopRightMap       = 
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
	
	public void init(MyGame myGame, int offset) {
		
		for(int z = 0; z < sandTopRightTile.length; z++) {
			for(int x = 0; x < sandTopRightTile[z].length; x++) {
				int tileSize    = 1;
				sandTopRightTile[x][z] = new SandTopRightTile(Tile.waterLowerLeftHalfAndHalfTexture, false);
				
				/*
				if (sandTopRightMap[z][x] == Tile.WaterUpperLeftHalfAndHalf) {  
					sandTopRightTile[x][z] = new SandTopRightTile(Tile.waterUpperLeftHalfAndHalfTexture, false);
				}*/
				/*
				if (sandTopRightMap[z][x] == Tile.WaterTileOne) {  
					sandTopRightTile[x][z] = new SandTopRightTile(Tile.waterLowerLeftHalfAndHalfTexture, false);
				}
				if (sandTopRightMap[z][x] == Tile.SandTile) {  
					sandTopRightTile[x][z] = new SandTopRightTile(Tile.sandTexture, false);
				}
				*/
				
				sandTopRightTile[x][z].setPosition(x - offset, z);
				sandTopRightTile[x][z].setSize(tileSize, tileSize);
			}
		}
	}
	
	public void render(MyGame myGame, int xOffset, int yOffset) {
		for(int z = 0; z < sandTopRightTile.length; z++) {
			for(int x = 0; x < sandTopRightTile[z].length; x++) {
				sandTopRightTile[x][z].setPosition(x - xOffset, z - yOffset);
				sandTopRightTile[x][z].draw(myGame.renderer.batch);
			}
		}
	}

}
