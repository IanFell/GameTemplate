package com.mygdx.mygame;

import com.badlogic.gdx.Game;

import factories.GameObjectFactory;
import handlers.AudioHandler;
import handlers.InputHandler;
import helpers.GameAttributeHelper;
import loaders.GameObjectLoader;
import loaders.ImageLoader;
import render.Render;
import screens.SplashScreen;

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

	@Override
	public void create () {
		imageLoader.init();
		renderer.init();
		gameObjectLoader.createObjects(this);
		audioHandler.init();
		inputHandler.init();
		gameAttributeHelper = new GameAttributeHelper();
		this.setScreen(new SplashScreen(this));
	}

	@Override
	public void render () {
		super.render();
		gameLoop();
	}

	@Override
	public void dispose () {
		renderer.dispose();
		imageLoader.dispose(); 
		audioHandler.dispose();
	}

	/**
	 * 60 FPS by default.
	 */
	private void gameLoop() {
		audioHandler.handleAudio();
		inputHandler.handleInput(this);
	}
}
