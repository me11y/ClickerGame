package com.mygdx.game.view.gameObjectViews;

public class HeroView extends GameObjectView {
    private int attackNumber=0;
    private boolean attacked;
    public HeroView(String path, int framecount) {
        super(path, framecount);
    }

    @Override
    public void update(float dt){
        objectAnimation.update(dt);
        if(attacked){
            timeSeconds += dt;
            if(timeSeconds>=0.25f) {
                attacked=false;
                stayAnimation();
                timeSeconds=0;
            }
        }
    }

    public void attackAnimation(){
        timeSeconds = 0f;
        attacked = true;
        if(attackNumber==0) {
            changeAnimation(newTexture("hero/Attack1.png"), 1);
            attackNumber++;
        }
        else if(attackNumber==1) {
            changeAnimation(newTexture("hero/Attack2.png"), 1);
            attackNumber++;
        }
        else {
            changeAnimation(newTexture("hero/Attack3.png"), 1);
            attackNumber=0;
        }
    }

    @Override
    public void stayAnimation(){
        changeAnimation(newTexture("hero/Stay.png"), 1);
    }

    public boolean isAttacked() {
        return attacked;
    }
}