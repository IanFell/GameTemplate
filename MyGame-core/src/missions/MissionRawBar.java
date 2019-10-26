package missions;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.mygame.MyGame;

import controllers.PlayerController;
import gameobjects.GameObject;
import gameobjects.gamecharacters.Player;
import helpers.GameAttributeHelper;
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
	public static final float MAX_MISSION_TIME_PHASE_TWO   = 15f;
	public static final float MAX_MISSION_TIME_PHASE_THREE = 15f;

	private final int MAX_OYSTERS_SPAWNED                        = 100;
	public static final int NUMBER_OF_OYSTERS_NEEDED_PHASE_ONE   = 20;
	public static final int NUMBER_OF_OYSTERS_NEEDED_PHASE_TWO   = 15;
	public static final int NUMBER_OF_OYSTERS_NEEDED_PHASE_THREE = 10;
	// This will be assigned to one of the above values.
	private int numberOfOystersNeededToWin;

	// Represents if PHASES are active, not necessarily entire mission.
	public static boolean phaseIsActive = true;
	
	// Represents ENTIRE mission, not just phases.
	public static boolean missionIsActive = false;

	private boolean initializeMission = true;

	// Each instance of this class in MissionHandler has their own phaseComplete.
	private boolean phaseComplete = false;

	public static boolean phasesAreInProgress = false;

	// Player has to collide with this locator to begin phases.
	private Rectangle startPhasesLocator;

	/**
	 * Timer to display to user how many oysters to collect.  
	 * This message only appears for a few seconds at the start of the phase.
	 */
	private int collectOysterMessageTimer = 0;
	
	private int locationFlashTimer = 0;

	// Oysters will have a random x, y, and size.
	private double[] oysterX                   = new double[MAX_OYSTERS_SPAWNED];
	private double[] oysterY                   = new double[MAX_OYSTERS_SPAWNED];
	private double[] oysterSize                = new double[MAX_OYSTERS_SPAWNED];
	private int oystersCollected               = 0;
	private ArrayList<Boolean> collectedOyster = new ArrayList<Boolean>();

	public static float playerX;
	public static float playerY;
	private float playerSize = 1;

	// Hitboxes for collision detection.
	private Rectangle[] oysterBounds = new Rectangle[MAX_OYSTERS_SPAWNED];
	private Rectangle playerBounds   = new Rectangle(0, 0, 0, 0);

	// Used for countdown timer.
	private float timeSeconds = 0f;
	private float phaseTimeLimit;

	private static final int INTRO_TIME_LIMIT = 100;
	private static int introTimer             = 0;
	private static boolean introHasCompleted  = false;
	
	public static boolean rawBarMissionComplete = false;
	
	private Rectangle[] fish = new Rectangle[5];
	
	private float fishOneDx;
	private float fishTwoDy;
	private float fishThreeDx;
	private float fishFourDx;
	private float fishFourDy;
	private float fishFiveDy;
	
	public static boolean playCollectionSound = false;

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
		int startPhaseLocatorSize = 1;
		startPhasesLocator = new Rectangle(
				GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 40, 
				GameAttributeHelper.CHUNK_SIX_Y_POSITION_START + 45, 
				startPhaseLocatorSize, 
				startPhaseLocatorSize
				);
		playerX = startPhasesLocator.x;
		playerY = startPhasesLocator.y;
		
		int startX = GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 25;
		int startY = GameAttributeHelper.CHUNK_SIX_Y_POSITION_START + 43;
		fish[0] = new Rectangle(startX, startY, 3, 3);
		fish[1] = new Rectangle(startX + 7, startY, 3, 3);
		fish[2] = new Rectangle(startX + 3, startY + 5, 3, 3);
		fish[3] = new Rectangle(startX + 2, startY, 3, 3);
		fish[4] = new Rectangle(startX + 15, startY + 5, 3, 3);
	}

	/**
	 * 
	 * @param MyGame myGame
	 */
	private void initializeMission(MyGame myGame) {
		int cameraOffset = 10;
		for (int i = 0 ; i < MAX_OYSTERS_SPAWNED; i++) {
			oysterX[i]             = RandomNumberGenerator.generateRandomDouble(
					GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 40 - cameraOffset, 
					GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 40 + cameraOffset
					);
			oysterY[i]             = RandomNumberGenerator.generateRandomDouble(
					GameAttributeHelper.CHUNK_SIX_Y_POSITION_START + 45 - cameraOffset, 
					GameAttributeHelper.CHUNK_SIX_Y_POSITION_START + 45 + cameraOffset
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
		
		// Set actual player to begin mission directly outside the Raw Bar's door.
		myGame.getGameObject(Player.PLAYER_ONE).setX(GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 37);
		myGame.getGameObject(Player.PLAYER_ONE).setY(GameAttributeHelper.CHUNK_SIX_Y_POSITION_START + 38);
		
		fishOneDx   = 1;
		fishTwoDy   = 1;
		fishThreeDx = 1;
		fishFourDx  = 1;
		fishFourDy  = 1;
		fishFiveDy  = 1;
	}

	/**
	 * 
	 * @param MyGame myGame
	 */
	public void updateMission(MyGame myGame) {
		if (initializeMission) {
			initializeMission(myGame);
			initializeMission = false;
		}

		if (MissionRawBar.phasesAreInProgress) {
			updatePhases(myGame);
		} else {
			// Execute this before player begins phases.
			// First, handle the intro.
			introTimer++;
			if (introTimer > INTRO_TIME_LIMIT) {
				introHasCompleted = true;
			}

			// Next, handle interaction between player and phases locator.
			if (introHasCompleted) {
				locationFlashTimer++;
				if (myGame.getGameObject(Player.PLAYER_ONE).rectangle.overlaps(startPhasesLocator) && !rawBarMissionComplete) {
					phasesAreInProgress = true;
				}
			}
		}
	}
	
	private void updateFishPositions() {
		fish[0].setX(fish[0].getX() + fishOneDx);
		if (fish[0].getX() > playerX + 3) {
			fishOneDx = -0.5f;
		} 
		if (fish[0].getX() < playerX - 3) {
			fishOneDx = 0.5f;
		}
		
		fish[1].setY(fish[1].getY() + fishTwoDy);
		if (fish[1].getY() > playerY + 3) {
			fishTwoDy = -0.5f;
		} 
		if (fish[1].getY() < playerY - 3) {
			fishTwoDy = 0.5f;
		}
		
		fish[2].setX(fish[2].getX() + fishThreeDx);
		if (fish[2].getX() > playerX + 1) {
			fishThreeDx = -0.5f;
		} 
		if (fish[2].getX() < playerX - 6) {
			fishThreeDx = 0.5f;
		}
		
		fish[3].setX(fish[3].getX() + fishFourDx);
		fish[3].setY(fish[3].getY() + fishFourDy);
		if (fish[3].getX() > playerX + 10) {
			fishFourDx = -0.5f;
			fishFourDy = -0.5f;
		} 
		if (fish[3].getX() < playerX - 10) {
			fishFourDx = 0.5f;
			fishFourDy = 0.5f;
		}
		
		fish[4].setY(fish[4].getY() + fishFiveDy);
		if (fish[4].getY() > playerY + 3) {
			fishFiveDy = -0.5f;
		} 
		if (fish[4].getY() < playerY - 3) {
			fishFiveDy = 0.5f;
		}
	}

	private void updatePhases(MyGame myGame) {
		playerBounds.x = playerX;
		playerBounds.y = playerY;
		
		updateFishPositions();

		for (int i = 0 ; i < MAX_OYSTERS_SPAWNED; i++) {
			if (playerBounds.overlaps(oysterBounds[i]) && collectedOyster.get(i).equals(false)) {
				collectedOyster.set(i, true);
				oystersCollected++;
				playCollectionSound = true;
			}
		}

		handleCountdownTimer();
		checkForMissionComplete();

		System.out.println("Oysters Collected: " + oystersCollected);

		// Only display how many oysters to collect for a few seconds.
		if (collectOysterMessageTimer < 50) {
			collectOysterMessageTimer++;
		}
		
		for (int i = 0; i < fish.length; i++) {
			if (fish[i].overlaps(playerBounds)) {
				myGame.getGameObject(Player.PLAYER_ONE).setHealth(myGame.getGameObject(Player.PLAYER_ONE).getHealth() - 1);
			}
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
	private void renderPhases(SpriteBatch batch, ImageLoader imageLoader, MyGame myGame) {
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
						imageLoader.oyster, 
						(float) oysterX[i], 
						(float) oysterY[i],
						(float) oysterSize[i], 
						(float) -oysterSize[i]
						);
			}
		}
		
		// Draw fish.
		for (int i = 0; i < fish.length; i++) {
			batch.draw(
					imageLoader.chestClosed, 
					fish[i].getX(), 
					fish[i].getY(),
					fish[i].width, 
					-fish[i].height
					);
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
		
		// Draw water.
		batch.draw(
				imageLoader.missionTransparentBlueSquare, 
				GameScreen.camera.position.x - GameScreen.camera.viewportWidth / 2, 
				GameScreen.camera.position.y + GameScreen.camera.viewportHeight / 2,
				GameScreen.camera.viewportWidth, 
				-GameScreen.camera.viewportHeight
				);
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 * @param MyGame      myGame
	 */
	@Override
	public void renderMission(SpriteBatch batch, ImageLoader imageLoader, MyGame myGame) {
		if (MissionRawBar.phasesAreInProgress) {
			renderPhases(batch, imageLoader, myGame);
		} else {
			// Draw intro screen until INTRO_TIME_LIMIT runs out.
			if (!introHasCompleted) {
				batch.draw(
						imageLoader.missionRawBarInside, 
						GameScreen.camera.position.x - GameScreen.camera.viewportWidth / 2, 
						GameScreen.camera.position.y + GameScreen.camera.viewportHeight / 2,
						GameScreen.camera.viewportWidth, 
						-GameScreen.camera.viewportHeight
						);
			} else {
				// Draw locator.
				if (locationFlashTimer % 10 >= 0 && locationFlashTimer % 10 <= 5 && !rawBarMissionComplete) {
					batch.draw(
							imageLoader.locationSkull, 
							startPhasesLocator.x, 
							startPhasesLocator.y,
							startPhasesLocator.width, 
							-startPhasesLocator.height
							);
				}
			}
		}

		if (rawBarMissionComplete) {
			renderMissionCompleteMessage(batch, imageLoader, myGame);
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
		int collectOysterMessageSize = 10;
		int half                     = 2;
		GameObject player            = PlayerController.getCurrentPlayer(myGame);
		if (collectOysterMessageTimer < 50) {
			batch.draw(
					imageLoader.collectOysters, 
					player.getX() - GameScreen.cameraWidth / half, 
					player.getY() + GameScreen.cameraWidth / half, 
					collectOysterMessageSize, 
					-collectOysterMessageSize
					);
		}
	}
}
