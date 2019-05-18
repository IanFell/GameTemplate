package inventory;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import gameobjects.gamecharacters.Player;
import gameobjects.gamecharacters.PlayerOne;
import input.computer.Mouse;
import loaders.ImageLoader;
import maps.MapHandler;
import physics.Lighting.Fire;
import screens.GameScreen;
import screens.Screens;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Inventory extends Screens {

	public static boolean mouseIsClickingOnInventoryObject;
	public static Rectangle rectangle;
	public static boolean playClickSound;
	private Fire fire;
	public ArrayList <GameObject> inventory;
	public static boolean inventoryIsEquipped;
	public static boolean allInventoryShouldBeRendered;
	public static int currentlySelectedInventoryObject;

	/**
	 * Constructor.
	 * 
	 * @param MyGame myGame
	 */
	public Inventory(final MyGame myGame) {
		super(myGame);
		inventory                        = new ArrayList<GameObject>();
		inventoryIsEquipped              = false;
		allInventoryShouldBeRendered     = false;
		currentlySelectedInventoryObject = 0;
		rectangle                        = new Rectangle(0, 0, 2, 2);
		mouseIsClickingOnInventoryObject = false;
		fire                             = new Fire(0, 0, 0, 0, "Inventory", false);
		playClickSound                   = false;
		inventory.clear();
	}

	/**
	 * 
	 * @param boolean shouldRenderAllInventory
	 */
	public void setAllInventoryShouldBeRendered(boolean shouldRenderAllInventory) {
		allInventoryShouldBeRendered = shouldRenderAllInventory;
	}

	/**
	 * 
	 * @param GameObject object
	 */
	public void addObjectToInventory(GameObject object) {
		inventory.add(object);
	}

	/**
	 * 
	 * @param float      x
	 * @param float      y
	 * @param MapHandler mapHandler
	 */
	public void updateInventory(float x, float y, MapHandler mapHandler) {
		// Set all inventory to follow player.
		float xPosition = 0;
		float yPosition = 0;
		for (int i = 0; i < inventory.size(); i++) {
			float inventoryHeight = inventory.get(i).getHeight();
			if (Player.playerIsPerformingAttack) {
				if (Player.isInWater) {
					switch (Player.direction) {
					case Player.DIRECTION_RIGHT:
						xPosition = x + 4;
						yPosition = y - 0.5f;
						break;
					case Player.DIRECTION_LEFT:
						xPosition = x - 4.5f;
						yPosition = y - 0.5f;
						break;
					case Player.DIRECTION_DOWN:
						xPosition = x - 0.3f;
						yPosition = y + inventoryHeight + 2;
						break;
					case Player.DIRECTION_UP:
						xPosition = x - 0.3f;
						yPosition = y - inventoryHeight - 3;
						break;
					}
				} else {
					switch (PlayerOne.playerDirections.get(PlayerOne.playerDirections.size() - 1)) {
					case Player.DIRECTION_RIGHT:
						xPosition = x + 4;
						yPosition = y - 1.5f;
						break;
					case Player.DIRECTION_LEFT:
						xPosition = x - 4.5f;
						yPosition = y - 1.5f;
						break;
					case Player.DIRECTION_DOWN:
						xPosition = x - 0.3f;
						yPosition = y + inventoryHeight + 1;
						break;
					case Player.DIRECTION_UP:
						xPosition = x - 0.3f;
						yPosition = y - inventoryHeight - 4;
						break;
					}
				}
			} else {
				if (Player.isInWater) {
					switch (PlayerOne.playerDirections.get(PlayerOne.playerDirections.size() - 1)) {
					case Player.DIRECTION_RIGHT:
						xPosition = x + 3;
						yPosition = y - 0.5f;
						break;
					case Player.DIRECTION_LEFT:
						xPosition = x - 3.5f;
						yPosition = y - 0.5f;
						break;
					case Player.DIRECTION_DOWN:
						xPosition = x - 0.3f;
						yPosition = y + inventoryHeight + 1;
						break;
					case Player.DIRECTION_UP:
						xPosition = x - 0.3f;
						yPosition = y - inventoryHeight - 2;
						break;
					}
				} else {
					switch (PlayerOne.playerDirections.get(PlayerOne.playerDirections.size() - 1)) {
					case Player.DIRECTION_RIGHT:
						xPosition = x + 3;
						yPosition = y - 1.5f;
						break;
					case Player.DIRECTION_LEFT:
						xPosition = x - 3.5f;
						yPosition = y - 1.5f;
						break;
					case Player.DIRECTION_DOWN:
						xPosition = x - 0.3f;
						yPosition = y + inventoryHeight;
						break;
					case Player.DIRECTION_UP:
						xPosition = x - 0.3f;
						yPosition = y - inventoryHeight - 3;
						break;
					}
				}
			}
			inventory.get(i).setX(xPosition);
			inventory.get(i).setY(yPosition);
		}
		fire.updateObject(myGame, mapHandler);
	}

	/**
	 * 
	 * @param boolean isEquipped
	 */
	public void setInventoryIsEquipped(boolean isEquipped) {
		inventoryIsEquipped = isEquipped;
	}

	/**
	 * 
	 * @return boolean
	 */
	public boolean getInventoryIsEquipped() {
		return inventoryIsEquipped;
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shapeRenderer
	 * @param ImageLoader   imageLoader
	 */
	public void renderInventory(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		System.out.println("Inventory size: " + inventory.size());
		System.out.println("Currently Selected Inventory: " + Inventory.currentlySelectedInventoryObject);
		if (inventory.size() > 0) {
			if (inventoryIsEquipped) {
				inventory.get(currentlySelectedInventoryObject).renderObject(batch, shapeRenderer, imageLoader);
			}
		}
		if (allInventoryShouldBeRendered) {
			int borderShrinkOffset = 1;
			batch.draw(
					imageLoader.inventoryScreen,
					camera.position.x - getViewportWidth() / denominatorOffset + borderShrinkOffset,
					(camera.position.y - verticalHeight / denominatorOffset) + camera.viewportHeight,
					camera.viewportWidth - borderShrinkOffset * 2, 
					-camera.viewportHeight
					);
			renderInventoryDisplay(batch, shapeRenderer, imageLoader);

			int clickedObject = 0;
			if (mouseIsClickingOnInventoryObject) {
				for (int i = 0; i < Mouse.inventoryButtonIsPressed.length; i++) {
					if (Mouse.inventoryButtonIsPressed[i]) {
						clickedObject = i;
					}
				}
				// White square that flashes when player clicks on an inventory square.
				drawClickHover(batch, imageLoader, clickedObject);
			}
			fire.setX(rectangle.x);
			fire.setY(rectangle.y);
			fire.setWidth(rectangle.getWidth());
			fire.setHeight(rectangle.getHeight());
			fire.renderObject(batch, shapeRenderer, imageLoader);
		}
	}

	/**
	 * Draws the white square that flashes when player clicks on an inventory square.
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 * @param int         hoverValue
	 */
	private void drawClickHover(SpriteBatch batch, ImageLoader imageLoader, int hoverValue) {
		int borderShrinkOffset = 1;
		switch (hoverValue) {
		case 0:
			rectangle.x = camera.position.x - getViewportWidth() / denominatorOffset + borderShrinkOffset + 0.3f;
			rectangle.y = (camera.position.y - verticalHeight / denominatorOffset) + camera.viewportHeight - 3.4f;
			break;
		case 1:
			rectangle.x = camera.position.x - getViewportWidth() / denominatorOffset + borderShrinkOffset + 0.3f + 2;
			rectangle.y = (camera.position.y - verticalHeight / denominatorOffset) + camera.viewportHeight - 3.4f;
			break;
		case 2:
			rectangle.x = camera.position.x - getViewportWidth() / denominatorOffset + borderShrinkOffset + 0.3f + 3.9f;
			rectangle.y = (camera.position.y - verticalHeight / denominatorOffset) + camera.viewportHeight - 3.4f;
			break;
		case 3:
			rectangle.x = camera.position.x - getViewportWidth() / denominatorOffset + borderShrinkOffset + 0.3f + 5.8f;
			rectangle.y = (camera.position.y - verticalHeight / denominatorOffset) + camera.viewportHeight - 3.4f;
			break;
		case 4:
			rectangle.x = camera.position.x - getViewportWidth() / denominatorOffset + borderShrinkOffset + 0.3f + 7.8f;
			rectangle.y = (camera.position.y - verticalHeight / denominatorOffset) + camera.viewportHeight - 3.4f;
			break;
		case 5:
			rectangle.x = camera.position.x - getViewportWidth() / denominatorOffset + borderShrinkOffset + 0.3f + 9.7f;
			rectangle.y = (camera.position.y - verticalHeight / denominatorOffset) + camera.viewportHeight - 3.4f;
			break;
		case 6:
			rectangle.x = camera.position.x - getViewportWidth() / denominatorOffset + borderShrinkOffset + 0.3f;
			rectangle.y = (camera.position.y - verticalHeight / denominatorOffset) + camera.viewportHeight - 1.0f;
			break;
		case 7:
			rectangle.x = camera.position.x - getViewportWidth() / denominatorOffset + borderShrinkOffset + 0.3f + 2f;
			rectangle.y = (camera.position.y - verticalHeight / denominatorOffset) + camera.viewportHeight - 1.0f;
			break;
		case 8:
			rectangle.x = camera.position.x - getViewportWidth() / denominatorOffset + borderShrinkOffset + 0.3f + 3.9f;
			rectangle.y = (camera.position.y - verticalHeight / denominatorOffset) + camera.viewportHeight - 1.0f;
			break;
		case 9:
			rectangle.x = camera.position.x - getViewportWidth() / denominatorOffset + borderShrinkOffset + 0.3f + 5.8f;
			rectangle.y = (camera.position.y - verticalHeight / denominatorOffset) + camera.viewportHeight - 1.0f;
			break;
		case 10:
			rectangle.x = camera.position.x - getViewportWidth() / denominatorOffset + borderShrinkOffset + 0.3f + 7.8f;
			rectangle.y = (camera.position.y - verticalHeight / denominatorOffset) + camera.viewportHeight - 1.0f;
			break;
		case 11:
			rectangle.x = camera.position.x - getViewportWidth() / denominatorOffset + borderShrinkOffset + 0.3f + 9.7f;
			rectangle.y = (camera.position.y - verticalHeight / denominatorOffset) + camera.viewportHeight - 1.0f;
			break;
		}

		batch.draw(
				imageLoader.whiteSquare,
				rectangle.x,
				rectangle.y,
				rectangle.width,
				-rectangle.height
				);
	}

	/**
	 * Renders the inventory objects over their inventory sqaures.
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shapeRenderer
	 * @param ImageLoader   imageLoader
	 */
	public void renderInventoryDisplay(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		float xStartPosition = GameScreen.camera.position.x - GameScreen.cameraWidth / 2 - 0.3f;
		float yStartPosition = GameScreen.camera.position.y + 0.65f;
		float x              = xStartPosition;
		float y              = GameScreen.camera.position.y + 0.65f;
		boolean resetX       = true;
		if (inventory.size() > 0) {
			for (int i = 0; i < inventory.size(); i++) {
				inventory.get(i).setX(x);
				inventory.get(i).setY(y);
				inventory.get(i).renderObject(batch, shapeRenderer, imageLoader);
				x += 1.95f;

				if (i > 4 && resetX) {
					x = xStartPosition;
					y = yStartPosition + 2.4f;
					resetX = false;
				}
			}
		}
	}
}