package com.mygdx.game.engine.components;

import com.badlogic.gdx.math.Vector2;

public class Speed implements Component {
    private Vector2 vector;
    public Speed(Vector2 vector) {
        this.vector = vector;
    }

    public Vector2 getVector() {
        return vector;
    }

    public void setVector(Vector2 vector) {
        this.vector = vector;
    }
}
