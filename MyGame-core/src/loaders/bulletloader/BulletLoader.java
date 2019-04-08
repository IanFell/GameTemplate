package loaders.bulletloader;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import controllers.PlayerController;
import gameobjects.gamecharacters.Player;
import gameobjects.weapons.Bullet;
import loaders.ImageLoader;
import maps.MapHandler;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class BulletLoader {

	private static ArrayList <Bullet> bullets = new ArrayList<Bullet>();

	// Used to kill bullet once off screen.
	private static int timer;

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	public static void updateBullets(MyGame myGame, MapHandler mapHandler) {
		if (bullets.size() > 0) {
			for (int i = 0; i < bullets.size(); i++) {
				bullets.get(i).updateObject(myGame, mapHandler);
				if (timer > 5) {
					bullets.remove(i);
				}
			}
		}
		timer++;
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shapeRenderer
	 * @param ImageLoader   imageLoader
	 */
	public static void renderBullets(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		if (bullets.size() > 0) {
			for (int i = 0; i < bullets.size(); i++) {
				bullets.get(i).renderObject(batch, shapeRenderer, imageLoader);
			}
		}
	}

	/**
	 * 
	 * @param MyGame myGame
	 */
	public static void createBullet(MyGame myGame) {
		// Only create new bullet if previous bullet is dead.  This is to prevent infinite bullets.
		if (bullets.size() < 1) {
			float yPosition = PlayerController.getCurrentPlayer(myGame).getY();
			// Do this so bullet doesn't spawn behind player's head.
			if (Player.direction == Player.DIRECTION_UP) {
				yPosition = PlayerController.getCurrentPlayer(myGame).getY() - 1;
			}
			bullets.add(new Bullet(
					PlayerController.getCurrentPlayer(myGame).getX(),
					yPosition
					));
			timer = 0;
		}
	}
}
