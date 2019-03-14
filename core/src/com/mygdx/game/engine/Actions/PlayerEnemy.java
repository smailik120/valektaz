package com.mygdx.game.engine.Actions;

import com.mygdx.game.engine.components.Position;
import com.mygdx.game.engine.entities.Entity;

public class PlayerEnemy implements CollisionAction{

    @Override
    public void action(Entity first, Entity second) {
        Position position = (Position) first.getComponent("position");
        position.setPosX(position.getPosX() - 100);
    }
}
