package gameEngine.object;

import collisions.Point;
import collisions.Polygon;
import gameEngine.Transform;
import gameEngine.behaviour.LivesBehaviour;
import gameEngine.behaviour.PlayerBehaviour;
import org.jetbrains.annotations.NotNull;

public class Lives extends GameObject {
    /**
     * Constrói o Score dashboard na posição 0, 0 //ALTERAR QUANDO TIVERMOS A MEXER COM PARTE GRAFICA-.
     */
    public Lives() {
        super("Lives", Transform.simpleTransform(new Point(0, 0)), null, new LivesBehaviour(null));
        behaviour.gameObject(this);
    }
}
