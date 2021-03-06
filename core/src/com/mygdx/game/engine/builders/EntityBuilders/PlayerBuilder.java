package com.mygdx.game.engine.builders.EntityBuilders;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.engine.builders.Build;
import com.mygdx.game.engine.components.*;
import com.mygdx.game.engine.entities.Entity;

import java.util.ArrayList;

public class PlayerBuilder implements EntityBuilder {
    private Entity player;

    @Override
    public Entity getEntity() {
        build();
        return player;
    }

    public void setPlayer(Entity player) {
        this.player = player;
    }

    public PlayerBuilder() {
        player = new Entity();
        player.addComponent("collision", new Collision(new ArrayList<Entity>()));
        player.addComponent("position", new Position(0, 0));
        player.addComponent("size", new Size(30, 30));
        player.addComponent("speed", new Speed(new Vector2(1, 0)));
        player.addComponent("mass", new Mass(0.3f));
        player.addComponent("picture", new Picture(new Texture("C:\\images\\b4.bmp")));
        player.setType("player");
    }


    @Override
    public void build() {

    }
}
