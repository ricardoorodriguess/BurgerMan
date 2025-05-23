package gameEngine.behaviour;

import gameEngine.ICollider;
import gameEngine.object.*;
import gameEngine.Client;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.event.InputEvent;
import java.util.List;

/**
 * Responsive class to deal with Collectible behaviour.
 * @author Ricardo Rodrigues
 * @author Rodrigo Linhas
 * @author Tiago Tome
 * @version May 11, 2025
 */
public class CollectibleBehaviour extends Behaviour {
    private boolean collected = false;
    //private boolean initialized = false;
    private Type collectibleType;

    /**
     * Construtor que associa este comportamento a um coletável.
     * @param collectible Coletável controlado por este comportamento.
     */
    public CollectibleBehaviour(@Nullable Collectible collectible) {
        super(collectible);
    }

    @Override
    public void gameObject(IGameObject gameObject) {
        super.gameObject(gameObject);
        this.collectibleType = ((Collectible) gameObject).getType();
    }

    /**
     * Atualiza o estado do coletável a cada frame.
     * @param dT Tempo desde o último frame (em segundos).
     * @param ie Evento de entrada do usuário.
     */
    @Override
    public void onUpdate(double dT, InputEvent ie) {
        /*if (!initialized) {
            onInit();
            initialized = true;
        }*/
        if (collected) {
            // Destrói o objeto quando coletado
            System.out.println("DESTROY COLLECT");
            onDestroy();
            collected = false;
        }
    }

    /**
     * Lida com colisões entre este coletável e outros objetos.
     * @param gameObjects Lista de objetos que colidiram com este coletável.
     */
    @Override
    public void onCollision(List<IGameObject> gameObjects) {
        ICollider c1 = igameObject.collider(), c2;
        for (IGameObject obj : gameObjects) {
            if (isCollision(obj) && ((c2 = obj.collider())) != null && c2.isColliding(c1)) {
                collected = true;
                break;
            }
        }
    }
    /**
     * Metodo complementar com o  {@link #onCollision(List)}.
     * @param obj Objeto que colidiu com este coletável.
     * @return true se o objeto colidiu com este coletável, false caso contrário.
     */
    private boolean isCollision(IGameObject obj) {
        if (obj instanceof Player) return true;
        else return obj instanceof Enemy && collectibleType == Type.PICKLE;
    }
    
    /**
     * Executado quando o comportamento é inicializado.
     */
    @Override
    public void onInit() {
        collected = false;
        //initialized = false;
    }

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
    public void onDestroy() {
        Client.ENGINE.destroy(igameObject);
    }

    //para os testes
    public boolean isCollected() { return collected; }
    //public boolean isInitialized() { return initialized; }
}
