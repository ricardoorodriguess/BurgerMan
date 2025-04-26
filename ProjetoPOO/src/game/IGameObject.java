package game;

import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * The {@code game.IGameObject} interface stores information about
 * an object's position, layer, angle and scale.
 * @author Ricardo Rodrigues
 * @author Rodrigo Linhas
 * @author Tiago Tome
 * @version March 25, 2025
 */
public interface IGameObject {
    /**
     * Returns the name of the game.GameObject.
     * @return the name of the game.GameObject.
     */
    String name();

    /**
     * Returns the game.Transform of the game.GameObject.
     * @return the game.Transform of the game.GameObject.
     */
    ITransform transform();

    IBehaviour behaviour();

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

    /**
     * Returns the Collider of the game.GameObject.
     * <p>The centroid will always lie at {@code this.transform().position()}.
     * @return the Collider of the game.GameObject.
     */
    @Nullable ICollider collider();
}