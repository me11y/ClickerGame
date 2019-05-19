package com.mygdx.game.view.gameObjectViews;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NpcViewList {
    private Map<Integer, NpcView> npcViews;

    public NpcViewList() {
        npcViews = new HashMap<Integer, NpcView>();
    }

    public void update(float dt){
        for (int i : npcViews.keySet()){
            npcViews.get(i).update(dt);
        }
    }

    public void render(SpriteBatch batch){
        for (int i : npcViews.keySet()) {
            batch.draw(npcViews.get(i).getTextureRegion(), npcViews.get(i).getX(), npcViews.get(i).getY(), 300, 150);
        }
    }

    public void addNpcView(int i){
        if(!npcViews.containsKey(i)) {
            npcViews.put(i, new NpcView(i));
        }
    }

    public NpcView getNpcView(int i){
        return npcViews.get(i);
    }

    public Map<Integer, NpcView> getNpcViews() {
        return npcViews;
    }
}
