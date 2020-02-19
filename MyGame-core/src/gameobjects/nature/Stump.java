package gameobjects.nature;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

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

	float movementDy;

	public static boolean playerIsOnStump = false;

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
		float hitboxOffset          = 0.3f;
		rectangle.x                 = x + hitboxOffset;
		rectangle.y                 = y - height;
		rectangle.width             = width - hitboxOffset;
		rectangle.height            = height;
		startY                      = y;
		int movementOffsetValue     = 1;
		verticalMovementOffsetMin   = startY - movementOffsetValue;
		verticalMovementOffsetMax   = startY + movementOffsetValue;
		this.startMovementDirection = startMovementDirection;
		movementDy                  = 0.1f;
		if (startMovementDirection == START_MOVING_DOWN) {
			dy = movementDy;
		} else {
			dy = -movementDy;
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
		super.updateObject(myGame, mapHandler);
		if (!MissionStumpHole.missionIsActive) {
			// This is now handled by an icon that player needs to touch.
			//CollisionHandler.checkIfPlayerCollidedWithStump(PlayerController.getCurrentPlayer(myGame), this);
		} else {
			animateStumps();
			checkStumpCollisionWithPlayer();
		}
	}

	private void checkStumpCollisionWithPlayer() {
		if(MissionStumpHole.playerDy > 0){
			if(MissionStumpHole.player.y + MissionStumpHole.player.height >= y - height && MissionStumpHole.player.y + MissionStumpHole.player.height < y + 1) {
				if(MissionStumpHole.player.x < x + width && MissionStumpHole.player.x + MissionStumpHole.player.width > x) {
					float newDY               = 0;
					MissionStumpHole.player.y = y - height - MissionStumpHole.player.height;
					MissionStumpHole.playerDy = newDY;
					playerIsOnStump	          = true;
				}
			}
		}
	}

	/**
	 * Moves stumps up and down.
	 */
	private void animateStumps() {
		if (y < verticalMovementOffsetMin) {
			dy = movementDy;
		} else if (y > verticalMovementOffsetMax) {
			dy = -movementDy;
		}
		y += dy;
	}
}
