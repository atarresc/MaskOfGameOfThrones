package net.infobosccoma.JocDeTrons;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

        config.title = "Joc de Trons";
        config.width = 600;
        config.height = 320;

        new LwjglApplication(new net.infobosccoma.JocDeTrons.JocDeTrons("Joc de Trons"), config);
	}
}
