package missions;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import gameobjects.LegendSword;
import loaders.ImageLoader;
import maps.MapHandler;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class MissionLegendOfTheSevenSwords {

	private final int AMOUNT_OF_SWORDS_NEEDED_TO_COMPLETE_MISSION = 7; 

	public static final int SWORD_RED    = 0;
	public static final int SWORD_BLUE   = 1;
	public static final int SWORD_GREEN  = 2;
	public static final int SWORD_YELLOW = 3;
	public static final int SWORD_PURPLE = 4;
	public static final int SWORD_ORANGE = 5;
	public static final int SWORD_PINK   = 6;

	public static int swordsCollected;

	private GameObject[] legendSwords = new LegendSword[7];

	/**
	 * Collection of swords player currently obtains.
	 */
	public static ArrayList<GameObject> legendSwordCollection = new ArrayList<GameObject>(); 

	/**
	 * Constructor.
	 */
	public MissionLegendOfTheSevenSwords() {
		swordsCollected            = 0;
		legendSwords[SWORD_RED]    = new LegendSword(0, 0);
		legendSwords[SWORD_BLUE]   = new LegendSword(10, 0);
		legendSwords[SWORD_GREEN]  = new LegendSword(20, 0);
		legendSwords[SWORD_YELLOW] = new LegendSword(30, 0);
		legendSwords[SWORD_PURPLE] = new LegendSword(40, 0);
		legendSwords[SWORD_ORANGE] = new LegendSword(50, 0);
		legendSwords[SWORD_PINK]   = new LegendSword(60, 0);
		legendSwordCollection.clear();
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shapeRenderer
	 * @param ImageLoader   imageLoader
	 */
	public void renderMission(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		for (int i = 0 ; i < AMOUNT_OF_SWORDS_NEEDED_TO_COMPLETE_MISSION; i++) {
			if (!legendSwords[i].hasBeenCollected) {
				legendSwords[i].renderObject(batch, shapeRenderer, imageLoader);
			}
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
			if (!legendSwords[i].hasBeenCollected) {
				legendSwords[i].updateObject(myGame, mapHandler);
			} 
		}
		if (swordsCollected == AMOUNT_OF_SWORDS_NEEDED_TO_COMPLETE_MISSION) {
			System.out.println("Player has completed Legend of the Seven Swords Mission!");
		}
	}
}
