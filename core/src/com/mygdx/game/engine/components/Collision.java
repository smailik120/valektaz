package com.mygdx.game.engine.components;

import com.mygdx.game.engine.entities.Entity;

import java.util.ArrayList;

public class Collision implements Component{
    private ArrayList<Entity> entities;

    public Collision(ArrayList<Entity> entities) {
        this.entities = entities;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }
}
