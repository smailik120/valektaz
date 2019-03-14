package com.mygdx.game.engine.systemManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class SystemManager {
    private LinkedHashMap<String, Manager> services;
    private ArrayList<Manager> activeServices;

    public ArrayList<Manager> getActiveServices() {
        return activeServices;
    }

    public void setActiveServices(ArrayList<Manager> activeServices) {
        this.activeServices = activeServices;
    }

    public SystemManager(LinkedHashMap<String, Manager> services, LinkedHashMap<String, Manager> activeServices) {
        this.services = services;
    }

    public HashMap<String, Manager> getServices() {
        return services;
    }

    public void setServices(LinkedHashMap<String, Manager> services) {
        this.services = services;
    }

    public void update() {
        for(Manager manager: activeServices) {
            manager.update();
        }
    }

    public void addManager(String name, Manager manager) {
        services.put(name, manager);
    }

    public Manager getSystemByName(String name) {
        return services.get(name);
    }
}
