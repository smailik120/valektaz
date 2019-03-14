package com.mygdx.game.engine.builders;

import com.mygdx.game.engine.entities.Entity;
import com.mygdx.game.engine.scene.Scene;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class SceneBuilder {
    private ArrayList<Scene> scenes;
    private Scene currentScene;
    public  SceneBuilder(ArrayList<ArrayList<Entity>> entities) {
        scenes = new ArrayList<Scene>();
        Scene start = new Scene(entities.get(0), "start");
        start.setGamePlay(true);
        scenes.add(start);
    }

    public ArrayList<Scene> getScenes() {
        return scenes;
    }

    public void setScenes(ArrayList<Scene> scenes) {
        this.scenes = scenes;
    }
}
