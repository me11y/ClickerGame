package com.mygdx.game.view.gameObjectViews;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.List;

public class NpcView extends GameObjectView {
    private List<String> pathList = new ArrayList<String>();
    private String path;
    private float x;
    private float y;
    private Texture stay;
    private Texture damage;
    private boolean attacked = false;


    public NpcView(int i) {
        stay = newTexture("npc/stay.png");
        damage = newTexture("npc/attack.png");
        stayAnimation();
        if(i==0){
            x=350;
            y=64;
        }
        else if(i==1){
            x=250;
            y=64;
        }
        else if(i==2){
            x=150;
            y=64;
        }
        else if(i==3){
            x=50;
            y=64;
        }

    }

    public void update(float dt) {
        objectAnimation.update(dt);
        if (attacked && objectAnimation.isAnimEnded()) {
            stayAnimation();
            attacked = false;
        }
    }

    public void damageAnimation() {
        changeAnimation(damage, damage.getWidth() / 512, 0.3f);
        attacked = true;
    }

    @Override
    public void stayAnimation() {
        changeAnimation(stay, stay.getWidth() / 512);
    }

    public boolean isAttacked() {
        return attacked;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
