package ru.sgs.fireman;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import ru.sgs.fireman.Game.MainGame;
import ru.sgs.fireman.Menu.MainMenu;

public class MainAndroid extends Game {
    private SpriteBatch batch;
    private ShapeRenderer shape;

    MainMenu menu;
    MainGame game;

    @Override
    public void create () {
        batch = new SpriteBatch();
        shape = new ShapeRenderer();

        menu = new MainMenu(this, batch, false);
        game = new MainGame(this, batch, false);


        setScreen(game);
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