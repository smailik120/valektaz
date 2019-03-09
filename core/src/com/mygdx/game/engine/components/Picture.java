package com.mygdx.game.engine.components;

import com.badlogic.gdx.graphics.Texture;

public class Picture implements Component {
    Texture image;
    public Picture(Texture image) {
        this.image = image;
    }

    public Texture getImage() {
        return image;
    }

    public void setImage(Texture image) {
        this.image = image;
    }
}
