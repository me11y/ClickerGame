package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.model.Hero;
import com.mygdx.game.model.NpcList;

public class TotalDamage {
    private String attackHeroDamage="";
    private String attackNpcsDamage="";
    private int summNpcDamage=0;

    public void update(Hero hero, NpcList npcs){
        attackHeroDamage = "Hero Damage: " + hero.getDamage();
        for(int i : npcs.getNpcs().keySet()){
            summNpcDamage+=npcs.getNpcs().get(i).getDamage();
        }
        attackNpcsDamage = "Npcs Damage: " + summNpcDamage;
        summNpcDamage=0;
    }

    public String getAttackHeroDamage() {
        return attackHeroDamage;
    }

    public String getAttackNpcsDamage() {
        return attackNpcsDamage;
    }
}
