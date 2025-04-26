package game;

import collisions.Point;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * This class represents GameObjects in 2D.
 * <p>It implements the IGameObject and encapsulates the object´s name,
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
    private final IBehaviour behaviour;

    /**
     * Constructor to class GameObject, create an instance of GameObject (see description of class).
     * @param name
     * @param transform
     * @param collider
     */
    public GameObject(String name, ITransform transform, @Nullable ICollider collider, IBehaviour behaviour)
    {
        this.name = name;
        this.transform = transform;
        this.collider = collider;
        this.behaviour = behaviour;
        if (this.behaviour != null) this.behaviour.gameObject(this); //se nao for null assosia este objeto ao behaviour
    }

    /**
     * Returns the name of the GameObject.
     * @return String with the name of the GameObject
     */
    @Override
    public String name() { return name; }

    /**
     * Response method to obtain the transform associate with this GameObject
     * The transform contains all the transformation info, including: position, layer, rotation angle, and scale factor.
     * @return an instance of ITransform that represents this GameObject´s transform.
     */
    @Override
    public ITransform transform() { return transform; }

    /**
     * Obtain the collider associate with this GameObject.
     * @return an instance of ICollider that represents this GameObject´s collider.
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
     * Give the GameObject info in a string
     * @return String with info of a GameObject
     */
    @Override
    public String toString() {
        return "<" + name + " | " + transform + " | " + collider + ">";
    }


    @Override
    public IBehaviour behaviour() {
        return behaviour;
    }

    @Override
    public void addEnabled(IGameObject gameObject) {

    }

    @Override
    public void addDisabled(IGameObject gameObject) {

    }

    @Override
    public void enable(IGameObject gameObject) {

    }

    @Override
    public void disable(IGameObject gameObject) {

    }

    @Override
    public boolean isEnabled(IGameObject gameObject) {
        return false;
    }

    @Override
    public boolean isDisabled(IGameObject gameObject) {
        return false;
    }

    @Override
    public List<IGameObject> getEnabled() {
        return List.of();
    }

    @Override
    public List<IGameObject> getDisabled() {
        return List.of();
    }

    /**
     * Destroy IGameObject gameObject whether it is enabled or disabled
     * pre: gameObject != null
     * pos: gameObject.onDestroy()
     *
     * @param gameObject
     */
    @Override
    public void destroy(IGameObject gameObject) {

    }

    /**
     * Destroy all IGameObjects
     * pos: calls onDesttoy for each IGameObject
     */
    @Override
    public void destroyAll() {

    }

    /**
     * Manipula a transform
     * Generates a new frame:
     * Get user input from Ul
     * update all the enabled GameObjects
     * check collisions and send info to GameObjects
     * update Ul
     * pos: Ul.input() &&
     * calls Behaviour.onUpdate() for all enabled objects && Behaviour.checkCollisions() &&
     * Ul.draw()
     */
    @Override
    public void run() {

    }

    /**
     * Check collisions for all the enabled objects
     * pos: calls Behaviour.onCollision(goI) for all enabled GameObjects passing in the list of all the objects that
     * collided with each IGameObject
     */
    @Override
    public void checkCollisions() {

    }
}
