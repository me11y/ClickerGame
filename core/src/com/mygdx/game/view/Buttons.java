package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
//скины для кнопок
public class Buttons {
    public static com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle menuButton, attackButton, menuExit, hero, npcs, equipment, npc1Button;
    public static Skin skin;

    public static void load(){
        skin = new Skin();
        skin.addRegions(new TextureAtlas(Gdx.files.internal("buttons/buttons.atlas")));

        menuButton = new com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle();
        menuButton.up = skin.getDrawable("menu");
        menuButton.down = skin.getDrawable("menuPressed");

        menuExit = new Button.ButtonStyle();
        menuExit.up = skin.getDrawable("menuExit");
        menuExit.down = skin.getDrawable("menuExit_p");

        attackButton = new Button.ButtonStyle();
        attackButton.up = skin.getDrawable("attack");
        attackButton.down = skin.getDrawable("attackPressed");

        npcs = new Button.ButtonStyle();
        npcs.up = skin.getDrawable("npcs");
        npcs.down = skin.getDrawable("npcs_p");

        npc1Button = new Button.ButtonStyle();
        npc1Button.up = skin.getDrawable("npc1");
        npc1Button.down = skin.getDrawable("npc1_p");

        hero = new Button.ButtonStyle();
        hero.up = skin.getDrawable("pers");
        hero.down = skin.getDrawable("pers_p");
    }

}
