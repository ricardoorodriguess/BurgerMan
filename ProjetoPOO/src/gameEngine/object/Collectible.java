package gameEngine.object;

import collisions.Circle;
import collisions.Point;
import gameEngine.Transform;
import gameEngine.behaviour.CollectibleBehaviour;
import org.jetbrains.annotations.NotNull;

/**
 * Responsive class to represent a Collectible GameObject.
 * @author Ricardo Rodrigues
 * @author Rodrigo Linhas
 * @author Tiago Tome
 * @version April 29, 2025
 */
public class Collectible extends GameObject {
    private final Type type;

    /**
     * Constrói um objeto coletável no jogo.
     * @param @Notnull type Tipo do coletável (ex: TOMATO, CHEESE).
     * @param @Notnull position Posição inicial do coletável no ambiente.
     */
    public Collectible(@NotNull Type type, @NotNull Point position) {
        super(type.name, Transform.simpleTransform(position), new Circle(position, 0.5), new CollectibleBehaviour(null));
        this.type = type;
        behaviour.gameObject(this);
    }

    /**
     * Retorna o tipo deste coletável.
     * @return Tipo enum do coletável.
     */
    public Type getType() {
        return type;
    }
}
