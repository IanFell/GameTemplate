package missions;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.mygame.MyGame;

import controllers.PlayerController;
import gameobjects.GameObject;
import gameobjects.gamecharacters.Player;
import gameobjects.weapons.LegendSword;
import helpers.GameAttributeHelper;
import inventory.Inventory;
import loaders.ImageLoader;
import maps.MapHandler;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class MissionLegendOfTheSevenSwords extends Mission {

	private final int AMOUNT_OF_SWORDS_NEEDED_TO_COMPLETE_MISSION = 7;

	public static final int SWORD_RED = 0;
	public static final int SWORD_BLUE = 1;
	public static final int SWORD_GREEN = 2;
	public static final int SWORD_YELLOW = 3;
	public static final int SWORD_PURPLE = 4;
	public static final int SWORD_ORANGE = 5;
	public static final int SWORD_PINK = 6;
	public static final int SWORD_RAINBOW = 7;

	public static int swordsCollected;

	private GameObject[] legendSwords = new LegendSword[7];

	/**
	 * Collection of swords player currently obtains.
	 */
	public static ArrayList<GameObject> legendSwordCollection = new ArrayList<GameObject>();

	/**
	 * Constructor.
	 * 
	 * @param MyGame
	 *            myGame
	 */
	public MissionLegendOfTheSevenSwords(MyGame myGame) {
		super();
		missionBeginTextTimer = 0;
		swordsCollected = 0;
		legendSwords[SWORD_RED] = new LegendSword(GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 40,
				GameAttributeHelper.CHUNK_ONE_Y_POSITION_START + 5, SWORD_RED,
				new TextureRegion(myGame.imageLoader.legendSwordRed),
				new TextureRegion(myGame.imageLoader.legendSwordRedHalf));
		legendSwords[SWORD_BLUE] = new LegendSword(GameAttributeHelper.CHUNK_FIVE_X_POSITION_START + 40,
				GameAttributeHelper.CHUNK_ONE_Y_POSITION_START + 35, SWORD_BLUE,
				new TextureRegion(myGame.imageLoader.legendSwordBlue),
				new TextureRegion(myGame.imageLoader.legendSwordBlueHalf));
		legendSwords[SWORD_GREEN] = new LegendSword(GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 10,
				GameAttributeHelper.CHUNK_TWO_Y_POSITION_START + 40, SWORD_GREEN,
				new TextureRegion(myGame.imageLoader.legendSwordGreen),
				new TextureRegion(myGame.imageLoader.legendSwordGreenHalf));
		legendSwords[SWORD_YELLOW] = new LegendSword(GameAttributeHelper.CHUNK_SIX_X_POSITION_START + 5,
				GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START + 4, SWORD_YELLOW,
				new TextureRegion(myGame.imageLoader.legendSwordYellow),
				new TextureRegion(myGame.imageLoader.legendSwordYellowHalf));
		legendSwords[SWORD_PURPLE] = new LegendSword(GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 5,
				GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START + 4, SWORD_PURPLE,
				new TextureRegion(myGame.imageLoader.legendSwordPurple),
				new TextureRegion(myGame.imageLoader.legendSwordPurpleHalf));
		legendSwords[SWORD_ORANGE] = new LegendSword(GameAttributeHelper.CHUNK_FIVE_X_POSITION_START + 25,
				GameAttributeHelper.CHUNK_SIX_Y_POSITION_START + 3, SWORD_ORANGE,
				new TextureRegion(myGame.imageLoader.legendSwordOrange),
				new TextureRegion(myGame.imageLoader.legendSwordOrangeHalf));
		legendSwords[SWORD_PINK] = new LegendSword(GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START + 15,
				GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START + 45, SWORD_PINK,
				new TextureRegion(myGame.imageLoader.legendSwordPink),
				new TextureRegion(myGame.imageLoader.legendSwordPinkHalf));
		legendSwordCollection.clear();
	}

	/**
	 * 
	 * @param SpriteBatch
	 *            batch
	 * @param ImageLoader
	 *            imageLoader
	 * @param MyGame
	 *            myGame
	 */
	@Override
	public void renderMission(SpriteBatch batch, ImageLoader imageLoader, MyGame myGame) {
		for (int i = 0; i < AMOUNT_OF_SWORDS_NEEDED_TO_COMPLETE_MISSION; i++) {
			if (!legendSwords[i].hasBeenCollected) {
				legendSwords[i].renderObject(batch, imageLoader);
			}
		}

		// If mission is complete, render "Mission Complete" message for a
		// little while.
		if (missionComplete) {
			/**
			 * This variable needs to be changed because as of now, it's a static global.
			 * Which means this message will render anytime missionComplete is true.
			 * We can't have that.
			 */
			//renderMissionMessage(batch, myGame, imageLoader.missionComplete);
		}

		// Remove this for now.
		//renderMissionStartMessage(batch, myGame, imageLoader.legendOfTheSevenSwordsBeginMissionText);
	}

	/**
	 * 
	 * @param MyGame
	 *            myGame
	 * @param MapHandler
	 *            mapHandler
	 */
	@Override
	public void updateMission(MyGame myGame, MapHandler mapHandler) {
		super.updateMission(myGame, mapHandler);
		//System.out.println("Legend Of The Seven Swords:  Number of Swords Collected: " + swordsCollected);
		//System.out.println("Legend Of The Seven Swords:  Which Swords Collected: " + legendSwordCollection);
		for (int i = 0; i < AMOUNT_OF_SWORDS_NEEDED_TO_COMPLETE_MISSION; i++) {
			legendSwords[i].updateObject(myGame, mapHandler);
			if (Inventory.allInventoryShouldBeRendered) {
				((LegendSword) legendSwords[i]).setRotationAngle(0);
			}
		}
		if (swordsCollected == AMOUNT_OF_SWORDS_NEEDED_TO_COMPLETE_MISSION) {
			//System.out.println("Player has completed Legend of the Seven Swords Mission!");
			missionComplete = true;
			// clearSevenSwordsFromInventory(myGame);
		}
	}

	/**
	 * 
	 * @param MyGame
	 *            myGame
	 */
	private void clearSevenSwordsFromInventory(MyGame myGame) {
		Player player = (Player) PlayerController.getCurrentPlayer(myGame);
		for (int i = 0; i < player.getInventory().inventory.size(); i++) {
			if (player.getInventory().inventory.get(i) instanceof LegendSword) {
				player.getInventory().inventory.remove(i);
			}
		}
	}
}
