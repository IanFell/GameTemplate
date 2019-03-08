package factories;

import gameobjects.GameObject;
import gameobjects.gamecharacters.PlayerOne;
import gameobjects.gamecharacters.PlayerThree;
import gameobjects.gamecharacters.PlayerTwo;
import gameobjects.stationarygameobjects.Chest;
import gameobjects.stationarygameobjects.RawBar;
import gameobjects.stationarygameobjects.TeePee;
import gameobjects.stationarygameobjects.treeobjects.PalmTree;
import gameobjects.stationarygameobjects.treeobjects.Plant;

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
			return new PlayerOne("Blackbeard");
		}
		if (objectType.equalsIgnoreCase("playerTwo")) {
			return new PlayerTwo("Jolly Roger");
		}
		if (objectType.equalsIgnoreCase("playerThree")) {
			return new PlayerThree("Peg Leg");
		}
		if (objectType.equalsIgnoreCase("tree")) {
			return new PalmTree(x, y);
		}
		if (objectType.equalsIgnoreCase("plant")) {
			return new Plant(x, y);
		}
		if (objectType.equalsIgnoreCase("chest")) {
			return new Chest(5, 5);
		}
		if (objectType.equalsIgnoreCase("teepee")) {
			return new TeePee(0, 0, null);
		}
		if (objectType.equalsIgnoreCase("rawbar")) {
			return new RawBar(0, 0);
		}
		return null;
	}
}
