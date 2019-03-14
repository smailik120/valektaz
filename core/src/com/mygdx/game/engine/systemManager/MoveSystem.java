package com.mygdx.game.engine.systemManager;

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
        System.out.println(card);
        Scene scene = card.getCurrentScene();
        ArrayList<Entity> player = scene.getEntityByType("player");
        Speed speed = (Speed) player.get(0).getComponent("speed");
        for (Entity entity : entities) {
            if(entity.getType() != "player") {
                Position position = (Position) entity.getComponent("position");
                position.setPosX(position.getPosX() - speed.getVector().x);
                position.setPosY(position.getPosY() - speed.getVector().y);
            }
        }
    }

    @Override
    public void update() {
            move();
    }
}
