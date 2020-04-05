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
	public Texture heartShadow;
	public Texture boat;
	public Texture rum;

	// Sign objects.
	public Texture sign;
	public Texture[] townSigns = new Texture[7];

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
	public Texture cloud;
	public Texture stump;
	public Texture sky;
	public Texture feather;
	public Texture quickSand;

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
	public Texture cannonBall;
	public Texture cannonLeft;
	public Texture cannonRight;

	// Structure Objects.
	public Texture teePee;
	public Texture rawbar;
	public Texture lightHouse;
	public Texture pigglywiggly;
	public Texture slaveHut;
	public Texture gruntHut;
	public Texture dockLeft;
	public Texture dockRight;
	public Texture tradingPost;

	// Effects Objects.
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
	public Texture missionTransparentBlueSquare;
	public Texture rightHand;
	public Texture leftHand;
	public Texture rightHandClosed;
	public Texture leftHandClosed;
	public Texture fishLeft;
	public Texture fishRight;
	public Texture playerRight;
	public Texture playerLeft;

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
	public Texture attackBird;
	public Texture objectiveRawBar;
	public Texture objectiveStumpHole;
	public Texture objectiveTradinPost;
	public Texture objectiveCollectLoot;
	public Texture objectiveCollectOysters;
	public Texture objectiveCollectFeathers;
	public Texture objectiveBuyTheGun;

	// Player name UI labels.
	public Texture jollyRogerUiNameLabel;
	public Texture blackBeardUiNameLabel;
	public Texture pegLegUiNameLabel;

	// Logo objects.
	public Texture splashScreenLogo;
	public Texture titleScreenLogo;
	public Texture icon;

	// Debugging objects.
	public Texture whiteSquare;
	public Texture blackSquare;

	// Character objects.
	public Texture knightLeft;
	public Texture knightRight;

	// Number objects.
	public Texture[] number = new Texture[10];

	public void init() {

		// Game objects.
		chestClosed = new Texture(Gdx.files.internal("artwork/Chest.png"));
		chestOpen   = new Texture(Gdx.files.internal("artwork/ChestOpen.png"));
		heart       = new Texture(Gdx.files.internal("artwork/Heart.png"));
		heartShadow = new Texture(Gdx.files.internal("artwork/HeartShadow.png"));
		boat        = new Texture(Gdx.files.internal("artwork/BOAT_NEW.png"));
		rum         = new Texture(Gdx.files.internal("artwork/Rum_Alternate.png"));

		// Nature Objects.
		rock 		  = new Texture(Gdx.files.internal("artwork/nature/Rock.png"));
		logs          = new Texture(Gdx.files.internal("artwork/nature/Logs.png"));
		palmTreeThree = new Texture(Gdx.files.internal("artwork/nature/PalmTreeOneAlternate_April2020.png"));
		palmTree      = new Texture(Gdx.files.internal("artwork/nature/PalmTreeOne_April2020.png"));
		plant         = new Texture(Gdx.files.internal("artwork/nature/PlantApril2020.png"));
		drSuessTree   = new Texture(Gdx.files.internal("artwork/nature/DrSuessTree2020.png"));
		light         = new Texture(Gdx.files.internal("artwork/nature/Lighting.png"));
		rain 		  = new Texture(Gdx.files.internal("artwork/nature/Rain.png"));
		shadow        = new Texture(Gdx.files.internal("artwork/nature/Shadow.png"));
		cloud         = new Texture(Gdx.files.internal("artwork/nature/Cloud.png"));
		stump         = new Texture(Gdx.files.internal("artwork/nature/Stump.png"));
		sky           = new Texture(Gdx.files.internal("artwork/nature/Sky.png"));
		feather       = new Texture(Gdx.files.internal("artwork/nature/Feather.png"));
		quickSand     = new Texture(Gdx.files.internal("artwork/nature/QuickSand.png"));

		// Weapon Objects.
		gunRight   			  = new Texture(Gdx.files.internal("artwork/weapons/gun/Right.png"));
		gunLeft               = new Texture(Gdx.files.internal("artwork/weapons/gun/Left.png"));
		gunUp                 = new Texture(Gdx.files.internal("artwork/weapons/gun/Up.png"));
		gunDown               = new Texture(Gdx.files.internal("artwork/weapons/gun/Down.png"));
		legendSwordRedHalf    = new Texture(Gdx.files.internal("artwork/weapons/sword/LegendSwordRedHalf.png"));
		legendSwordBlueHalf   = new Texture(Gdx.files.internal("artwork/weapons/sword/LegendSwordBlueHalf.png"));
		legendSwordGreenHalf  = new Texture(Gdx.files.internal("artwork/weapons/sword/LegendSwordGreenHalf.png"));
		legendSwordYellowHalf = new Texture(Gdx.files.internal("artwork/weapons/sword/LegendSwordYellowHalf.png"));
		legendSwordOrangeHalf = new Texture(Gdx.files.internal("artwork/weapons/sword/LegendSwordOrangeHalf.png"));
		legendSwordPurpleHalf = new Texture(Gdx.files.internal("artwork/weapons/sword/LegendSwordPurpleHalf.png"));
		legendSwordPinkHalf   = new Texture(Gdx.files.internal("artwork/weapons/sword/LegendSwordPinkHalf.png"));
		legendSwordRainbow    = new Texture(Gdx.files.internal("artwork/weapons/sword/SwordRainbow.png"));
		legendSwordRed        = new Texture(Gdx.files.internal("artwork/weapons/sword/SwordRed.png"));
		legendSwordBlue       = new Texture(Gdx.files.internal("artwork/weapons/sword/SwordBlue.png"));
		legendSwordGreen      = new Texture(Gdx.files.internal("artwork/weapons/sword/SwordGreen.png"));
		legendSwordYellow     = new Texture(Gdx.files.internal("artwork/weapons/sword/SwordYellow.png"));
		legendSwordOrange     = new Texture(Gdx.files.internal("artwork/weapons/sword/SwordOrange.png"));
		legendSwordPurple     = new Texture(Gdx.files.internal("artwork/weapons/sword/SwordPurple.png"));
		legendSwordPink       = new Texture(Gdx.files.internal("artwork/weapons/sword/SwordPink.png"));
		oyster                = new Texture(Gdx.files.internal("artwork/weapons/Oyster.png"));
		cannonBall            = new Texture(Gdx.files.internal("artwork/weapons/cannon/CannonBall.png"));
		cannonLeft            = new Texture(Gdx.files.internal("artwork/weapons/cannon/CannonLeft.png"));
		cannonRight           = new Texture(Gdx.files.internal("artwork/weapons/cannon/CannonRight.png"));

		// Structure Objects.
		slaveHut     = new Texture(Gdx.files.internal("artwork/structures/SlaveHut.png"));
		rawbar		 = new Texture(Gdx.files.internal("artwork/structures/RawBar3d.png"));
		lightHouse   = new Texture(Gdx.files.internal("artwork/structures/LightHouse.png"));
		pigglywiggly = new Texture(Gdx.files.internal("artwork/structures/PigglyWiggly3D.png"));
		teePee   	 = new Texture(Gdx.files.internal("artwork/structures/TeePee3D.png"));
		gruntHut     = new Texture(Gdx.files.internal("artwork/structures/GruntHut.png"));
		dockLeft   	 = new Texture(Gdx.files.internal("artwork/structures/DockLeft.png"));
		dockRight    = new Texture(Gdx.files.internal("artwork/structures/DockRight.png"));
		tradingPost  = new Texture(Gdx.files.internal("artwork/structures/TradingPost3d.png"));

		// Effects Objects.
		dustParticleOne   = new Texture(Gdx.files.internal("artwork/effects/dust/DustParticleOne.png"));
		dustParticleTwo   = new Texture(Gdx.files.internal("artwork/effects/dust/DustParticleTwo.png"));
		dustParticleThree = new Texture(Gdx.files.internal("artwork/effects/dust/DustParticleThree.png"));

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
		worldMapMexicoBeach  = new Texture(Gdx.files.internal("artwork/maps/WorldMapMexicoBeach.png"));
		worldMapThePoint	 = new Texture(Gdx.files.internal("artwork/maps/WorldMapThePoint.png"));
		worldMapPortStJoe	 = new Texture(Gdx.files.internal("artwork/maps/WorldMapPortStJoe.png"));
		worldMapCapeSanBlas	 = new Texture(Gdx.files.internal("artwork/maps/WorldMapCapeSanBlas.png"));
		worldMapApalachicola = new Texture(Gdx.files.internal("artwork/maps/WorldMapApalachicola.png"));
		worldMapWewa      	 = new Texture(Gdx.files.internal("artwork/maps/WorldMapWewa.png"));
		worldMapStGeorge     = new Texture(Gdx.files.internal("artwork/maps/WorldMapStGeorge.png"));
		worldMapFake		 = new Texture(Gdx.files.internal("artwork/maps/WorldMapFake_02.png"));
		worldMapReal		 = new Texture(Gdx.files.internal("artwork/maps/WorldMapReal.png"));

		// Mission objects.
		legendOfTheSevenSwordsBeginMissionText = new Texture(Gdx.files.internal("artwork/missions/LegendOfTheSevenSwords.png"));
		missionTransparentBlueSquare           = new Texture(Gdx.files.internal("artwork/missions/TransparentBlueSquare.png"));
		rightHand      						   = new Texture(Gdx.files.internal("artwork/missions/HandOpenRight.png"));
		leftHand      						   = new Texture(Gdx.files.internal("artwork/missions/HandOpenLeft.png"));
		rightHandClosed      				   = new Texture(Gdx.files.internal("artwork/missions/HandClosedRight.png"));
		leftHandClosed      				   = new Texture(Gdx.files.internal("artwork/missions/HandClosedLeft.png"));
		fishLeft                               = new Texture(Gdx.files.internal("artwork/missions/fishLeft.png"));
		fishRight                              = new Texture(Gdx.files.internal("artwork/missions/fishRight.png"));
		playerLeft                             = new Texture(Gdx.files.internal("artwork/gamecharacters/player/PlayerLeft.png"));
		playerRight                            = new Texture(Gdx.files.internal("artwork/gamecharacters/player/PlayerRight.png"));

		// Tile objects.
		grassTileOne     	   = new Texture(Gdx.files.internal("artwork/tiles/GrassTileOne.png"));
		sandTile               = new Texture(Gdx.files.internal("artwork/tiles/SandTile2.png"));
		sandTileHorizontalPath = new Texture(Gdx.files.internal("artwork/tiles/SandTileHorizontalPath.png"));
		sandTileLeftDownPath   = new Texture(Gdx.files.internal("artwork/tiles/SandTileLeftDownPath.png"));
		sandTileVerticalPath   = new Texture(Gdx.files.internal("artwork/tiles/SandTileVerticalPath.png"));
		sandTileTopRightPath   = new Texture(Gdx.files.internal("artwork/tiles/SandTileTopRightPath.png"));
		sandTileCrossPath      = new Texture(Gdx.files.internal("artwork/tiles/SandTileCrossPath.png"));
		waterTileOne           = new Texture(Gdx.files.internal("artwork/tiles/WaterOne.png"));
		waterTileTwo           = new Texture(Gdx.files.internal("artwork/tiles/WaterTwo.png"));
		waterTileThree		   = new Texture(Gdx.files.internal("artwork/tiles/WaterThree.png"));
		nightTimeShader        = new Texture(Gdx.files.internal("artwork/tiles/NightTimeShader.png"));

		// UI objects.
		mapNavigationBar         = new Texture(Gdx.files.internal("artwork/ui/UiMap.png"));
		inventoryNavigationBar   = new Texture(Gdx.files.internal("artwork/ui/UiInventory.png"));
		inventoryScreen          = new Texture(Gdx.files.internal("artwork/ui/InventoryScreen.png"));
		inventoryLabel           = new Texture(Gdx.files.internal("artwork/ui/InventoryLabel.png"));
		locationSkull            = new Texture(Gdx.files.internal("artwork/ui/Skull.png"));
		attackBird               = new Texture(Gdx.files.internal("artwork/ui/AttackBird.png"));
		objectiveRawBar          = new Texture(Gdx.files.internal("artwork/ui/objectives/RawBar.png"));
		objectiveStumpHole       = new Texture(Gdx.files.internal("artwork/ui/objectives/StumpHole.png"));
		objectiveCollectLoot     = new Texture(Gdx.files.internal("artwork/ui/objectives/CollectLoot.png"));
		objectiveTradinPost      = new Texture(Gdx.files.internal("artwork/ui/objectives/TradinPost.png"));
		objectiveCollectOysters  = new Texture(Gdx.files.internal("artwork/ui/objectives/CollectOysters.png"));
		objectiveCollectFeathers = new Texture(Gdx.files.internal("artwork/ui/objectives/CollectFeathers.png"));
		objectiveBuyTheGun       = new Texture(Gdx.files.internal("artwork/ui/objectives/BuyTheGun.png"));

		// Player name UI labels.
		jollyRogerUiNameLabel = new Texture(Gdx.files.internal("artwork/ui/playernames/JollyRoger.png"));
		blackBeardUiNameLabel = new Texture(Gdx.files.internal("artwork/ui/playernames/BlackBeard.png"));
		pegLegUiNameLabel     = new Texture(Gdx.files.internal("artwork/ui/playernames/PegLeg.png"));

		// Logo objects.
		splashScreenLogo = new Texture(Gdx.files.internal("artwork/logos/logo_ffg.png"));
		titleScreenLogo  = new Texture(Gdx.files.internal("artwork/logos/GoldenAgeLogo.png"));
		icon             = new Texture(Gdx.files.internal("artwork/logos/GoldenAgeIcon.png"));

		// Sign objects.  sign can be removed.
		sign         = new Texture(Gdx.files.internal("artwork/signs/Sign.png"));
		townSigns[0] = new Texture(Gdx.files.internal("artwork/signs/Apalachicola.png"));
		townSigns[1] = new Texture(Gdx.files.internal("artwork/signs/PortStJoe.png"));
		townSigns[2] = new Texture(Gdx.files.internal("artwork/signs/Wewa.png"));
		townSigns[3] = new Texture(Gdx.files.internal("artwork/signs/MexicoBeach.png"));
		townSigns[4] = new Texture(Gdx.files.internal("artwork/signs/StGeorge.png"));
		townSigns[5] = new Texture(Gdx.files.internal("artwork/signs/CapeSanBlas.png"));
		townSigns[6] = new Texture(Gdx.files.internal("artwork/signs/ThePoint.png"));

		// Debugging objects.
		whiteSquare = new Texture(Gdx.files.internal("artwork/debugging/WhiteSquare.png"));
		blackSquare = new Texture(Gdx.files.internal("artwork/debugging/BlackSquare.png"));

		// Character objects.
		knightLeft  = new Texture(Gdx.files.internal("artwork/gamecharacters/knight/KnightLeft.png"));
		knightRight = new Texture(Gdx.files.internal("artwork/gamecharacters/knight/KnightRight.png"));

		// Number objects.
		number[0] = new Texture(Gdx.files.internal("artwork/numbers/0.png"));
		number[1] = new Texture(Gdx.files.internal("artwork/numbers/1.png"));
		number[2] = new Texture(Gdx.files.internal("artwork/numbers/2.png"));
		number[3] = new Texture(Gdx.files.internal("artwork/numbers/3.png"));
		number[4] = new Texture(Gdx.files.internal("artwork/numbers/4.png"));
		number[5] = new Texture(Gdx.files.internal("artwork/numbers/5.png"));
		number[6] = new Texture(Gdx.files.internal("artwork/numbers/6.png"));
		number[7] = new Texture(Gdx.files.internal("artwork/numbers/7.png"));
		number[8] = new Texture(Gdx.files.internal("artwork/numbers/8.png"));
		number[9] = new Texture(Gdx.files.internal("artwork/numbers/9.png"));
	}

	public void dispose() {

		// Game objects.
		chestClosed.dispose();
		chestOpen.dispose();
		heart.dispose();
		heartShadow.dispose();
		boat.dispose();
		rum.dispose();

		// Sign objects.
		sign.dispose();
		for (int i = 0; i < townSigns.length; i++) {
			townSigns[i].dispose();
		}

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
		cloud.dispose();
		stump.dispose();
		sky.dispose();
		feather.dispose();
		quickSand.dispose();

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
		cannonBall.dispose();
		cannonLeft.dispose();
		cannonRight.dispose();

		// Structure objects.
		slaveHut.dispose();
		teePee.dispose();
		rawbar.dispose();
		lightHouse.dispose();
		pigglywiggly.dispose();
		gruntHut.dispose();
		dockRight.dispose();
		dockLeft.dispose();
		tradingPost.dispose();

		// Effects Objects.
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
		missionTransparentBlueSquare.dispose();
		rightHand.dispose();
		leftHand.dispose();
		rightHandClosed.dispose();
		leftHandClosed.dispose();
		fishLeft.dispose();
		fishRight.dispose();
		playerRight.dispose();
		playerLeft.dispose();

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
		attackBird.dispose();
		objectiveRawBar.dispose();
		objectiveStumpHole.dispose();
		objectiveCollectLoot.dispose();
		objectiveTradinPost.dispose();
		objectiveCollectOysters.dispose();
		objectiveCollectFeathers.dispose();
		objectiveBuyTheGun.dispose();

		// Player name UI labels.
		jollyRogerUiNameLabel.dispose();
		blackBeardUiNameLabel.dispose();
		pegLegUiNameLabel.dispose();

		// Logo objects.
		splashScreenLogo.dispose();
		titleScreenLogo.dispose();
		icon.dispose();

		// Debugging objects.
		whiteSquare.dispose();
		blackSquare.dispose();

		// Character objects.
		knightLeft.dispose();
		knightRight.dispose();

		// Number objects.
		for (int i = 0; i < number.length; i++) {
			number[i].dispose();
		}
	}
}
