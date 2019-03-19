package com.mygdx.game.engine.builders;

import com.mygdx.game.engine.builders.EntityBuilders.EnemyBuilder;
import com.mygdx.game.engine.builders.EntityBuilders.EntityBuilder;
import com.mygdx.game.engine.builders.EntityBuilders.PlayerBuilder;

import java.util.LinkedHashMap;

public class BuilderMapEntity {
    private LinkedHashMap<String, EntityBuilder> builders;

    public BuilderMapEntity() {
        builders = new LinkedHashMap<String, EntityBuilder>();
        builders.put("enemy", new EnemyBuilder());
        builders.put("player", new PlayerBuilder());
    }

    public LinkedHashMap<String, EntityBuilder> getBuilders() {
        return builders;
    }

    public void setBuilders(LinkedHashMap<String, EntityBuilder> builders) {
        this.builders = builders;
    }
}
