package com.mygdx.game.engine.scene;

import com.mygdx.game.engine.entities.Entity;
import com.mygdx.game.engine.systemManager.Manager;

import java.util.ArrayList;

public class Scene {
    private String name;
    private ArrayList<Entity> entities;
    private ArrayList<Manager> activeServices;
    public ArrayList<Entity> getEntities() {
        return entities;
    }
    private boolean gamePlay = false;

    public ArrayList<Manager> getActiveServices() {
        return activeServices;
    }

    public void setActiveServices(ArrayList<Manager> activeServices) {
        this.activeServices = activeServices;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }

    public Scene(ArrayList<Entity> entities,String name)
    {
        this.entities = entities;
        setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Entity> getEntityByType(String type) {
        ArrayList<Entity> result = new ArrayList<Entity>();
        for (Entity entity : entities) {
            if(entity.getType() == type) {
                result.add(entity);
            }
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public boolean isGamePlay() {
        return gamePlay;
    }

    public void setGamePlay(boolean gamePlay) {
        this.gamePlay = gamePlay;
    }

    public ArrayList<Entity> getEntitiesByComponent(String name) {
        ArrayList<Entity> result = new ArrayList<Entity>();
        for(Entity entity: entities) {
            if(entity.validate(name)) {
                result.add(entity);
            }
        }
        return result;
    }
}
