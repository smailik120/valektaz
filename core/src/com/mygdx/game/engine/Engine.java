package com.mygdx.game.engine;
import com.badlogic.gdx.ApplicationAdapter;
import com.mygdx.game.engine.Map.Card;
import com.mygdx.game.engine.builders.Builder;
import com.mygdx.game.engine.systemManager.*;

public class Engine extends ApplicationAdapter {
    private static Engine engine;
    private static Card card;
    private static SystemManager manager;
    private Builder builder;
    public static Card getCard() {
        return card;
    }

    public static Engine getEngine() {
        if (engine == null) {
            engine = new Engine();
        }
            return engine;
    }

    public static void initEngine() {
        engine = getEngine();
    }

    @Override
    public void create () {
        initEngine();
        builder = new Builder();
        card = builder.getCard();
        manager = builder.getManager();
    }

    @Override
    public void render () {
        manager.update();
    }

    @Override
    public void dispose () {
        CameraSystem cameraSystem = (CameraSystem) manager.getServices().get("cameraSystem");
        cameraSystem.dispose();
    }

}
