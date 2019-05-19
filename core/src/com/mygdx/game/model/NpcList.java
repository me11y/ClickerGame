package com.mygdx.game.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NpcList {
    private Map<Integer, Npc> npcs;

    public NpcList() {
       npcs = new HashMap<Integer, Npc>();
    }

    public Npc getNpc(int i) {
        return npcs.get(i);
    }

    public void addNpc(int i) {
        npcs.put(i, new Npc(i));
    }

    public void update(Monster monster, float dt){
        for(int i : npcs.keySet()){
            npcs.get(i).update(monster, dt);
        }
    }

    public void upgradeNpc(int i){
        if(isExist(i)){
            npcs.get(i).damageUpgrade();
        }
        else{
            addNpc(i);
        }
    }

    public Map<Integer, Npc> getNpcs() {
        return npcs;
    }

    public int getUpgradePrice(int i){
        if(isExist(i)){
            return npcs.get(i).getDamageUpgradePrice();
        }
        if(i==0) {
            return 10;
        }
        else if(i==1){
            return 50;
        }
        else if(i==2){
            return 100;
        }
        else if(i==3){
            return 150;
        }
        return 0;
    }

    public boolean isExist(int i){
        if(npcs.containsKey(i)){
            return true;
        }
        return false;
    }
}
