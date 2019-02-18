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
	public Texture sandTileHorizontalPath;
	public Texture sandTileLeftDownPath;
	public Texture sandTileVerticalPath;
	public Texture sandTileTopRightPath;
	public Texture sandTileCrossPath;
	public Texture waterTileOne;
	public Texture waterTileTwo;
	public Texture waterTileThree;


	public Texture light;
	public Texture shadow;

	public Texture playerSprite;

	public Texture tree;

	public Texture palmTree;
	public Texture plant;

	public Texture chestClosed;
	public Texture chestOpen;

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
		waterTileThree				   = new Texture(Gdx.files.internal("WaterThree.png"));
		sandTile                       = new Texture(Gdx.files.internal("SandTile.png"));
		sandTileHorizontalPath         = new Texture(Gdx.files.internal("SandTileHorizontalPath.png"));
		sandTileLeftDownPath           = new Texture(Gdx.files.internal("SandTileLeftDownPath.png"));
		sandTileVerticalPath		   = new Texture(Gdx.files.internal("SandTileVerticalPath.png"));
		sandTileTopRightPath	       = new Texture(Gdx.files.internal("SandTileTopRightPath.png"));
		sandTileCrossPath              = new Texture(Gdx.files.internal("SandTileCrossPath.png"));
		solidTile                      = new Texture(Gdx.files.internal("FakeTile.png"));
		light                          = new Texture(Gdx.files.internal("Lighting.png"));
		shadow                         = new Texture(Gdx.files.internal("Shadow.png"));
		playerSprite                   = new Texture(Gdx.files.internal("PlayerSprite.png"));
		tree                           = new Texture(Gdx.files.internal("SampleTree.png"));
		chestClosed                    = new Texture(Gdx.files.internal("Chest.png"));
		chestOpen					   = new Texture(Gdx.files.internal("ChestOpen.png"));
		whiteSquare                    = new Texture(Gdx.files.internal("WhiteSquare.png"));
		playerScore                    = new Texture(Gdx.files.internal("PlayerScoreGui.png"));
		rain 						   = new Texture(Gdx.files.internal("Rain.png"));
		palmTree					   = new Texture(Gdx.files.internal("PalmTreeNewOriginal3.png"));
		plant                          = new Texture(Gdx.files.internal("PlantNewOriginal.png"));
	}

	public void dispose() {
		splashScreenLogo.dispose();
		titleScreenLogo.dispose();
		testImage.dispose();
		grassTileOne.dispose();
		grassTileTwo.dispose();
		waterTileOne.dispose();
		waterTileTwo.dispose();
		waterTileThree.dispose();
		solidTile.dispose();
		sandTile.dispose();
		sandTileHorizontalPath.dispose();
		sandTileLeftDownPath.dispose();
		sandTileVerticalPath.dispose();
		sandTileTopRightPath.dispose();
		sandTileCrossPath.dispose();
		light.dispose();
		shadow.dispose();
		playerSprite.dispose();
		tree.dispose();
		chestClosed.dispose();
		chestOpen.dispose();
		whiteSquare.dispose();
		playerScore.dispose();
		rain.dispose();
		palmTree.dispose();
		plant.dispose();
	}
}
