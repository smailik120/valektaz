package com.mygdx.game.engine.builders;

import com.mygdx.game.engine.Actions.CollisionAction;
import com.mygdx.game.engine.entities.Entity;
import com.mygdx.game.engine.systemManager.*;
import com.mygdx.game.manager.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class ManagerBuilder {
    private SystemManager services;
    public ManagerBuilder(ArrayList<Entity> entities) {
        HashMap<Pair<String, String>, CollisionAction> collisions;
        LinkedHashMap systems = new LinkedHashMap<String, Manager>();
        LinkedHashMap activeSystems = new LinkedHashMap<String, Manager>();
        services = new SystemManager(systems, activeSystems);
        Camera camera = new Camera(entities);
        CameraSystem cameraSystem = new CameraSystem(camera);
        MoveSystem moveSystem = new MoveSystem(entities);
        collisions = new BuilderCollision().getCollisions();
        CollisionSystem collisionSystem = new CollisionSystem(entities, collisions);
        services.addManager("cameraSystem", cameraSystem);
        services.addManager("moveSystem", moveSystem);
        services.addManager("collisionSystem", collisionSystem);
    }

    public SystemManager getServices() {
        return services;
    }

    public void setServices(SystemManager services) {
        this.services = services;
    }

}
