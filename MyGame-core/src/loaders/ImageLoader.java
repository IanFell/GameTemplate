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
	
	public Texture splashScreenLogo;
	
	/**
	 * Fake tile images for set up.
	 */
	public Texture fakeTileOne, fakeTileTwo;
	
	public Texture light;
	
	public Texture shadow;
	
	public Texture playerSprite;
	
	public void init() {
		splashScreenLogo = new Texture(Gdx.files.internal("logo_ffg.png"));
		testImage        = new Texture(Gdx.files.internal("badlogic.jpg"));
		fakeTileOne      = new Texture(Gdx.files.internal("FakeTile.png"));
		fakeTileTwo      = new Texture(Gdx.files.internal("FakeTile2.png"));
		light            = new Texture(Gdx.files.internal("Lighting.png"));
		shadow           = new Texture(Gdx.files.internal("Shadow.png"));
		playerSprite     = new Texture(Gdx.files.internal("PlayerSprite.png"));
	}
	
	public void dispose() {
		splashScreenLogo.dispose();
		testImage.dispose();
		fakeTileOne.dispose();
		fakeTileTwo.dispose();
		light.dispose();
		shadow.dispose();
		playerSprite.dispose();
	}
}
