package handlers;

import com.mygdx.mygame.MyGame;

import gameobjects.stationarygameobjects.buildings.GruntHut;
import gameobjects.weapons.LegendSword;
import gameobjects.weapons.Weapon;
import helpers.GameAttributeHelper;
import loaders.GameObjectLoader;
import loaders.ImageLoader;
import maps.MapHandler;
import physics.Lighting.Fire;
import spawners.GruntSpawner;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class GruntHandler {

	public GruntSpawner[] gruntSpawner = new GruntSpawner[6];

	// Use grunt huts to mask enemy spawning.
	public static GruntHut[] gruntHut = new GruntHut[6];

	private Fire[] fire = new Fire[6];

	/**
	 * 
	 * @param ImageLoader imageLoader
	 */
	public void init(ImageLoader imageLoader) {
		float yOffset = 3.5f;
		gruntSpawner[0] = new GruntSpawner(
				GameAttributeHelper.CHUNK_FIVE_X_POSITION_START + 48, 
				GameAttributeHelper.CHUNK_ONE_Y_POSITION_START + 24.5f - yOffset, 
				null
				);
		gruntSpawner[1] = new GruntSpawner(
				GameAttributeHelper.CHUNK_THREE_X_POSITION_START + 45, 
				GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START + 35 - yOffset, 
				null
				);
		gruntSpawner[2] = new GruntSpawner(
				GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START + 3, 
				GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START - 10 - yOffset, 
				null
				);
		gruntSpawner[3] = new GruntSpawner(
				GameAttributeHelper.CHUNK_SIX_X_POSITION_START, 
				GameAttributeHelper.CHUNK_SIX_Y_POSITION_START - 10 - yOffset, 
				null
				);
		gruntSpawner[4] = new GruntSpawner(
				GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START + 6, 
				GameAttributeHelper.CHUNK_EIGHT_Y_POSITION_START - 1 - yOffset, 
				null
				);
		gruntSpawner[5] = new GruntSpawner(
				GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 60, 
				20 - yOffset, 
				null
				);

		for (int i = 0; i < gruntHut.length; i++) {
			gruntHut[i] = new GruntHut(0, 0, 8, 8, imageLoader.gruntHut);
			fire[i] = new Fire(0, 0, 1.0f, 2.0f, null, true);

			GameObjectLoader.gameObjectList.add(gruntHut[i]);
			GameObjectLoader.gameObjectList.add(fire[i]);
		}

		int xOffset = 3;
		yOffset     = 1;
		gruntHut[0].setX(GameAttributeHelper.CHUNK_FIVE_X_POSITION_START + 47 - xOffset);
		gruntHut[0].setY(GameAttributeHelper.CHUNK_ONE_Y_POSITION_START + 25 + yOffset);
		gruntHut[1].setX(GameAttributeHelper.CHUNK_THREE_X_POSITION_START + 42.5f - xOffset);
		gruntHut[1].setY(GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START + 37 + yOffset);
		gruntHut[2].setX(GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START + 3 - xOffset);
		gruntHut[2].setY(GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START - 10 + yOffset);
		gruntHut[3].setX(GameAttributeHelper.CHUNK_SIX_X_POSITION_START - xOffset);
		gruntHut[3].setY(GameAttributeHelper.CHUNK_SIX_Y_POSITION_START - 10 + yOffset);
		gruntHut[4].setX(GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START + 6 - xOffset);
		gruntHut[4].setY(GameAttributeHelper.CHUNK_EIGHT_Y_POSITION_START - 1 + yOffset);
		gruntHut[5].setX(GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 60 - xOffset);
		gruntHut[5].setY(20 + yOffset);

		for (int i = 0; i < fire.length; i++) {
			fire[i].setX(gruntHut[i].getX() + 3.5f);
			fire[i].setY(gruntHut[i].getY() - 2.0f);
		}
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	public void updateGrunts(MyGame myGame, MapHandler mapHandler) {
		for (int i = 0; i < gruntSpawner.length; i++) {
			gruntSpawner[i].updateGrunts(myGame, mapHandler);
			gruntHut[i].updateObject(myGame, mapHandler);
			fire[i].updateObject(myGame, mapHandler);
		}
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param LegenSword legendSword
	 */
	public void checkWeaponCollision(MyGame myGame, LegendSword legendSword) {
		for (int i = 0; i < gruntSpawner.length; i++) {
			if (gruntSpawner[i].grunts != null) {
				for (int k = 0; k < gruntSpawner[i].grunts.size(); k++) {
					CollisionHandler.checkIfWeaponHasCollidedWithEnemy(gruntSpawner[i].grunts.get(k), legendSword);
				}
			}
		}
	}

	/**
	 * 
	 * @param MyGame myGame
	 * @param Weapon weapon
	 */
	public void checkProjectileCollision(MyGame myGame, Weapon weapon) {
		for (int i = 0; i < gruntSpawner.length; i++) {
			if (gruntSpawner[i].grunts != null) {
				for (int k = 0; k < gruntSpawner[i].grunts.size(); k++) {
					CollisionHandler.checkIfProjectileHasCollidedWithEnemy(gruntSpawner[i].grunts.get(k), weapon);
				}
			}
		}
	}
}
