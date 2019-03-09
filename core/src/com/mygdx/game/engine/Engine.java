package com.mygdx.game.engine;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
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
    private ArrayList<Scene> array;
    ArrayList<Entity> entities;
    SystemManager manager;
    public static Engine getEngine() {
        if (engine == null) {
            engine = new Engine();
        }
            return engine;
    }

    public void initEngine() {
        engine = getEngine();
    }

    public void init() {
        initEngine();
        array = new ArrayList<Scene>();
        entities = new ArrayList<Entity>();
        LinkedHashMap<String, Manager> services = new LinkedHashMap<String, Manager>();
        manager = new SystemManager(services);
        Entity player = new Entity();
        player.addComponent("position", new Position(0, 0));
        player.addComponent("size", new Size(30, 30));
        player.addComponent("speed", new Speed(new Vector2(1, 0)));
        player.addComponent("picture", new Picture(new Texture("C:\\images\\b.bmp")));
        entities.add(player);
        Scene scene = new Scene(entities);
        Camera camera = new Camera(scene.getEntities());
        CameraSystem cameraSystem = new CameraSystem(camera);
        MoveSystem moveSystem = new MoveSystem(entities);
        manager.addManager("cameraSystem", cameraSystem);
        manager.addManager("moveSystem", moveSystem);
    }

    @Override
    public void create () {
        init();
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
