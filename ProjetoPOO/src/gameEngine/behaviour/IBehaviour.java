package gameEngine.behaviour;

import gameEngine.object.IGameObject;

import java.awt.event.InputEvent;
import java.util.List;

public interface IBehaviour {
    //para acesso ao gameObject que está associado

    /**
     * Retorna o GameObject associado a este comportamento.
     */
    IGameObject gameObject();

    /**
     * Define o GameObject controlado por este comportamento.
     * @param gameObject Novo GameObject a ser controlado.
     */
    void gameObject(IGameObject gameObject);

    //chamado pelo game engine em cada frame

    /**
     * Atualiza o estado do GameObject a cada frame.
     * @param dT Tempo desde o último frame em segundos.
     * @param ie Eventos de entrada do usuário.
     */
    void onUpdate(double dT, InputEvent ie);

    /**
     * Trata colisões com outros GameObjects.
     * @param gameObjects Lista de objetos colididos.
     */
    void onCollision(List<IGameObject> gameObjects);

    /**
     * Inicializa o comportamento (chamado uma vez no início).
     */
    void onInit();

    /**
     * Executado quando o GameObject é habilitado.
     */
    void onEnabled();

    /**
     * Executado quando o GameObject é desabilitado.
     */
    void onDisabled();

    /**
     * Executado quando o GameObject é destruído.
     */
    void onDestroy();
}