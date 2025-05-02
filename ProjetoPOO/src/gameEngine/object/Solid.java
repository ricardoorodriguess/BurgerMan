package gameEngine.object;

import collisions.Point;
import collisions.Polygon;
import gameEngine.ICollider;
import gameEngine.ITransform;
import gameEngine.Transform;
import gameEngine.behaviour.IBehaviour;
import gameEngine.behaviour.SolidBehaviour;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Solid extends GameObject {
    /**
     * Constrói o solid na posição especificada.
     * @param topleft
     * @param horizontal
     * @param vertical
     */
    public Solid(Point topleft, double horizontal, double vertical) {
        super("Solid", Transform.simpleTransform(topleft), Polygon.simpleRectangle(topleft, horizontal, vertical),
                new SolidBehaviour(null));
        behaviour.gameObject(this);
    }
}
