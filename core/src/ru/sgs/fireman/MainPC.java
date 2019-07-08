package ru.sgs.fireman;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.sgs.fireman.Menu.MainMenu;
import ru.sgs.fireman.utlis.Version;

public class MainPC extends Game {
	private final static boolean debug = true;

	private Version version;

	private SpriteBatch batch;

	MainMenu menu;
	
	@Override
	public void create () {
		version = new Version();
		batch = new SpriteBatch();
		menu = new MainMenu(batch, true);

		System.out.println(version.getSubversion() + " v." + version.getVersion());

		if (debug)
			version.writeVersion();

		setScreen(menu);
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
