package com.mygdx.game.engine.systemManager;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.engine.components.Mass;
import com.mygdx.game.engine.components.Speed;
import com.mygdx.game.engine.entities.Entity;

import java.util.ArrayList;

public class GravitationSystem implements Manager{
    private ArrayList<Entity> entities;

    public GravitationSystem(ArrayList<Entity> entities) {
        this.entities = entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }

    @Override
    public void update() {
        for (Entity entity : entities) {
            Mass mass = (Mass) entity.getComponent("mass");
            Speed speed = (Speed) entity.getComponent("speed");
            float a = 0;
            if (mass != null && speed!=null) {
                float b = mass.getMass() * 0.02f;
                a += b;
                speed.setVector(new Vector2(
                        speed.getVector().x,
                        speed.getVector().y - a
                ));
            }
        }
    }
}