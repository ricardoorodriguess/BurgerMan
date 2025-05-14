package gameEngine.object;

import collisions.Point;
import gameEngine.Transform;
import gameEngine.behaviour.LivesBehaviour;

public class Lives extends GameObject {
    /**
     * Constrói o Score dashboard na posição 0, 0 //ALTERAR QUANDO TIVERMOS A MEXER COM PARTE GRAFICA-.
     */
    public Lives() {
        super("Lives", Transform.simpleTransform(new Point(0, 0)), null, new LivesBehaviour(null));
        behaviour.gameObject(this);
    }
}
