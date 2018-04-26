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
	 * Fake tile images for set up.
	 */
	public Texture fakeTileOne, fakeTileTwo;
	
	public Texture fakeTileBottom, fakeTileTop;
	
	/**
	 * Light texture.
	 */
	public Texture light;
	
	public Texture playerSprite;
	
	/**
	 * Initialize textures.
	 */
	public void init() {
		splashScreenLogo = new Texture(Gdx.files.internal("logo_ffg.png"));
		testImage        = new Texture(Gdx.files.internal("badlogic.jpg"));
		fakeTileOne      = new Texture(Gdx.files.internal("FakeTile.png"));
		fakeTileTwo      = new Texture(Gdx.files.internal("FakeTile2.png"));
		fakeTileBottom      = new Texture(Gdx.files.internal("FakeTileBottom.png"));
		fakeTileTop      = new Texture(Gdx.files.internal("FakeTileTop.png"));
		light            = new Texture(Gdx.files.internal("Lighting.png"));
		playerSprite            = new Texture(Gdx.files.internal("PlayerSprite.png"));
	}
	
	/**
	 * Dispose of textures.
	 */
	public void dispose() {
		splashScreenLogo.dispose();
		testImage.dispose();
		fakeTileOne.dispose();
		fakeTileTwo.dispose();
		fakeTileBottom.dispose();
		fakeTileTop.dispose();
		light.dispose();
		playerSprite.dispose();
	}
}
