// TODO
/**
 * This class represent the collider
 * @author Ricardo Rodrigues
 * @author Rodrigo Linhas
 * @author Tiago Tome
 * @version March 26, 2025
 */
abstract class Collider {
    protected Point centroid; //?

    /**
     * Simple method to check if collide with another collider
     * @return boolean depending on the situation
     *         true if it happen
     *         false otherwise
     */
    abstract boolean collides(Collider collider);
}
