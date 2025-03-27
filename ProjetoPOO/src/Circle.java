// TODO

import java.awt.Point;

/**
 * This class represent a simple circle
 * @author Ricardo Rodrigues
 * @author Rodrigo Linhas
 * @author Tiago Tome
 * @version March 26, 2025
 */
public class Circle extends Collider
{
    private Point center;
    private double radius;

    /**
     * Construtor of the class
     *
     */
    public Circle(Point center ,double radius)
    {
        this.center = center;
        this.radius = radius;
    }

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
