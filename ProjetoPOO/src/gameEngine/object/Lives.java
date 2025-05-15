package gameEngine.object;

import collisions.Point;
import gameEngine.Transform;
import gameEngine.behaviour.LivesBehaviour;
import gameEngine.shape.textShape;

import java.awt.*;

public class Lives extends GameObject {
    /**
     * Constrói o Score dashboard na posição 0, 0 //ALTERAR QUANDO TIVERMOS A MEXER COM PARTE GRAFICA-.
     */
    public Lives() {
        super("Lives", Transform.simpleTransform(new Point(0, 0)), null, new LivesBehaviour(null),
                new textShape("Lives: 3", Color.WHITE, 24));
        behaviour.gameObject(this);
        shape.gameObject(this);
    }
}
