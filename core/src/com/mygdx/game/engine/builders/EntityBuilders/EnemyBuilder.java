package com.mygdx.game.engine.builders.EntityBuilders;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.engine.builders.Build;
import com.mygdx.game.engine.components.Picture;
import com.mygdx.game.engine.components.Position;
import com.mygdx.game.engine.components.Size;
import com.mygdx.game.engine.components.Speed;
import com.mygdx.game.engine.entities.Entity;

import java.util.Date;
import java.util.Random;

import static com.badlogic.gdx.physics.box2d.Box2D.init;

public class EnemyBuilder implements EntityBuilder{
    private Entity enemy;
    private int minDistanceX = 100;
    private int minDistanceY = 0;
    public void setPlayer(Entity enemy) {
        this.enemy = enemy;
    }

    public EnemyBuilder() {
        build();
    }

    public int getMinDistanceX() {
        return minDistanceX;
    }

    public void setMinDistanceX(int minDistanceX) {
        this.minDistanceX = minDistanceX;
    }

    public int getMinDistanceY() {
        return minDistanceY;
    }

    public void setMinDistanceY(int minDistanceY) {
        this.minDistanceY = minDistanceY;
    }

    public void setEnemy(Entity enemy) {
        this.enemy = enemy;
    }

    @Override
    public void build() {
        Random random = new Random(new Date().getTime());
        int randomValue = 600;
        float startValue = 400;
        enemy = new Entity();
        enemy.addComponent("position", new Position(startValue + random.nextInt(randomValue), 0));
        enemy.addComponent("size", new Size(50, 100));
        enemy.addComponent("speed", new Speed(new Vector2(0, 0)));
        enemy.addComponent("picture", new Picture(new Texture("badlogic.jpg")));
        enemy.setType("enemy");
    }

    @Override
    public Entity getEntity() {
        build();
        return enemy;
    }
}
