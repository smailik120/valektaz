package com.mygdx.game.engine.systemManager;

import com.mygdx.game.Generator.Generator;

public class GenerateSystem implements Manager {
    private Generator generator;
    public GenerateSystem(Generator generator) {
        this.generator = generator;
    }
    @Override
    public void update() {
        generator.update();
    }
}
