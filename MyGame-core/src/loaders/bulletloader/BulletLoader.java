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
			float xPosition = 0;
			float yPosition = 0;
			switch (Player.direction) {
			case Player.DIRECTION_LEFT:
				xPosition = PlayerController.getCurrentPlayer(myGame).getX() - 1.5f;
				yPosition = PlayerController.getCurrentPlayer(myGame).getY() - 0.7f;
				break;
			case Player.DIRECTION_RIGHT:
				xPosition = PlayerController.getCurrentPlayer(myGame).getX() + 1.5f;
				yPosition = PlayerController.getCurrentPlayer(myGame).getY() - 0.7f;
				break;
			case Player.DIRECTION_UP:
				xPosition = PlayerController.getCurrentPlayer(myGame).getX() + 0.5f;
				yPosition = PlayerController.getCurrentPlayer(myGame).getY() - 2.5f;
				break;
			case Player.DIRECTION_DOWN:
				xPosition = PlayerController.getCurrentPlayer(myGame).getX() - 0.2f;
				yPosition = PlayerController.getCurrentPlayer(myGame).getY() + 1;
				break;
			}
			bullets.add(new Bullet(xPosition, yPosition));
			timer = 0;
		}
	}
}
