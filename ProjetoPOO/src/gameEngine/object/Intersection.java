package gameEngine.object;

import collisions.Circle;
import collisions.Point;
import gameEngine.Transform;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class Intersection extends GameObject {
    private final List<Point> directions;
    private final Point returnDir;
    private @Nullable Point metPlayer;

    public Intersection(Point base, List<Point> directions) {
        super("Inter", Transform.simpleTransform(base), new Circle(base, 0.1), null, null);
        if (directions.isEmpty()) throw new IllegalArgumentException();
        this.directions = directions;
        returnDir = directions.getFirst();
        metPlayer = null;
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

    public void setLastPlayerDir(Point point) {
        metPlayer = point;
    }

    public @Nullable Point getLastPlayerDir() {
        return metPlayer;
    }
}
