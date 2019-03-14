package com.mygdx.game.engine.builders;
import com.mygdx.game.engine.Actions.CollisionAction;
import com.mygdx.game.engine.Actions.PlayerEnemy;
import com.mygdx.game.engine.entities.Entity;
import com.mygdx.game.manager.Pair;

import java.util.HashMap;

public class BuilderCollision {
    HashMap<Pair<String, String>, CollisionAction> collisions;

    public BuilderCollision() {
        collisions = new HashMap<Pair<String, String>, CollisionAction>();
        collisions.put(new Pair<String, String>("player", "enemy"), new PlayerEnemy());
        collisions.put(new Pair<String, String>("enemy", "player"), new PlayerEnemy());
    }

    public HashMap<Pair<String, String>, CollisionAction> getCollisions() {
        return collisions;
    }

}
