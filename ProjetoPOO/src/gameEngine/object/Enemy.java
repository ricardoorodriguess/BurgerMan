package gameEngine.object;

import collisions.Point;
import collisions.Polygon;
import gameEngine.Transform;
import gameEngine.behaviour.EnemyBehavior;

public class Enemy extends GameObject {
    public Enemy(Point position) {
        super("Enemy", Transform.simpleTransform(position), Polygon.simpleSquare(position), new EnemyBehavior(null));
        behaviour.gameObject(this);
    }
}
