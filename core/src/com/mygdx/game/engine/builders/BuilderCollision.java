package com.mygdx.game.engine.builders;

import android.util.Pair;
import com.mygdx.game.engine.Actions.CollisionAction;

import java.util.HashMap;

public class BuilderCollision {
    HashMap<Pair<String, String>, CollisionAction> collisions;

    public BuilderCollision() {
        //init
    }

    public HashMap<Pair<String, String>, CollisionAction> getCollisions() {
        return collisions;
    }

}
