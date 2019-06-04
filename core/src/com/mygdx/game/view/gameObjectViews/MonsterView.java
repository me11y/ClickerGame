package com.mygdx.game.view.gameObjectViews;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MonsterView extends GameObjectView {
    private boolean damaged;
    private List<String> pathList = new ArrayList<String>();
    private List<String> bossList = new ArrayList<String>();
    private String path;
    private boolean dead;
    private Texture stay;
    private Texture damage;
    private Texture death;
    private boolean boss = false;
    Random rnd = new Random();

    public MonsterView() {
        pathList.add("goblin");
        pathList.add("skeleton");
        bossList.add("dragon");
        bossList.add("octopus");
        bossList.add("plusheye");
        bossList.add("darkknight");
        bossList.add("demon");
        path = pathList.get(rnd.nextInt(pathList.size()));
        stay = newTexture("monsters/" + path + "/stay.png");
        damage = newTexture("monsters/" + path + "/damage.png");
        death = newTexture("monsters/death1.png");
        stayAnimation();
    }

    @Override
    public void update(float dt) {
        objectAnimation.update(dt);
        if (damaged && !dead) {
            if (objectAnimation.isAnimEnded()) {
                damaged = false;
                stayAnimation();
            }
        }
        if (dead) {
            if (objectAnimation.isAnimEnded()) {
                if (!boss) {
                    path = pathList.get(rnd.nextInt(pathList.size()));
                }
                else{
                    path = bossList.get(rnd.nextInt(bossList.size()));
                }
                stay = newTexture("monsters/" + path + "/stay.png");
                damage = newTexture("monsters/" + path + "/damage.png");
                dead = false;
                stayAnimation();
            }
        }
    }

    public void takeDamageAnimation() {
        damaged = true;
        changeAnimation(damage, damage.getWidth() / 512, 0.25f);
    }

    @Override
    public void stayAnimation() {
        changeAnimation(stay, stay.getWidth() / 512);
    }

    public void die() {
        dead = true;
        changeAnimation(death, death.getWidth() / 512, 0.3f);
        if(boss){
            boss = false;
        }
    }

    public boolean isDead() {
        return dead;
    }

    public boolean isDamaged() {
        return damaged;
    }

    public boolean isBoss() {
        return boss;
    }

    public void setBoss(boolean boss) {
        this.boss = boss;
    }
}