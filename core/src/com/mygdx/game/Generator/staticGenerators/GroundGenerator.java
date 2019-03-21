package com.mygdx.game.Generator.staticGenerators;

import com.mygdx.game.engine.Engine;
import com.mygdx.game.engine.builders.EntityBuilders.BlockBuilder;
import com.mygdx.game.engine.components.Position;
import com.mygdx.game.engine.components.Size;
import com.mygdx.game.engine.entities.Entity;
import com.mygdx.game.engine.scene.Scene;

import java.util.ArrayList;

public class GroundGenerator {
    public void update() {
        //todo
        ArrayList<Entity> entities  = Engine.getCard().getCurrentScene().getEntityByType("block");
        ArrayList<Entity> result = Engine.getCard().getCurrentScene().getEntities();
        if (entities.size() < 1) entities.add(new BlockBuilder().getEntity());
        Position pos = (Position) entities.get(0).getComponent("position");
        Size size = (Size) entities.get(0).getComponent("size");
        if (entities.size() <2 ){
            BlockBuilder blockBuilder = new BlockBuilder();
            Entity entity = blockBuilder.getEntity();
            Position position = (Position)entity.getComponent("position");
            position.setPosX(pos.getPosX()+size.getWidth());
            position.setPosY(pos.getPosY());
            result.add(entity);
        }
        if (pos.getPosX() < 0 - size.getWidth() && entities.size()>1) {
            ArrayList<Entity> newEntities = new ArrayList<Entity>();
            newEntities.add(entities.get(1));
            entities = newEntities;
        }
    }
}
