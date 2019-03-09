package com.mygdx.game.engine.systemManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.engine.components.Picture;
import com.mygdx.game.engine.components.Position;
import com.mygdx.game.engine.components.Size;
import com.mygdx.game.engine.components.Speed;
import com.mygdx.game.engine.entities.Entity;

import java.util.ArrayList;

public class Camera {
    private ArrayList<Entity> entities;
    private SpriteBatch batch;
    public Camera(ArrayList<Entity> entities) {
        this.entities = entities;
        batch = new SpriteBatch();
    }

    public void update() {
        Gdx.gl.glClearColor(0,0,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        for (Entity entity : entities) {
            Position position = (Position) entity.getComponent("position");
            Size size = (Size) entity.getComponent("size");
            Picture picture = (Picture) entity.getComponent("picture");
            batch.begin();
            batch.draw(picture.getImage(), position.getPosX(), position.getPosY(), size.getWidth(), size.getHeight());
            batch.end();
        }
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public void setBatch(SpriteBatch batch) {
        this.batch = batch;
    }

    public void dispose() {
        batch.dispose();
        for (Entity entity : entities) {
            Picture picture = (Picture) entity.getComponent("picture");
            picture.getImage().dispose();
        }
    }
}
