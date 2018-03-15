package tiles;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import interfaces.TileInterface;
import loaders.ImageLoader;
import screens.Screens;

/**
 * Tile object class.
 * 
 * @author Fabulous Fellini
 *
 */
public class Tile extends GameObject implements TileInterface {
	
	/**
	 * ShapeRenderer to draw our characters's circle / hit box / display, etc.
	 */
	protected ShapeRenderer shapeRenderer = new ShapeRenderer();
	
	/**
	 * Determines which image to load on top of tile.
	 */
	private String tileType;
	
	/**
	 * Size of width and height of tiles.
	 */
	private int tileSize = 32;
	
	/**
	 * Contstructor.
	 * 
	 * @param String tileType
	 */
	public Tile(String tileType, float x, float y) {
		this.x        = x;
		this.y        = y;
		this.height   = tileSize;
		this.width    = tileSize;
		this.tileType = tileType;
		this.shapeRenderer.setColor(0, 1, 1, 1);
	}
	
	/**
	 * Initialize object image.
	 * 
	 * @param ImgageLoader imageLoader
	 */
	public void init(ImageLoader imageLoader) {  
		if (getTileType().equalsIgnoreCase("tileTypeOne")) {
			texture = imageLoader.fakeTile;
		}
		if (getTileType().equalsIgnoreCase("tileTypeTwo")) {
			texture = imageLoader.fakeTileAlternate;
		}
	}
	
	/**
	 * 
	 * @param SpriteBatch batch
	 * @param float       x
	 * @param float       y
	 * @param MyGame      myGame
	 */
	public void drawTile(SpriteBatch batch, float x, float y, MyGame myGame) {
		batch.draw(texture, x, y, width, height);
	}

	/**
	 * 
	 * @return String
	 */
	public String getTileType() {
		return tileType;
	}

	/**
	 * 
	 * @param String tileType
	 */
	public void setTileType(String tileType) {
		this.tileType = tileType;
	}

	@Override
	public void updateGameObject() {
		// TODO Auto-generated method stub

	}
}
