package game;

import collisions.Point;
import collisions.Polygon;
import org.jetbrains.annotations.Nullable;

public class Solid extends GameObject {
    public Solid(Point topLeft, double horizontal, double vertical) {
        super("Solid", new Transform(topLeft, 0, 0, 1), Polygon.simpleRectangle(topLeft, horizontal, vertical));
    }
}
