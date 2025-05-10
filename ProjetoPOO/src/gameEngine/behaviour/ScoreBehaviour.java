package gameEngine.behaviour;

import collisions.Point;
import gameEngine.object.IGameObject;
import gameEngine.object.Player;
import gameEngine.object.Score;

import java.awt.event.InputEvent;
import java.util.List;

public class ScoreBehaviour extends Behaviour {
    private int totalScore;

    /**
     *
     * @param score
     */
    public ScoreBehaviour(Score score) {
        super(score);
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
        this.totalScore = 0;
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

    /**
     * Incrementa a pontuação total do jogador.
     * @param points Pontos a serem adicionados.
     */
    public void incrementScore(int points) {
        if (points < 0) throw new IllegalArgumentException();
        totalScore += points;
    }

    /**
     * Retorna a pontuação atual do jogador.
     * @return Pontuação total.
     */
    public int getScore() { return totalScore; }
}
