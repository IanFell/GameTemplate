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

	public Texture[] cutSceneDialogueOne = new Texture[9];
	public Texture inventoryNavigationBar;
	public Texture mapNavigationBar;
	public Texture testImage;
	public Texture icon;
	public Texture worldMapReal;
	public Texture worldMapFake;
	public Texture worldMapMexicoBeach;
	public Texture worldMapApalachicola;
	public Texture worldMapStGeorge;
	public Texture worldMapPortStJoe;
	public Texture worldMapCapeSanBlas;
	public Texture worldMapThePoint;
	public Texture worldMapWewa;
	public Texture enemy;
	public Texture boat;
	public Texture gunRight;
	public Texture gunLeft;
	public Texture gunUp;
	public Texture gunDown;
	public Texture splashScreenLogo;
	public Texture titleScreenLogo;
	public Texture inventoryScreen;
	public Texture legendOfTheSevenSwordsBeginMissionText;
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
	public Texture fireFive;
	public Texture fireSix;
	public Texture fireSeven;
	public Texture fireEight;
	public Texture fireNine;
	public Texture fireTen;
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
	public Texture inventoryLabel;
	public Texture nightTimeShader;
	public Texture dustParticleOne;
	public Texture dustParticleTwo;
	public Texture dustParticleThree;
	public Texture palmTreeThree;
	public Texture slaveHut;

	public void init() {
		mapNavigationBar                       = new Texture(Gdx.files.internal("UiMap.png"));
		inventoryNavigationBar                 = new Texture(Gdx.files.internal("UiInventory.png"));
		slaveHut                               = new Texture(Gdx.files.internal("SlaveHut.png"));
		palmTreeThree                          = new Texture(Gdx.files.internal("PalmTreeNewOriginalAlternate.png"));
		worldMapMexicoBeach					   = new Texture(Gdx.files.internal("WorldMapMexicoBeach.png"));
		worldMapThePoint					   = new Texture(Gdx.files.internal("WorldMapThePoint.png"));
		worldMapPortStJoe					   = new Texture(Gdx.files.internal("WorldMapPortStJoe.png"));
		worldMapCapeSanBlas					   = new Texture(Gdx.files.internal("WorldMapCapeSanBlas.png"));
		worldMapApalachicola				   = new Texture(Gdx.files.internal("WorldMapApalachicola.png"));
		worldMapWewa      					   = new Texture(Gdx.files.internal("WorldMapWewa.png"));
		worldMapStGeorge					   = new Texture(Gdx.files.internal("WorldMapStGeorge.png"));
		worldMapFake						   = new Texture(Gdx.files.internal("WorldMapFake.png"));
		worldMapReal						   = new Texture(Gdx.files.internal("WorldMapReal.png"));
		dustParticleOne                        = new Texture(Gdx.files.internal("DustParticleOne.png"));
		dustParticleTwo                        = new Texture(Gdx.files.internal("DustParticleTwo.png"));
		dustParticleThree                      = new Texture(Gdx.files.internal("DustParticleThree.png"));
		nightTimeShader                        = new Texture(Gdx.files.internal("NightTimeShader.png"));
		icon                                   = new Texture(Gdx.files.internal("GoldenAgeIcon.png"));
		legendOfTheSevenSwordsBeginMissionText = new Texture(Gdx.files.internal("LegendOfTheSevenSwords.png"));
		boat    					           = new Texture(Gdx.files.internal("BOAT_NEW.png"));
		enemy    					           = new Texture(Gdx.files.internal("Enemy.png"));
		inventoryScreen                        = new Texture(Gdx.files.internal("InventoryScreen.png"));
		inventoryLabel                         = new Texture(Gdx.files.internal("InventoryLabel.png"));
		gunRight   					           = new Texture(Gdx.files.internal("GunRight.png"));
		gunLeft                                = new Texture(Gdx.files.internal("GunLeft.png"));
		gunUp  					               = new Texture(Gdx.files.internal("GunUp.png"));
		gunDown                                = new Texture(Gdx.files.internal("GunDown.png"));
		legendSwordRedHalf                     = new Texture(Gdx.files.internal("LegendSwordRedHalf.png"));
		legendSwordBlueHalf                    = new Texture(Gdx.files.internal("LegendSwordBlueHalf.png"));
		legendSwordGreenHalf                   = new Texture(Gdx.files.internal("LegendSwordGreenHalf.png"));
		legendSwordYellowHalf                  = new Texture(Gdx.files.internal("LegendSwordYellowHalf.png"));
		legendSwordOrangeHalf                  = new Texture(Gdx.files.internal("LegendSwordOrangeHalf.png"));
		legendSwordPurpleHalf                  = new Texture(Gdx.files.internal("LegendSwordPurpleHalf.png"));
		legendSwordPinkHalf                    = new Texture(Gdx.files.internal("LegendSwordPinkHalf.png"));
		missionComplete                        = new Texture(Gdx.files.internal("MissionComplete.png"));
		legendSwordRainbow                     = new Texture(Gdx.files.internal("SwordRainbow.png"));
		legendSwordRed                         = new Texture(Gdx.files.internal("SwordRed.png"));
		legendSwordBlue                        = new Texture(Gdx.files.internal("SwordBlue.png"));
		legendSwordGreen                       = new Texture(Gdx.files.internal("SwordGreen.png"));
		legendSwordYellow                      = new Texture(Gdx.files.internal("SwordYellow.png"));
		legendSwordOrange                      = new Texture(Gdx.files.internal("SwordOrange.png"));
		legendSwordPurple                      = new Texture(Gdx.files.internal("SwordPurple.png"));
		legendSwordPink                        = new Texture(Gdx.files.internal("SwordPink.png"));
		sword                                  = new Texture(Gdx.files.internal("Sword.png"));
		logs                                   = new Texture(Gdx.files.internal("Logs.png"));
		fireOne                                = new Texture(Gdx.files.internal("Fire1.png"));
		fireTwo                                = new Texture(Gdx.files.internal("Fire2.png"));
		fireThree                              = new Texture(Gdx.files.internal("Fire3.png"));
		fireFour                               = new Texture(Gdx.files.internal("Fire4.png"));
		fireFive                               = new Texture(Gdx.files.internal("Fire5.png"));
		fireSix                                = new Texture(Gdx.files.internal("Fire6.png"));
		fireSeven                              = new Texture(Gdx.files.internal("Fire7.png"));
		fireEight                              = new Texture(Gdx.files.internal("Fire8.png"));
		fireNine	                           = new Texture(Gdx.files.internal("Fire9.png"));
		fireTen                                = new Texture(Gdx.files.internal("Fire10.png"));
		splashScreenLogo                       = new Texture(Gdx.files.internal("logo_ffg.png"));
		titleScreenLogo                        = new Texture(Gdx.files.internal("GoldenAgeLogo.png"));
		testImage                              = new Texture(Gdx.files.internal("badlogic.jpg"));
		grassTileOne     			           = new Texture(Gdx.files.internal("GrassTileOne.png"));
		grassTileTwo                           = new Texture(Gdx.files.internal("GrassTileTwo.png"));
		waterTileOne                           = new Texture(Gdx.files.internal("WaterOne.png"));
		waterTileTwo                           = new Texture(Gdx.files.internal("WaterTwo.png"));
		waterTileThree				           = new Texture(Gdx.files.internal("WaterThree.png"));
		sandTile                               = new Texture(Gdx.files.internal("SandTile2.png"));
		sandTileHorizontalPath                 = new Texture(Gdx.files.internal("SandTileHorizontalPath.png"));
		sandTileLeftDownPath                   = new Texture(Gdx.files.internal("SandTileLeftDownPath.png"));
		sandTileVerticalPath		           = new Texture(Gdx.files.internal("SandTileVerticalPath.png"));
		sandTileTopRightPath	               = new Texture(Gdx.files.internal("SandTileTopRightPath.png"));
		sandTileCrossPath                      = new Texture(Gdx.files.internal("SandTileCrossPath.png"));
		solidTile                              = new Texture(Gdx.files.internal("FakeTile.png"));
		light                                  = new Texture(Gdx.files.internal("Lighting.png"));
		shadow                                 = new Texture(Gdx.files.internal("Shadow.png"));
		playerSprite                           = new Texture(Gdx.files.internal("PlayerSprite.png"));
		tree                                   = new Texture(Gdx.files.internal("SampleTree.png"));
		chestClosed                            = new Texture(Gdx.files.internal("Chest.png"));
		chestOpen					           = new Texture(Gdx.files.internal("ChestOpen.png"));
		whiteSquare                            = new Texture(Gdx.files.internal("WhiteSquare.png"));
		playerScore                            = new Texture(Gdx.files.internal("PlayerScoreGui.png"));
		rain 						           = new Texture(Gdx.files.internal("Rain.png"));
		palmTree					  	       = new Texture(Gdx.files.internal("PalmTreeNewOriginal3.png"));
		plant                         	       = new Texture(Gdx.files.internal("PlantNewOriginal.png"));
		drSuessTree                            = new Texture(Gdx.files.internal("DrSuessTree.png"));
		teePee   					           = new Texture(Gdx.files.internal("TeePee3D.png"));
		playerHeadUp 				           = new Texture(Gdx.files.internal("PlayerHeadUp.png"));
		playerHeadDown 				           = new Texture(Gdx.files.internal("PlayerHeadDown.png"));
		playerHeadLeft 				           = new Texture(Gdx.files.internal("PlayerHeadLeft.png"));
		playerHeadRight 			           = new Texture(Gdx.files.internal("PlayerHeadRight.png"));
		ui 							           = new Texture(Gdx.files.internal("UI.png"));
		rawbar						           = new Texture(Gdx.files.internal("RawBar3d.png"));
		lightHouse                             = new Texture(Gdx.files.internal("LightHouse.png"));
		pigglywiggly                           = new Texture(Gdx.files.internal("PigglyWiggly3D.png"));

		cutSceneDialogueOne[0] = new Texture(Gdx.files.internal("Cutscene_One_Dialogue_One.png"));
		cutSceneDialogueOne[1] = new Texture(Gdx.files.internal("Cutscene_One_Dialogue_Two.png"));
		cutSceneDialogueOne[2] = new Texture(Gdx.files.internal("Cutscene_One_Dialogue_Three.png"));
		cutSceneDialogueOne[3] = new Texture(Gdx.files.internal("Cutscene_One_Dialogue_Four.png"));
		cutSceneDialogueOne[4] = new Texture(Gdx.files.internal("Cutscene_One_Dialogue_Five.png"));
		cutSceneDialogueOne[5] = new Texture(Gdx.files.internal("Cutscene_One_Dialogue_Six.png"));
		cutSceneDialogueOne[6] = new Texture(Gdx.files.internal("Cutscene_One_Dialogue_Seven.png"));
		cutSceneDialogueOne[7] = new Texture(Gdx.files.internal("Cutscene_One_Dialogue_Eight.png"));
		cutSceneDialogueOne[8] = new Texture(Gdx.files.internal("Cutscene_One_Dialogue_Nine.png"));
	}

	public void dispose() {
		mapNavigationBar.dispose();
		inventoryNavigationBar.dispose();
		slaveHut.dispose();
		palmTreeThree.dispose();
		worldMapMexicoBeach.dispose();
		worldMapStGeorge.dispose();
		worldMapApalachicola.dispose();
		worldMapThePoint.dispose();
		worldMapCapeSanBlas.dispose();
		worldMapWewa.dispose();
		worldMapPortStJoe.dispose();
		worldMapFake.dispose();
		worldMapReal.dispose();
		dustParticleOne.dispose();
		dustParticleTwo.dispose();
		dustParticleThree.dispose();
		icon.dispose();
		legendOfTheSevenSwordsBeginMissionText.dispose();
		boat.dispose();
		enemy.dispose();
		inventoryScreen.dispose();
		inventoryLabel.dispose();
		gunUp.dispose();
		gunDown.dispose();
		gunRight.dispose();
		gunLeft.dispose();
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
		fireFive.dispose();
		fireSix.dispose();
		fireSeven.dispose();
		fireEight.dispose();
		fireNine.dispose();
		fireTen.dispose();
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
		nightTimeShader.dispose();

		for(int i = 0; i < cutSceneDialogueOne.length; i++) {
			cutSceneDialogueOne[i].dispose();
		}
	}
}
