package com.mygdx.game.engine.systemManager;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class SystemManager {
    private LinkedHashMap<String, Manager> services = new LinkedHashMap<String, Manager>();

    public SystemManager(LinkedHashMap<String, Manager> services) {
        this.services = services;
    }

    public HashMap<String, Manager> getServices() {
        return services;
    }

    public void setServices(LinkedHashMap<String, Manager> services) {
        this.services = services;
    }

    public void update() {
        for(Manager manager: services.values()) {
            manager.update();
        }
    }

    public void addManager(String name, Manager manager) {
        services.put(name, manager);
    }
}
