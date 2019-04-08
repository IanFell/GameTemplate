package gameobjects.weapons;

import gameobjects.GameObject;
import physics.CollisionHandler;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Weapon extends GameObject {

	public static final int DAMAGE_INFLICTED_BULLET       = 10;
	public static final int DAMAGE_INFLICTED_LEGEND_SWORD = 5;

	protected int damageInflicted;

	/**
	 * Constructor.
	 * 
	 * @param float x
	 * @param float y
	 */
	public Weapon(float x, float y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * 
	 * @param GameObject[] objects
	 * @param Weapon       weapon
	 */
	protected void checkIfWeaponHasCollidedWithObject(GameObject[] objects, Weapon weapon) {
		for (int i = 0; i < objects.length; i++) {
			CollisionHandler.checkIfWeaponHasCollidedWithObject(
					objects[i],
					weapon
					);
		}
	}
}
