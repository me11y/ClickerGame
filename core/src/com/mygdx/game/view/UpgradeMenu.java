package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.mygdx.game.view.gameObjectViews.GameObjectView;

public class UpgradeMenu {
    private GameObjectView menuBackground;
    private GameplayScreen gameplayScreen;
    private boolean opened;
    private Stage gui;
    private Button exitButton;
    private Button attackButton;
    private Button heroButton;
    private Button npcsButton;
    private Button npc1Button;
    private Button npc2Button;
    private BitmapFont fnt;
    private String price1;
    private String price2;
    private String price3;
    private String price4;
    private short menu;

    public UpgradeMenu(GameplayScreen gameplayScreen, Stage gui) {
        menuBackground = new GameObjectView("buttons/menuBack.png");
        this.gui = gui;
        this.gameplayScreen = gameplayScreen;
        Buttons.load();
        exitButton = new Button(Buttons.menuExit);
        exitButton.setBounds(Gdx.graphics.getWidth() * 0.91f, Gdx.graphics.getHeight() * 0.35f, Gdx.graphics.getWidth() * 0.09f, Gdx.graphics.getHeight() * 0.05f);
        attackButton = new Button(Buttons.attackButton);
        attackButton.setBounds(Gdx.graphics.getWidth() * 0.036f, Gdx.graphics.getHeight() * 0.25f, Gdx.graphics.getWidth() * 0.16f, Gdx.graphics.getHeight() * 0.1f);
        heroButton = new Button(Buttons.hero);
        heroButton.setBounds(Gdx.graphics.getWidth() * 0.009f, Gdx.graphics.getHeight() * 0.35f, Gdx.graphics.getWidth() * 0.28f, Gdx.graphics.getHeight() * 0.05f);
        npcsButton = new Button(Buttons.npcs);
        npcsButton.setBounds(Gdx.graphics.getWidth() * 0.279f, Gdx.graphics.getHeight() * 0.35f, Gdx.graphics.getWidth() * 0.28f, Gdx.graphics.getHeight() * 0.05f);
        npc1Button = new Button(Buttons.npc1Button);
        npc1Button.setBounds(Gdx.graphics.getWidth() * 0.036f, Gdx.graphics.getHeight() * 0.25f, Gdx.graphics.getWidth() * 0.16f, Gdx.graphics.getHeight() * 0.1f);
        npc2Button = new Button(Buttons.npc1Button);
        npc2Button.setBounds(Gdx.graphics.getWidth() * 0.036f, Gdx.graphics.getHeight() * 0.17f, Gdx.graphics.getWidth() * 0.16f, Gdx.graphics.getHeight() * 0.1f);
        fnt = new BitmapFont(Gdx.files.internal("sch.fnt"));
        menu = 1;
    }

    public void draw() {
        gameplayScreen.batch.begin();
        gameplayScreen.batch.draw(menuBackground.getSprite().getTexture(), 0, 0, Main.WIDTH, Main.HEIGHT * 0.2f);
        gameplayScreen.batch.end();
        gui.draw();
        gameplayScreen.batch.begin();
        if(menu==1) {
            price1 = "Price: " + gameplayScreen.getHero().getDamageUpgradePrice();
            fnt.draw(gameplayScreen.batch, price1, 150, 200);
        }
        else if(menu==2){
            price1 = "Price: " + gameplayScreen.getNpcs().getUpgradePrice(0);
            price2 =  "Price: " + gameplayScreen.getNpcs().getUpgradePrice(1);
            fnt.draw(gameplayScreen.batch, price1, 150, 200);
            fnt.draw(gameplayScreen.batch, price2, 150, 150);
        }
        gameplayScreen.batch.end();
    }

    public void open() {
        gui.clear();
        gui.addActor(exitButton);
        gui.addActor(heroButton);
        gui.addActor(npcsButton);
        if(menu==1) {
            gui.addActor(attackButton);
        }
        if(menu==2){
            gui.addActor(npc1Button);
            gui.addActor(npc2Button);
        }
        opened=true;
    }

    public boolean isOpened() {
        return opened;
    }

    public Button getExitButton() {
        return exitButton;
    }

    public void close() {
        opened=false;
        gui.clear();
    }

    public Button getAttackButton() {
        return attackButton;
    }

    public short getMenu() {
        return menu;
    }

    public void setMenu(short menu) {
        this.menu = menu;
    }

    public Button getHeroButton() {
        return heroButton;
    }

    public Button getNpcsButton() {
        return npcsButton;
    }

    public Button getNpc1Button() {
        return npc1Button;
    }

    public Button getNpc2Button() {
        return npc2Button;
    }
}
