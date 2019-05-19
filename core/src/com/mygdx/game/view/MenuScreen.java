package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuScreen extends GameScreen {
    private Texture background;
    private Texture playbtn;
    public MenuScreen(GameScreenManager gsm) {
        super(gsm);
        background = new Texture("menu.jpg");
        playbtn = new Texture("playbtn.png");
    }

    protected void handleInput() {
        if(Gdx.input.justTouched())
            gsm.set(new GameplayScreen(gsm));
    }

    @Override
    public void update(float dtime) {
        handleInput();
    }

    @Override
    public void render() {
        batch.begin();
        batch.draw(background, 0, 0, Main.WIDTH, Main.HEIGHT);
        batch.draw(playbtn, Main.WIDTH/2-playbtn.getWidth()/2, Main.HEIGHT/1.7f-playbtn.getHeight()/2);
        batch.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playbtn.dispose();
    }
}