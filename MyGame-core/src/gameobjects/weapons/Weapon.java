package gameobjects.weapons;

import gameobjects.GameObject;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Weapon extends GameObject {

	public static int WEAPON_TYPE_SWORD = 0;
	public static int WEAPON_TYPE_GUN   = 1;

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
	 * @param Enemy  enemy
	 * @param Weapon weapon
	 */
	/*
	protected void checkIfWeaponHasCollidedWithEnemy(Enemy enemy, Weapon weapon) {
		CollisionHandler.checkIfWeaponHasCollidedWithEnemy(
				enemy,
				weapon
				);
	}*/
}
