/**
 * This class represent a simple circle
 * @author Ricardo Rodrigues
 * @author Rodrigo Linhas
 * @author Tiago Tome
 * @version March 27, 2025
 */
public class Circle extends Collider
{
    private Point center;
    private double radius;

    /**
     * Construtor of the class
     * @param center
     * @param radius
     * @throws IllegalArgumentException if any violation is detected
     *
     */
    public Circle(Point center ,double radius)
    {
        if (radius < 0) throw new IllegalArgumentException("Circulo:vi\n");
        this.center = center;
        this.radius = radius;
    }

    /**
     * Method that returns the radius
     * @return radius
     */
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

    /**
     * Method to move the cirlce
     * @param point
     */
    @Override
    public void move(Point point) { center.move(point); }

    /**
     * Method to get the centroid
     * @return centroid (the center of the circle)
     */
    @Override
    public Point centroid() { return this.center; }


    /**
     * Method to rotate the circle
     * @param angle
     */
    @Override
    public void rotate(double angle) { return; /*nada é feito*/ }

    /**
     * Method to scale the circle
     * @param scale
     */
    @Override
    public void scale(double scale) { this.radius *= scale; }

    /**
     * Method toString of the circle
     * @return (x,y) radius
     */
    @Override
    public String toString()
    {
        return center.toString() + " " + radius;
    }
}
