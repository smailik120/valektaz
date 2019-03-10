package com.mygdx.game.engine.systemManager;
import com.mygdx.game.engine.Actions.CollisionAction;
import com.mygdx.game.engine.components.Collision;
import com.mygdx.game.engine.entities.Entity;
import com.mygdx.game.manager.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class CollisionSystem implements Manager {
    ArrayList<Entity> entities;
    HashMap<Pair<String, String>, CollisionAction> collisions;
    public CollisionSystem(ArrayList<Entity> entities, HashMap<Pair<String, String>, CollisionAction> collisions) {
        this.entities = entities;
        this.collisions = collisions;
    }
    @Override
    public void update() {
        for(Entity entityFirst: entities) {
            for(Entity entitySecond: entities) {
                if(!entityFirst.equals(entitySecond)) {
                    if(collide(entityFirst, entitySecond)) {
                        Collision collision = (Collision) entityFirst.getComponent("collision");
                        collision.getEntities().add(entitySecond);
                    }
                }
            }
        }
        for(Entity entity: entities) {
            Collision collision = (Collision) entity.getComponent("collision");
            if (collision != null) {
                for (Entity other : collision.getEntities()) {
                    String firstType;
                    String secondType;
                    CollisionAction collisionAction;
                    //collisionAction.action
                }
                collision.setEntities(new ArrayList<Entity>());
            }
        }
    }
    public boolean collide(Entity first, Entity second) {
        //todo
        return true;
    }
}
