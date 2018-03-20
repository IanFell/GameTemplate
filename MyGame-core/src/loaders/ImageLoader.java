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
	 * Splash Screen Logo.
	 */
	public Texture splashScreenLogo;
	
	/**
	 * Fake tile images for set up..
	 */
	public Texture fakeTileOne, fakeTileTwo, fakeTileThree;
	
	/**
	 * Initialize class.
	 */
	public void init() {
		splashScreenLogo = new Texture(Gdx.files.internal("logo_ffg.png"));
		testImage        = new Texture(Gdx.files.internal("badlogic.jpg"));
		fakeTileOne      = new Texture(Gdx.files.internal("FakeTile.png"));
		fakeTileTwo      = new Texture(Gdx.files.internal("FakeTile2.png"));
		fakeTileThree    = new Texture(Gdx.files.internal("FakeTile3.png"));
	}
	
	/**
	 * Dispose of resources.
	 */
	public void dispose() {
		splashScreenLogo.dispose();
		testImage.dispose();
		fakeTileOne.dispose();
		fakeTileTwo.dispose();
		fakeTileThree.dispose();
	}
}
