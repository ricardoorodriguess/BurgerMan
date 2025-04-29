package gameEngine.object;

import collisions.Point;
import collisions.Polygon;
import gameEngine.Transform;
import gameEngine.behaviour.PlayerBehaviour;
import org.jetbrains.annotations.NotNull;

/**
 * Responsive class to represent a Player GameObject.
 * @author Ricardo Rodrigues
 * @author Rodrigo Linhas
 * @author Tiago Tome
 * @version April 29, 2025
 */
public class Player extends GameObject {
    /**
     * Constrói o jogador na posição especificada.
     * @param position Posição inicial do jogador.
     */
    public Player(@NotNull Point position) {
        super("Player", Transform.simpleTransform(position), Polygon.simpleSquare(position), new PlayerBehaviour(null));
        behaviour.gameObject(this);
    }
}
