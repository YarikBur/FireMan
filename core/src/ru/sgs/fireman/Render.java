package ru.sgs.fireman;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import ru.sgs.fireman.Game.Handler.AndroidHandler;

public class Render {
    private Texture sun;
    private float speedBackground = 1;
    private Sprite background[][] = new Sprite[6][2];
    private ShapeRenderer shape;

    public Render(){
        sun = new Texture("background/sun.png");

        for (int i=0; i<6; i++){
            background[i][0] = new Sprite(new Texture("background/bg" + (i+1) + ".png"));
            background[i][1] = new Sprite(new Texture("background/bg" + (i+1) + ".png"));
            background[i][0].setX(0);
            background[i][1].setX(background[i][0].getWidth());
        }

        shape = new ShapeRenderer();
    }

    public void renderBG(SpriteBatch batch, int widthWindow, int heightWindow){
        //Градиент
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.rect(0, 0,widthWindow, heightWindow,
                new Color(245/255f, 220/255f, 100/255f, 1), new Color(245/255f, 220/255f, 100/255f, 1),
                new Color(220/255f, 150/255f, 90/255f, 1), new Color(220/255f, 150/255f, 90/255f, 1));
        shape.end();

        batch.begin();
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
        batch.end();
    }

    public void renderButtons(){
        shape.begin(ShapeRenderer.ShapeType.Filled);

        if (AndroidHandler.getPressed()[0])
            shape.setColor(Color.GRAY);
        else
            shape.setColor(Color.WHITE);
        shape.ellipse(100, 100, 200, 200);

        if (AndroidHandler.getPressed()[1])
            shape.setColor(Color.GRAY);
        else
            shape.setColor(Color.WHITE);
        shape.ellipse(Gdx.graphics.getWidth()-300, 100, 200, 200);

        shape.end();
    }

    public void dispose(){
        for (int i=0; i<6; i++){
            background[i][0].getTexture().dispose();
            background[i][1].getTexture().dispose();
        }
    }

    public float getSpeedBackground(){
        return speedBackground;
    }

    public void setSpeedBackground(float speedBackground){
        this.speedBackground = speedBackground;
    }
}
