package gameEngine.behaviour;

import gameEngine.Client;
import gameEngine.object.Enemy;
import gameEngine.object.IGameObject;

import java.awt.event.InputEvent;
import java.util.List;

public class EnemyBehavior extends Behaviour {
    /**
     * Construtor que associa um GameObject a este comportamento.
     * @param enemy GameObject que será controlado por este comportamento.
     */
    public EnemyBehavior(Enemy enemy) {
        super(enemy);
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
    public void onDisabled() {

    }

    /**
     * Destrói o inimigo ao ser chamado, removendo-o do motor do jogo.
     */
    @Override
    public void onDestroy() {
        Client.ENGINE.destroy(igameObject);
    }
}
