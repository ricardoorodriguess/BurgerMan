package gameEngine.behaviour;

import gameEngine.object.Enemy;
import gameEngine.object.IGameObject;

import java.awt.event.InputEvent;
import java.util.List;

public class EnemyBehavior extends Behaviour {
    /**
     * Construtor que associa um GameObject a este comportamento.
     * @param enemy GameObject que será controlado por este comportamento.
     */
    public EnemyBehavior(Enemy enemy) {
        super(enemy);
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
