package ru.sgs.fireman.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.sgs.fireman.Game.Handler.AndroidHandler;
import ru.sgs.fireman.Game.objs.Player;
import ru.sgs.fireman.Game.objs.RailwayCarrige;
import ru.sgs.fireman.MainAndroid;
import ru.sgs.fireman.MainPC;
import ru.sgs.fireman.Render;

public class MainGame implements Screen {

    private SpriteBatch batch;

    private boolean devise;

    private MainAndroid mainAndroid;
    private MainPC mainPC;

    private Render render;

    private AndroidHandler androidHandler;

    private RailwayCarrige[] railwayCarrige = new RailwayCarrige[5];
    private Player playe;


    private static final int speedMoved = 15;

    public MainGame(MainPC mainPC, SpriteBatch batch, boolean devise){
        this.mainPC = mainPC;

        init(batch, devise);
    }

    public MainGame(MainAndroid mainAndroid, SpriteBatch batch, boolean devise){
        this.mainAndroid = mainAndroid;

        init(batch, devise);
    }

    private void init(SpriteBatch batch, boolean devise) {
        this.batch = batch;
        this.devise = devise;

        render = new Render();
        androidHandler = new AndroidHandler();

        playe = new Player(30, 50, 0, 26);

        for (int i = 0; i < railwayCarrige.length; i++)
            railwayCarrige[i] = new RailwayCarrige(650, 325, i*660, 25, Color.BLACK);
    }

    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        //Фон
        render.renderBG(batch, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        for (int i = 0; i < railwayCarrige.length; i++)
            railwayCarrige[i].renderer();

        playe.renderer();

        //Кнопки
        render.renderButtons();



        //Обработка кнопок ходьбы
        if (AndroidHandler.getPressed()[2])
            for (int i = 0; i < railwayCarrige.length; i++)
                railwayCarrige[i].setX(railwayCarrige[i].getX()-speedMoved);
        if (AndroidHandler.getPressed()[3])
            for (int i = 0; i < railwayCarrige.length; i++)
                railwayCarrige[i].setX(railwayCarrige[i].getX()+speedMoved);
    }

    @Override
    public void dispose(){
        render.dispose();

    }

    @Override
    public void pause(){

    }

    @Override
    public void show(){
        if (!devise)
            androidHandler.setInputProcessor();
    }

    @Override
    public void hide(){

    }

    @Override
    public void resume(){

    }

    @Override
    public void resize(int width, int height){

    }
}
