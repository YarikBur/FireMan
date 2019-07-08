package ru.sgs.fireman.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import ru.sgs.fireman.utlis.Font;
import ru.sgs.fireman.utlis.Version;

public class MainMenu implements Screen {

    private Version version = new Version();

    private SpriteBatch batch;
    private Sprite logo;
    private ShapeRenderer shape;
    private int widthWindow;
    private int heightWindow;

    private final float speedBackground = 1;
    private Sprite background[][] = new Sprite[6][2];
    private Texture sun;

    private ButtonPC buttonPC;
    private ButtonAndroid buttonAndroid;

    private Font font;

    //Device
    //true - PC
    //false - Android
    private boolean device;

    public MainMenu(SpriteBatch batch, boolean device){
        this.device = device;
        this.batch = batch;

        font = new Font();
        buttonPC = new ButtonPC();
        buttonAndroid = new ButtonAndroid();

        shape = new ShapeRenderer();
        logo = new Sprite(new Texture("FireManLogo.png"));
        sun = new Texture("background/sun.png");

        widthWindow = Gdx.app.getGraphics().getWidth();
        heightWindow = Gdx.app.getGraphics().getHeight();

        for (int i=0; i<6; i++){
            background[i][0] = new Sprite(new Texture("background/bg" + (i+1) + ".png"));
            background[i][1] = new Sprite(new Texture("background/bg" + (i+1) + ".png"));
            background[i][0].setX(0);
            background[i][1].setX(background[i][0].getWidth());
        }

        if (!device)
            logo.scale(1.125f);
    }

    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Градиент
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.rect(0, 0,widthWindow, heightWindow,
                new Color(245/255f, 220/255f, 100/255f, 1), new Color(245/255f, 220/255f, 100/255f, 1),
                new Color(220/255f, 150/255f, 90/255f, 1), new Color(220/255f, 150/255f, 90/255f, 1));
        shape.end();

        batch.begin();

        //Фон
        batch.draw(sun, widthWindow/2+widthWindow/4, heightWindow/2+heightWindow/4);
        for (int i=0; i<6; i++){
            background[i][0].draw(batch);
            background[i][1].draw(batch);

            background[i][0].setX(background[i][0].getX()-speedBackground*(i+0.5f));
            background[i][1].setX(background[i][1].getX()-speedBackground*(i+0.5f));

            if(background[i][0].getX() <= -background[i][0].getWidth())
                background[i][0].setX(background[i][1].getX()+background[i][1].getWidth());

            if(background[i][1].getX() <= -background[i][1].getWidth())
                background[i][1].setX(background[i][0].getX()+background[i][0].getWidth());
        }

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
        for (int i=0; i<6; i++){
            background[i][0].getTexture().dispose();
            background[i][1].getTexture().dispose();
        }
    }

    @Override
    public void show(){

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
