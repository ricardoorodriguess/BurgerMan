package gameEngine.behaviour;

import gameEngine.object.IGameObject;

import java.awt.event.InputEvent;
import java.util.List;

//classe que implemneta os metodos de controlo de cada GameObject: andar, os inimigos patrulharem, atacarem,etc...
public class Behaviour implements IBehaviour {
    private IGameObject igameObject;

    /**
     * Construtor que associa um GameObject a este comportamento.
     * @param igameObject GameObject que será controlado por este comportamento.
     */
    public Behaviour(IGameObject igameObject) {
        this.igameObject = igameObject;
    }

    /**
     * Retorna o GameObject associado a este comportamento.
     * @return GameObject vinculado.
     */
    @Override
    public IGameObject gameObject() {
        return this.igameObject;
    }


    /**
     * Define um novo GameObject para este comportamento.
     * @param gameObject Novo GameObject a ser controlado.
     */
    @Override
    public void gameObject(IGameObject gameObject) {
        this.igameObject = gameObject;
    }

    /**
     * Chamado a cada frame para atualizar o estado do GameObject.
     * @param dT Tempo em segundos desde o último frame (delta time).
     * @param ie Eventos de entrada do usuário (ex: teclado).
     */
    @Override
    public void onUpdate(double dT, InputEvent ie) {

    }

    /**
     * Chamado quando ocorre uma colisão com outros GameObjects.
     * @param gameObjects Lista de GameObjects colididos.
     */
    @Override
    public void onCollision(List<IGameObject> gameObjects) {

    }


    /**
     * Chamado quando o GameObject é inicializado (antes do primeiro frame).
     */
    @Override
    public void onInit() {

    }

    /**
     * Chamado quando o GameObject é habilitado (ex: adicionado ao jogo).
     */
    @Override
    public void onEnabled() {

    }

    /**
     * Chamado quando o GameObject é desabilitado (ex: removido temporariamente).
     */
    @Override
    public void onDisabled() {

    }


    /**
     * Chamado quando o GameObject é destruído (remoção permanente).
     */
    @Override
    public void onDestroy() {

    }
}
