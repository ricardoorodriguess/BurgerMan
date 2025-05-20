package gameEngine.object;

import collisions.Circle;
import collisions.Point;
import gameEngine.Transform;

import java.util.List;
import java.util.Random;

public class Intersection extends GameObject {
    private final List<Point> directions;
    private final Point returnDir;

    public Intersection(Point base, List<Point> directions, Point returnDir) {
        super("Inter", Transform.simpleTransform(base), new Circle(base, 0.1), null, null);
        this.directions = directions;
        this.returnDir = returnDir;
    }

    public List<Point> list() {
        return directions;
    }

    public Point randomDir(Random random, Point except) {
        List<Point> filter = directions.stream()
                .filter(p -> !p.equals(except.scaleOrigin(-1)))
                .toList();
        return filter.get(random.nextInt(filter.size()));
    }

    public Point getReturnDir() {
        return returnDir;
    }
}
