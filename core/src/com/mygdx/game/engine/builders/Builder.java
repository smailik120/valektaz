package com.mygdx.game.engine.builders;
import com.mygdx.game.engine.Map.Card;
import com.mygdx.game.engine.entities.Entity;
import com.mygdx.game.engine.scene.Scene;
import com.mygdx.game.engine.systemManager.SystemManager;

import java.util.ArrayList;

public class Builder {
    private Card card;
    private SystemManager manager;
    public Builder() {
        ArrayList<Scene> array = new ArrayList<Scene>();
        ArrayList<Entity> entities = new ArrayList<Entity>();
        entities.add(new PlayerBuilder().getPlayer());
        Scene start = new Scene(entities, "start");
        array.add(start);
        Card card = new Card(array);
        ManagerBuilder managerBuilder = new ManagerBuilder(card.getCurrentScene().getEntities());
        manager = managerBuilder.getServices();
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
