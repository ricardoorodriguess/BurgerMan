package gameEngine.object;

import collisions.Point;
import gameEngine.Transform;
import gameEngine.behaviour.ScoreBehaviour;
import gameEngine.shape.TextShape;

import java.awt.*;

public class Score extends GameObject {
    /**
     * Constrói o Score dashboard na posição 0, 1 //ALTERAR QUANDO TIVERMOS A MEXER COM PARTE GRAFICA-.
     */
    public Score() {
        super("Score", Transform.simpleTransform(new Point(125, 65)), null, new ScoreBehaviour(null),
                new TextShape("Score: 0", Color.WHITE, 24)); //por enquanto deixar assim
        behaviour.gameObject(this);
        shape.gameObject(this);
    }
}
