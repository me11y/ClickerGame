package com.mygdx.game.view.gameObjectViews;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.view.Animation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BackgroundView extends GameObjectView {
    Random rnd = new Random();

    public BackgroundView() {
        this.objectAnimation = new Animation(new TextureRegion(newTexture("environment/bg" + rnd.nextInt(4) + ".png")), 1, 0.5f);
    }

    public void changeBg() {
        objectAnimation.dispose();
        changeAnimation(newTexture("environment/bg" + rnd.nextInt(4) + ".png"), 1);
    }
}
