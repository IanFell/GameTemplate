package gameobjects.weapons;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import controllers.PlayerController;
import gameobjects.gamecharacters.Player;
import gameobjects.gamecharacters.PlayerOne;
import handlers.CollisionHandler;
import inventory.Inventory;
import loaders.ImageLoader;
import maps.MapHandler;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class LegendSword extends Weapon {

	// This variable is basically so it's easier to see which color sword is being created. 
	private int color;

	private int rotationAngle;
	public static boolean playSound;
	private TextureRegion textureRegionFull;
	private TextureRegion textureRegionHalf;

	/**
	 * Constructor.
	 * 
	 * @param int           x
	 * @param int           y
	 * @param TextureRegion textureRegionFull
	 * @param TextureRegion textureReguionHalf
	 */
	public LegendSword(int x, int y, int color, TextureRegion textureRegionFull, TextureRegion textureRegionHalf) {
		super(x, y);
		this.width                = 1;
		this.height               = 1;
		this.rectangle.width      = width;
		this.rectangle.height     = height;
		hasBeenCollected          = false;
		this.color                = color;
		this.rotationAngle        = 0;
		playSound                 = false;
		this.textureRegionFull    = textureRegionFull;
		this.textureRegionHalf    = textureRegionHalf;
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shaperender
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		if (hasBeenCollected || Inventory.allInventoryShouldBeRendered) {
			batch.draw(
					textureRegionFull, 
					x, 
					y, 
					width / 2, 
					height / 2, 
					width, 
					-height, 
					1, 
					1, 
					rotationAngle
					); 
		} else {
			batch.draw(
					textureRegionHalf, 
					x, 
					y, 
					width / 2, 
					height / 2, 
					width, 
					-height, 
					1, 
					1, 
					rotationAngle
					); 
			int plantSize = 1;
			batch.draw(imageLoader.plant, x, y + 0.5f, plantSize, -plantSize);
		}
		//renderHitBox(batch, imageLoader);
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 */
	private void renderHitBox(SpriteBatch batch, ImageLoader imageLoader) {
		batch.draw(
				imageLoader.whiteSquare, 
				rectangle.x, 
				rectangle.y, 
				rectangle.width, 
				rectangle.height
				);
	}

	/**
	 * 
	 * @param MyGame     myGamet
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		super.updateObject(myGame, mapHandler);

		if (!hasBeenCollected) {
			this.rectangle.x = x;
			this.rectangle.y = y - height;
			CollisionHandler.checkIfPlayerHasCollidedWithLegendSword(
					PlayerController.getCurrentPlayer(myGame),
					this
					);
		} else {
			height = 2;
			setRotationAngleDependingOnPlayerDirection();
			updateHitBox();

			if (myGame.gameScreen.enemySpawnerMexicoBeach.enemies != null) {
				for (int i = 0; i < myGame.gameScreen.enemySpawnerMexicoBeach.enemies.size(); i++) {
					CollisionHandler.checkIfWeaponHasCollidedWithEnemy(myGame.gameScreen.enemySpawnerMexicoBeach.enemies.get(i), this);
				}
			}
			if (myGame.gameScreen.enemySpawnerPortStJoe.enemies != null) {
				for (int i = 0; i < myGame.gameScreen.enemySpawnerPortStJoe.enemies.size(); i++) {
					CollisionHandler.checkIfWeaponHasCollidedWithEnemy(myGame.gameScreen.enemySpawnerPortStJoe.enemies.get(i), this);
				}
			}
			if (myGame.gameScreen.enemySpawnerThePoint.enemies != null) {
				for (int i = 0; i < myGame.gameScreen.enemySpawnerThePoint.enemies.size(); i++) {
					CollisionHandler.checkIfWeaponHasCollidedWithEnemy(myGame.gameScreen.enemySpawnerThePoint.enemies.get(i), this);
				}
			}
			if (myGame.gameScreen.enemySpawnerWewa.enemies != null) {
				for (int i = 0; i < myGame.gameScreen.enemySpawnerWewa.enemies.size(); i++) {
					CollisionHandler.checkIfWeaponHasCollidedWithEnemy(myGame.gameScreen.enemySpawnerWewa.enemies.get(i), this);
				}
			}
			if (myGame.gameScreen.enemySpawnerApalachicola.enemies != null) {
				for (int i = 0; i < myGame.gameScreen.enemySpawnerApalachicola.enemies.size(); i++) {
					CollisionHandler.checkIfWeaponHasCollidedWithEnemy(myGame.gameScreen.enemySpawnerApalachicola.enemies.get(i), this);
				}
			}
			if (myGame.gameScreen.enemySpawnerStGeorge.enemies != null) {
				for (int i = 0; i < myGame.gameScreen.enemySpawnerStGeorge.enemies.size(); i++) {
					CollisionHandler.checkIfWeaponHasCollidedWithEnemy(myGame.gameScreen.enemySpawnerStGeorge.enemies.get(i), this);
				}
			}
			if (myGame.gameScreen.enemySpawnerCapeSanBlas.enemies != null) {
				for (int i = 0; i < myGame.gameScreen.enemySpawnerCapeSanBlas.enemies.size(); i++) {
					CollisionHandler.checkIfWeaponHasCollidedWithEnemy(myGame.gameScreen.enemySpawnerCapeSanBlas.enemies.get(i), this);
				}
			}
		}
	}

	private void setRotationAngleDependingOnPlayerDirection() {
		switch (PlayerOne.playerDirections.get(PlayerOne.playerDirections.size() - 1)) {
		case Player.DIRECTION_RIGHT:
			setRotationAngle(-90);
			break;
		case Player.DIRECTION_LEFT:
			setRotationAngle(90);
			break;
		case Player.DIRECTION_DOWN:
			setRotationAngle(0);
			break;
		case Player.DIRECTION_UP:
			setRotationAngle(180);
			break;
		}
	}

	/**
	 * Change hit box x, y, width, and height to match the shape of rotated object.
	 */
	private void updateHitBox() {
		float offsetValue = 0.5f;
		switch (PlayerOne.playerDirections.get(PlayerOne.playerDirections.size() - 1)) {
		case Player.DIRECTION_RIGHT:
			this.rectangle.x      = x - height - offsetValue;
			this.rectangle.y      = y + offsetValue + 0.2f;
			this.rectangle.width  = height;
			this.rectangle.height = width / 2;
			break;
		case Player.DIRECTION_LEFT:
			this.rectangle.x      = x + height - offsetValue;
			this.rectangle.y      = y + offsetValue + 0.2f;
			this.rectangle.width  = height;
			this.rectangle.height = width / 2;
			break;
		case Player.DIRECTION_DOWN:
			this.rectangle.x      = x + 0.2f;
			this.rectangle.y      = y - height;
			this.rectangle.width  = width / 2;
			this.rectangle.height = height;
			break;
		case Player.DIRECTION_UP:
			this.rectangle.x      = x + 0.2f;
			this.rectangle.y      = y + height;
			this.rectangle.width  = width / 2;
			this.rectangle.height = height;
			break;
		}
	}

	/**
	 * 
	 * @param int rotationAngle
	 */
	public void setRotationAngle(int rotationAngle) {
		this.rotationAngle = rotationAngle;
	}
}