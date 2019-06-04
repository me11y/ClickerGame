package com.mygdx.game.model;

public class Hero {
    int damage;
    long gold = 0;
    int damageUpgradePrice = 20;

    public Hero(int damage) {
        this.damage = damage;
    }

    //нанести урон монстру
    public void attack(Monster target) {
        target.takeDamage(damage);
    }

    //дать герою золота
    public void getMoreGold(long gold) {
        this.gold += gold;
    }

    //улучшение наносимого урона
    public void damageUpgrade() {
        if (gold >= damageUpgradePrice) {
            damage *= 1.5f;
            gold -= damageUpgradePrice;
            damageUpgradePrice *= 1.5f;
        }
    }

    //может ли герой себе позволить улучшение
    public boolean isAbleToUpgrade(int price){
        if(gold>=price) return true;
        return false;
    }

    //снять деньги за улучшение нпс
    public void npcUpgrade(int price){
        gold-=price;
    }

    public int getDamageUpgradePrice() {
        return damageUpgradePrice;
    }

    public long getGold() {
        return gold;
    }

    public void update() {
    }
    public int getDamage() {
        return damage;
    }
}
