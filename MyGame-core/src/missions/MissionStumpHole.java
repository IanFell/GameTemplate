package missions;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.mygame.MyGame;

import gameobjects.Bird;
import gameobjects.GameObject;
import gameobjects.gamecharacters.Player;
import gameobjects.nature.Stump;
import handlers.CollisionHandler;
import helpers.GameAttributeHelper;
import loaders.ImageLoader;
import maps.MapHandler;
import screens.GameScreen;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class MissionStumpHole extends Mission {

	private Bird bird;

	public static boolean missionIsActive = false;

	public static ArrayList <GameObject> stumps = new ArrayList <GameObject>();

	private final int AMOUNT_OF_STUMPS = 13;
	
	public static Rectangle player;
	
	public static float playerDx;
	public static float playerDy;
	
	private float playerSize = 1.0f;
	
	/**
	 * Gravity variables.
	 */
	private double gravity = 0.6d;
	private double dt      = 0.2d; 
	
	public static boolean playerIsJumping = false;
	
	private int jumpTimer = 0;
	
	private final float VERTICAL_ACCELERATION = 0.3f;
	private final float PEAK_JUMP_VALUE       = 7.0f;

	/**
	 * Constructor.
	 */
	public MissionStumpHole() {
		// Place bird on last stump of row one of stumps.
		bird = new Bird(
				GameAttributeHelper.CHUNK_FOUR_X_POSITION_START + 5f, 
				GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START + 32.5f
				);
		loadStumps();
		player   = new Rectangle(stumps.get(0).getX(), stumps.get(0).getY() - 15, playerSize, playerSize);
		playerDx = 0.1f;
		playerDy = 0;
	}

	private void loadStumps() {
		float startX = GameAttributeHelper.CHUNK_FOUR_X_POSITION_START - 24.5f;
		int startY = GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START + 45;
		for (int i = 0; i < AMOUNT_OF_STUMPS; i++) {
			if (i % 2 == 0) {
				stumps.add(new Stump((int) startX, startY, Stump.START_MOVING_DOWN));
			} else {
				stumps.add(new Stump((int) startX, startY, Stump.START_MOVING_UP));
			}
			startX += 2;
		}
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 * @param MyGame      myGame
	 */
	@Override
	public void renderMission(SpriteBatch batch, ImageLoader imageLoader, MyGame myGame) {
		if (missionIsActive) {
			// Draw background.
			batch.draw(
					imageLoader.whiteSquare, 
					GameScreen.camera.position.x - GameScreen.camera.viewportWidth / 2, 
					GameScreen.camera.position.y + GameScreen.camera.viewportHeight / 2,
					GameScreen.camera.viewportWidth, 
					-GameScreen.camera.viewportHeight
					);

			for (int i = 0; i < stumps.size(); i++) {
				stumps.get(i).renderObject(batch, imageLoader);
			}
			
			// Draw player.
			batch.draw(imageLoader.blackSquare, player.getX(), player.getY(), player.getWidth(), player.getHeight());
		} else {
			bird.renderObject(batch, imageLoader);
		}
	}
	
	// TODO Make sure this comment is correct.
	/**
	 * So far this method handles player falling and landing on stump, and stump goes up and down.
	 * @param stump
	 */
	private void applyPlayerVsStumpPhysics(GameObject stump) {
		//playerDy = 0;
		//player.y = stump.getY() - stump.getHeight() - player.height;
		//player.y = player.y - playerDy;
		//player.y = 
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateMission(MyGame myGame, MapHandler mapHandler) {
		if (Stump.playerIsOnStump) {
			//playerIsJumping = false;
		}
		if (playerIsJumping) {
			playerDy = playerDy - VERTICAL_ACCELERATION;
			jumpTimer++;
			if (jumpTimer > PEAK_JUMP_VALUE) {
				playerIsJumping = false;
				jumpTimer = 0;
			}
		}
		//playerDy = 0.1f;
		for (int i = 0; i < stumps.size(); i++) {
			stumps.get(i).updateObject(myGame, mapHandler);
			if (CollisionHandler.playerHasCollidedWithStump(player, stumps.get(i))) {
				//applyPlayerVsStumpPhysics(stumps.get(i));
			} 
			
		}
		applyGravityToPlayer();
	}
	
	private void applyGravityToPlayer() {
		playerDy += gravity * dt; // Change in velocity.
		player.y += playerDy * dt + .00005f * gravity * dt * dt; // Position formula.
	}
}
