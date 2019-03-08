package gameobjects.stationarygameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import loaders.ImageLoader;
import maps.MapHandler;
import physics.CollisionHandler;

public class RawBar extends GamePlayObject {

	public RawBar(int x, int y) {
		super(x, y);
		this.width       = 5;
		this.height      = 4;
		this.rectangle.x = width;
		this.rectangle.y = height;
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shaperender
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		batch.draw(imageLoader.rawbar, x, y, width, -height);
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		super.updateObject(myGame, mapHandler);
		CollisionHandler.checkIfPlayerHasCollidedWithRawBar(
				myGame.getGameObject(GameObject.PLAYER_ONE),
				this
				);
	}

}
