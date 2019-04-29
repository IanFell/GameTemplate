package gameobjects.stationarygameobjects.buildings;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.mygame.MyGame;

import maps.MapHandler;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TeePee extends Building {

	private String name;

	/**
	 * Constructor.
	 * 
	 * @param int     x
	 * @param int     y
	 * @param int     width
	 * @param int     height
	 * @param Texture texture
	 */
	public TeePee(int x, int y, int width, int height, Texture texture, String name) {
		super(x, y, width, height, texture);
		this.name = name;
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		super.updateObject(myGame, mapHandler);
		/*
		CollisionHandler.checkIfPlayerHasCollidedWithStructure(
				myGame.getGameObject(GameObject.PLAYER_ONE),
				this,
				"Tee Pee",
				myGame
				);
				*/
	}
}
