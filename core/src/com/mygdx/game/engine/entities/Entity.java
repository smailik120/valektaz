package com.mygdx.game.engine.entities;

import com.mygdx.game.engine.components.Component;

import java.util.HashMap;

public class Entity {
    private HashMap<String, Component> container = new HashMap<String, Component>();

    public void addComponent(String componentName, Component component) {
        container.put(componentName, component);
    }
    public Component getComponent(String componentName) {
        return container.get(componentName);
    }
    public HashMap<String, Component> getContainer() {
        return container;
    }

    public void setContainer(HashMap<String, Component> container) {
        this.container = container;
    }
}
