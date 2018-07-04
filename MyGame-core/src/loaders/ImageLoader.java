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

	public Texture grassTileOne;
	public Texture grassTileTwo;
	public Texture solidTile;
	public Texture sandTile;

	public Texture light;
	public Texture shadow;

	public Texture playerSprite;

	public Texture tree;

	public Texture lightningFlash;
	
	public Texture playerScore;

	public void init() {
		splashScreenLogo = new Texture(Gdx.files.internal("logo_ffg.png"));
		testImage        = new Texture(Gdx.files.internal("badlogic.jpg"));
		grassTileOne     = new Texture(Gdx.files.internal("GrassTileOne.png"));
		grassTileTwo     = new Texture(Gdx.files.internal("GrassTileTwo.png"));
		sandTile         = new Texture(Gdx.files.internal("SandTile.png"));
		solidTile        = new Texture(Gdx.files.internal("FakeTile.png"));
		light            = new Texture(Gdx.files.internal("Lighting.png"));
		shadow           = new Texture(Gdx.files.internal("Shadow.png"));
		playerSprite     = new Texture(Gdx.files.internal("PlayerSprite.png"));
		tree             = new Texture(Gdx.files.internal("Tree.png"));
		lightningFlash   = new Texture(Gdx.files.internal("LightningFlash.png"));
		playerScore      = new Texture(Gdx.files.internal("PlayerScoreGui.png"));
	}

	public void dispose() {
		splashScreenLogo.dispose();
		testImage.dispose();
		grassTileOne.dispose();
		grassTileTwo.dispose();
		solidTile.dispose();
		sandTile.dispose();
		light.dispose();
		shadow.dispose();
		playerSprite.dispose();
		tree.dispose();
		lightningFlash.dispose();
		playerScore.dispose();
	}
}
