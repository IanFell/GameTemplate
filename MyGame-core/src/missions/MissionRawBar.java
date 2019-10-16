package missions;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.mygame.MyGame;

import controllers.PlayerController;
import gameobjects.GameObject;
import helpers.RandomNumberGenerator;
import loaders.ImageLoader;
import screens.GameScreen;

/**
 * This mission will consist of three phases, where the player will have to collect a certain amount of 
 * oysters within a certain amount of time.
 * 
 * Mission plan:
 * 	- Player arrives at Raw Bar.
 *  - Player is instructed to go find the oyster, which could be at one of seven locations (towns), 
 *      chosen at random, however each should be by a body of water.  Player will recieve clues to 
 *      figure out which location to go to.
 *  - Player travels to location.
 *  - Player begins mini game (The 3 phases).
 *  - If player completes mission, they will recieve the oyster.
 *  
 * @author Fabulous Fellini
 *
 */
public class MissionRawBar extends Mission {

	// Time alloted for all phases of mission.
	public static final float MAX_MISSION_TIME_PHASE_ONE   = 15f;
	public static final float MAX_MISSION_TIME_PHASE_TWO   = 10f;
	public static final float MAX_MISSION_TIME_PHASE_THREE = 2f;

	private final int MAX_OYSTERS_SPAWNED                        = 100;
	public static final int NUMBER_OF_OYSTERS_NEEDED_PHASE_ONE   = 40;
	public static final int NUMBER_OF_OYSTERS_NEEDED_PHASE_TWO   = 10;
	public static final int NUMBER_OF_OYSTERS_NEEDED_PHASE_THREE = 25;
	// This will be assigned to one of the above values.
	private int numberOfOystersNeededToWin;

	public static boolean phaseIsActive = true;

	private boolean initializeMission = true;

	private boolean phaseComplete = false;

	/**
	 * Timer to display to user how many oysters to collect.  
	 * This message only appears for a few seconds at the start of the phase.
	 */
	private int collectOysterMessageTimer = 0;

	// Oysters will have a random x, y, and size.
	private double[] oysterX                   = new double[MAX_OYSTERS_SPAWNED];
	private double[] oysterY                   = new double[MAX_OYSTERS_SPAWNED];
	private double[] oysterSize                = new double[MAX_OYSTERS_SPAWNED];
	private int oystersCollected               = 0;
	private ArrayList<Boolean> collectedOyster = new ArrayList<Boolean>();

	public static float playerX = 100f;
	public static float playerY = 10f;
	private float playerSize    = 1;

	// Hitboxes for collision detection.
	private Rectangle[] oysterBounds = new Rectangle[MAX_OYSTERS_SPAWNED];
	private Rectangle playerBounds   = new Rectangle(0, 0, 0, 0);

	// Used for countdown timer.
	private float timeSeconds = 0f;
	private float phaseTimeLimit;

	/**
	 * Constructor.
	 * 
	 * @param int   numberOfOystersNeededToWin
	 * @param float phaseTimeLimit
	 */
	public MissionRawBar(int numberOfOystersNeededToWin, float phaseTimeLimit) {
		this.numberOfOystersNeededToWin = numberOfOystersNeededToWin;
		this.phaseTimeLimit             = phaseTimeLimit;
		for (int i = 0 ; i < MAX_OYSTERS_SPAWNED; i++) {
			oysterBounds[i] = new Rectangle(0, 0, 0, 0);
			collectedOyster.add(false);
		}
	}

	private void initializeMission() {
		for (int i = 0 ; i < MAX_OYSTERS_SPAWNED; i++) {
			oysterX[i]             = RandomNumberGenerator.generateRandomDouble(
					GameScreen.camera.position.x - GameScreen.camera.viewportWidth / 2, 
					GameScreen.camera.position.x - GameScreen.camera.viewportWidth / 2 + GameScreen.camera.viewportWidth
					);
			oysterY[i]             = RandomNumberGenerator.generateRandomDouble(
					GameScreen.camera.position.y - GameScreen.camera.viewportHeight / 2, 
					GameScreen.camera.position.y - GameScreen.camera.viewportHeight / 2 + GameScreen.camera.viewportHeight
					);
			oysterSize[i]          = RandomNumberGenerator.generateRandomDouble(0.2d, 0.8d);
			oysterBounds[i].x      = (float) oysterX[i];
			oysterBounds[i].y      = (float) oysterY[i];
			oysterBounds[i].width  = (float) oysterSize[i];
			oysterBounds[i].height = (float) oysterSize[i];
		}
		playerBounds.width  = playerSize;
		playerBounds.height = playerSize;
		missionComplete     = false;
	}

