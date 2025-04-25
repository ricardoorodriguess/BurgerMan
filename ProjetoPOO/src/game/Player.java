package game;

import collisions.Circle;
import collisions.Point;

public class Player extends GameObject {
    private double vx, vy;

    public Player(Point position) {
        super("Player", new Transform(position, 0, 0, 1), new Circle(position, 1), true, false, false, false);
        vx = 0;
        vy = 0;
    }

    public void changeSpeed(double vx, double vy) {
        this.vx = vx;
        this.vy = vy;
    }

    public double getVx() {
        return vx;
    }

    public double getVy() {
        return vy;
    }

    @Override
    public String toString() {
        return this.name() + " vx=" + vx + ", vy=" + vy;
    }
}
