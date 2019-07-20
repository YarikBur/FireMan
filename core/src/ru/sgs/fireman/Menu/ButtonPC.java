package ru.sgs.fireman.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.sgs.fireman.utlis.Font;

public class ButtonPC {

    private Font font;

    private final static int fontSize = 3;

    public void setInputProcessor(){
        Gdx.input.setInputProcessor(new InputAdapter(){
            @Override
            public boolean touchDown (int screenX, int screenY, int pointer, int button){
                System.out.print("[Touch Down] ScreenX: " + screenX + " ScreenY: " + screenY
                        + " Pointer: " + pointer + " Button: " + button + '\n');

                //Play
                if (screenX >= Gdx.app.getGraphics().getWidth()/2-(font.getFontSize(fontSize)*2) &&
                        screenY >= Gdx.app.getGraphics().getHeight()/2 &&

                        screenX <= Gdx.app.getGraphics().getWidth()/2+(font.getFontSize(fontSize)*0.45f) &&
                        screenY <= Gdx.app.getGraphics().getHeight()/2+font.getFontSize(fontSize))
                    System.out.print("Play" + '\n');


                //Reference
                if (screenX >= Gdx.app.getGraphics().getWidth()/2-(font.getFontSize(fontSize)*3.6f) &&
                        screenY >= Gdx.app.getGraphics().getHeight()/2-(font.getFontSize(fontSize)*2))
                    System.out.print("Reference" + '\n');
                //Settings
                //Exit
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

    public ButtonPC(){
        font = new Font();
    }

    public void render(SpriteBatch batch){
        font.printText(
                batch,
                "Play",
                fontSize,
                Gdx.app.getGraphics().getWidth()/2-(font.getFontSize(fontSize)*2),
                Gdx.app.getGraphics().getHeight()/2
        );

        font.printText(
                batch,
                "Reference",
                fontSize,
                Gdx.app.getGraphics().getWidth()/2-(font.getFontSize(fontSize)*3.6f),
                Gdx.app.getGraphics().getHeight()/2-(font.getFontSize(fontSize)*2)
        );

        font.printText(
                batch,
                "Setting",
                fontSize,
                Gdx.app.getGraphics().getWidth()/2-(font.getFontSize(fontSize)*3f),
                Gdx.app.getGraphics().getHeight()/2-(font.getFontSize(fontSize)*4)
        );

        font.printText(
                batch,
                "Exit",
                fontSize,
                Gdx.app.getGraphics().getWidth()/2-(font.getFontSize(fontSize)*2),
                Gdx.app.getGraphics().getHeight()/2-(font.getFontSize(fontSize)*6)
        );
    }

    public void dispose(){

    }
}
