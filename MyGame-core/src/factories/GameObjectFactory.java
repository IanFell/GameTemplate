package factories;

import gameobjects.GameObject;
import gameobjects.gamecharacters.Player;
import gameobjects.gamecharacters.PlayerOne;
import gameobjects.gamecharacters.PlayerThree;
import gameobjects.gamecharacters.PlayerTwo;
import gameobjects.stationarygameobjects.Chest;
import gameobjects.stationarygameobjects.buildings.LightHouse;
import gameobjects.stationarygameobjects.buildings.PigglyWiggly;
import gameobjects.stationarygameobjects.buildings.RawBar;
import gameobjects.stationarygameobjects.buildings.TeePee;
import gameobjects.nature.trees.DrSuessTree;
import gameobjects.nature.trees.PalmTree;
import gameobjects.nature.trees.Plant;

/**
 * Factory to create our game objects.
 * 
 * @author Fabulous Fellini
 *
 */
public class GameObjectFactory {

	/**
	 * Creates our game objects.
	 * 
	 * @param string  objectType
	 * @return GameObject
	 */
	public GameObject getObject(String objectType, int x, int y) {
		if (objectType == null) {
			return null;
		}
		if (objectType.equalsIgnoreCase("playerOne")) {
			return new PlayerOne("Jolly Roger", null, Player.PLAYER_ONE);
		}
		if (objectType.equalsIgnoreCase("playerTwo")) {
			return new PlayerTwo("Black Beard", null, Player.PLAYER_TWO);
		}
		if (objectType.equalsIgnoreCase("playerThree")) {
			return new PlayerThree("Peg Leg", null, Player.PLAYER_THREE);
		}
		if (objectType.equalsIgnoreCase("tree")) {
			return new PalmTree(x, y);
		}
		if (objectType.equalsIgnoreCase("drSuessTree")) {
			return new DrSuessTree(x, y);
		}
		if (objectType.equalsIgnoreCase("plant")) {
			return new Plant(x, y);
		}
		if (objectType.equalsIgnoreCase("chest")) {
			return new Chest(5, 5);
		}
		if (objectType.equalsIgnoreCase("teepee")) {
			return new TeePee(0, 0, 0, 0, null, null);
		}
		if (objectType.equalsIgnoreCase("rawbar")) {
			return new RawBar(0, 0, 0, 0, null);
		}
		if (objectType.equalsIgnoreCase("pigglywiggly")) {
			return new PigglyWiggly(0, 0, 0, 0, null);
		}
		if (objectType.equalsIgnoreCase("lighthouse")) {
			return new LightHouse(0, 0, 0, 0, null);
		}
		return null;
	}
}
