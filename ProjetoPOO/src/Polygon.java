// TODO

import java.util.ArrayList;

/**
 * This class represent a polygon witch contains 3 or more points
 * @author Ricardo Rodrigues
 * @author Rodrigo Linhas
 * @author Tiago Tome
 * @version March 26, 2025
 */

public class Polygon extends Collider{

    private ArrayList<Point> points;
    private ArrayList<LineSegment> segments;
    /**
     * Construtor of the class
     *
     */
    public Polygon() {
        this.points = new ArrayList<>();
        this.segments = new ArrayList<>();
        //check(points);
    }

    //TODO IMPLEMENT LOGIC
    /**
     * checker to determine if the polygon is valid
     * @param points (should be 3 or more)
     *
     */
    private static void check(ArrayList<Point> points) {
        if (points.size() < 3) {
            System.out.println("MERDA");
            //TALVEZ ADICIONAR THROW PARA ESTE ERRO ?
        }

    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public ArrayList<LineSegment> getSegments() {
        return segments;
    }

    public boolean contains(Point point) {
        Line line;
        for (LineSegment seg : segments) {
            line = new Line(point, seg);
            boolean b = false;
            for (LineSegment other : segments) if (line.intersects(other)) {
                b = true;
                break;
            }
            if (!b) return false;
        }
        return true;
    }

    /**
     * Simple method to check if collide with another collider
     * @return boolean depending on the situation
     *         true if it happen
     *         false otherwise
     */
    @Override
    boolean collides(Collider collider) {
        if (collider instanceof Circle) return collider.collides(this);
        // TODO
        return false;
    }

    @Override
    public void move(Point point) {

    }

    @Override
    public Point centroid() {
        return null;
    }

    @Override
    public void rotate(double angle) {

    }

    @Override
    public void scale(double scale) {

    }

    @Override
    public String toString()
    {
        return "";
    }
}
