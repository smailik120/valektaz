package com.mygdx.game.engine.builders.EntityBuilders;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.engine.components.Picture;
import com.mygdx.game.engine.components.Position;
import com.mygdx.game.engine.components.Size;
import com.mygdx.game.engine.components.Speed;
import com.mygdx.game.engine.entities.Entity;

public class EnemyBuilder {
    private Entity enemy;

    public Entity getPlayer() {
        return enemy;
    }

    public void setPlayer(Entity enemy) {
        this.enemy = enemy;
    }

    public EnemyBuilder() {
        enemy = new Entity();
        enemy.addComponent("position", new Position(400, 0));
        enemy.addComponent("size", new Size(50, 100));
        enemy.addComponent("speed", new Speed(new Vector2(0, 0)));
        enemy.addComponent("picture", new Picture(new Texture("badlogic.jpg")));
        enemy.setType("enemy");
    }
}
