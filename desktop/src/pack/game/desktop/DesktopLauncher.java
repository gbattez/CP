package pack.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import pack.game.RenderUtils;
import pack.game.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = RenderUtils.V_WIDTH/2;
		config.height = RenderUtils.V_HEIGHT/2;
		new LwjglApplication(new Main(), config);
	}
}
