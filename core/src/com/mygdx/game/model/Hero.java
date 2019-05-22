package com.mygdx.game.model;

public class Hero {
    int damage;
    int lvl;
    long gold = 0;
    int damageUpgradePrice = 20;

    public Hero(int damage, int lvl) {
        this.damage = damage;
        this.lvl = lvl;
    }

    public void attack(Monster target) {
        target.takeDamage(damage);
    }

    public void lvlUp() {
        lvl++;
    }

    public void getMoreGold(long gold) {
        this.gold += gold;
    }

    public long getGold() {
        return gold;
    }

    public void update() {
    }

    public int getDamage() {
        return damage;
    }

    public void damageUpgrade() {
        if (gold >= damageUpgradePrice) {
            damage *= 1.5f;
            gold -= damageUpgradePrice;
            damageUpgradePrice *= 1.5f;
        }
    }

    public void npcUpgrade(int price){
        gold-=price;
    }

    public boolean isAbleToUpgrade(int price){
        if(gold>=price) return true;
        return false;
    }

    public int getDamageUpgradePrice() {
        return damageUpgradePrice;
    }
}
