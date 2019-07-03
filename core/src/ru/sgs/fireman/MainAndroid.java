package ru.sgs.fireman;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.sgs.fireman.Menu.MainMenu;

public class MainAndroid extends Game {
    private SpriteBatch batch;

    MainMenu menu;

    @Override
    public void create () {
        batch = new SpriteBatch();

        menu = new MainMenu(batch, false);

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