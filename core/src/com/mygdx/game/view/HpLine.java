package com.mygdx.game.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.model.Monster;

public class HpLine {
    private Texture hpBlank;
    private Texture hpLine;

    public HpLine() {
        hpBlank = new Texture("hpBar/hpBarOut.png");
        hpLine = new Texture("hpBar/hpBarIn.png");
    }

    public void render(SpriteBatch batch, Monster monster){
        batch.draw(hpBlank, 160, 582 - hpBlank.getHeight() / 2, hpBlank.getWidth() * 1.3f, hpBlank.getHeight() / 2.5f);
        batch.draw(hpLine, 160, 582 - hpBlank.getHeight() / 2, hpLine.getWidth() * 1.3f * monster.getHp() / monster.getMaxHp(), hpLine.getHeight() / 2.5f);
    }
}
