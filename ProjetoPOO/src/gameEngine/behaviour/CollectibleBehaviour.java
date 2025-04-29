package gameEngine.behaviour;

import gameEngine.object.Collectible;
import gameEngine.object.IGameObject;

import java.awt.event.InputEvent;
import java.util.List;

/**
 * Responsive class to deal with Collectible behaviour.
 * @author Ricardo Rodrigues
 * @author Rodrigo Linhas
 * @author Tiago Tome
 * @version April 29, 2025
 */
public class CollectibleBehaviour extends Behaviour {
    /**
     * Construtor que associa este comportamento a um coletável.
     * @param collectible Coletável controlado por este comportamento.
     */
    public CollectibleBehaviour(Collectible collectible) {
        super(collectible);
    }

    /**
     * Atualiza o estado do coletável a cada frame.
     * @param dT Tempo desde o último frame (em segundos).
     * @param ie Evento de entrada do usuário.
     */
    @Override
    public void onUpdate(double dT, InputEvent ie) {}

    /**
     * Lida com colisões entre este coletável e outros objetos.
     * @param gameObjects Lista de objetos que colidiram com este coletável.
     */
    @Override
    public void onCollision(List<IGameObject> gameObjects) {}

    /**
     * Executado quando o comportamento é inicializado.
     */
    @Override
    public void onInit() {}

    /**
     * Executado quando o objeto é ativado.
     */
    @Override
    public void onEnabled() {}

    /**
     * Executado quando o objeto é desativado.
     */
    @Override
    public void onDisabled() {}

    /**
     * Executado quando o objeto é destruído.
     */
    @Override
    public void onDestroy() {}
}
