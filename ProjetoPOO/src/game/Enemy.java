package game;

import collisions.Point;
import collisions.Polygon;

public class Enemy extends GameObject {
    public Enemy(Point position) {
        super("Enemy", new Transform(position, 0, 0, 1), Polygon.simpleSquare(position), false, true, false);
    }

    public void kill() {}

    public void collideWithPlayer() {
        if (Client.PLAYER_INVULNERABLE > 0) kill();
        else Client.ENGINE.alertScoreboard(Scoreboard::onDeath);
    }
}
