package com.mygdx.game.Generator;

import com.mygdx.game.engine.Engine;
import com.mygdx.game.engine.builders.EntityBuilders.EnemyBuilder;
import com.mygdx.game.engine.builders.EntityBuilders.EntityBuilder;
import com.mygdx.game.engine.components.Position;
import com.mygdx.game.engine.components.Size;
import com.mygdx.game.engine.entities.Entity;
import com.mygdx.game.engine.scene.Scene;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Random;

public class Generator {
    private Scene scene;
    private long time = 0;
    private LinkedHashMap<String, EntityBuilder> builders;
    public Generator(LinkedHashMap<String, EntityBuilder> builders) {
        this.builders = builders;
    }

    public void update() {
        scene = Engine.getCard().getCurrentScene();
        time = System.currentTimeMillis()/1000;
        int numberEntity = 1;
        int minDistance = 100;
        int randomValue = 600;
        int startValue = 400;
        int counter = 0;
        Random random = new Random(new Date().getTime());
        for(int i = 1; i <= numberEntity ; i++) {
            EnemyBuilder builder = (EnemyBuilder) builders.get("enemy");
            Entity first = builder.getPlayer();
            Position positionFirst = null;
            Size sizeFirst = null;
            if(first.validate("position")) {
                positionFirst = (Position) first.getComponent("position");
                sizeFirst = (Size) (first.getComponent("size"));
                positionFirst.setPosX(random.nextInt(randomValue) + startValue);
            }
            for (Entity second : scene.getEntities()) {
                Position positionSecond = (Position) second.getComponent("position");
                Size sizeSecond = (Size) (second.getComponent("size"));
                if(minDistance <= positionSecond.getPosX() - (positionFirst.getPosX() + sizeFirst.getWidth()) || minDistance <= positionFirst.getPosX() - (positionSecond.getPosX() + sizeSecond.getWidth())) {
                    counter++;
                }
            }
            if(counter == scene.getEntities().size()) {
                ArrayList<Entity> entities = scene.getEntities();
                entities.add(first);
                System.out.println("yep");
            }
            counter = 0;
        }
    }
}
