package ru.sgs.fireman.Game.objs;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Player implements Obj {
    private int width;
    private int height;
    private int x;
    private int y;

    private ShapeRenderer shape;

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public Player(int width, int height, int x, int y){
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;

        shape = new ShapeRenderer();
    }

    public void renderer(){
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(Color.WHITE);
        shape.rect(x, y, width, height);
        shape.end();
    }
}
