package ru.sgs.fireman.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.sgs.fireman.utlis.Font;

public class ButtonPC {

    private Font font;

    public ButtonPC(){
        font = new Font();

        Gdx.input.setInputProcessor(new InputAdapter(){
            @Override
            public boolean touchDown (int screenX, int screenY, int pointer, int button){
                System.out.print("[Touch Down] ScreenX: " + screenX + " ScreenY: " + screenY
                        + " Pointer: " + pointer + " Button: " + button + '\n');

                return true;
            }

            @Override
            public boolean touchUp (int screenX, int screenY, int pointer, int button){
                System.out.print("[Touch Up] ScreenX: " + screenX + " ScreenY: " + screenY
                        + " Pointer: " + pointer + " Button: " + button + '\n');

                return true;
            }
        });
    }

    public void render(SpriteBatch batch){
        font.printText(
                batch,
                "Play",
                2,
                Gdx.app.getGraphics().getWidth()/2-(font.getFontSize(2)*2),
                Gdx.app.getGraphics().getHeight()/2
        );

        font.printText(
                batch,
                "Reference",
                2,
                Gdx.app.getGraphics().getWidth()/2-(font.getFontSize(2)*3.6f),
                Gdx.app.getGraphics().getHeight()/2-(font.getFontSize(2)*2)
        );

        font.printText(
                batch,
                "Setting",
                2,
                Gdx.app.getGraphics().getWidth()/2-(font.getFontSize(2)*3f),
                Gdx.app.getGraphics().getHeight()/2-(font.getFontSize(2)*4)
        );

        font.printText(
                batch,
                "Exit",
                2,
                Gdx.app.getGraphics().getWidth()/2-(font.getFontSize(2)*2),
                Gdx.app.getGraphics().getHeight()/2-(font.getFontSize(2)*6)
        );
    }

    public void dispose(){

    }
}
