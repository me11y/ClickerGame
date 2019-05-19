package com.mygdx.game.model;

import com.badlogic.gdx.Gdx;

public class Npc {
    private int damage=5;
    protected float timeSeconds = 0f;
    private int damageUpgradePrice = 20;

    public Npc(int i) {
        if(i==0){
            damageUpgradePrice=20;
        }
        else if(i==1){
            damageUpgradePrice=100;
        }
        else if(i==2){
            damageUpgradePrice=150;
        }
        else if(i==3){
            damageUpgradePrice=200;
        }
    }

    public void update(Monster target, float dt) {
        timeSeconds+=dt;
        if(timeSeconds>=2) {
            target.takeDamage(damage);
            timeSeconds=0;
        }
    }

    public float getTimeSeconds() {
        return timeSeconds;
    }

    public void damageUpgrade() {
        damage *= 1.2f;
        damageUpgradePrice *= 1.5f;
    }

    public int getDamageUpgradePrice() {
        return damageUpgradePrice;
    }

    public int getDamage() {
        return damage;
    }
}
