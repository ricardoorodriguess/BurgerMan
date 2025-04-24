package game;

import collisions.Point;
import org.jetbrains.annotations.Nullable;

/**
 * This class represents GameObjects in 2D.
 * <p>It implements the game.IGameObject and encapsulates the object´s name,
 * its transform (layer,position, angle, scale) and its collider.
 * @author Ricardo Rodrigues
 * @author Rodrigo Linhas
 * @author Tiago Tome
 * @version March 27, 2025
 */
public class GameObject implements IGameObject
{
    private final String name;
    private final ITransform transform;
    private final @Nullable ICollider collider;
    private final boolean isPlayer, isEnemy, isScoreboard;

    /**
     * Constructor to class game.GameObject, create an instance of game.GameObject (see description of class).
     * @param name
     * @param transform
     * @param collider
     */
    public GameObject(String name, ITransform transform, @Nullable ICollider collider, boolean isPlayer, boolean isEnemy, boolean isScoreboard)
    {
        this.name = name;
        this.transform = transform;
        this.collider = collider;
        this.isPlayer = isPlayer;
        this.isEnemy = isEnemy;
        this.isScoreboard = isScoreboard;
    }

    public GameObject(String name, ITransform transform, @Nullable ICollider collider) {
        this(name, transform, collider, false, false, false);
    }

    /**
     * Returns the name of the game.GameObject.
     * @return String with the name of the game.GameObject
     */
    @Override
    public String name() { return name; }

    /**
     * Response method to obtain the transform associate with this game.GameObject
     * The transform contains all the transformation info, including: position, layer, rotation angle, and scale factor.
     * @return an instance of game.ITransform that represents this game.GameObject´s transform.
     */
    @Override
    public ITransform transform() { return transform; }

    /**
     * Obtain the collider associate with this game.GameObject.
     * @return an instance of game.ICollider that represents this game.GameObject´s collider.
     */
    @Override
    public @Nullable ICollider collider() { return collider; }

    /**
     * Move the gameObject and the collider
     * @param point to move
     * @param layer to move
     */
    public void move(Point point, int layer) {
        transform.move(point, layer);
        if (collider != null)
            collider.move(point);
    }

    /**
     * Rotate the gameObject and the collider
     * @param dTheta to rotate
     */
    public void rotate(double dTheta) {
        transform.rotate(dTheta);
        if (collider != null)
            collider.rotate(dTheta);
    }

    /**
     * Scale the gameObject and the collider
     * @param dScale to scale
     */
    public void scale(double dScale) {
        transform.scale(dScale);
        if (collider != null)
            collider.scale(dScale);
    }

    /**
     * Move the gameObject to a specific point
     * @param point to calculate the diference between the atual position to this point
     * @param layer to move
     */
    public void moveTo(Point point, int layer) {
        Point delta = new Point(point.getX() - transform.position().getX(), point.getY() - transform.position().getY());
        System.out.println(delta);
        move(delta, layer);
    }

    /**
     * Give the game.GameObject info in a string
     * @return String with info of a game.GameObject
     */
    @Override
    public String toString() {
        return "<" + name + " | " + transform + " | " + collider + ">";
    }

    public boolean isPlayer() {
        return isPlayer;
    }

    public boolean isEnemy() {
        return isEnemy;
    }

    public boolean isScoreboard() {
        return isScoreboard;
    }
}
