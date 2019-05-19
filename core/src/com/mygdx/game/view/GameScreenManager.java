package com.mygdx.game.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class GameScreenManager {
    private Stack<GameScreen> screens;

    public GameScreenManager() {
        screens = new Stack<GameScreen>();
    }

    public void push(GameScreen screen) {
        screens.push(screen);
    }

    public void pop(){
        screens.pop().dispose();
    }

    public void set(GameScreen screen){
        screens.pop().dispose();
        screens.push(screen);
    }

    public void update(float dt){
        screens.peek().update(dt);
    }

    public void render(){
        screens.peek().render();
    }
}
