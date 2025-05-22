package gameEngine.behaviour;

import collisions.Point;
import gameEngine.Client;
import gameEngine.ICollider;
import gameEngine.object.Enemy;
import gameEngine.object.GameObject;
import gameEngine.object.IGameObject;
import gameEngine.object.Intersection;

import java.awt.event.InputEvent;
import java.util.List;

/**
 * Responsive class to deal with Enemy behaviour.
 * @author Ricardo Rodrigues
 * @author Rodrigo Linhas
 * @author Tiago Tome
 * @version May 11, 2025
 */
public class EnemyBehavior extends Behaviour {
    public Point speed;
    private int state;

    /**
     * Construtor que associa um GameObject a este comportamento.
     * @param enemy GameObject que será controlado por este comportamento.
     */
    public EnemyBehavior(Enemy enemy) {
        super(enemy);
        speed = new Point(0, 0);
        state = 0;
    }

    /**
     * Atualiza o estado do coletável a cada frame.
     * @param dT Tempo desde o último frame (em segundos).
     * @param ie Evento de entrada do usuário.
     */
    @Override
    public void onUpdate(double dT, InputEvent ie) {
        Intersection i = Client.ENGINE.getInterAt(igameObject.collider().centroid());
        if (i != null)
            switch (state) {
                case 0:
                    // SCATTER STATE
                    speed = rand(i);
                    break;
                case 1:
                    // CHASE STATE
                    Point last = i.getLastPlayerDir();
                    speed = last == null ? rand(i) : last;
                    break;
                case 2:
                    // SCARED STATE
                    speed = rand(i).scaleOrigin(0.8);
                    break;
                case 3:
                    // RETURNING STATE
                    speed = i.getReturnDir();
                    break;
            }

        ((GameObject) igameObject).move(speed, 0);
    }

    /**
     * Lida com colisões entre este coletável e outros objetos.
     * @param gameObjects Lista de objetos que colidiram com este coletável.
     */
    @Override
    public void onCollision(List<IGameObject> gameObjects) {
        for (IGameObject gameObject : gameObjects) {
            switch (gameObject.name()) {
                case "Pickle":
                    ((PlayerBehaviour) Client.ENGINE.getPlayerObject().behaviour()).slowDown();
                    break;
                case "Inter":
                    Intersection i = (Intersection) gameObject;
                    switch (state) {
                        case 3:
                            speed = i.getReturnDir();
                            break;
                        case 2:
                            speed = rand(i).scaleOrigin(0.8);
                            break;
                        case 1:
                            Point last = i.getLastPlayerDir();
                            speed = last == null ? rand(i) : last;
                            break;
                        case 0:
                            speed = rand(i);
                            break;
                    }
                    break;
            }
        }
    }

    private Point rand(Intersection i) {
        return i.randomDir(Client.RANDOM, speed);
    }

    public void setState(int state) {
        this.state = state;
    }

    /**
     * Executado quando o comportamento é inicializado.
     */
    @Override
    public void onInit() {
        ICollider c = igameObject.collider();
        if (c == null) return;
        speed = new Point(0, 1);
    }

    /**
     * Executado quando o objeto é ativado.
     */
    @Override
    public void onEnabled() {
        onInit();
        Client.ENGINE.enable(gameObject());
    }

    /**
     * Executado quando o objeto é desativado.
     */
    @Override
    public void onDisabled() {
        Client.ENGINE.disable(gameObject());
    }

    /**
     * Destrói o inimigo ao ser chamado, removendo-o do motor do jogo.
     */
    @Override
    public void onDestroy() {
        Client.ENGINE.destroy(igameObject);
    }
}
