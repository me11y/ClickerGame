package com.mygdx.game.model;

public class Monster {
    int hp;
    int maxHp=100;
    long gold=5;

    public Monster(int hp) {
        this.hp = hp;
    }

    public void takeDamage(int damage){
        hp-=damage;
    }

    public void die(){
        maxHp*=1.1f;
        hp=maxHp;
        gold*=10f;
    }

    public int getHp() {
        return hp;
    }

    public long getGold() {
        return gold;
    }

    public int getMaxHp() {
        return maxHp;
    }
}
