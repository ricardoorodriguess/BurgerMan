/**
 * This class represents a simple Line in 2D.
 * @author Ricardo Rodrigues
 * @author Rodrigo Linhas
 * @author Tiago Tome
 * @version March 26, 2025
 */

public class Line {
    protected Point a, b;

    /**
     * Constructor that check if the given line is valid
     * @param a
     * @param b
     * @throws IllegalArgumentException if the 2 points are equal
     */
    public Line(Point a, Point b)
    {
        if (a.equals(b)) throw new IllegalArgumentException();
        this.a = a;
        this.b = b;
    }

    /**
     * Constructor but receveis a point and a line
     * @param a
     * @param l
     * @throws IllegalArgumentException if the 2 points are equal
     */
    public Line(Point a, Line l)
    {
        this(a, l.closest(a, false));
    }

    /**
     * Getter from the 1st point
     * @return 1st point from the line
     */
    public Point getA()
    {
        return a;
    }

    /**
     * Getter from the lasy«t point
     * @return last point from the line
     */
    public Point getB()
    {
        return b;
    }

    /**
     * Method to check if the point is in the given line
     * @param point
     * @return true if in fact is the given line
     *         false otherwise
     */
    public boolean contains(Point point) {
        return (point.getX() - a.getX()) * (b.getY() - a.getY()) == (point.getY() - a.getY()) * (b.getX() - a.getX());
    }

    protected double closestRatio(Point point, boolean interior)
    {
        double dx = b.getX() - a.getX(), dy = b.getY() - a.getY();
        return (dx * (point.getX() - a.getX()) + dy * (point.getY() - a.getY())) / (dx * dx + dy * dy);
    }

    public Point closest(Point point)
    {
        return closest(point, true);
    }

    public Point closest(Point point, boolean interior)
    {
        double dx = b.getX() - a.getX(), dy = b.getY() - a.getY(), k = closestRatio(point, interior);
        return new Point(a.getX() + k * dx, b.getY() + k * dy);
    }

    public boolean intersects(Circle circle)
    {
        return closest(circle.centroid()).dist(circle.centroid()) <= circle.getRadius();
    }

    public boolean intersects(Polygon polygon)
    {
        for (LineSegment segment : polygon.getSegments()) if (intersects(segment)) return true;
        return false;
    }

    public boolean intersects(LineSegment segment)
    {
        double dx = b.getX() - a.getX(), dy = b.getY() - a.getY();
        double dz = b.getX() * a.getY() - b.getY() * a.getX();
        Point a = segment.getA(), b = segment.getB();
        return (dx * a.getY() - dy * a.getX() - dz) * (dx * b.getY() - dy * b.getX() - dz) <= 0;
    }
}
