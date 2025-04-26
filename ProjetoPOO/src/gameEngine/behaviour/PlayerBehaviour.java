package gameEngine.behaviour;

import collisions.Point;
import gameEngine.Client;
import gameEngine.GameState;
import gameEngine.object.Collectible;
import gameEngine.object.IGameObject;
import gameEngine.object.Player;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.List;

public class PlayerBehaviour extends Behaviour {
    private boolean invincible;
    private double invincibilityTime;

    /**
     * Construtor que associa um GameObject a este comportamento.
     * @param player GameObject que será controlado por este comportamento.
     */
    public PlayerBehaviour(Player player) {
        super(player);
    }

    /**
     * Chamado a cada frame para atualizar o estado do GameObject.
     * @param dT Tempo em segundos desde o último frame (delta time).
     * @param ie Eventos de entrada do usuário (ex: teclado).
     */
    @Override
    public void onUpdate(double dT, InputEvent ie) {
        if (this.invincible) {
            this.invincibilityTime -= dT;
            if (this.invincibilityTime <= 0) {
                invincible = false;
            }
        }

        if ("Player".equals(this.igameObject.name()) && ie instanceof KeyEvent k) {
            Point delta = new Point(0, 0);
            switch (k.getKeyCode()) {
                case KeyEvent.VK_W -> {}
                case KeyEvent.VK_S -> {}
                case KeyEvent.VK_D -> {}
                case KeyEvent.VK_A -> {}
            }
            return;
        }

        if (!"Player".equals(this.igameObject.name())) {
            //para fazer o movimento dos enemys
        }
    }

    /**
     * Chamado quando ocorre uma colisão com outros GameObjects.
     * @param gameObjects Lista de GameObjects colididos.
     */
    @Override
    public void onCollision(List<IGameObject> gameObjects) {
        for (IGameObject gameObject : gameObjects) {
            switch (gameObject.name())
            {
                case "Point" -> {
                    GameState.incrementScore(10);
                    gameObjects.remove(gameObject);
                }
                case "Tomato" -> {
                    invincible = true;
                    invincibilityTime = 60;
                    gameObjects.remove(gameObject);
                }
                case "Onion" -> {}
                case "Cheese" -> {
                    Client.PLAYER_SPEED = Client.RANDOM.nextBoolean() ? 0.8 : 1.2;
                    Client.PLAYER_SPEED_BUFFER = 60;
                    gameObjects.remove(gameObject);
                }
                case "Pickle" -> {}
                case "Enemy" -> {}
                default -> {}
            }
        }
    }


    /**
     * Chamado quando o GameObject é inicializado (antes do primeiro frame).
     */
    @Override
    public void onInit() {
        invincible = false;
        invincibilityTime = 0;
    }

    /**
     * Chamado quando o GameObject é habilitado (ex: adicionado ao jogo).
     */
    @Override
    public void onEnabled() {
        invincible = false;
        invincibilityTime = 0;
    }

    /**
     * Chamado quando o GameObject é desabilitado (ex: removido temporariamente).
     */
    @Override
    public void onDisabled() {
        //O QUE É SUPOSTO FAZER AQUI ?
    }

    /**
     * Chamado quando o GameObject é destruído (remoção permanente).
     */
    @Override
    public void onDestroy() {
        Client.ENGINE.destroy(igameObject);
    }
}
