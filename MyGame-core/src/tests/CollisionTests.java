package tests;

import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import physics.CollisionHandler;

/**
 * Tests collisions between game objects.
 * 
 * @author Fabulous Fellini
 *
 */
public class CollisionTests {
	
	/**
	 * Generic collision message.
	 */
	private static String collisionMessage = "We have a collision";
	
	/**
	 * Tests collision with player and enemy.
	 * 
	 * @param GameObject player
	 * @param GameObject enemy
	 * @param MyGame     myGame
	 */
	public static void performPlayerAndEnemyCollisionTest(GameObject player, GameObject enemy, MyGame myGame) {
		
		// Move enemy x, y position to match player.
		if (enemy.getX() > player.getX()) {
			enemy.translateX(-2);
		}
		if (enemy.getY() > player.getY()) {
			enemy.translateY(-2);
		}
		
		// Here we handle collisions.
		if (CollisionHandler.twoGameObjectsHaveCollided(myGame.gameObjectLoader.player, myGame.gameObjectLoader.enemy)) {
			System.out.println(collisionMessage);
		}
		
		System.out.println("Player X position: " + myGame.gameObjectLoader.player.getX());
		System.out.println("Player Circle X position: " + myGame.gameObjectLoader.player.getCircle().x);
		System.out.println("Enemy X position: " + myGame.gameObjectLoader.enemy.getX());
		System.out.println("Enemy Circle X position: " + myGame.gameObjectLoader.enemy.getCircle().x);
	}
}
