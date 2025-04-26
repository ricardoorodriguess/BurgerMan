package gameEngine.behaviour;

import gameEngine.object.Collectible;
import gameEngine.object.IGameObject;

import java.awt.event.InputEvent;
import java.util.List;

public class CollectibleBehaviour extends Behaviour {
    public CollectibleBehaviour(Collectible collectible) {
        super(collectible);
    }

    @Override
    public void onUpdate(double dT, InputEvent ie) {

    }

    @Override
    public void onCollision(List<IGameObject> gameObjects) {

    }

    @Override
    public void onInit() {

    }

    @Override
    public void onEnabled() {

    }

    @Override
    public void onDisabled() {

    }

    @Override
    public void onDestroy() {

    }
}
