package com.mygdx.game.engine.systemManager;

import com.mygdx.game.engine.components.Picture;
import com.mygdx.game.engine.components.Position;
import com.mygdx.game.engine.components.Size;
import com.mygdx.game.engine.components.Speed;
import com.mygdx.game.engine.entities.Entity;

import java.util.ArrayList;

public class MoveSystem implements Manager{
    ArrayList<Entity> entities;

    public MoveSystem(ArrayList<Entity> entities) {
        this.entities = entities;
    }

    public void move() {
        for (Entity entity : entities) {
            Position position = (Position) entity.getComponent("position");
            Speed speed = (Speed) entity.getComponent("speed");
            position.setPosX(position.getPosX() + speed.getVector().x);
            position.setPosY(position.getPosY() + speed.getVector().y);
        }
    }

    @Override
    public void update() {
        move();
    }
}
