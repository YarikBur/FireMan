package ru.sgs.fireman.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class MainMenu implements Screen {

    private SpriteBatch batch;
    private Texture logo;
    private ShapeRenderer shape;
    private int widthWindow;
    private int heightWindow;

    private final float speedBackground = 1;
    private Sprite background[][] = new Sprite[6][2];
    private Texture sun;

    //Device
    //true - PC
    //false - Android
    private boolean device;

    public MainMenu(SpriteBatch batch, boolean device){
        this.device = device;
        this.batch = batch;

        shape = new ShapeRenderer();
        logo = new Texture("FireManLogo.png");
        sun = new Texture("background/sun.png");

        widthWindow = Gdx.app.getGraphics().getWidth();
        heightWindow = Gdx.app.getGraphics().getHeight();

        for (int i=0; i<6; i++){
            background[i][0] = new Sprite(new Texture("background/bg" + (i+1) + ".png"));
            background[i][1] = new Sprite(new Texture("background/bg" + (i+1) + ".png"));
            background[i][0].setX(0);
            background[i][1].setX(background[i][0].getWidth());
        }
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
        batch.draw(logo, ((widthWindow/2)-(logo.getWidth()/2)), ((heightWindow/2)+logo.getHeight()));

        //Кнопки
        if (device)
            ru.sgs.fireman.Menu.ButtonPC.render();
        else
            ru.sgs.fireman.Menu.ButtonAndoid.render();

        batch.end();
    }

    @Override
    public void dispose(){
        ru.sgs.fireman.Menu.ButtonPC.dispose();
        ru.sgs.fireman.Menu.ButtonAndoid.dispose();
        batch.dispose();
        logo.dispose();
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
