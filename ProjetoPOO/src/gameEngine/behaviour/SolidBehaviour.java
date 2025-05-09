package gameEngine.behaviour;

import collisions.Point;
import gameEngine.object.GameObject;
import gameEngine.object.IGameObject;
import gameEngine.object.Solid;

import java.awt.event.InputEvent;
import java.util.List;

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
     *
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

    private Point calculateCollisionResponse(GameObject gameObject) {
        Point solidCentroid = igameObject.collider().centroid();
        Point gameObjectCentroid = gameObject.collider().centroid();

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
