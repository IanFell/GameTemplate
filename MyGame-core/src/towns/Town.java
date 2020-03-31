package towns;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.mygame.MyGame;

import controllers.PlayerController;
import loaders.ImageLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Town {
	
	private final int TOWN_SIZE = 35;

	public static final int MEXICO_BEACH  = 0;
	public static final int PORT_ST_JOE   = 1;
	public static final int THE_POINT     = 2;
	public static final int WEWA          = 3;
	public static final int APALACHICOLA  = 4;
	public static final int ST_GEORGE     = 5;
	public static final int CAPE_SAN_BLAS = 6; 
	public static final int STUMP_HOLE    = 7;

	public boolean isInTown;

	protected Rectangle townBorder = new Rectangle();

	/**
	 * Constructor.
	 */
	public Town() {
		townBorder.width  = TOWN_SIZE;
		townBorder.height = TOWN_SIZE;
		isInTown          = false;
	}
	
	/**
	 * 
	 * @param MyGame myGame
	 */
	public void updateTown(MyGame myGame) {
		isInTown = false;
		if (checkIfPlayerIsWithinBoundsOfTown(myGame)) {
			isInTown = true;
		} 
	}

	/**
	 * This is used strictly for debugging.
	 * 
	 * @param SpriteBatch   batch
	 * @param ImageLoader   imageLoader
	 */
	public void renderTownBorder(SpriteBatch batch, ImageLoader imageLoader) {
		batch.draw(
				imageLoader.whiteSquare,
				townBorder.x,
				townBorder.y,
				townBorder.width, 
				townBorder.height
				);
	}

	/**
	 * 
	 * @param MyGame myGame
	 * @return boolean
	 */
	protected boolean checkIfPlayerIsWithinBoundsOfTown(MyGame myGame) {
		if (PlayerController.getCurrentPlayer(myGame).rectangle.overlaps(townBorder)) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @return boolean
	 */
	public boolean isInTown() {
		return isInTown;
	}
}
