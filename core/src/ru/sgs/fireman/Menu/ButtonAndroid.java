package ru.sgs.fireman.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.sgs.fireman.utlis.Font;

public class ButtonAndroid {

    private Font font;
    private int sizeText = 3;
    private MainMenu mainMenu;

    public void setInputProcessor(){
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

    public ButtonAndroid(MainMenu mainMenu){
        font = new Font();

        this.mainMenu = mainMenu;
    }

    public void render(SpriteBatch batch){
        font.printText(
                batch,
                "To start the game, click on the screen",
                sizeText,
                Gdx.app.getGraphics().getWidth()/2-(font.getFontSize(3)*11.5f),
                Gdx.app.getGraphics().getHeight()/2
        );
    }

    public void dispose(){

    }
}
