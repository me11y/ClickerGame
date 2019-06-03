package com.mygdx.game.view;

import com.mygdx.game.model.Monster;

public class LevelView {
    private String lvl;

    public LevelView() {
        lvl = "";
    }

    public void update(Monster monster){
        lvl = "Level: " + monster.getLvl();
    }

    public String getLvl() {
        return lvl;
    }
}
