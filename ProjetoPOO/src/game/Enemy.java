package game;

import collisions.Point;
import collisions.Polygon;

public class Enemy extends GameObject {
    public Enemy(Point position) {
        super("Enemy", Transform.simpleTransform(position), Polygon.simpleSquare(position), false, true, false, false);
    }

    public void kill() {}

    public void collideWithPlayer() {
        if (Client.PLAYER_INVULNERABLE > 0) kill();
        else Client.ENGINE.alertScoreboard(Scoreboard::onDeath);
    }
}
