package gameEngine.object;

import collisions.Point;
import collisions.Polygon;
import gameEngine.Transform;
import gameEngine.behaviour.EnemyBehavior;
import org.jetbrains.annotations.NotNull;

/**
 * Responsive class to represent a Enemy GameObject.
 * @author Ricardo Rodrigues
 * @author Rodrigo Linhas
 * @author Tiago Tome
 * @version April 29, 2025
 */
public class Enemy extends GameObject {
    /**
     * Constrói um inimigo na posição especificada.
     * @param position Posição inicial do inimigo.
     */
    public Enemy(@NotNull Point position) {
        super("Enemy", Transform.simpleTransform(position), Polygon.simpleSquare(position), new EnemyBehavior(null));
        behaviour.gameObject(this);
    }
}
