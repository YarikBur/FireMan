package ru.sgs.fireman.utlis;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;
import java.util.Map;

public class Tiles {
    private Texture texture = null;
    private int lines = 0;
    private int columns = 0;

    private Map<String, TextureRegion> textureRegionMap = null;

    public void createAtlas(String texture, String name, int lines, int columns){
        this.texture = new Texture(texture);
        textureRegionMap = new HashMap<String, TextureRegion>();
        this.lines = lines;
        this.columns = columns;

        createAtlas(name);
    }

    private void createAtlas(String name){
        TextureRegion tmp[][] = TextureRegion.split(texture, texture.getWidth()/lines, texture.getHeight()/columns);
        for (int y=0; y<columns; y++)
            for (int x=0; x<lines; x++)
                textureRegionMap.put(name + y + "_" + x, tmp[y][x]);
    }
}
