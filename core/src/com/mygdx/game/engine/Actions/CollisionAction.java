package com.mygdx.game.engine.Actions;

import com.mygdx.game.engine.entities.Entity;

public interface CollisionAction {
    public void action(Entity first, Entity second);
}
