package gameEngine.object;

import collisions.Point;
import collisions.Polygon;
import gameEngine.Transform;
import gameEngine.behaviour.PlayerBehaviour;
import org.jetbrains.annotations.NotNull;

public class Player extends GameObject {
    public Player(@NotNull Point position) {
        super("Player", Transform.simpleTransform(position), Polygon.simpleSquare(position), new PlayerBehaviour(null));
        behaviour.gameObject(this);
    }
}
