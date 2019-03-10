package com.mygdx.game.engine.entities;

import com.mygdx.game.engine.components.Component;

import java.util.HashMap;
import java.util.Objects;

public class Entity {
    private HashMap<String, Component> container = new HashMap<String, Component>();
    String type;
    public void addComponent(String componentName, Component component) {
        container.put(componentName, component);
    }
    public Component getComponent(String componentName) {
        return container.get(componentName);
    }
    public HashMap<String, Component> getContainer() {
        return container;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setContainer(HashMap<String, Component> container) {
        this.container = container;
    }
}
