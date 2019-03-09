package com.mygdx.game.engine.systemManager;

import com.mygdx.game.engine.components.Picture;
import com.mygdx.game.engine.components.Position;
import com.mygdx.game.engine.components.Size;
import com.mygdx.game.engine.components.Speed;
import com.mygdx.game.engine.entities.Entity;

import java.util.ArrayList;

public class CameraSystem implements Manager {
    private Camera camera;

    public CameraSystem(Camera camera) {
        this.camera = camera;
    }

    @Override
    public void update() {
        camera.update();
    }

    public void dispose() {
        camera.dispose();
    }
}
