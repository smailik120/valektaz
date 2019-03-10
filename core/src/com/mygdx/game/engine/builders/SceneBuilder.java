package com.mygdx.game.engine.builders;

import com.mygdx.game.engine.entities.Entity;
import com.mygdx.game.engine.scene.Scene;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class SceneBuilder {
    private ArrayList<Scene> scenes;
    private Scene currentScene;
    public  SceneBuilder(LinkedHashMap<String, ArrayList<Entity>> entities) {
        scenes = new ArrayList<Scene>();
        for(String name: entities.keySet()) {
            scenes.add(new Scene(entities.get(name), name));
        }
        currentScene = scenes.get(0);
    }

    public ArrayList<Scene> getScenes() {
        return scenes;
    }

    public void setScenes(ArrayList<Scene> scenes) {
        this.scenes = scenes;
    }
}
