package com.mygdx.game.engine.builders.EntityBuilders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.engine.components.Mass;
import com.mygdx.game.engine.components.Picture;
import com.mygdx.game.engine.components.Position;
import com.mygdx.game.engine.components.Size;
import com.mygdx.game.engine.components.Speed;
import com.mygdx.game.engine.entities.Entity;

public class BlockBuilder implements EntityBuilder{
    private Entity block;
    public BlockBuilder() {
        build();
    }

    @Override
    public Entity getEntity() {
        build();
        return block;
    }

    @Override
    public void build() {
        block = new Entity();
        final int x = 0;
        final int y = 0;
        Picture picture = new Picture(new Texture("ground.png"));
        block.addComponent("position", new Position(x, y));
        block.addComponent("size", new Size(picture.getImage().getWidth(), picture.getImage().getHeight()));
        block.addComponent("picture", picture);
        block.addComponent("mass", new Mass(0));
        block.setType("block");
    }
}
