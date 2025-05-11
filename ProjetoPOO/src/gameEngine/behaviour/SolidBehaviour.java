package gameEngine.behaviour;

import collisions.Point;
import gameEngine.ICollider;
import gameEngine.object.GameObject;
import gameEngine.object.IGameObject;
import gameEngine.object.Solid;

import java.awt.event.InputEvent;
import java.util.List;

/**
 * Responsive class to deal with Solid behaviour (the walls).
 * @author Ricardo Rodrigues
 * @author Rodrigo Linhas
 * @author Tiago Tome
 * @version May 11, 2025
 */
public class SolidBehaviour extends Behaviour {
    /**
     * Construtor que associa um GameObject a este Behaviour.
     *
     * @param solid GameObject que será controlado por este comportamento.
     */
    public SolidBehaviour(Solid solid) {
        super(solid);
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
     * @param gameObjects Lista de objetos colididos.
     */
    @Override
    public void onCollision(List<IGameObject> gameObjects) {
        for (IGameObject gameObject : gameObjects) {
            if (gameObject.transform() != null && gameObject.collider() != null) {
                Point collisionResponse = calculateCollisionResponse((GameObject)gameObject);
                ((GameObject)gameObject).move(collisionResponse, gameObject.transform().layer());
            }
        }
    }

    /**
     * Este método é auxiliar ao onCollision.
     * Calcula a resposta à colisão entre este GameObject e o Solid (as paredes).
     * A resposta é um vetor de deslocamento que indica a direção oposta ao eixo principal da colisão.
     * @param gameObject
     * @return um Point que representa o vetor de resposta à colisão, ou null se o gameObject em questão não tiver colisor.
     * @see chatgpt onde vimos este algoritmo.
     */
    private Point calculateCollisionResponse(GameObject gameObject) {
        ICollider c1 = igameObject.collider(), c2 = gameObject.collider();
        if (c1 == null || c2 == null) return null;
        Point solidCentroid = c1.centroid();
        Point gameObjectCentroid = c2.centroid();

        double dx = gameObjectCentroid.getX() - solidCentroid.getX();
        double dy = gameObjectCentroid.getY() - solidCentroid.getY();

        if (Math.abs(dx) > Math.abs(dy)) {
            return new Point(-dx, 0);
        } else {
            return new Point(0, -dy);
        }
    }

    /**
     * Inicializa o comportamento (chamado uma vez no início).
     */
    @Override
    public void onInit() {

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
