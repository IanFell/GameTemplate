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

	public Texture playerHeadUp;
	public Texture playerHeadDown;
	public Texture playerHeadLeft;
	public Texture playerHeadRight;

	public Texture tree;

	public Texture drSuessTree;
	public Texture palmTree;
	public Texture plant;

	public Texture chestClosed;
	public Texture chestOpen;

	public Texture whiteSquare;

	public Texture rain;

	public Texture playerScore;

	public Texture teePee;
	public Texture rawbar;

	public Texture ui;

	public Texture missionComplete;

	public Texture lightHouse;
	public Texture pigglywiggly;

	public Texture fireOne;
	public Texture fireTwo;
	public Texture fireThree;
	public Texture fireFour;
	public Texture logs;

	public Texture sword;

	public Texture legendSwordRed;
	public Texture legendSwordBlue;
	public Texture legendSwordGreen;
	public Texture legendSwordYellow;
	public Texture legendSwordOrange;
	public Texture legendSwordPurple;
	public Texture legendSwordPink;
	public Texture legendSwordRedHalf;
	public Texture legendSwordBlueHalf;
	public Texture legendSwordGreenHalf;
	public Texture legendSwordYellowHalf;
	public Texture legendSwordOrangeHalf;
	public Texture legendSwordPurpleHalf;
	public Texture legendSwordPinkHalf;
	public Texture legendSwordRainbow;

	public void init() {
		legendSwordRedHalf             = new Texture(Gdx.files.internal("LegendSwordRedHalf.png"));
		legendSwordBlueHalf            = new Texture(Gdx.files.internal("LegendSwordBlueHalf.png"));
		legendSwordGreenHalf           = new Texture(Gdx.files.internal("LegendSwordGreenHalf.png"));
		legendSwordYellowHalf          = new Texture(Gdx.files.internal("LegendSwordYellowHalf.png"));
		legendSwordOrangeHalf          = new Texture(Gdx.files.internal("LegendSwordOrangeHalf.png"));
		legendSwordPurpleHalf          = new Texture(Gdx.files.internal("LegendSwordPurpleHalf.png"));
		legendSwordPinkHalf            = new Texture(Gdx.files.internal("LegendSwordPinkHalf.png"));
		missionComplete                = new Texture(Gdx.files.internal("MissionComplete.png"));
		legendSwordRainbow             = new Texture(Gdx.files.internal("SwordRainbow.png"));
		legendSwordRed                 = new Texture(Gdx.files.internal("SwordRed.png"));
		legendSwordBlue                = new Texture(Gdx.files.internal("SwordBlue.png"));
		legendSwordGreen               = new Texture(Gdx.files.internal("SwordGreen.png"));
		legendSwordYellow              = new Texture(Gdx.files.internal("SwordYellow.png"));
		legendSwordOrange              = new Texture(Gdx.files.internal("SwordOrange.png"));
		legendSwordPurple              = new Texture(Gdx.files.internal("SwordPurple.png"));
		legendSwordPink                = new Texture(Gdx.files.internal("SwordPink.png"));
		sword                          = new Texture(Gdx.files.internal("Sword.png"));
		logs                           = new Texture(Gdx.files.internal("Logs.png"));
		fireOne                        = new Texture(Gdx.files.internal("Fire1.png"));
		fireTwo                        = new Texture(Gdx.files.internal("Fire2.png"));
		fireThree                      = new Texture(Gdx.files.internal("Fire3.png"));
		fireFour                       = new Texture(Gdx.files.internal("Fire4.png"));
		splashScreenLogo               = new Texture(Gdx.files.internal("logo_ffg.png"));
		titleScreenLogo                = new Texture(Gdx.files.internal("GoldenAgeLogo.png"));
		testImage                      = new Texture(Gdx.files.internal("badlogic.jpg"));
		grassTileOne     			   = new Texture(Gdx.files.internal("GrassTileOne.png"));
		grassTileTwo                   = new Texture(Gdx.files.internal("GrassTileTwo.png"));
		waterTileOne                   = new Texture(Gdx.files.internal("WaterOne.png"));
		waterTileTwo                   = new Texture(Gdx.files.internal("WaterTwo.png"));
		waterTileThree				   = new Texture(Gdx.files.internal("WaterThree.png"));
		sandTile                       = new Texture(Gdx.files.internal("SandTile2.png"));
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
		drSuessTree                    = new Texture(Gdx.files.internal("DrSuessTree.png"));
		teePee   					   = new Texture(Gdx.files.internal("TeePee.png"));
		playerHeadUp 				   = new Texture(Gdx.files.internal("PlayerHeadUp.png"));
		playerHeadDown 				   = new Texture(Gdx.files.internal("PlayerHeadDown.png"));
		playerHeadLeft 				   = new Texture(Gdx.files.internal("PlayerHeadLeft.png"));
		playerHeadRight 			   = new Texture(Gdx.files.internal("PlayerHeadRight.png"));
		ui 							   = new Texture(Gdx.files.internal("UI.png"));
		rawbar						   = new Texture(Gdx.files.internal("RawBar.png"));
		lightHouse                     = new Texture(Gdx.files.internal("LightHouse.png"));
		pigglywiggly                   = new Texture(Gdx.files.internal("PigglyWiggly.png"));
	}

	public void dispose() {
		missionComplete.dispose();
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
		teePee.dispose();
		playerHeadUp.dispose();
		playerHeadDown.dispose();
		playerHeadLeft.dispose();
		playerHeadRight.dispose();
		ui.dispose();
		rawbar.dispose();
		lightHouse.dispose();
		fireOne.dispose();
		fireTwo.dispose();
		fireThree.dispose();
		fireFour.dispose();
		logs.dispose();
		drSuessTree.dispose();
		sword.dispose();
		legendSwordRed.dispose();
		legendSwordBlue.dispose();
		legendSwordGreen.dispose();
		legendSwordYellow.dispose();
		legendSwordPurple.dispose();
		legendSwordOrange.dispose();
		legendSwordPink.dispose();
		legendSwordRainbow.dispose();
		legendSwordRedHalf.dispose();
		legendSwordYellowHalf.dispose();
		legendSwordBlueHalf.dispose();
		legendSwordGreenHalf.dispose();
		legendSwordPurpleHalf.dispose();
		legendSwordPinkHalf.dispose();
		legendSwordOrangeHalf.dispose();
		pigglywiggly.dispose();
	}
}
