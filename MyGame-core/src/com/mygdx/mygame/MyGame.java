package com.mygdx.mygame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import factories.GameObjectFactory;
import gameobjects.GameObject;
import handlers.AudioHandler;
import handlers.InputHandler;
import helpers.GameAttributeHelper;
import loaders.GameObjectLoader;
import loaders.ImageLoader;
import render.Render;
import screens.GameScreen;

/**
 * Main game class.
 * 
 * @author Fabulous Fellini
 *
 */
public class MyGame extends Game {

	/**
	 * Game renderer.
	 */
	public Render renderer = new Render();

	/**
	 * Factory for creating game objects.
	 */
	public GameObjectFactory gameObjectFactory = new GameObjectFactory();

	/**
	 * Creates and initializes game objects.
	 */
	public GameObjectLoader gameObjectLoader = new GameObjectLoader();

	/**
	 * Holds game attributes such as screen size, game state, etc.
	 */
	public GameAttributeHelper gameAttributeHelper;

	private AudioHandler audioHandler = new AudioHandler();

	/**
	 * Loads and holds all images.
	 */
	public ImageLoader imageLoader = new ImageLoader();

	/**
	 * Computer or a game pad handler.
	 */
	public InputHandler inputHandler = new InputHandler();

	public GameScreen gameScreen;

	/**
	 * 
	 * @return GameScreen
	 */
	public GameScreen getGameScreen() {
		return gameScreen;
	}

	@Override
	public void create () {
		Gdx.graphics.setContinuousRendering(true);
		Gdx.graphics.setResizable(false);
		imageLoader.init();
		renderer.init();
		gameObjectLoader.createObjects(this);
		audioHandler.init();
		inputHandler.init();
		gameAttributeHelper = new GameAttributeHelper();
		gameScreen          = new GameScreen(this);
		this.setScreen(gameScreen);
	}

	@Override
	public void render () {
		super.render();
		gameLoop();
		//System.out.println("Game State: " + GameAttributeHelper.gameState);
	}

	@Override
	public void dispose () {
		renderer.dispose();
		imageLoader.dispose(); 
		audioHandler.dispose();
	}

	/**
	 * 30 FPS.
	 */
	private void gameLoop() {
		inputHandler.handleInput(this);
		audioHandler.handleAudio(this);
		//System.out.println("Frames Per Second: " + Gdx.graphics.getFramesPerSecond());
	}

	/**
	 * 
	 * @param int object
	 * @return GameObject
	 */
	public GameObject getGameObject(int object) {
		GameObject desiredObject = null;
		switch (object) {
		case GameObject.PLAYER_ONE:
			desiredObject = gameObjectLoader.playerOne;
			break;
		case GameObject.PLAYER_TWO:
			desiredObject = gameObjectLoader.playerTwo;
			break;
		case GameObject.PLAYER_THREE:
			desiredObject = gameObjectLoader.playerThree;
			break;
		}
		return desiredObject;
	}
}
