package com.mygdx.game.view.gameObjectViews;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MonsterView extends GameObjectView {
    private boolean damaged;
    private List<String> pathList= new ArrayList<String>();
    private String path;
    private boolean dead;
    private Texture stay;
    private Texture damage;
    private Texture death;
    Random rnd = new Random();

    public MonsterView() {
        pathList.add("goblin");
        pathList.add("skeleton");
        pathList.add("dragon");
        pathList.add("octopus");
        pathList.add("plusheye");
        pathList.add("darkknight");
        pathList.add("demon");
        path = pathList.get(rnd.nextInt(pathList.size()));
        stay = newTexture("monsters/" + path + "/stay.png");
        damage = newTexture("monsters/" + path + "/damage.png");
        death = newTexture("monsters/death1.png");
        stayAnimation();
    }

    @Override
    public void update(float dt){
        objectAnimation.update(dt);
        if(damaged && !dead){
            if(objectAnimation.isAnimEnded()) {
                damaged=false;
                stayAnimation();
            }
        }
        if(dead){
            if(objectAnimation.isAnimEnded()){
                path = pathList.get(rnd.nextInt(pathList.size()));
                stay = newTexture("monsters/" + path + "/stay.png");
                damage = newTexture("monsters/" + path + "/damage.png");
                dead=false;
                stayAnimation();
            }
        }
    }

    public void takeDamageAnimation(){
        damaged = true;
        changeAnimation(damage, damage.getWidth()/512, 0.25f);
    }

    @Override
    public void stayAnimation(){
        changeAnimation(stay, stay.getWidth()/512);
    }

    public void die(){
        dead=true;
        changeAnimation(death, death.getWidth()/512, 0.3f);
    }

    public boolean isDead() {
        return dead;
    }

    public boolean isDamaged() {
        return damaged;
    }
}