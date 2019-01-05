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
	public Texture titleScreenLogo;

	public Texture grassTileOne;
	public Texture grassTileTwo;
	public Texture solidTile;
	public Texture sandTile;
	public Texture waterTileOne;
	public Texture waterTileTwo;
	public Texture waterLowerLeftHalfAndHalfTile;
	public Texture waterUpperLeftHalfAndHalfTile;
	public Texture waterLowerRightHalfAndHalfTile;
	public Texture waterUpperRightHalfAndHalfTile;
	public Texture waterUpperLeftCurvedTile;

	public Texture light;
	public Texture shadow;

	public Texture playerSprite;

	public Texture tree;
	
	public Texture palmTree;
	public Texture plant;
	
	public Texture chest;

	public Texture whiteSquare;
	
	public Texture rain;
	
	public Texture playerScore;

	public void init() {
		splashScreenLogo               = new Texture(Gdx.files.internal("logo_ffg.png"));
		titleScreenLogo                = new Texture(Gdx.files.internal("GoldenAgeLogo.png"));
		testImage                      = new Texture(Gdx.files.internal("badlogic.jpg"));
		grassTileOne     			   = new Texture(Gdx.files.internal("GrassTileOne.png"));
		grassTileTwo                   = new Texture(Gdx.files.internal("GrassTileTwo.png"));
		waterTileOne                   = new Texture(Gdx.files.internal("WaterOne.png"));
		waterTileTwo                   = new Texture(Gdx.files.internal("WaterTwo.png"));
		waterLowerLeftHalfAndHalfTile  = new Texture(Gdx.files.internal("WaterLowerLeftHalfAndHalf.png"));
		waterUpperLeftHalfAndHalfTile  = new Texture(Gdx.files.internal("WaterUpperLeftHalfAndHalf.png"));
		waterUpperLeftCurvedTile       = new Texture(Gdx.files.internal("WaterUpperLeftCurved.png"));
		waterLowerRightHalfAndHalfTile = new Texture(Gdx.files.internal("WaterLowerRightHalfAndHalf.png"));
		waterUpperRightHalfAndHalfTile = new Texture(Gdx.files.internal("WaterUpperRightHalfAndHalf.png"));
		sandTile                       = new Texture(Gdx.files.internal("SandTile.png"));
		solidTile                      = new Texture(Gdx.files.internal("FakeTile.png"));
		light                          = new Texture(Gdx.files.internal("Lighting.png"));
		shadow                         = new Texture(Gdx.files.internal("Shadow.png"));
		playerSprite                   = new Texture(Gdx.files.internal("PlayerSprite.png"));
		tree                           = new Texture(Gdx.files.internal("SampleTree.png"));
		chest                          = new Texture(Gdx.files.internal("Chest.png"));
		whiteSquare                    = new Texture(Gdx.files.internal("WhiteSquare.png"));
		playerScore                    = new Texture(Gdx.files.internal("PlayerScoreGui.png"));
		rain 						   = new Texture(Gdx.files.internal("Rain.png"));
		palmTree					   = new Texture(Gdx.files.internal("PalmTree.png"));
		plant                          = new Texture(Gdx.files.internal("Plant.png"));
	}

	public void dispose() {
		splashScreenLogo.dispose();
		titleScreenLogo.dispose();
		testImage.dispose();
		grassTileOne.dispose();
		grassTileTwo.dispose();
		waterTileOne.dispose();
		waterTileTwo.dispose();
		waterLowerLeftHalfAndHalfTile.dispose();
		waterUpperLeftHalfAndHalfTile.dispose();
		waterLowerRightHalfAndHalfTile.dispose();
		waterUpperRightHalfAndHalfTile.dispose();
		waterUpperLeftCurvedTile.dispose();
		solidTile.dispose();
		sandTile.dispose();
		light.dispose();
		shadow.dispose();
		playerSprite.dispose();
		tree.dispose();
		chest.dispose();
		whiteSquare.dispose();
		playerScore.dispose();
		rain.dispose();
		palmTree.dispose();
		plant.dispose();
	}
}
