package com.mygdx.game.engine.builders;
import com.mygdx.game.Generator.Generator;
import com.mygdx.game.engine.Engine;
import com.mygdx.game.engine.Map.Card;
import com.mygdx.game.engine.builders.EntityBuilders.EnemyBuilder;
import com.mygdx.game.engine.builders.EntityBuilders.PlayerBuilder;
import com.mygdx.game.engine.entities.Entity;
import com.mygdx.game.engine.scene.Scene;
import com.mygdx.game.engine.systemManager.Manager;
import com.mygdx.game.engine.systemManager.SystemManager;

import java.util.ArrayList;

public class Builder {
    private Card card;
    private SystemManager manager;
    public Builder() {
        ArrayList<ArrayList<Entity>> entitiesForScenes = new  ArrayList<ArrayList<Entity>>();
        ArrayList<Entity> entities = new ArrayList<Entity>();
        entities.add(new PlayerBuilder().getPlayer());
        entities.add(new EnemyBuilder().getPlayer());
        entitiesForScenes.add(entities);
        card = new Card(new SceneBuilder(entitiesForScenes).getScenes());
        ManagerBuilder managerBuilder = new ManagerBuilder(card.getCurrentScene().getEntities());
        manager = managerBuilder.getServices();
        BuilderManagersForScenes builderManagersForScenes = new BuilderManagersForScenes(manager);
        for(Scene scene: card.getScenes()) {
            scene.setActiveServices(builderManagersForScenes.getManagersForScene().get(card.getCurrentScene().getName()));
        }
        manager.setActiveServices(card.getCurrentScene().getActiveServices());
    }

    public SystemManager getManager() {
        return manager;
    }

    public void setManager(SystemManager manager) {
        this.manager = manager;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

}
