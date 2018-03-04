package input.computer;

import com.badlogic.gdx.ApplicationListener;
import com.mygdx.mygame.MyGame;

/**
 * Parent class to handle keyboard and mouse input.
 * 
 * @author Fabulous Fellini
 *
 */
abstract public class ComputerInput implements ApplicationListener {
	
	/**
	 * Abstract method to handle computer input.  This method is overriden
	 * in Keyboard and Mouse input classes.
	 * 
	 * @param MyGame myGame
	 */
	protected abstract void handleInput(MyGame myGame);

	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}
