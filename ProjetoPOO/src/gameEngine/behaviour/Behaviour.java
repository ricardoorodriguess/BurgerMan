package gameEngine.behaviour;

import gameEngine.object.IGameObject;

//classe que implemneta os metodos de controlo de cada GameObject: andar, os inimigos patrulharem, atacarem,etc...
public abstract class Behaviour implements IBehaviour {
    IGameObject igameObject;

    /**
     * Construtor que associa um GameObject a este Behaviour.
     * @param igameObject GameObject que será controlado por este comportamento.
     */
    public Behaviour(IGameObject igameObject) {
        this.igameObject = igameObject;
    }

    /**
     * Retorna o GameObject associado a este Behaviour.
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
}
