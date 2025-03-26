// TODO
/**
 * This class represent a simple circle
 * @author Ricardo Rodrigues
 * @author Rodrigo Linhas
 * @author Tiago Tome
 * @version March 26, 2025
 */
public class Circle extends Collider {
    private double radius;

    //TODO
    /**
     * Construtor of the class
     *
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    //TODO
    /**
     * Simple method to check if collide with another collider
     * @return boolean depending on the situation
     *         true if it happens
     *         false otherwise
     */
    @Override
    boolean collides(Collider collider) {
        return false;
    }
}
