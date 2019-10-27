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

	// Game objects.
	public Texture chestClosed;
	public Texture chestOpen;
	public Texture heart;
	public Texture boat;
	public Texture sign;

	// Nature Objects.
	public Texture rock;
	public Texture drSuessTree;
	public Texture palmTree;
	public Texture palmTreeThree;
	public Texture plant;
	public Texture logs;
	public Texture light;
	public Texture rain;
	public Texture shadow;

	// Weapon Objects.
	public Texture gunRight;
	public Texture gunLeft;
	public Texture gunUp;
	public Texture gunDown;
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
	public Texture oyster;

	// Structure Objects.
	public Texture teePee;
	public Texture rawbar;
	public Texture lightHouse;
	public Texture pigglywiggly;
	public Texture slaveHut;
	public Texture gruntHut;

	// Effects Objects.
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
	public Texture dustParticleOne;
	public Texture dustParticleTwo;
	public Texture dustParticleThree;

	// Cutscene objects.
	public Texture[] cutSceneDialogueOne = new Texture[9];

	// Map objects.
	public Texture worldMapReal;
	public Texture worldMapFake;
	public Texture worldMapMexicoBeach;
	public Texture worldMapApalachicola;
	public Texture worldMapStGeorge;
	public Texture worldMapPortStJoe;
	public Texture worldMapCapeSanBlas;
	public Texture worldMapThePoint;
	public Texture worldMapWewa;

	// Mission objects.
	public Texture legendOfTheSevenSwordsBeginMissionText;
	public Texture missionComplete;
	public Texture missionRawBarInside;
	public Texture missionTransparentBlueSquare;
	public Texture collectOysters;
	public Texture rightHand;
	public Texture leftHand;
	public Texture rightHandClosed;
	public Texture leftHandClosed;

	// Tile objects.
	public Texture grassTileOne;
	public Texture sandTile;
	public Texture sandTileHorizontalPath;
	public Texture sandTileLeftDownPath;
	public Texture sandTileVerticalPath;
	public Texture sandTileTopRightPath;
	public Texture sandTileCrossPath;
	public Texture waterTileOne;
	public Texture waterTileTwo;
	public Texture waterTileThree;
	public Texture nightTimeShader;

	// UI objects.
	public Texture inventoryNavigationBar;
	public Texture mapNavigationBar;
	public Texture inventoryScreen;
	public Texture inventoryLabel;
	public Texture locationSkull;

	// Logo objects.
	public Texture splashScreenLogo;
	public Texture titleScreenLogo;
	public Texture icon;

	// Debugging Objects.
	public Texture whiteSquare;

	public void init() {

		// Game objects.
		chestClosed                            = new Texture(Gdx.files.internal("artwork/Chest.png"));
		chestOpen					           = new Texture(Gdx.files.internal("artwork/ChestOpen.png"));
		heart    						       = new Texture(Gdx.files.internal("artwork/Heart.png"));
		boat    					           = new Texture(Gdx.files.internal("artwork/BOAT_NEW.png"));
		sign                                   = new Texture(Gdx.files.internal("artwork/signs/Sign.png"));

		// Nature Objects.
		rock 								   = new Texture(Gdx.files.internal("artwork/nature/Rock.png"));
		logs                                   = new Texture(Gdx.files.internal("artwork/nature/Logs.png"));
		palmTreeThree                          = new Texture(Gdx.files.internal("artwork/nature/PalmTreeNewOriginal3_02.png"));
		palmTree					  	       = new Texture(Gdx.files.internal("artwork/nature/PalmTreeNewOriginal3.png"));
		plant                         	       = new Texture(Gdx.files.internal("artwork/nature/PlantNewOriginal.png"));
		drSuessTree                            = new Texture(Gdx.files.internal("artwork/nature/DrSuessTree.png"));
		light                                  = new Texture(Gdx.files.internal("artwork/nature/Lighting.png"));
		rain 						           = new Texture(Gdx.files.internal("artwork/nature/Rain.png"));
		shadow                                 = new Texture(Gdx.files.internal("artwork/nature/Shadow.png"));

		// Weapon Objects.
		gunRight   					           = new Texture(Gdx.files.internal("artwork/weapons/gun/Right.png"));
		gunLeft                                = new Texture(Gdx.files.internal("artwork/weapons/gun/Left.png"));
		gunUp                                  = new Texture(Gdx.files.internal("artwork/weapons/gun/Up.png"));
		gunDown                                = new Texture(Gdx.files.internal("artwork/weapons/gun/Down.png"));
		legendSwordRedHalf                     = new Texture(Gdx.files.internal("artwork/weapons/sword/LegendSwordRedHalf.png"));
		legendSwordBlueHalf                    = new Texture(Gdx.files.internal("artwork/weapons/sword/LegendSwordBlueHalf.png"));
		legendSwordGreenHalf                   = new Texture(Gdx.files.internal("artwork/weapons/sword/LegendSwordGreenHalf.png"));
		legendSwordYellowHalf                  = new Texture(Gdx.files.internal("artwork/weapons/sword/LegendSwordYellowHalf.png"));
		legendSwordOrangeHalf                  = new Texture(Gdx.files.internal("artwork/weapons/sword/LegendSwordOrangeHalf.png"));
		legendSwordPurpleHalf                  = new Texture(Gdx.files.internal("artwork/weapons/sword/LegendSwordPurpleHalf.png"));
		legendSwordPinkHalf                    = new Texture(Gdx.files.internal("artwork/weapons/sword/LegendSwordPinkHalf.png"));
		legendSwordRainbow                     = new Texture(Gdx.files.internal("artwork/weapons/sword/SwordRainbow.png"));
		legendSwordRed                         = new Texture(Gdx.files.internal("artwork/weapons/sword/SwordRed.png"));
		legendSwordBlue                        = new Texture(Gdx.files.internal("artwork/weapons/sword/SwordBlue.png"));
		legendSwordGreen                       = new Texture(Gdx.files.internal("artwork/weapons/sword/SwordGreen.png"));
		legendSwordYellow                      = new Texture(Gdx.files.internal("artwork/weapons/sword/SwordYellow.png"));
		legendSwordOrange                      = new Texture(Gdx.files.internal("artwork/weapons/sword/SwordOrange.png"));
		legendSwordPurple                      = new Texture(Gdx.files.internal("artwork/weapons/sword/SwordPurple.png"));
		legendSwordPink                        = new Texture(Gdx.files.internal("artwork/weapons/sword/SwordPink.png"));
		oyster                                 = new Texture(Gdx.files.internal("artwork/weapons/Oyster.png"));

		// Structure Objects.
		slaveHut                               = new Texture(Gdx.files.internal("artwork/structures/SlaveHut.png"));
		rawbar						           = new Texture(Gdx.files.internal("artwork/structures/RawBar3d.png"));
		lightHouse                             = new Texture(Gdx.files.internal("artwork/structures/LightHouse.png"));
		pigglywiggly                           = new Texture(Gdx.files.internal("artwork/structures/PigglyWiggly3D.png"));
		teePee   					           = new Texture(Gdx.files.internal("artwork/structures/TeePee3D.png"));
		gruntHut 							   = new Texture(Gdx.files.internal("artwork/structures/GruntHut.png"));

		// Effects Objects.
		fireOne                                = new Texture(Gdx.files.internal("artwork/effects/fire/Fire1.png"));
		fireTwo                                = new Texture(Gdx.files.internal("artwork/effects/fire/Fire2.png"));
		fireThree                              = new Texture(Gdx.files.internal("artwork/effects/fire/Fire3.png"));
		fireFour                               = new Texture(Gdx.files.internal("artwork/effects/fire/Fire4.png"));
		fireFive                               = new Texture(Gdx.files.internal("artwork/effects/fire/Fire5.png"));
		fireSix                                = new Texture(Gdx.files.internal("artwork/effects/fire/Fire6.png"));
		fireSeven                              = new Texture(Gdx.files.internal("artwork/effects/fire/Fire7.png"));
		fireEight                              = new Texture(Gdx.files.internal("artwork/effects/fire/Fire8.png"));
		fireNine	                           = new Texture(Gdx.files.internal("artwork/effects/fire/Fire9.png"));
		fireTen                                = new Texture(Gdx.files.internal("artwork/effects/fire/Fire10.png"));
		dustParticleOne                        = new Texture(Gdx.files.internal("artwork/effects/dust/DustParticleOne.png"));
		dustParticleTwo                        = new Texture(Gdx.files.internal("artwork/effects/dust/DustParticleTwo.png"));
		dustParticleThree                      = new Texture(Gdx.files.internal("artwork/effects/dust/DustParticleThree.png"));

		// Cutscene objects.
		cutSceneDialogueOne[0] = new Texture(Gdx.files.internal("artwork/cutscenes/Cutscene_One_Dialogue_One.png"));
		cutSceneDialogueOne[1] = new Texture(Gdx.files.internal("artwork/cutscenes/Cutscene_One_Dialogue_Two.png"));
		cutSceneDialogueOne[2] = new Texture(Gdx.files.internal("artwork/cutscenes/Cutscene_One_Dialogue_Three.png"));
		cutSceneDialogueOne[3] = new Texture(Gdx.files.internal("artwork/cutscenes/Cutscene_One_Dialogue_Four.png"));
		cutSceneDialogueOne[4] = new Texture(Gdx.files.internal("artwork/cutscenes/Cutscene_One_Dialogue_Five.png"));
		cutSceneDialogueOne[5] = new Texture(Gdx.files.internal("artwork/cutscenes/Cutscene_One_Dialogue_Six.png"));
		cutSceneDialogueOne[6] = new Texture(Gdx.files.internal("artwork/cutscenes/Cutscene_One_Dialogue_Seven.png"));
		cutSceneDialogueOne[7] = new Texture(Gdx.files.internal("artwork/cutscenes/Cutscene_One_Dialogue_Eight.png"));
		cutSceneDialogueOne[8] = new Texture(Gdx.files.internal("artwork/cutscenes/Cutscene_One_Dialogue_Nine.png"));

		// Map objects.
		worldMapMexicoBeach					   = new Texture(Gdx.files.internal("artwork/maps/WorldMapMexicoBeach.png"));
		worldMapThePoint					   = new Texture(Gdx.files.internal("artwork/maps/WorldMapThePoint.png"));
		worldMapPortStJoe					   = new Texture(Gdx.files.internal("artwork/maps/WorldMapPortStJoe.png"));
		worldMapCapeSanBlas					   = new Texture(Gdx.files.internal("artwork/maps/WorldMapCapeSanBlas.png"));
		worldMapApalachicola				   = new Texture(Gdx.files.internal("artwork/maps/WorldMapApalachicola.png"));
		worldMapWewa      					   = new Texture(Gdx.files.internal("artwork/maps/WorldMapWewa.png"));
		worldMapStGeorge					   = new Texture(Gdx.files.internal("artwork/maps/WorldMapStGeorge.png"));
		worldMapFake						   = new Texture(Gdx.files.internal("artwork/maps/WorldMapFake_02.png"));
		worldMapReal						   = new Texture(Gdx.files.internal("artwork/maps/WorldMapReal.png"));

		// Mission objects.
		legendOfTheSevenSwordsBeginMissionText = new Texture(Gdx.files.internal("artwork/missions/LegendOfTheSevenSwords.png"));
		missionComplete                        = new Texture(Gdx.files.internal("artwork/missions/MissionComplete.png"));
		missionRawBarInside                    = new Texture(Gdx.files.internal("artwork/missions/RawBarMissionInside.png"));
		missionTransparentBlueSquare           = new Texture(Gdx.files.internal("artwork/missions/TransparentBlueSquare.png"));
		collectOysters                         = new Texture(Gdx.files.internal("artwork/missions/CollectOysters.png"));
		rightHand      						   = new Texture(Gdx.files.internal("artwork/missions/HandOpenRight.png"));
		leftHand      						   = new Texture(Gdx.files.internal("artwork/missions/HandOpenLeft.png"));
		rightHandClosed      				   = new Texture(Gdx.files.internal("artwork/missions/HandClosedRight.png"));
		leftHandClosed      				   = new Texture(Gdx.files.internal("artwork/missions/HandClosedLeft.png"));

		// Tile objects.
		grassTileOne     			           = new Texture(Gdx.files.internal("artwork/tiles/GrassTileOne.png"));
		sandTile                               = new Texture(Gdx.files.internal("artwork/tiles/SandTile2.png"));
		sandTileHorizontalPath                 = new Texture(Gdx.files.internal("artwork/tiles/SandTileHorizontalPath.png"));
		sandTileLeftDownPath                   = new Texture(Gdx.files.internal("artwork/tiles/SandTileLeftDownPath.png"));
		sandTileVerticalPath		           = new Texture(Gdx.files.internal("artwork/tiles/SandTileVerticalPath.png"));
		sandTileTopRightPath	               = new Texture(Gdx.files.internal("artwork/tiles/SandTileTopRightPath.png"));
		sandTileCrossPath                      = new Texture(Gdx.files.internal("artwork/tiles/SandTileCrossPath.png"));
		waterTileOne                           = new Texture(Gdx.files.internal("artwork/tiles/WaterOne.png"));
		waterTileTwo                           = new Texture(Gdx.files.internal("artwork/tiles/WaterTwo.png"));
		waterTileThree				           = new Texture(Gdx.files.internal("artwork/tiles/WaterThree.png"));
		nightTimeShader                        = new Texture(Gdx.files.internal("artwork/tiles/NightTimeShader.png"));

		// UI objects.
		mapNavigationBar                       = new Texture(Gdx.files.internal("artwork/ui/UiMap.png"));
		inventoryNavigationBar                 = new Texture(Gdx.files.internal("artwork/ui/UiInventory.png"));
		inventoryScreen                        = new Texture(Gdx.files.internal("artwork/ui/InventoryScreen.png"));
		inventoryLabel                         = new Texture(Gdx.files.internal("artwork/ui/InventoryLabel.png"));
		locationSkull                          = new Texture(Gdx.files.internal("artwork/ui/Skull.png"));

		// Logo objects.
		splashScreenLogo                       = new Texture(Gdx.files.internal("artwork/logos/logo_ffg.png"));
		titleScreenLogo                        = new Texture(Gdx.files.internal("artwork/logos/GoldenAgeLogo.png"));
		icon                                   = new Texture(Gdx.files.internal("artwork/logos/GoldenAgeIcon.png"));

		// Debugging objects.
		whiteSquare                            = new Texture(Gdx.files.internal("artwork/debugging/WhiteSquare.png"));
	}

	public void dispose() {

		// Game objects.
		chestClosed.dispose();
		chestOpen.dispose();
		heart.dispose();
		boat.dispose();
		sign.dispose();

		// Nature Objects.
		rock.dispose();
		logs.dispose();
		palmTreeThree.dispose();
		palmTree.dispose();
		plant.dispose();
		drSuessTree.dispose();
		light.dispose();
		rain.dispose();
		shadow.dispose();

		// Weapon Objects.
		gunRight.dispose();
		gunLeft.dispose();
		gunUp.dispose();
		gunDown.dispose();
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
		oyster.dispose();

		// Structure objects.
		slaveHut.dispose();
		teePee.dispose();
		rawbar.dispose();
		lightHouse.dispose();
		pigglywiggly.dispose();
		gruntHut.dispose();

		// Effects Objects.
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
		dustParticleOne.dispose();
		dustParticleTwo.dispose();
		dustParticleThree.dispose();

		// Cutscene objects.
		for(int i = 0; i < cutSceneDialogueOne.length; i++) {
			cutSceneDialogueOne[i].dispose();
		}

		// Map objects.
		worldMapMexicoBeach.dispose();
		worldMapStGeorge.dispose();
		worldMapApalachicola.dispose();
		worldMapThePoint.dispose();
		worldMapCapeSanBlas.dispose();
		worldMapWewa.dispose();
		worldMapPortStJoe.dispose();
		worldMapFake.dispose();
		worldMapReal.dispose();

		// Mission objects.
		legendOfTheSevenSwordsBeginMissionText.dispose();
		missionComplete.dispose();
		missionRawBarInside.dispose();
		missionTransparentBlueSquare.dispose();
		collectOysters.dispose();
		rightHand.dispose();
		leftHand.dispose();
		rightHandClosed.dispose();
		leftHandClosed.dispose();

		// Tile objects.
		grassTileOne.dispose();
		sandTile.dispose();
		sandTileHorizontalPath.dispose();
		sandTileLeftDownPath.dispose();
		sandTileVerticalPath.dispose();
		sandTileTopRightPath.dispose();
		sandTileCrossPath.dispose();
		waterTileOne.dispose();
		waterTileTwo.dispose();
		waterTileThree.dispose();
		nightTimeShader.dispose();

		// UI objects.
		mapNavigationBar.dispose();
		inventoryNavigationBar.dispose();
		inventoryScreen.dispose();
		inventoryLabel.dispose();
		locationSkull.dispose();

		// Logo objects.
		splashScreenLogo.dispose();
		titleScreenLogo.dispose();
		icon.dispose();

		// Debugging objects.
		whiteSquare.dispose();
	}
}
