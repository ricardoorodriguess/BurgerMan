import static java.lang.Math.*;

/**
 * This class represents a Point in 2D.
 * @author Ricardo Rodrigues
 * @author Rodrigo Linhas
 * @author Tiago Tome
 * @version March 26, 2025
 */
public class Point
{
    private double x;
    private double y;

    /**
     * Returns the abscissa of the Point.
     * @return x -> abscissa of a Point
     */
    public double getX() { return this.x; }

    /**
     * Returns the ordinate of the Point.
     * @return y -> ordinate of a Point
     */
    public double getY() { return this.y; }

    /**
     * Response method to do a translation in one Point.
     * @param point, coordinates x and y to add to this.point
     */
    public void move(Point point)
    {
        this.x += point.x;
        this.y += point.y;
    }

    /**
     * Response method to calculate distance between two Points.
     * @param point, point to calculate distance
     * @return distance between point and this.point
     */
    public double dist(Point point)
    {
        return sqrt(pow(this.x - point.x, 2) + pow(this.y - point.y, 2));
    }
}
