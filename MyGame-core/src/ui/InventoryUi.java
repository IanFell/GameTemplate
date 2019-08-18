package ui;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import input.computer.Mouse;
import input.controllers.LogitechF310;
import loaders.ImageLoader;
import physics.Lighting.Fire;
import screens.GameScreen;
import screens.Screens;

/**
 * Extend Screens so we can use camera easier.
 * 
 * @author Fabulous Fellini
 *
 */
public class InventoryUi extends Screens {

	/**
	 * Constructor.
	 * 
	 * @param MyGame myGame
	 */
	public InventoryUi(MyGame myGame) {
		super(myGame);
	}

	/**
	 * 
	 * @param SpriteBatch            batch
	 * @param ImageLoader            imageLoader
	 * @param ArrayList <GameObject> inventory
	 * @param boolean                inventoryIsEquipped
	 * @param int                    currentlySelectedInventoryObject
	 * @param boolean                allInventoryShouldBeRendered
	 * @param Fire                   fire
	 * @param boolean                mouseIsClickingOnInventoryObject
	 * @param Rectangle              rectangle
	 */
	public void renderInventoryUi(
			SpriteBatch batch, 
			ImageLoader imageLoader, 
			ArrayList <GameObject> inventory,
			boolean inventoryIsEquipped,
			int currentlySelectedInventoryObject,
			boolean allInventoryShouldBeRendered,
			Fire fire,
			boolean mouseIsClickingOnInventoryObject,
			Rectangle rectangle
			) {
		if (inventory.size() > 0) {
			if (inventoryIsEquipped) {
				inventory.get(currentlySelectedInventoryObject).renderObject(batch, imageLoader);
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
			renderInventoryDisplay(batch, imageLoader, inventory);

			int clickedObject = 0;
			if (mouseIsClickingOnInventoryObject) {
				for (int i = 0; i < Mouse.inventoryButtonIsPressed.length; i++) {
					if (Mouse.inventoryButtonIsPressed[i] || LogitechF310.inventoryButtonIsPressed[i]) {
						clickedObject = i;
					}
				}
				// White square that flashes when player clicks on an inventory square.
				drawClickHover(batch, imageLoader, clickedObject, rectangle);
			}
			fire.setX(rectangle.x + 1.5f);
			fire.setY(rectangle.y);
			fire.setWidth(rectangle.getWidth() / 6.5f);
			fire.setHeight(rectangle.getHeight() / 2);
			fire.renderObject(batch, imageLoader);

			renderUiNavigationBar(imageLoader.inventoryNavigationBar, batch);
		}
	}

	/**
	 * Draws the white square that flashes when player clicks on an inventory square.
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 * @param int         hoverValue
	 * @param Rectangle   rectangle
	 */
	private void drawClickHover(SpriteBatch batch, ImageLoader imageLoader, int hoverValue, Rectangle rectangle) {
		int borderShrinkOffset = 1;
		float yOffsetTopRow    = 6.15f;
		float yOffsetBottomRow = 1.6f; 
		switch (hoverValue) {
		case 0:
			rectangle.x = camera.position.x - getViewportWidth() / denominatorOffset + borderShrinkOffset + 0.7f;
			rectangle.y = (camera.position.y - verticalHeight / denominatorOffset) + camera.viewportHeight - yOffsetTopRow;
			break;
		case 1:
			rectangle.x = camera.position.x - getViewportWidth() / denominatorOffset + borderShrinkOffset + 0.7f + 4.2f;
			rectangle.y = (camera.position.y - verticalHeight / denominatorOffset) + camera.viewportHeight - yOffsetTopRow;
			break;
		case 2:
			rectangle.x = camera.position.x - getViewportWidth() / denominatorOffset + borderShrinkOffset + 0.7f + 8f;
			rectangle.y = (camera.position.y - verticalHeight / denominatorOffset) + camera.viewportHeight - yOffsetTopRow;
			break;
		case 3:
			rectangle.x = camera.position.x - getViewportWidth() / denominatorOffset + borderShrinkOffset + 0.7f + 12.0f;
			rectangle.y = (camera.position.y - verticalHeight / denominatorOffset) + camera.viewportHeight - yOffsetTopRow;
			break;
		case 4:
			rectangle.x = camera.position.x - getViewportWidth() / denominatorOffset + borderShrinkOffset + 0.7f + 16f;
			rectangle.y = (camera.position.y - verticalHeight / denominatorOffset) + camera.viewportHeight - yOffsetTopRow;
			break;
		case 5:
			rectangle.x = camera.position.x - getViewportWidth() / denominatorOffset + borderShrinkOffset + 0.7f + 20f;
			rectangle.y = (camera.position.y - verticalHeight / denominatorOffset) + camera.viewportHeight - yOffsetTopRow;
			break;
		case 6:
			rectangle.x = camera.position.x - getViewportWidth() / denominatorOffset + borderShrinkOffset + 0.7f;
			rectangle.y = (camera.position.y - verticalHeight / denominatorOffset) + camera.viewportHeight - yOffsetBottomRow;
			break;
		case 7:
			rectangle.x = camera.position.x - getViewportWidth() / denominatorOffset + borderShrinkOffset + 0.7f + 4.2f;
			rectangle.y = (camera.position.y - verticalHeight / denominatorOffset) + camera.viewportHeight - yOffsetBottomRow;
			break;
		case 8:
			rectangle.x = camera.position.x - getViewportWidth() / denominatorOffset + borderShrinkOffset + 0.7f + 8f;
			rectangle.y = (camera.position.y - verticalHeight / denominatorOffset) + camera.viewportHeight - yOffsetBottomRow;
			break;
		case 9:
			rectangle.x = camera.position.x - getViewportWidth() / denominatorOffset + borderShrinkOffset + 0.7f + 12.0f;
			rectangle.y = (camera.position.y - verticalHeight / denominatorOffset) + camera.viewportHeight - yOffsetBottomRow;
			break;
		case 10:
			rectangle.x = camera.position.x - getViewportWidth() / denominatorOffset + borderShrinkOffset + 0.7f + 16f;
			rectangle.y = (camera.position.y - verticalHeight / denominatorOffset) + camera.viewportHeight - yOffsetBottomRow;
			break;
		case 11:
			rectangle.x = camera.position.x - getViewportWidth() / denominatorOffset + borderShrinkOffset + 0.7f + 20f;
			rectangle.y = (camera.position.y - verticalHeight / denominatorOffset) + camera.viewportHeight - yOffsetBottomRow;
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
	 * @param SpriteBatch            batch
	 * @param ImageLoader            imageLoader
	 * @param ArrayList <GameObject> inventory
	 */
	public void renderInventoryDisplay(SpriteBatch batch, ImageLoader imageLoader, ArrayList <GameObject> inventory) {
		float xStartPosition = GameScreen.camera.position.x - GameScreen.cameraWidth / 2 - 5.5f;
		float offset         = 0.25f;
		float yStartPosition = GameScreen.camera.position.y + offset;
		float x              = xStartPosition;
		float y              = GameScreen.camera.position.y + offset;
		boolean resetX       = true;
		if (inventory.size() > 0) {
			for (int i = 0; i < inventory.size(); i++) {
				inventory.get(i).setX(x);
				inventory.get(i).setY(y);
				inventory.get(i).renderObject(batch, imageLoader);
				x += 4f;

				if (i > 4 && resetX) {
					x = xStartPosition;
					y = yStartPosition + 4.6f;
					resetX = false;
				}
			}
		}
	}
}
