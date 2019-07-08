package ru.sgs.fireman.utlis;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;


public class Font {
    private static BitmapFont largeFont;
    private static BitmapFont mediumFont;
    private static BitmapFont smallFont;
    private static BitmapFont miniFont;

    private static boolean init = false;

    public Font(){
        if(!init) {
            //Init fonts
            largeFont = new BitmapFont();
            mediumFont = new BitmapFont();
            smallFont = new BitmapFont();
            miniFont = new BitmapFont();

            FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/pixel.ttf"));
            FreeTypeFontParameter parameter = new FreeTypeFontParameter();

            parameter.borderColor = Color.BLACK;
            parameter.borderWidth = 1;

            parameter.size = 48;
            largeFont = generator.generateFont(parameter);

            parameter.size = 24;
            mediumFont = generator.generateFont(parameter);

            parameter.size = 18;
            smallFont = generator.generateFont(parameter);

            parameter.size = 9;
            miniFont = generator.generateFont(parameter);

            generator.dispose();
            init = true;
        }
    }

    /**
     * @param batch - SpriteBatch
     * @param text - Type text
     * @param size - Basic font size (1 - mini, 2 - small, 3 - medium, 4 - large)
     */
    public void printText(SpriteBatch batch, String text, int size, float x, float y){
        if (size == 1)
            miniFont.draw(batch, text, x, y);
        else if (size == 2)
            smallFont.draw(batch, text, x, y);
        else if (size == 3)
            mediumFont.draw(batch, text, x, y);
        else
            largeFont.draw(batch, text, x, y);
    }

    /**
     * Displays the text on the left above
     * @param batch - SpriteBatch
     * @param size - Basic font size (1 - mini, 2 - small, 3 - medium, 4 - large)
     * @param text - Array strings
     */
    public void writeUpperLeft(SpriteBatch batch, int size, String... text){
        int i, indentation;

        if (size == 1)
            indentation = 11;
        else if (size == 2)
            indentation = 20;
        else if (size == 3)
            indentation = 26;
        else
            indentation = 50;

        i = indentation/3;

        for (String str : text){
            if (size == 1)
                miniFont.draw(batch, str, indentation/3, Gdx.app.getGraphics().getHeight() - i);
            else if (size == 2)
                smallFont.draw(batch, str, indentation/3, Gdx.app.getGraphics().getHeight() - i);
            else if (size == 3)
                mediumFont.draw(batch, str, indentation/3, Gdx.app.getGraphics().getHeight() - i);
            else
                largeFont.draw(batch, str, indentation/3, Gdx.app.getGraphics().getHeight() - i);

            i += indentation;
        }
    }

    /**
     * Displays the text on the left below
     * @param batch - SpriteBatch
     * @param size - Basic font size (1 - mini, 2 - small, 3 - medium, 4 - large)
     * @param text - Array strings
     */
    public void writeLowerLeft(SpriteBatch batch, int size, String... text){
        int i, indentation;

        if (size == 1)
            indentation = 11;
        else if (size == 2)
            indentation = 20;
        else if (size == 3)
            indentation = 26;
        else
            indentation = 50;

        i = indentation;

        for (String str : text){
            if (size == 1)
                miniFont.draw(batch, str, indentation/3, i);
            else if (size == 2)
                smallFont.draw(batch, str, indentation/3, i);
            else if (size == 3)
                mediumFont.draw(batch, str, indentation/3, i);
            else
                largeFont.draw(batch, str, indentation/3, i);

            i += indentation;
        }
    }

    /**
     * !!!Crookedly works!!!
     * Displays the text on the right above
     * @param batch - SpriteBatch
     * @param size - Basic font size (1 - mini, 2 - small, 3 - medium, 4 - large)
     * @param text - Array strings
     */
    public void writeUpperRight(SpriteBatch batch, int size, String... text){
        int i, indentation;

        if (size == 1)
            indentation = 11;
        else if (size == 2)
            indentation = 0;
        else if (size == 3)
            indentation = 26;
        else
            indentation = 50;

        i = indentation;

        for (String str : text){
            if (size == 1)
                miniFont.draw(batch, str,
                        Gdx.app.getGraphics().getWidth()-(str.length()*(indentation-5)),
                        Gdx.app.getGraphics().getHeight() - i);
            else if (size == 2)
                smallFont.draw(batch, str,
                        Gdx.app.getGraphics().getWidth()-(str.length()*(indentation-5)),
                        Gdx.app.getGraphics().getHeight() - i);
            else if (size == 3)
                mediumFont.draw(batch, str,
                        Gdx.app.getGraphics().getWidth()-(str.length()*(indentation-5)),
                        Gdx.app.getGraphics().getHeight() - i);
            else
                largeFont.draw(batch, str,
                        Gdx.app.getGraphics().getWidth()-(str.length()*(indentation-5)),
                        Gdx.app.getGraphics().getHeight() - i);

            i += indentation;
        }
    }

    /**
     * !!!Crookedly works!!!
     * Displays the text on the right below
     * @param batch - SpriteBatch
     * @param size - Basic font size (1 - mini, 2 - small, 3 - medium, 4 - large)
     * @param text - Array strings
     */
    public void writeLowerRight(SpriteBatch batch, int size, String... text){
        int i, indentation;

        if (size == 1)
            indentation = 11;
        else if (size == 2)
            indentation = 20;
        else if (size == 3)
            indentation = 26;
        else
            indentation = 50;

        i = indentation;

        for (String str : text){
            if (size == 1)
                miniFont.draw(batch, str, Gdx.app.getGraphics().getWidth()-(str.length()*(indentation-5)), i);
            else if (size == 2)
                smallFont.draw(batch, str, Gdx.app.getGraphics().getWidth()-(str.length()*(indentation-5)), i);
            else if (size == 3)
                mediumFont.draw(batch, str, Gdx.app.getGraphics().getWidth()-(str.length()*(indentation-5)), i);
            else
                largeFont.draw(batch, str, Gdx.app.getGraphics().getWidth()-(str.length()*(indentation-5)), i);

            i += indentation;
        }
    }

    /**
     *
     * @param size
     * @return
     */
    public int getFontSize(int size){
        if (size == 1)
            return 9;
        else if (size == 2)
            return 18;
        else if (size == 3)
            return 24;
        else
            return 48;
    }

    public BitmapFont getLargeFont() {
        return largeFont;
    }

    public BitmapFont getMediumFont() {
        return mediumFont;
    }

    public BitmapFont getMiniFont(){
        return miniFont;
    }

    public BitmapFont getSmallFont() {
        return smallFont;
    }
}
