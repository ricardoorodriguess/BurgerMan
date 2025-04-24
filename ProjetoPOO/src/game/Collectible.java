package game;

import collisions.Circle;
import collisions.Point;

public class Collectible extends GameObject {
    public Collectible(Point position) {
        super("Collect", new Transform(position, 0, 0, 1), new Circle(position, 0.5));
    }

    public void collect(GameObject go) {
        if (go.isPlayer()) {
            Client.ENGINE.alertScoreboard(sc -> sc.increment(10));
            Client.ENGINE.destroy(this);
        }
    }
}
