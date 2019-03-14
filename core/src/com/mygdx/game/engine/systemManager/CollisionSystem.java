package com.mygdx.game.engine.systemManager;
import com.mygdx.game.engine.Actions.CollisionAction;
import com.mygdx.game.engine.Engine;
import com.mygdx.game.engine.components.Collision;
import com.mygdx.game.engine.components.Position;
import com.mygdx.game.engine.components.Size;
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
        ArrayList<Entity> collisionEntities = Engine.getCard().getCurrentScene().getEntitiesByComponent("collision");
        for (Entity entityFirst : collisionEntities) {
            for (Entity entitySecond : entities) {
                if (!entityFirst.equals(entitySecond)) {
                    if (collide(entityFirst, entitySecond)) {
                        if (entityFirst.validate("collision")) {
                            Collision collision = (Collision) entityFirst.getComponent("collision");
                            ArrayList<Entity> collisionList = collision.getEntities();
                            collisionList.add(entitySecond);
                        }
                    }
                }
            }
        }
        for (Entity entity : collisionEntities) {
            if (entity.validate("collision")) {
                Collision collision = (Collision) entity.getComponent("collision");
                if(collision.getEntities() != null) {
                    ArrayList<Entity> collisionList = collision.getEntities();
                    for (Entity other : collisionList) {
                        String firstType = entity.getType();
                        String secondType = other.getType();
                        CollisionAction collisionAction;
                        collisionAction = collisions.get(new Pair<String, String>(firstType, secondType));
                        collisionAction.action(entity, other);
                    }
                    collision.setEntities(new ArrayList<Entity>());
                }
            }
        }
    }
    public boolean collide(Entity first, Entity second) {
        Position firstPos = (Position) first.getComponent("position");
        Position secondPos = (Position) second.getComponent("position");
        Size firstSize = (Size) first.getComponent("size");
        Size secondSize = (Size) second.getComponent("size");
        return (((firstPos.getPosX() < secondPos.getPosX() + secondSize.getWidth()) &&
                (firstPos.getPosX() + firstSize.getWidth() > secondPos.getPosX()))) && (firstPos.getPosY() < secondPos.getPosY() + secondSize.getHeight()) &&
                (secondPos.getPosY() < firstPos.getPosY() + firstSize.getHeight());
    }
}
