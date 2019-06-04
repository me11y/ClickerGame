package com.mygdx.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.mygdx.game.view.Buttons;
import com.mygdx.game.view.GameplayScreen;
import com.mygdx.game.view.Main;

public class Controller {
    GameplayScreen gameplayScreen;
    public Controller(GameplayScreen gameplayScreen) {
        this.gameplayScreen = gameplayScreen;
    }

    public void update() {
        for(int i: gameplayScreen.getNpcViews().getNpcViews().keySet()) {
            if (gameplayScreen.getNpcs().getNpc(i).getTimeSeconds() >= 1.8f && !gameplayScreen.getNpcViews().getNpcView(i).isAttacked()) {
                gameplayScreen.getNpcViews().getNpcView(i).damageAnimation();
            } else if (!gameplayScreen.getMonsterView().isDamaged() && gameplayScreen.getNpcs().getNpc(i).getTimeSeconds() >= 2 - Gdx.graphics.getDeltaTime()) {
                gameplayScreen.getMonsterView().takeDamageAnimation();
                gameplayScreen.newDamageViewNpc();
            }
        }
        if(gameplayScreen.getMonster().isLvlChanged()){
            gameplayScreen.getMonster().setLvlChanged();
            gameplayScreen.changeBackground();
        }
        if(gameplayScreen.getMonster().getSublvl()==10 && !gameplayScreen.getMonsterView().isBoss()){
            gameplayScreen.getMonsterView().setBoss(true);
        }
    }

    public void handleInput() {
        //клики по врагу
        if (!gameplayScreen.getUpgradeMenu().isOpened()) {
            if (!gameplayScreen.getMonsterView().isDead()) {
                if (Gdx.input.justTouched()) {
                    if (Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getHeight() / 5.7f) {
                        gameplayScreen.getHeroView().attackAnimation();
                        gameplayScreen.getMonsterView().takeDamageAnimation();
                        gameplayScreen.getHero().attack(gameplayScreen.getMonster());
                        gameplayScreen.newDamageView();
                    }
                }
            }
        } else {
            if (gameplayScreen.getUpgradeMenu().getExitButton().isChecked()) {
                gameplayScreen.getUpgradeMenu().getExitButton().setChecked(false);
                gameplayScreen.closeMenu();
            }
            if (gameplayScreen.getUpgradeMenu().getAttackButton().isChecked()) {
                gameplayScreen.getUpgradeMenu().getAttackButton().setChecked(false);
                gameplayScreen.getHero().damageUpgrade();
            }
            if (gameplayScreen.getUpgradeMenu().getNpc1Button().isChecked()) {
                gameplayScreen.getUpgradeMenu().getNpc1Button().setChecked(false);
                upgradeNpc(0);
            }
            if(gameplayScreen.getUpgradeMenu().getNpc2Button().isChecked()){
                gameplayScreen.getUpgradeMenu().getNpc2Button().setChecked(false);
                upgradeNpc(1);
            }
            if(gameplayScreen.getUpgradeMenu().getNpc3Button().isChecked()){
                gameplayScreen.getUpgradeMenu().getNpc3Button().setChecked(false);
                upgradeNpc(2);
            }
            if(gameplayScreen.getUpgradeMenu().getNpc4Button().isChecked()){
                gameplayScreen.getUpgradeMenu().getNpc4Button().setChecked(false);
                upgradeNpc(3);
            }
            if(gameplayScreen.getUpgradeMenu().getHeroButton().isChecked()){
                gameplayScreen.getUpgradeMenu().getHeroButton().setChecked(false);
                gameplayScreen.getUpgradeMenu().setMenu((short)1);
                gameplayScreen.getUpgradeMenu().open();
            }
            if(gameplayScreen.getUpgradeMenu().getNpcsButton().isChecked()){
                gameplayScreen.getUpgradeMenu().getNpcsButton().setChecked(false);
                gameplayScreen.getUpgradeMenu().setMenu((short)2);
                gameplayScreen.getUpgradeMenu().open();
            }
        }
        if (gameplayScreen.getMonster().getHp() <= 0) {
            gameplayScreen.getHero().getMoreGold(gameplayScreen.getMonster().getGold());
            gameplayScreen.getMonster().die();
            gameplayScreen.getMonsterView().die();
        }
        if (gameplayScreen.getMenuButton().isChecked()) {
            gameplayScreen.getGui().clear();
            gameplayScreen.getMenuButton().setChecked(false);
            gameplayScreen.getUpgradeMenu().open();
        }
    }

    private void upgradeNpc(int i){
        if(gameplayScreen.getHero().isAbleToUpgrade(gameplayScreen.getNpcs().getUpgradePrice(i))){
            gameplayScreen.getHero().npcUpgrade(gameplayScreen.getNpcs().getUpgradePrice(i));
            gameplayScreen.getNpcs().upgradeNpc(i);
            gameplayScreen.getNpcViews().addNpcView(i);
        }
    }
}
