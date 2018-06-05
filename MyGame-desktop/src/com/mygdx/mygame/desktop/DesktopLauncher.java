package com.mygdx.mygame.desktop;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.mygame.MyGame;

/**
 * Launch game on desktop.
 * 
 * @author Fabulous Fellini
 *
 */
public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.addIcon("GrassTileOne.png", FileType.Internal);
		float f       = 0.5f;
		float width   = LwjglApplicationConfiguration.getDesktopDisplayMode().width;
		float height  = LwjglApplicationConfiguration.getDesktopDisplayMode().height;
		config.width  = (int)(width * f);
		config.height = (int)(height * f);
		new LwjglApplication(new MyGame(), config);
	}
}
