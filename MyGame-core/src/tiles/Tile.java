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
	
	public Rectangle rectangle;
	
	/**
	 * ShapeRenderer to draw our characters's circle / hit box / display, etc.
	 */
	protected ShapeRenderer shapeRenderer = new ShapeRenderer();
	
	/**
	 * Determines which image to load on top of tile.
	 */
	private String tileType;
	
	/**
	 * Contstructor.
	 * 
	 * @param String tileType
	 */
	public Tile(String tileType, float x, float y) {
		this.x        = x;
		this.y        = y;
		this.height   = 32;
		this.width    = 32;
		this.tileType = tileType;
		this.shapeRenderer.setColor(0, 1, 1, 1);
		this.rectangle = new Rectangle(x, y, width, height);
	}
	
	public void drawTileOverlayForDebugging() {
		shapeRenderer.setProjectionMatrix(Screens.camera.combined);
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.rect(x, y, width, height);
		shapeRenderer.end();
	}
	
	/**
	 * Initialize object image.
	 * 
	 * @param ImgageLoader imageLoader
	 */
	public void init(ImageLoader imageLoader) {  
		if (getTileType().equalsIgnoreCase("tileTypeOne")) {
			img = imageLoader.fakeTile;
		}
		if (getTileType().equalsIgnoreCase("tileTypeTwo")) {
			img = imageLoader.fakeTileAlternate;
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
		batch.draw(img, x, y, width, height);
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
