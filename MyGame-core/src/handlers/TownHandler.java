package handlers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import loaders.ImageLoader;
import towns.Apalachicola;
import towns.CapeSanBlas;
import towns.MexicoBeach;
import towns.PortStJoe;
import towns.StGeorge;
import towns.ThePoint;
import towns.Wewa;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TownHandler {

	private MexicoBeach mexicoBeach;
	private PortStJoe portStJoe;
	private Wewa wewa;
	private Apalachicola apalachicola;
	private StGeorge stGeorge;
	private ThePoint thePoint;
	private CapeSanBlas capeSanBlas;

	/**
	 * Constructor.
	 */
	public TownHandler() {
		mexicoBeach  = new MexicoBeach();
		portStJoe    = new PortStJoe();
		wewa         = new Wewa();
		apalachicola = new Apalachicola();
		stGeorge     = new StGeorge();
		thePoint     = new ThePoint();
		capeSanBlas  = new CapeSanBlas();
	}

	/**
	 * 
	 * @param MyGame myGame
	 */
	public void updateTowns(MyGame myGame) {
		mexicoBeach.updateTown(myGame);
		portStJoe.updateTown(myGame);
		wewa.updateTown(myGame);
		apalachicola.updateTown(myGame);
		stGeorge.updateTown(myGame);
		thePoint.updateTown(myGame);
		capeSanBlas.updateTown(myGame);
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ImageLoader   imageLoader
	 */
	public void renderTownBorders(SpriteBatch batch, ImageLoader imageLoader) {
		mexicoBeach.renderTownBorder(batch, imageLoader);
		portStJoe.renderTownBorder(batch, imageLoader);
		wewa.renderTownBorder(batch, imageLoader);
		apalachicola.renderTownBorder(batch, imageLoader);
		stGeorge.renderTownBorder(batch, imageLoader);
		thePoint.renderTownBorder(batch, imageLoader);
		capeSanBlas.renderTownBorder(batch, imageLoader);
	}

	/**
	 * 
	 * @return MexicoBeach
	 */
	public MexicoBeach getMexicoBeach() {
		return mexicoBeach;
	}

	/**
	 * 
	 * @return PortStJoe
	 */
	public PortStJoe getPortStJoe() {
		return portStJoe;
	}

	/**
	 * 
	 * @return Wewa
	 */
	public Wewa getWewa() {
		return wewa;
	}

	/**
	 * 
	 * @return Apalachicola
	 */
	public Apalachicola getApalachicola() {
		return apalachicola;
	}

	/**
	 * 
	 * @return StGeorge
	 */
	public StGeorge getStGeorge() {
		return stGeorge;
	}

	/**
	 * 
	 * @return ThePoint
	 */
	public ThePoint getThePoint() {
		return thePoint;
	}

	/**
	 * 
	 * @return CapeSanBlas
	 */
	public CapeSanBlas getCapeSanBlas() {
		return capeSanBlas;
	}
}
