package com.mygdx.game.engine.Map;

import com.mygdx.game.engine.scene.Scene;

import java.util.ArrayList;

public class Card {
    ArrayList<Scene> scenes;
    Scene currentScene;
    public Card(ArrayList<Scene> scenes) {
        this.scenes = scenes;
        currentScene = scenes.get(0);
    }

    public ArrayList<Scene> getScenes() {
        return scenes;
    }

    public void setCurrentScene(Scene currentScene) {
        this.currentScene = currentScene;
    }

    public Scene getCurrentScene() {
        return currentScene;
    }
}
