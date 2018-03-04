package loaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Class to hold and handle our images.
 * 
 * @author Fabulous Fellini
 *
 */
public class ImageLoader {
	
	/**
	 * Image used to debug.
	 */
	public Texture testImage;
	
	/**
	 * Fabulous Fellini Logo.
	 */
	public Texture fabulousFelliniLogo;
	
	/**
	 * Fake tile images for set up..
	 */
	public Texture fakeTile, fakeTileAlternate;
	
	/**
	 * Initialize class.
	 */
	public void init() {
		fabulousFelliniLogo = new Texture(Gdx.files.internal("logo_ffg.png"));
		testImage           = new Texture(Gdx.files.internal("badlogic.jpg"));
		fakeTile            = new Texture(Gdx.files.internal("FakeTile.png"));
		fakeTileAlternate   = new Texture(Gdx.files.internal("FakeTile2.png"));
	}
	
	/**
	 * Dispose of resources.
	 */
	public void dispose() {
		fabulousFelliniLogo.dispose();
		testImage.dispose();
		fakeTile.dispose();
		fakeTileAlternate.dispose();
	}
}
