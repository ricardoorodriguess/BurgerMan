/**
 * This class represents GameObjects in 2D. It implements the IGameObject and encapsulates the object´s name, its transform (layer,
 * position, angle, scale) and its collider.
 * @author Ricardo Rodrigues
 * @author Rodrigo Linhas
 * @author Tiago Tome
 * @version March 26, 2025
 * @inv //TODO ?
 */
public class GameObject implements IGameObject
{
    private String name;
    private ITransform transform;
    private ICollider collider;

    /**
     * Returns the name of the GameObject.
     * @return String with the name of the GameObject
     */
    @Override
    public String name() {
        return "";
    }

    /**
     * Response method to obtain the transform associate with this GameObject
     * The transform contains all the transformation info, including: position, layer, rotation angle, and scale factor.
     * @return an instance of ITransform that represents this GameObject´s transform.
     */
    @Override
    public ITransform transform() {
        return null;
    }

    /**
     * Obtain the collider associate with this GameObject.
     * @return an instance of ICollider that represents this GameObject´s collider.
     */
    @Override
    public ICollider collider() {
        return null;
    }
}
