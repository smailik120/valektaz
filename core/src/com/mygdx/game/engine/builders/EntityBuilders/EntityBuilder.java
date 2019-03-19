package com.mygdx.game.engine.builders.EntityBuilders;

import com.mygdx.game.engine.builders.Build;
import com.mygdx.game.engine.entities.Entity;

import java.util.ArrayList;
import java.util.HashMap;

public interface EntityBuilder extends Build {
    public Entity getEntity();
}
