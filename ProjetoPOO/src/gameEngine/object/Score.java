package gameEngine.object;

import collisions.Point;
import gameEngine.Transform;
import gameEngine.behaviour.LivesBehaviour;
import gameEngine.behaviour.ScoreBehaviour;

public class Score extends GameObject {
    /**
     * Constrói o Score dashboard na posição 0, 1 //ALTERAR QUANDO TIVERMOS A MEXER COM PARTE GRAFICA-.
     */
    public Score() {
        super("Score", Transform.simpleTransform(new Point(0, 1)), null, new ScoreBehaviour(null));
        behaviour.gameObject(this);
    }
}
