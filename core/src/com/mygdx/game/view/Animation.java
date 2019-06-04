package com.mygdx.game.view;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Animation {
    private Array<TextureRegion> frames;
    private float maxFrameTime;
    private float currentFrameTime;
    private int frameCount;
    private int maxFrames;
    private int currentFrame;
    private boolean animEnded;

    public Animation(TextureRegion region, int frameCount, float cycleTime) {
        //работа с регионами текстур
        maxFrames = frameCount;
        frames = new Array<TextureRegion>();
        int frameWidth = region.getRegionWidth() / frameCount;
        for (int i = 0; i < frameCount; i++) {
            frames.add(new TextureRegion(region, i * frameWidth, 0, frameWidth, region.getRegionHeight()));
        }
        this.frameCount = frameCount;
        maxFrameTime = cycleTime / frameCount;
        currentFrame = 0;
    }

    public void update(float dtime) {
        //сам процесс анимации
        if (currentFrame == 0) animEnded = false;
        currentFrameTime += dtime;
        if (currentFrameTime > maxFrameTime) {
            currentFrame++;
            currentFrameTime = 0;
        }
        if (currentFrame >= maxFrames) {
            currentFrame = 0;
            animEnded = true;
        }
    }

    public TextureRegion getFrame() {
        return frames.get(currentFrame);
    }

    public float getCurrentFrameTime() {
        return currentFrameTime;
    }

    public float getMaxFrameTime() {
        return maxFrameTime;
    }

    public void setMaxFrames(int maxFrames) {
        this.maxFrames = maxFrames;
    }

    public int getMaxFrames() {
        return maxFrames;
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public boolean isAnimEnded() {
        return animEnded;
    }

    public void dispose(){
        for(int i=0; i<frames.size; i++){
            frames.get(i).getTexture().dispose();
        }
    }
}

