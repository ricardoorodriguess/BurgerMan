package game;

import collisions.Circle;
import collisions.Point;

public class Player extends GameObject {
    public Player(Point position) {
        super("Player", new Transform(position, 0, 0, 1), new Circle(position, 1), true, false, false);
    }
}
