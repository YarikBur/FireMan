package ru.sgs.fireman.Game.Handler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;

public class AndroidHandler {
    private static boolean pressed[] = new boolean[4];

    public void setInputProcessor(){
        Gdx.input.setInputProcessor(new InputAdapter(){
            @Override
            public boolean touchDown (int screenX, int screenY, int pointer, int button){
                pressed[0] = pressedBreak(screenX, Gdx.graphics.getHeight()-screenY);
                pressed[1] = pressedFill(screenX, Gdx.graphics.getHeight()-screenY);
                pressed[2] = pressedMoveToLeft(screenX, Gdx.graphics.getHeight()-screenY);
                pressed[3] = pressedMoveToRight(screenX, Gdx.graphics.getHeight()-screenY);
                return true;
            }

            @Override
            public boolean touchUp (int screenX, int screenY, int pointer, int button){

                for (int i = 0; i < pressed.length; i++)
                    pressed[i] = false;

                return true;
            }
        });
    }

    public boolean pressedBreak(int x, int y){
        if (x >= 100 && x <= 300 &&
            y >= 100 && y <= 300)
            return true;
        else
            return false;
    }

    public boolean pressedFill(int x, int y){
        if (x >= Gdx.graphics.getWidth()-300 && x <=Gdx.graphics.getWidth()-100 &&
            y >= 100 && y <= 300)
            return true;
        else
            return false;
    }

    public boolean pressedMoveToLeft(int x, int y){
        if (x >= 0 && x <= Gdx.graphics.getWidth()/2
            && !pressedBreak(x, y))
            return true;
        else
            return false;
    }

    public boolean pressedMoveToRight(int x, int y){
        if (x >= Gdx.graphics.getWidth()/2 && x <= Gdx.graphics.getWidth()
            && !pressedFill(x, y))
            return true;
        else
            return false;
    }

    public static boolean[] getPressed(){
        return pressed;
    }
}
