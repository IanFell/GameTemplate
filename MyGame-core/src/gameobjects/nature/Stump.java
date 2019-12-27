package gameobjects.nature;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import controllers.PlayerController;
import handlers.CollisionHandler;
import loaders.ImageLoader;
import maps.MapHandler;
import missions.MissionStumpHole;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Stump extends NatureObject {

	private float startY;
	private float verticalMovementOffsetMin;
	private float verticalMovementOffsetMax;

	/**
	 * Constructor.
	 * 
	 * @param int x
	 * @param int y
	 */
	public Stump(int x, int y) {
		super(x, y);
		this.width                = 1;
		this.height               = 3;
		rectangle.x               = x;
		rectangle.y               = y - height;
		rectangle.width           = width;
		rectangle.height          = height;
		startY                    = y;
		verticalMovementOffsetMin = startY - 3;
		verticalMovementOffsetMax = startY + 3;
		dy                        = 0.2f;
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ImageLoader imageLoader) {
		renderNatureObject(batch, imageLoader.stump);
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		if (!MissionStumpHole.missionIsActive) {
			CollisionHandler.checkIfPlayerCollidedWithStump(PlayerController.getCurrentPlayer(myGame), this);
		} else {
			animateStumps();
		}
	}

	private void animateStumps() {
		y += dy;
		if (y < verticalMovementOffsetMin) {
			dy = 0.5f;
		} else if (y > verticalMovementOffsetMax) {
			dy = -0.5f;
		}
	}
}
