package com.mygdx.game.Generator;

import com.mygdx.game.engine.Engine;
import com.mygdx.game.engine.builders.Build;
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
        int counter = 0;
        int numberType = builders.size();
        Random random = new Random(new Date().getTime());
        for(int i = 1; i <= numberEntity ; i++) {
            EntityBuilder builder = null;
            int numberCurrentType = random.nextInt(numberType);
            for (String current : builders.keySet()) {
                if (counter == numberCurrentType && !current.equals("player")) {
                    builder = builders.get(current);
                    if(numberCurrentType == 2) {
                        System.out.println(builder);
                    }
                }
                counter++;
            }
            counter = 0;
            if (builder != null) {
                Entity first = builder.getEntity();
                Position positionFirst = null;
                Size sizeFirst = null;
                if (first.validate("position")) {
                    positionFirst = (Position) first.getComponent("position");
                    sizeFirst = (Size) (first.getComponent("size"));
                }
                for (Entity second : scene.getEntities()) {
                    Position positionSecond = (Position) second.getComponent("position");
                    Size sizeSecond = (Size) (second.getComponent("size"));
                }
                ArrayList<Entity> entities = scene.getEntities();
                entities.add(first);
                counter = 0;
            }
        }
    }
}
