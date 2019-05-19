package com.mygdx.game.view.gameObjectViews;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;
import com.mygdx.game.view.Animation;

public class GameObjectView {
    private Polygon bounds;
    protected Animation objectAnimation;
    protected float timeSeconds = 0f;
    protected Sprite sprite;

    public GameObjectView(String path, int framecount) {
        this.bounds = new Polygon();
        this.objectAnimation = new Animation(new TextureRegion(newTexture(path)), framecount, 0.5f);
    }

    public GameObjectView(String path) {
        sprite = new Sprite(newTexture(path));
    }

    public GameObjectView() {
    }

    public Polygon getBounds() {
        return bounds;
    }

    public void update(float dt) {
        objectAnimation.update(dt);
    }

    public void dispose() {
        objectAnimation.dispose();
    }

    public TextureRegion getTextureRegion() {
        return objectAnimation.getFrame();
    }

    public Texture getTexture(){
        return objectAnimation.getFrame().getTexture();
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setBounds(Polygon bounds) {
        this.bounds = bounds;
    }

    public void changeAnimation(Texture frames, int framecount) {
        objectAnimation = new Animation(new TextureRegion(frames), framecount, 0.5f);
    }

    public void changeAnimation(Texture frames, int framecount, float cycleTime) {
        objectAnimation = new Animation(new TextureRegion(frames), framecount, cycleTime);
    }

    public void stayAnimation(){}

    public static Texture newTexture(String path) {
        Texture texture = new Texture(Gdx.files.internal(path));
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        return texture;
    }

    public Animation getObjectAnimation() {
        return objectAnimation;
    }
}
