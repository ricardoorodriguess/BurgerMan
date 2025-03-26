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
    /**
     * Construtor of the class
     *
     */
    public Polygon() {
        this.points = new ArrayList<>();
        //check(points);
    }

    //TODO IMPLEMENT LOGIC
    /**
     * checker to determine if the polygon is valid
     * @param points (should be 3 or more)
     *
     */
    private static void ceck(ArrayList<Point> points) {
        if (points.size() < 3) {
            System.out.println("MERDA");
            //TALVEZ ADICIONAR THROW PARA ESTE ERRO ?
        }

    }

    /**
     * Simple method to check if collide with another collider
     * @return boolean depending on the situation
     *         true if it happen
     *         false otherwise
     */
    @Override
    boolean collides(Collider collider) {
        return false;
    }
}
