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

	// Values to set the starting movement direction for stumps during stump hole mission.
	public static final int START_MOVING_DOWN = 0;
	public static final int START_MOVING_UP   = 1;
	private int startMovementDirection;

	private float startY;
	private float verticalMovementOffsetMin;
	private float verticalMovementOffsetMax;

	/**
	 * Constructor.
	 * 
	 * @param int x
	 * @param int y
	 * @param int startMovementDirection
	 */
	public Stump(int x, int y, int startMovementDirection) {
		super(x, y);
		this.width                  = 1;
		this.height                 = 3;
		rectangle.x                 = x;
		rectangle.y                 = y - height;
		rectangle.width             = width;
		rectangle.height            = height;
		startY                      = y;
		int movementOffsetValue     = 2;
		verticalMovementOffsetMin   = startY - movementOffsetValue;
		verticalMovementOffsetMax   = startY + movementOffsetValue;
		this.startMovementDirection = startMovementDirection;
		if (startMovementDirection == START_MOVING_DOWN) {
			dy = 0.2f;
		} else {
			dy = -0.2f;
		}
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

	/**
	 * Moves stumps up and down.
	 */
	private void animateStumps() {
		if (y < verticalMovementOffsetMin) {
			dy = 0.5f;
		} else if (y > verticalMovementOffsetMax) {
			dy = -0.5f;
		}
		y += dy;
	}
}
