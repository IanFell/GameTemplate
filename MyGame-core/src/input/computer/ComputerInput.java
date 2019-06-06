package input.computer;

import com.badlogic.gdx.ApplicationListener;
import com.mygdx.mygame.MyGame;

import input.Input;

/**
 * Parent class to handle keyboard and mouse input.
 * 
 * @author Fabulous Fellini
 *
 */
abstract public class ComputerInput extends Input implements ApplicationListener {

	/**
	 * Abstract method to handle computer input.  This method is overriden
	 * in Keyboard and Mouse input classes.
	 * 
	 * @param MyGame myGame
	 */
	protected abstract void handleInput(MyGame myGame);

	@Override
	public void create() {}

	@Override
	public void resize(int width, int height) {}

	@Override
	public void render() {}

	@Override
	public void pause() {}

	@Override
	public void resume() {}

	@Override
	public void dispose() {}
}
