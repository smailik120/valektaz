package com.mygdx.game.engine.entities;

import com.mygdx.game.engine.components.Component;

import java.util.HashMap;
import java.util.Objects;

public class Entity {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return Objects.equals(container, entity.container) &&
                Objects.equals(type, entity.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(container, type);
    }

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

    public boolean validate(String name) {
       if(container.containsKey(name)) {
           return true;
       }
       return false;
    }
}
