// TODO

import java.util.ArrayList;

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

    public double getRadius() {
        return radius;
    }

    /**
     * Simple method to check if collide with another collider
     * @return boolean depending on the situation
     *         true if it happens
     *         false otherwise
     */
    @Override
    boolean collides(Collider collider)
    {
        if (collider instanceof Circle c) return radius + c.radius <= center.dist(c.center);
        if (collider instanceof Polygon p)
        {
            for (Point po : p.getPoints()) if (po.dist(center) <= radius) return true;
            for (LineSegment seg : p.getSegments()) if (seg.intersects(this)) return true;
            return p.contains(center);
        }
        return false;
    }

    @Override
    public void move(Point point) { center.move(point); }

    @Override
    public Point centroid() { return this.center; }

    @Override
    public void rotate(double angle) { /*nada é feito, precisamos ter isto?*/ }

    @Override
    public void scale(double scale) { this.radius *= scale; }

    @Override
    public String toString()
    {
        return center.toString() + radius;
    }
}
