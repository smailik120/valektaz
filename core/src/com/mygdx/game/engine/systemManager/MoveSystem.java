package com.mygdx.game.engine.systemManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.engine.Engine;
import com.mygdx.game.engine.Map.Card;
import com.mygdx.game.engine.components.Picture;
import com.mygdx.game.engine.components.Position;
import com.mygdx.game.engine.components.Size;
import com.mygdx.game.engine.components.Speed;
import com.mygdx.game.engine.entities.Entity;
import com.mygdx.game.engine.scene.Scene;

import java.util.ArrayList;

public class MoveSystem implements Manager{
    ArrayList<Entity> entities;

    public MoveSystem(ArrayList<Entity> entities) {
        this.entities = entities;
    }

    public void move() {
        Engine engine = Engine.getEngine();
        Card card = engine.getCard();
        Scene scene = card.getCurrentScene();
        ArrayList<Entity> player = scene.getEntityByType("player");
        Speed speed = (Speed) player.get(0).getComponent("speed");
        if (Gdx.input.justTouched() && speed.getVector().y == 0) {
            speed.setVector(new Vector2(speed.getVector().x,10));
        }

        for (Entity entity : entities) {
            if(entity.getType() != "player") {
                Position position = (Position) entity.getComponent("position");
                if(entity.validate("speed") == true) {
                    Speed current = (Speed) entity.getComponent("speed");
                    position.setPosX(position.getPosX() - speed.getVector().x + current.getVector().x);
                    position.setPosY(position.getPosY() - speed.getVector().y + current.getVector().y);
                }
                else {
                    position.setPosX(position.getPosX() - speed.getVector().x);
                    position.setPosY(position.getPosY() - speed.getVector().y);
                }
            }
        }
    }

    @Override
    public void update() {
            move();
    }
}
