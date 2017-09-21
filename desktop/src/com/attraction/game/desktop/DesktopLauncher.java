package com.attraction.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.attraction.game.Attraction;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title  = "Attraction";
		config.width  = 400;
		config.height = 600;
		new LwjglApplication(new Attraction(), config);
	}
}
