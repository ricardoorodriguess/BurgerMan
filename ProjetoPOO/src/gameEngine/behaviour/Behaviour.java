package gameEngine.behaviour;

import collisions.Point;
import com.sun.nio.sctp.NotificationHandler;
import gameEngine.Client;
import gameEngine.GameState;
import gameEngine.object.GameObject;
import gameEngine.object.IGameObject;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.awt.Event;
import java.util.List;

//classe que implemneta os metodos de controlo de cada GameObject: andar, os inimigos patrulharem, atacarem,etc...
public abstract class Behaviour implements IBehaviour {
    IGameObject igameObject;

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
}
