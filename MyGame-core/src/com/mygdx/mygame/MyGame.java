package com.mygdx.mygame;

import com.badlogic.gdx.Game;

import factories.GameObjectFactory;
import factories.TileFactory;
import handlers.AudioHandler;
import handlers.InputHandler;
import helpers.GameAttributeHelper;
import loaders.GameObjectLoader;
import loaders.ImageLoader;
import loaders.TileLoader;
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
	 * Factory for our game objects.
	 */
	public GameObjectFactory gameObjectFactory = new GameObjectFactory();
	
	/**
	 * Factory for our tiles.
	 */
	public TileFactory tileFactory = new TileFactory();
	
	/**
	 * Creates and initializes our game objects.
	 */
	public GameObjectLoader gameObjectLoader = new GameObjectLoader();
	
	/**
	 * Creates and initializes tiles.
	 */
	public TileLoader tileLoader = new TileLoader();
	
	/**
	 * Holds game attributes such as screen size, game state, etc.
	 */
	public GameAttributeHelper gameAttributeHelper = new GameAttributeHelper();
	
	/**
	 * Handles audio.
	 */
	private AudioHandler audioHandler = new AudioHandler();
	
	/**
	 * Class to hold all of our images.
	 */
	public ImageLoader imageLoader = new ImageLoader();
	
	/**
	 * Handles all game input, whether that is the computer or a game pad.
	 */
	public InputHandler inputHandler = new InputHandler();
	
	@Override
	public void create () {
		imageLoader.init();
		renderer.init();
		gameObjectLoader.createObjects(this);
		gameObjectLoader.init(imageLoader);
		audioHandler.init();
		inputHandler.init();
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
	 * Main game loop.  
	 * Right now it is called 60 frames per second.
	 */
	private void gameLoop() {
		audioHandler.handleAudio();
		inputHandler.handleInput(this);
	}
}
