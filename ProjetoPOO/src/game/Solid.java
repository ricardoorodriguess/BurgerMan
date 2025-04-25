package game;

import collisions.Point;
import collisions.Polygon;

public class Solid extends GameObject {
    public Solid(Point topLeft, double horizontal, double vertical) {
        super("Solid", Transform.simpleTransform(topLeft), Polygon.simpleRectangle(topLeft, horizontal, vertical),
                false, false, true, false);
    }

    @Override
    public String toString()
    {
        return this.name() + ": <TRANSFORM: " + this.transform() + "> <COLLIDER: " + this.collider() + ">";
    }
}
