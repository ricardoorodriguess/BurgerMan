package gameEngine.behaviour;

import collisions.Point;
import gameEngine.Client;
import gameEngine.ICollider;
import gameEngine.object.Enemy;
import gameEngine.object.GameObject;
import gameEngine.object.IGameObject;

import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Responsive class to deal with Enemy behaviour.
 * @author Ricardo Rodrigues
 * @author Rodrigo Linhas
 * @author Tiago Tome
 * @version April 29, 2025
 */
public class EnemyBehavior extends Behaviour {
    private Point speed;
    private static final double SPEED = 0.8;

    /**
     * Construtor que associa um GameObject a este comportamento.
     * @param enemy GameObject que será controlado por este comportamento.
     */
    public EnemyBehavior(Enemy enemy) {
        super(enemy);
        speed = new Point(0, 0);
    }

    /**
     * Atualiza o estado do coletável a cada frame.
     * @param dT Tempo desde o último frame (em segundos).
     * @param ie Evento de entrada do usuário.
     */
    @Override
    public void onUpdate(double dT, InputEvent ie) {
        ICollider c = igameObject.collider();
        if (c == null) return;
        Point centroid = c.centroid(),
                left = new Point(-speed.getY(), speed.getX()),
                right = new Point(speed.getY(), -speed.getX());
        List<Point> speeds = new ArrayList<>();
        if (Client.ENGINE.checkSolidCollisionAt(centroid.add(speed)))
            speeds.add(speed);
        if (Client.ENGINE.checkSolidCollisionAt(centroid.add(left)))
            speeds.add(left);
        if (Client.ENGINE.checkSolidCollisionAt(centroid.add(right)))
            speeds.add(right);
        if (speeds.isEmpty()) speed.scaleOrigin(-1);
        else speed = speeds.get(Client.RANDOM.nextInt(speeds.size()));
        ((GameObject) igameObject).move(speed, 0);
    }

    /**
     * Lida com colisões entre este coletável e outros objetos.
     * @param gameObjects Lista de objetos que colidiram com este coletável.
     */
    @Override
    public void onCollision(List<IGameObject> gameObjects) {
        for (IGameObject gameObject : gameObjects) {
            if (gameObject.name().equals("Pickle")) {
                // ...
            }
        }
    }

    /**
     * Executado quando o comportamento é inicializado.
     */
    @Override
    public void onInit() {
        ICollider c = igameObject.collider();
        if (c == null) return;
        Point centroid = c.centroid();
        List<Point> speeds = new ArrayList<>();
        Point[] possible = new Point[]{new Point(1, 0), new Point(0, 1), new Point(-1, 0), new Point(0, -1)};
        for (Point p : possible)
            if (Client.ENGINE.checkSolidCollisionAt(centroid.add(p)))
                speeds.add(p);
        if (!speeds.isEmpty())
            speed = speeds.get(Client.RANDOM.nextInt(speeds.size()));
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