	public void updateMission() {
		if (initializeMission) {
			initializeMission();
			initializeMission = false;
		}

		playerBounds.x = playerX;
		playerBounds.y = playerY;

		for (int i = 0 ; i < MAX_OYSTERS_SPAWNED; i++) {
			if (playerBounds.overlaps(oysterBounds[i]) && collectedOyster.get(i).equals(false)) {
				collectedOyster.set(i, true);
				oystersCollected++;
			}
		}

		handleCountdownTimer();
		checkForMissionComplete();

		System.out.println("Oysters Collected: " + oystersCollected);

		// Only display how many oysters to collect for a few seconds.
		if (collectOysterMessageTimer < 50) {
			collectOysterMessageTimer++;
		}
	}

	/**
	 * Countdown until timeSeconds exceeds phaseTimeLimit.  Technically it counts up.
	 * If time runs out, kill the game.
	 */
	private void handleCountdownTimer() {
		timeSeconds +=Gdx.graphics.getRawDeltaTime();
		if(timeSeconds > phaseTimeLimit){    
			System.exit(0);
		}
	}

	private void checkForMissionComplete() {
		if (oystersCollected >= numberOfOystersNeededToWin) {
			missionComplete = true;
			phaseComplete   = true;
		}
	}

	/**
	 * 
	 * @return boolean
	 */
	public boolean isPhaseComplete() {
		return phaseComplete;
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 * @param MyGame      myGame
	 */
	@Override
	public void renderMission(SpriteBatch batch, ImageLoader imageLoader, MyGame myGame) {
		// Draw background.
		batch.draw(
				imageLoader.whiteSquare, 
				GameScreen.camera.position.x - GameScreen.camera.viewportWidth / 2, 
				GameScreen.camera.position.y + GameScreen.camera.viewportHeight / 2,
				GameScreen.camera.viewportWidth, 
				-GameScreen.camera.viewportHeight
				);

		// Draw oysters.
		for (int i = 0 ; i < MAX_OYSTERS_SPAWNED; i++) {
			// Only draw oysters if they are alive.
			if (collectedOyster.get(i).equals(false)) {
				batch.draw(
						imageLoader.chestClosed, 
						(float) oysterX[i], 
						(float) oysterY[i],
						(float) oysterSize[i], 
						(float) -oysterSize[i]
						);
			}
		}

		// Draw player.
		batch.draw(
				imageLoader.dustParticleOne, 
				playerX, 
				playerY,
				playerSize, 
				-playerSize
				);

		/**
		 * Alert player how many oysters to collect.  
		 * This message appears for a few seconds at the start of the phase.
		 */
		renderCollectOysterMessage(batch, imageLoader, myGame);

		if (missionComplete) {
			//renderMissionCompleteMessage(batch, imageLoader, myGame);
		}
	}

	/**
	 * Alerts player how many oysters to collect.  
	 * This message appears for a few seconds at the start of the phase.
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 * @param MyGame      myGame
	 */
	protected void renderCollectOysterMessage(SpriteBatch batch, ImageLoader imageLoader, MyGame myGame) {
		int missionCompleteSize = 10;
		int half                = 2;
		GameObject player       = PlayerController.getCurrentPlayer(myGame);
		if (collectOysterMessageTimer < 50) {
			batch.draw(
					imageLoader.missionComplete, 
					player.getX() - GameScreen.cameraWidth / half, 
					player.getY() + GameScreen.cameraWidth / half, 
					missionCompleteSize, 
					-missionCompleteSize
					);
		}
	}
}
