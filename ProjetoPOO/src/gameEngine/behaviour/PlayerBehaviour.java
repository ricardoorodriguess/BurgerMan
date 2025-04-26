package gameEngine.behaviour;

import gameEngine.object.IGameObject;

import java.awt.event.InputEvent;
import java.util.List;

public class PlayerBehaviour extends Behaviour {
    /**
     * Construtor que associa um GameObject a este comportamento.
     * @param igameObject GameObject que será controlado por este comportamento.
     */
    public PlayerBehaviour(IGameObject igameObject) {
        super(igameObject);
    }

    @Override
    public IGameObject gameObject() {
        return super.gameObject();
    }

    @Override
    public void onUpdate(double dT, InputEvent ie) {
        super.onUpdate(dT, ie);
    }

    @Override
    public void onCollision(List<IGameObject> gameObjects) {
        super.onCollision(gameObjects);
    }

    @Override
    public void onInit() {
        super.onInit();
    }

    @Override
    public void onEnabled() {
        super.onEnabled();
    }

    @Override
    public void onDisabled() {
        super.onDisabled();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
