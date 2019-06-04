package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.controller.Controller;
import com.mygdx.game.model.Hero;
import com.mygdx.game.model.Monster;
import com.mygdx.game.model.Npc;
import com.mygdx.game.model.NpcList;
import com.mygdx.game.view.gameObjectViews.BackgroundView;
import com.mygdx.game.view.gameObjectViews.GameObjectView;
import com.mygdx.game.view.gameObjectViews.HeroView;
import com.mygdx.game.view.gameObjectViews.MonsterView;
import com.mygdx.game.view.gameObjectViews.NpcView;
import com.mygdx.game.view.gameObjectViews.NpcViewList;

import java.util.ArrayList;

public class GameplayScreen extends GameScreen {

    private BackgroundView bg;
    private GameObjectView earth;
    private HeroView heroView;
    private MonsterView monsterView;
    private Hero hero;
    private Monster monster;
    private Controller controller;
    private BitmapFont goldFont;
    private BitmapFont dmgFont;
    private HpLine hpLine;
    private ArrayList<DamageView> damageViews = new ArrayList<DamageView>();
    private Button menuButton;
    private Stage gui;
    private UpgradeMenu upgradeMenu;
    private NpcList npcs;
    private NpcViewList npcViews;
    private TotalDamage totalDamage;
    private LevelView lvlView;

    public GameplayScreen(GameScreenManager gsm) {
        super(gsm);
        camera.setToOrtho(false, Main.WIDTH, Main.HEIGHT / 2f);
        earth = new GameObjectView("environment/earth.png", 1);
        bg = new BackgroundView();
        heroView = new HeroView("hero/Stay.png", 1);
        monsterView = new MonsterView();
        monster = new Monster(100);
        npcs = new NpcList();
        npcViews = new NpcViewList();
        hero = new Hero(10);
        controller = new Controller(this);
        goldFont = new BitmapFont(Gdx.files.internal("gold.fnt"));
        dmgFont = new BitmapFont(Gdx.files.internal("sch_for_damage_view.fnt"));
        lvlView = new LevelView();
        hpLine = new HpLine();
        Buttons.load();
        menuButton = new Button(Buttons.menuButton);
        gui = new Stage();
        gui.addActor(menuButton);
        Gdx.input.setInputProcessor(gui);
        upgradeMenu = new UpgradeMenu(this, gui);
        totalDamage = new TotalDamage();
    }


    @Override
    public void update(float dt) {
        controller.handleInput();
        controller.update();
        heroView.update(dt);
        hero.update();
        monsterView.update(dt);
        npcViews.update(dt);
        npcs.update(monster, dt);
        totalDamage.update(hero, npcs);
        lvlView.update(monster);
    }

    @Override
    public void render() {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(bg.getTexture(), 0, 0, 720, 650);
        batch.draw(monsterView.getTextureRegion(), 15, 84.43f, 705.6f, 416);
        batch.draw(earth.getTexture(), 0, -70, 720, 880);
        batch.draw(heroView.getTextureRegion(), 360 - heroView.getTexture().getWidth() / 2, 118 - heroView.getTexture().getHeight() / 2, 90, 67f);
        goldFont.draw(batch, "GOLD: " + getHero().getGold(), 360, 624.4f, 5, 5, true);
        npcViews.render(batch);
        hpLine.render(batch, monster);
        dmgFont.draw(batch, totalDamage.getAttackHeroDamage(), 550, 625);
        dmgFont.draw(batch, totalDamage.getAttackNpcsDamage(), 550, 600);
        dmgFont.draw(batch, lvlView.getLvl(), 30, 625);
        if (monsterView.isBoss()) {
            dmgFont.draw(batch, "BOSS", 330, 575);
        }
        menuButton.setBounds(Gdx.graphics.getWidth() * 0.87f, Gdx.graphics.getHeight() * 0.005f, Gdx.graphics.getWidth() * 0.12f, Gdx.graphics.getHeight() * 0.089f);
        if (!damageViews.isEmpty()) {
            for (int i = 0; i < damageViews.size(); i++) {
                if (damageViews.get(i).isEnded()) {
                    damageViews.get(i).dispose();
                    damageViews.remove(i);
                } else {
                    damageViews.get(i).setBatch(batch);
                    damageViews.get(i).draw();
                }
            }
        }
        batch.end();
        if (!upgradeMenu.isOpened()) {
            gui.act(Gdx.graphics.getDeltaTime());
            gui.draw();
        } else {
            upgradeMenu.draw();
        }
    }

    @Override
    public void dispose() {
        bg.dispose();
        earth.dispose();
        heroView.dispose();
    }

    public HeroView getHeroView() {
        return heroView;
    }

    public MonsterView getMonsterView() {
        return monsterView;
    }

    public Hero getHero() {
        return hero;
    }

    public Monster getMonster() {
        return monster;
    }

    public void newDamageView() {
        damageViews.add(new DamageView(hero.getDamage()));
    }

    public void newDamageViewNpc() {
        for (int i : npcs.getNpcs().keySet()) {
            damageViews.add(new DamageView(npcs.getNpc(i).getDamage()));
        }
    }

    public Button getMenuButton() {
        return menuButton;
    }

    public UpgradeMenu getUpgradeMenu() {
        return upgradeMenu;
    }

    public Stage getGui() {
        return gui;
    }

    public void closeMenu() {
        upgradeMenu.close();
        gui.addActor(menuButton);
    }


    public NpcList getNpcs() {
        return npcs;
    }

    public NpcViewList getNpcViews() {
        return npcViews;
    }

    public void changeBackground() {
        bg.changeBg();
    }
}
