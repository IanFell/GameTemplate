package maps;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.mygame.MyGame;

/**
 * Loads level maps / creates tiles for level maps.
 * 
 * @author Fabulous Fellini
 *
 */
public class MapLoader {
	
	/**
	 * Array of tiles / sprites.
	 */
	public final Sprite[][] sprites = new Sprite[10][10];
	
	/**
	 * Texture for tile one.
	 */
	private Texture textureOne;
	
	/**
	 * Texture for tile two.
	 */
	private Texture textureTwo;
	
	/**
	 * Creates and initializes tiles for map.
	 * 
	 * @param MyGame myGame
	 */
	public void loadMap(MyGame myGame) { 
		initializeTextures(myGame);
		for(int z = 0; z < 10; z++) {
			for(int x = 0; x < 10; x++) {
				if (z % 2 == 0 && x % 2 == 0) {
					sprites[x][z] = new Sprite(textureOne);
				} else {
					sprites[x][z] = new Sprite(textureTwo);
				}
				sprites[x][z].setPosition(x,z);
				sprites[x][z].setSize(1, 1);
			}
		}
	}
	
	/**
	 * Initializes tile textures.
	 * 
	 * @param MyGame myGame
	 */
	private void initializeTextures(MyGame myGame) {
		textureOne = myGame.imageLoader.fakeTile;
		textureTwo = myGame.imageLoader.fakeTileAlternate;
	}
}
