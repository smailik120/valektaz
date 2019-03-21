package com.mygdx.game.engine.components;

public class Mass implements Component{
    private float mass;

    public Mass(float mass) {
      this.mass = mass;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }

    public float getMass() {
        return mass;
    }
}
