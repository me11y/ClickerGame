package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Polygon;

import java.util.Random;

public class DamageView {
    private SpriteBatch batch;
    private String damage;
    private BitmapFont font = new BitmapFont(Gdx.files.internal("damage.fnt"));
    private int x;
    private int y;
    private int startY;
    private boolean ended;
    Random rnd = new Random();
    //отображение урона
    public DamageView(int damage) {
        this.damage = "" + damage;
        x = rnd.nextInt(200)+220;
        y = rnd.nextInt(20)+360;
        startY = y;
    }

    public String getDamage() {
        return damage;
    }

    public BitmapFont getFont() {
        return font;
    }

    public void draw(){
        font.draw(batch, damage, x, y+=2);
        if(y-startY>=35){
            ended = true;
        }
    }

    public void setBatch(SpriteBatch batch) {
        this.batch = batch;
    }

    public boolean isEnded() {
        return ended;
    }

    public void dispose(){
        font.dispose();
    }
}
