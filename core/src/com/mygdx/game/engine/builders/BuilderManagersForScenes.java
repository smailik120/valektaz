package com.mygdx.game.engine.builders;

import com.mygdx.game.engine.systemManager.GravitationSystem;
import com.mygdx.game.engine.systemManager.Manager;
import com.mygdx.game.engine.systemManager.SystemManager;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class BuilderManagersForScenes {
    HashMap<String, ArrayList<Manager>> managersForScene;
    public HashMap<String, ArrayList<Manager>> getManagersForScene() {
        return managersForScene;
    }

    public void setManagersForScene(HashMap<String, ArrayList<Manager>> managersForScene) {
        this.managersForScene = managersForScene;
    }

    public BuilderManagersForScenes(SystemManager manager) {
        managersForScene = new HashMap<String, ArrayList<Manager>>();
        ArrayList<Manager> current = new ArrayList<Manager>();
        current.add(manager.getSystemByName("cameraSystem"));
        current.add(manager.getSystemByName("moveSystem"));
        current.add(manager.getSystemByName("gravitationSystem"));
        //current.add(manager.getSystemByName("collisionSystem"));
        current.add(manager.getSystemByName("generateSystem"));
        managersForScene.put("start", current);
    }

}
