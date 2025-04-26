package gameEngine;

import java.awt.event.InputEvent;
import java.util.List;

//classe que implemneta os metodos de controlo de cada GameObject: andar, os inimigos patrulharem, atacarem,etc...
public class Behaviour implements IBehaviour {
    private IGameObject igameObject;

    public Behaviour(IGameObject igameObject) {
        this.igameObject = igameObject;
    }

    @Override
    public IGameObject gameObject() {
        return this.igameObject;
    }

    @Override
    public void gameObject(IGameObject gameObject) {
        this.igameObject = gameObject;
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
