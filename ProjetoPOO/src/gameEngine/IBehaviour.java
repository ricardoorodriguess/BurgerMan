package gameEngine;

import java.awt.event.InputEvent;
import java.util.List;

public interface IBehaviour {
    //para acesso ao gameObject que está associado
    public IGameObject gameObject();
    public void gameObject(IGameObject gameObject);

    //chamado pelo game engine em cada frame
    void onUpdate(double dT, InputEvent ie);
    void onCollision(List<IGameObject> gameObjects);

    void onInit();
    void onEnabled();
    void onDisabled();
    void onDestroy();
}