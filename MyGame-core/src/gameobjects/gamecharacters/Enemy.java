package gameobjects.gamecharacters;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.mygdx.mygame.MyGame;

import helpers.ColorHelper;
import helpers.GamePlayHelper;
import loaders.ImageLoader;
import maps.MapEditor;

/**
 * Enemy object.
 * 
 * @author Fabulous Fellini
 *
 */
public class Enemy extends GameCharacter {
	
	/**
	 * Constructor.
	 */
	public Enemy() {
		this.x      = GamePlayHelper.setObjectXPositionInMiddleOfScreen(this) + 200;
		this.y      = GamePlayHelper.setObjectYPositionInMiddleOfScreen(this) + 100;
		this.radius = characterSize;
		this.circle = new Circle(x, y, radius);
	}
	
	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shapeRenderer
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		shapeRenderer.setColor(ColorHelper.BLUE);
		shapeRenderer.circle(x, y, radius);
	}
	
	/**
	 * 
	 * @param MyGame    myGame
	 * @param MapEditor mapEditor
	 */
	@Override
	public void updateObject(MyGame myGame, MapEditor mapEditor) {
		circle.x = x;
		circle.y = y;
	}
}
