package tests;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Plane;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.Ray;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import maps.MapEditor;
import physics.CollisionHandler;
import screens.Screens;

/**
 * Tests collisions between game objects.
 * 
 * @author Fabulous Fellini
 *
 */
public class CollisionTests {
	
	/**
	 * These variables are needed for methods associated with all tile collision tests.
	 */
	private final static Plane xzPlane        = new Plane(new Vector3(0, 1, 0), 0);
	private final static Vector3 intersection = new Vector3();
	private static Sprite lastSelectedTile    = null;

	/**
	 * Tests collision with player and enemy.
	 * 
	 * @param GameObject player
	 * @param GameObject enemy
	 * @param MyGame     myGame
	 */
	public static void performPlayerAndEnemyCollisionTest(GameObject player, GameObject enemy, MyGame myGame) {
		
		// Move enemy x, y position to match player.
		int speed = -2;
		if (enemy.getX() > player.getX()) {
			enemy.translateX(speed);
		}
		if (enemy.getY() > player.getY()) {
			enemy.translateY(speed);
		}
		
		// Here we handle collisions.
		if (CollisionHandler.twoGameObjectsHaveCollided(myGame.gameObjectLoader.player, myGame.gameObjectLoader.enemy)) {
			System.out.println("Player and enemy have collided!");
		}
		
		// Print out important coordinates in console.
		System.out.println("Player X position: " + myGame.gameObjectLoader.player.getX());
		System.out.println("Player Circle X position: " + myGame.gameObjectLoader.player.getCircle().x);
		System.out.println("Enemy X position: " + myGame.gameObjectLoader.enemy.getX());
		System.out.println("Enemy Circle X position: " + myGame.gameObjectLoader.enemy.getCircle().x);
	}
	
	/**
	 * Checks to see if a tile has been clicked on by mouse.
	 * 
	 * @param MyGame    myGame
	 * @param MapEditor mapEditor
	 */
	public static void checkTileTouchedWithMouse(MyGame myGame, MapEditor mapEditor) {
		if(Gdx.input.justTouched()) {
			Ray pickRay = Screens.camera.getPickRay(Gdx.input.getX(), Gdx.input.getY());
			Intersector.intersectRayPlane(pickRay, xzPlane, intersection);
			int x = (int)intersection.x;
			int z = (int)intersection.z;
			if(x >= 0 && x < mapEditor.map.length && z >= 0 && z < mapEditor.map.length) {
				if(lastSelectedTile != null) lastSelectedTile.setColor(1, 1, 1, 1);
				Sprite sprite = mapEditor.tiles[x][z];
				sprite.setColor(1, 0, 0, 1);
				lastSelectedTile = sprite;
				System.out.println("Tile has been clicked!");
			}
		}
	}
	
	/**
	 * Checks to see if a tile has touched by player.
	 * 
	 * @param MyGame    myGame
	 * @param MapEditor mapEditor
	 */
	public static void checkTileTouchedByPlayer(MyGame myGame, MapEditor mapEditor) {
		Ray pickRay = Screens.camera.getPickRay(myGame.gameObjectLoader.player.getX(), myGame.gameObjectLoader.player.getY());
		Intersector.intersectRayPlane(pickRay, xzPlane, intersection);
		int x = (int)intersection.x;
		int z = -(int)intersection.z;
		if(x >= 0 && x < mapEditor.map.length && z >= 0 && z < mapEditor.map.length) {
			if(lastSelectedTile != null) lastSelectedTile.setColor(1, 1, 1, 1);
			Sprite sprite = mapEditor.tiles[x][z];
			sprite.setColor(1, 0, 0, 1);
			lastSelectedTile = sprite;
			System.out.println("Tile has been touched by player!");
		}
	}

	/**
	 * Checks if player has collided with a solid tile.
	 * 
	 * @param MyGame    myGame
	 * @param MapEditor mapEditor
	 * @param int       direction
	 * @return boolean
	 */
	public static boolean checkIfPlayerHasTouchedSolidTile(MyGame myGame, MapEditor mapEditor, int direction) {
		Ray pickRay = Screens.camera.getPickRay(myGame.gameObjectLoader.player.getX(), myGame.gameObjectLoader.player.getY());
		Intersector.intersectRayPlane(pickRay, xzPlane, intersection);
		int x = (int)intersection.x;
		int z = -(int)intersection.z;
		if(x >= 0 && x < mapEditor.map.length && z >= 0 && z < mapEditor.map.length) {
			if (mapEditor.tiles[x][z].isSolid()) {
				if(lastSelectedTile != null) lastSelectedTile.setColor(1, 1, 1, 1);
				Sprite sprite = mapEditor.tiles[x][z];
				sprite.setColor(1, 0, 0, 1);
				lastSelectedTile = sprite;
				Screens.stopScrolling(direction);
				System.out.println("Player is touching a solid tile!  Camera should be stopped now!");
			}
		}
		return false;
	}
}
