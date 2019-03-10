package com.mygdx.game.engine;
import android.util.Pair;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.engine.Actions.CollisionAction;
import com.mygdx.game.engine.Map.Card;
import com.mygdx.game.engine.builders.Builder;
import com.mygdx.game.engine.builders.ManagerBuilder;
import com.mygdx.game.engine.builders.PlayerBuilder;
import com.mygdx.game.engine.builders.SceneBuilder;
import com.mygdx.game.engine.components.Picture;
import com.mygdx.game.engine.components.Position;
import com.mygdx.game.engine.components.Size;
import com.mygdx.game.engine.components.Speed;
import com.mygdx.game.engine.entities.Entity;
import com.mygdx.game.engine.scene.Scene;
import com.mygdx.game.engine.systemManager.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Engine extends ApplicationAdapter {
    private static Engine engine;
    private Card card;
    private SystemManager manager;
    private Builder builder;
    public static Engine getEngine() {
        if (engine == null) {
            engine = new Engine();
        }
            return engine;
    }

    public void initEngine() {
        engine = getEngine();
    }

    @Override
    public void create () {
        initEngine();
        builder = new Builder();
        card = builder.getCard();
        manager = builder.getManager();
    }

    @Override
    public void render () {
        manager.update();
    }

    @Override
    public void dispose () {
        CameraSystem cameraSystem = (CameraSystem) manager.getServices().get("cameraSystem");
        cameraSystem.dispose();
    }

}
