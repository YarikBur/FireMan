package ru.sgs.fireman.Game.objs;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class RailwayCarrige implements Obj {
    private Color colorFill;
    private int width;
    private int height;
    private int x;
    private int y;

    private ShapeRenderer shape;

    public RailwayCarrige(int width, int height, int x, int y, Color color){
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.colorFill = color;

        shape = new ShapeRenderer();
    }

    public void renderer(){
        shape.begin(ShapeRenderer.ShapeType.Filled);

        shape.setColor(colorFill);
        shape.rect(x, y, width, height);

        shape.end();
    }

    public int getX(){
        return x;
    }

    public void setX(int x){
        this.x = x;
    }

    public RailwayCarrige getRailwayCarrige(){
        return this;
    }
}
