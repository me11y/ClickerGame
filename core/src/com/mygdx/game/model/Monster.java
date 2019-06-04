package com.mygdx.game.model;

public class Monster {
    private int hp;
    private int maxHp = 100;
    private float gold = 1;
    private int lvl;
    private int sublvl;
    private boolean lvlChanged;

    public Monster(int hp) {
        this.hp = hp;
        this.lvl = 1;
        this.sublvl = 1;
    }

    public void takeDamage(int damage) {
        hp -= damage;
    }

    public void die() {
        maxHp *= 1.1f;
        gold += 1;
        sublvl++;
        if(sublvl == 10){
            maxHp *= 2;
            gold *= 1.5f;
        }
        else if (sublvl == 11) {
            lvl++;
            sublvl = 0;
            gold /= 1.3f;
            maxHp /= 1.5f;
            lvlChanged = true;
        }
        hp = maxHp;
    }

    public int getLvl() {
        return lvl;
    }

    public int getHp() {
        return hp;
    }

    public long getGold() {
        return Math.round(gold);
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setLvlChanged(){
        lvlChanged = false;
    }

    public boolean isLvlChanged() {
        return lvlChanged;
    }

    public int getSublvl() {
        return sublvl;
    }
}
