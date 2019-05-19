package com.mygdx.game.view;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class GameScreen {
    protected OrthographicCamera camera;
    protected Vector3 mouse;
    protected GameScreenManager gsm;
    protected SpriteBatch batch;

    public GameScreen(GameScreenManager gsm){
        this.gsm = gsm;
        camera = new OrthographicCamera();
        mouse = new Vector3();
        batch = new SpriteBatch();
    }

    public abstract void update(float dt);
    public abstract void render();
    public abstract void dispose();

    public SpriteBatch getBatch() {
        return batch;
    }
}