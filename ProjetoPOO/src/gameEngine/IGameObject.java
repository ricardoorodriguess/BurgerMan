package gameEngine;

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

    /**
     * Returns the Collider of the game.GameObject.
     * <p>The centroid will always lie at {@code this.transform().position()}.
     * @return the Collider of the game.GameObject.
     */
    @Nullable ICollider collider();
}