package game;

import collisions.Point;
import collisions.Polygon;

public class Enemy extends GameObject {
    private double vx, vy;

    public Enemy(Point position) {
        super("Enemy", Transform.simpleTransform(position), Polygon.simpleSquare(position), false, true, false, false);
        vx = 0;
        vy = 0;
    }

    public void changeSpeed(double vx, double vy) {
        this.vx = vx;
        this.vy = vy;
    }

    public void kill() {}

    public void collideWithPlayer() {
        if (Client.PLAYER_INVULNERABLE > 0) kill();
        else Client.ENGINE.alertScoreboard(Scoreboard::onDeath);
    }
}
