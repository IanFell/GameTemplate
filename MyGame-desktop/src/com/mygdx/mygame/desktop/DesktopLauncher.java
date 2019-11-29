package com.mygdx.mygame.desktop;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.mygame.MyGame;

import helpers.GameAttributeHelper;

/**
 * Launch game on desktop.
 * 
 * @author Fabulous Fellini
 *
 */
public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.addIcon("artwork/logos/GoldenAgeIcon.png", FileType.Internal);
		config.title         = "The Golden Age: Legend of the Seven Swords";
		config.foregroundFPS = GameAttributeHelper.FRAMES_PER_SECOND;

		// Full screen.
		float f       = 1.0f;
		// Phone screen.
		//float f       = 0.5f;

		float width   = LwjglApplicationConfiguration.getDesktopDisplayMode().width;
		float height  = LwjglApplicationConfiguration.getDesktopDisplayMode().height;
		config.width  = (int)(width * f);
		config.height = (int)(height * f);
		new LwjglApplication(new MyGame(), config);
	}
}
