package game;

import collisions.Point;
import collisions.Polygon;

public class Solid extends GameObject {
    public Solid(Point topLeft, double horizontal, double vertical) {
        super("Solid", new Transform(topLeft, 0, 0, 1), Polygon.simpleRectangle(topLeft, horizontal, vertical), false, false, true, false);
    }
}
