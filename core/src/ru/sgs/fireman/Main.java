package ru.sgs.fireman;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.sgs.fireman.Menu.MainMenu;

public class Main extends Game {
	private SpriteBatch batch;

	MainMenu menu;
	
	@Override
	public void create () {
		batch = new SpriteBatch();

		menu = new MainMenu(batch);

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
