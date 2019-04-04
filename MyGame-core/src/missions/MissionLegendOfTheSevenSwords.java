package missions;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import controllers.PlayerController;
import gameobjects.GameObject;
import gameobjects.LegendSword;
import gameobjects.gamecharacters.Player;
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

	public static final int SWORD_RED     = 0;
	public static final int SWORD_BLUE    = 1;
	public static final int SWORD_GREEN   = 2;
	public static final int SWORD_YELLOW  = 3;
	public static final int SWORD_PURPLE  = 4;
	public static final int SWORD_ORANGE  = 5;
	public static final int SWORD_PINK    = 6;
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
	 * @param MyGame myGame
	 */
	public MissionLegendOfTheSevenSwords(MyGame myGame) {
		super();
		swordsCollected             = 0;
		legendSwords[SWORD_RED]     = new LegendSword(0, 0, SWORD_RED, new TextureRegion(myGame.imageLoader.legendSwordRed));
		legendSwords[SWORD_BLUE]    = new LegendSword(10, 0, SWORD_BLUE, new TextureRegion(myGame.imageLoader.legendSwordBlue));
		legendSwords[SWORD_GREEN]   = new LegendSword(20, 0, SWORD_GREEN, new TextureRegion(myGame.imageLoader.legendSwordGreen));
		legendSwords[SWORD_YELLOW]  = new LegendSword(30, 0, SWORD_YELLOW, new TextureRegion(myGame.imageLoader.legendSwordYellow));
		legendSwords[SWORD_PURPLE]  = new LegendSword(40, 0, SWORD_PURPLE, new TextureRegion(myGame.imageLoader.legendSwordPurple));
		legendSwords[SWORD_ORANGE]  = new LegendSword(50, 0, SWORD_ORANGE, new TextureRegion(myGame.imageLoader.legendSwordOrange));
		legendSwords[SWORD_PINK]    = new LegendSword(60, 0, SWORD_PINK, new TextureRegion(myGame.imageLoader.legendSwordPink));
		legendSwordCollection.clear();
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shapeRenderer
	 * @param ImageLoader   imageLoader
	 * @param MyGame        myGame
	 */
	@Override
	public void renderMission(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader, MyGame myGame) {
		for (int i = 0 ; i < AMOUNT_OF_SWORDS_NEEDED_TO_COMPLETE_MISSION; i++) {
			if (!legendSwords[i].hasBeenCollected) {
				legendSwords[i].renderObject(batch, shapeRenderer, imageLoader);
			}
		}

		// If mission is complete, render "Mission Complete" message for a little while.
		if (missionComplete) {
			renderMissionCompleteMessage(batch, shapeRenderer, imageLoader, myGame);
		}
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	public void updateMission(MyGame myGame, MapHandler mapHandler) {
		System.out.println("Legend Of The Seven Swords:  Number of Swords Collected: " + swordsCollected);
		System.out.println("Legend Of The Seven Swords:  Which Swords Collected: " + legendSwordCollection);
		for (int i = 0 ; i < AMOUNT_OF_SWORDS_NEEDED_TO_COMPLETE_MISSION; i++) {
			legendSwords[i].updateObject(myGame, mapHandler);
			if (Inventory.allInventoryShouldBeRendered) {
				((LegendSword) legendSwords[i]).setRotationAngle(0);
			}
		}
		if (swordsCollected == AMOUNT_OF_SWORDS_NEEDED_TO_COMPLETE_MISSION) {
			System.out.println("Player has completed Legend of the Seven Swords Mission!");
			missionComplete = true;
			//clearSevenSwordsFromInventory(myGame);
		}
	}

	/**
	 * 
	 * @param MyGame myGame
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
