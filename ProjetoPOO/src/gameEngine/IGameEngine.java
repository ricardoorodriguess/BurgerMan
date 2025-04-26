package gameEngine;

import java.util.List;

public interface IGameEngine {
    void addEnabled(IGameObject gameObject);

    void addDisabled(IGameObject gameObject);

    void enable(IGameObject gameObject);

    void disable(IGameObject gameObject);

    boolean isEnabled(IGameObject gameObject);

    boolean isDisabled(IGameObject gameObject);

    List<IGameObject> getEnabled();

    List<IGameObject> getDisabled();

    /**
     * Destroy IGameObject gameObject whether it is enabled or disabled
     * pre: gameObject != null
     * pos: gameObject.onDestroy()
     * @param gameObject
     */
    void destroy(IGameObject gameObject);

    /**
     * Destroy all IGameObjects
     * pos: calls onDesttoy for each IGameObject
     */
    void destroyAll();

    /**
     * Manipula a transform
     * Generates a new frame:
     * Get user input from Ul
     * update all the enabled GameObjects
     * check collisions and send info to GameObjects
     * update Ul
     * pos: Ul.input() &&
     calls Behaviour.onUpdate() for all enabled objects && Behaviour.checkCollisions() &&
     Ul.draw()
     */
    void run();

    /**
     * Check collisions for all the enabled objects
     * pos: calls Behaviour.onCollision(goI) for all enabled GameObjects passing in the list of all the objects that
     * collided with each IGameObject
     */
    void checkCollisions();
}
