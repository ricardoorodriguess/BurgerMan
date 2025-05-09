package gameEngine.behaviour;

import collisions.Point;
import gameEngine.Client;
import gameEngine.object.Enemy;
import gameEngine.object.GameObject;
import gameEngine.object.IGameObject;
import gameEngine.object.Player;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * Responsive class to deal with Player behaviour.
 * @author Ricardo Rodrigues
 * @author Rodrigo Linhas
 * @author Tiago Tome
 * @version April 29, 2025
 */
public class PlayerBehaviour extends Behaviour {
    private double playerSpeed;
    private double PlayerSpeedTime;
    private boolean invincible;
    private double invincibilityTime;
    private Point speed;
    ScoreBehaviour score = (ScoreBehaviour) Client.ENGINE.getScoreObject().behaviour();
    LivesBehaviour lives = (LivesBehaviour) Client.ENGINE.getLivesObject().behaviour();

    /**
     * Construtor que associa um GameObject a este comportamento.
     * @param player GameObject que será controlado por este comportamento.
     */
    public PlayerBehaviour(Player player) {
        super(player);
        speed = new Point(0, 0);
    }

    /**
     * Chamado a cada frame para atualizar o estado do GameObject.
     * @param dT Tempo em segundos desde o último frame (delta time).
     * @param ie Eventos de entrada do utilizador (ex: teclado).
     */
    @SuppressWarnings("DataFlowIssue")
    @Override
    public void onUpdate(double dT, InputEvent ie) {
        if (this.invincible) {
            this.invincibilityTime -= dT;
            if (this.invincibilityTime <= 0) {
                invincible = false;
            }
        }

        Point prevSpeed = speed;
        if ("Player".equals(this.igameObject.name()) && ie instanceof KeyEvent k) {
            switch (k.getKeyCode()) {
                case KeyEvent.VK_W -> speed = new Point(0, -1);
                case KeyEvent.VK_S -> speed = new Point(0, 1);
                case KeyEvent.VK_D -> speed = new Point(1, 0);
                case KeyEvent.VK_A -> speed = new Point(-1, 0);
            }
        }

        if (Client.ENGINE.checkSolidCollisionAt(igameObject.collider().centroid().add(speed)))
            speed = prevSpeed;

        ((GameObject) igameObject).move(speed, 0);
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
                    this.score.incrementScore(10);
                    Client.ENGINE.destroy(gameObject);
                    return;
                }
                case "Tomato" -> {
                    invincible = true;
                    invincibilityTime = 60;
                    Client.ENGINE.destroy(gameObject);
                    return;
                }
                case "Onion" -> {
                    Client.ENGINE.destroy(Client.ENGINE.randomObject(o -> o instanceof Enemy));
                    Client.ENGINE.destroy(gameObject);
                    return;
                }
                case "Cheese" -> {
                    playerSpeed = Client.RANDOM.nextBoolean() ? 0.8 : 1.2;
                    PlayerSpeedTime = 60;
                    Client.ENGINE.destroy(gameObject);
                    return;
                }
                case "Pickle" -> {
                    Client.ENGINE.destroy(gameObject);
                    return;
                }
                case "Enemy" -> {
                    if (invincible) gameObject.behaviour().onDisabled();
                    else onDisabled();
                }
                case "Solid" -> {
                    ((GameObject) igameObject).move(speed.scaleOrigin(-1), 0);
                    speed = new Point(0, 0);
                }
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
        playerSpeed = 1;
        PlayerSpeedTime = 0;
    }

    /**
     * Chamado quando o GameObject é habilitado (ex: adicionado ao jogo).
     */
    @Override
    public void onEnabled() {
        invincible = false;
        invincibilityTime = 0;
        playerSpeed = 1;
        PlayerSpeedTime = 0;
    }

    /**
     * Chamado quando o GameObject é desabilitado (ex: removido temporariamente).
     */
    @Override
    public void onDisabled() {
        this.lives.decreaseLives();
    }

    /**
     * Chamado quando o GameObject é destruído (remoção permanente).
     */
    @Override
    public void onDestroy() {
        Client.ENGINE.destroy(igameObject);
    }

    public boolean isInvincible() {
        return invincible;
    }

    public double getInvincibilityTime() {
        return invincibilityTime;
    }

    public double getPlayerSpeed() {
        return playerSpeed;
    }

    public double getPlayerSpeedTime() {
        return PlayerSpeedTime;
    }

    /**
     * for tests
     */
    public void setInvincible(double time) {
        invincible = true;
        invincibilityTime = time;
    }
}
