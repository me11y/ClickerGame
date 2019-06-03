package com.mygdx.game.model;

public class Monster {
    int hp;
    int maxHp = 100;
    float gold = 1;
    int lvl;
    int sublvl;

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
        gold *= 10f;
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
}
