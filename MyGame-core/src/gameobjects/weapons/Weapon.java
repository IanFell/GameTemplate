package gameobjects.weapons;

import gameobjects.GameObject;
import gameobjects.gamecharacters.Enemy;
import physics.CollisionHandler;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Weapon extends GameObject {

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
	 * @param GameObject   object
	 * @param Weapon       weapon
	 */
	protected void checkIfWeaponHasCollidedWithEnemy(Enemy enemy, Weapon weapon) {
		CollisionHandler.checkIfWeaponHasCollidedWithEnemy(
				enemy,
				weapon
				);
	}
}
