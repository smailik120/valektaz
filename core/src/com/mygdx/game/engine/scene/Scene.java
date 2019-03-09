package com.mygdx.game.engine.scene;

import com.mygdx.game.engine.entities.Entity;

import java.util.ArrayList;

public class Scene {
    String name;
    private ArrayList<Entity> entities = new ArrayList<Entity>();

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }

    public Scene(ArrayList<Entity> entities) {
        this.entities = entities;
    }

    public void setName(String name) {
        this.name = name;
    }
}
