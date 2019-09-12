package ru.sgs.fireman.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import ru.sgs.fireman.MainAndroid;
import ru.sgs.fireman.MainPC;
import ru.sgs.fireman.Render;
import ru.sgs.fireman.utlis.Font;
import ru.sgs.fireman.utlis.Version;

public class MainMenu implements Screen {

    private Version version = new Version();

    private SpriteBatch batch;
    private Sprite logo;

    private int widthWindow;
    private int heightWindow;

    private Render render;

    private ButtonPC buttonPC;
    private ButtonAndroid buttonAndroid;

    private Font font;

    //Device
    //true - PC
    //false - Android
    private boolean device;
    MainAndroid mainAndroid;
    MainPC mainPC;

    public MainMenu(MainAndroid mainAndroid, SpriteBatch batch, boolean device){
        this.mainAndroid = mainAndroid;

        init(batch, device);
    }

    public MainMenu(MainPC mainPC, SpriteBatch batch, boolean device){
        this.mainPC = mainPC;

        init(batch, device);
    }


    private void init (SpriteBatch batch, boolean device){
        this.device = device;
        this.batch = batch;

        font = new Font();
        buttonPC = new ButtonPC();
        buttonAndroid = new ButtonAndroid(this);


        logo = new Sprite(new Texture("FireManLogo.png"));


        widthWindow = Gdx.app.getGraphics().getWidth();
        heightWindow = Gdx.app.getGraphics().getHeight();

        render = new Render();

        if (!device)
            logo.scale(1.125f);
    }

    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Фон
        render.renderBG(batch, widthWindow, heightWindow);

        batch.begin();

        //Лого FireMan
        logo.setX(((widthWindow/2)-(logo.getWidth()/2)));
        logo.setY(((heightWindow/2)+logo.getHeight()));
        logo.draw(batch);

        //Кнопки
        if (device)
            buttonPC.render(batch);
        else
            buttonAndroid.render(batch);

        font.writeUpperLeft(batch, 1, version.getSubversion() + " v." + version.getVersion());

        batch.end();
    }

    @Override
    public void dispose(){
        buttonPC.dispose();
        buttonAndroid.dispose();
        batch.dispose();
        logo.getTexture().dispose();
        render.dispose();
    }

    @Override
    public void show(){
        if (device)
            buttonPC.setInputProcessor();
        else
            buttonAndroid.setInputProcessor();
    }

    @Override
    public void hide(){

    }

    @Override
    public void pause(){

    }

    @Override
    public void resume(){

    }

    @Override
    public void resize(int width, int height){
        widthWindow = width;
        heightWindow = height;

        System.out.println("Window width: " + width + " and height: " + height);
    }
}
