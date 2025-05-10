package gameEngine.behaviour;

import collisions.Point;
import gameEngine.object.IGameObject;
import gameEngine.object.Lives;
import gameEngine.object.Player;

import java.awt.event.InputEvent;
import java.util.List;

public class LivesBehaviour extends Behaviour {
    private int lives;

    /**
     *
     * @param lives
     */
    public LivesBehaviour(Lives lives) {
        super(lives);
    }

    public int getLives() {
        return lives;
    }

    /**
     * Atualiza o estado do GameObject a cada frame.
     *
     * @param dT Tempo desde o último frame em segundos.
     * @param ie Eventos de entrada do usuário.
     */
    @Override
    public void onUpdate(double dT, InputEvent ie) {

    }

    /**
     * Trata colisões com outros GameObjects.
     *
     * @param gameObjects Lista de objetos colididos.
     */
    @Override
    public void onCollision(List<IGameObject> gameObjects) {

    }

    /**
     * Inicializa o comportamento (chamado uma vez no início).
     */
    @Override
    public void onInit() {
        lives = 3;
    }

    public void decreaseLives() {
        if (lives > 0) {
            lives--;
        }
        else{
            return;
        }
    }

    /**
     * Executado quando o GameObject é habilitado.
     */
    @Override
    public void onEnabled() {

    }

    /**
     * Executado quando o GameObject é desabilitado.
     */
    @Override
    public void onDisabled() {

    }

    /**
     * Executado quando o GameObject é destruído.
     */
    @Override
    public void onDestroy() {

    }
}
