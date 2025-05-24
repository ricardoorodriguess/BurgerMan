package gameEngine.behaviour;

import collisions.Point;
import gameEngine.Client;
import gameEngine.ICollider;
import gameEngine.object.*;
import gameEngine.shape.PlayerShape;
import gameEngine.sound.AudioPlayer;
import org.jetbrains.annotations.Nullable;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * Responsive class to deal with Player behaviour.
 * @author Ricardo Rodrigues
 * @author Rodrigo Linhas
 * @author Tiago Tome
 * @version May 11, 2025
 */
public class PlayerBehaviour extends Behaviour {
    private double playerSpeed;
    private double playerSpeedTime;
    private boolean invincible;
    private double invincibilityTime;
    public Point speed;
    ScoreBehaviour score;
    LivesBehaviour lives;
    AudioPlayer audioPlayer;

    /**
     * Construtor que associa um GameObject a este comportamento.
     * @param player GameObject que será controlado por este comportamento.
     */
    public PlayerBehaviour(Player player) {
        super(player);
        speed = new Point(0, 0);
        this.invincible = false;
        this.audioPlayer = new AudioPlayer();
        playSound();
    }

    @Override
    public void gameObject(IGameObject gameObject) {
        super.gameObject(gameObject);
        score = (ScoreBehaviour) Client.ENGINE.getScoreObject().behaviour();
        lives = (LivesBehaviour) Client.ENGINE.getLivesObject().behaviour();
    }

    /**
     * Chamado a cada frame para atualizar o estado do GameObject.
     * @param dT Tempo em segundos desde o último frame (delta time).
     * @param ie Eventos de entrada do utilizador (ex: teclado).
     */
    @SuppressWarnings("DataFlowIssue")
    @Override
    public void onUpdate(double dT, @Nullable InputEvent ie) {
        System.out.println("PlayerBehaviour atualizado!");
        if (this.invincible) {
            this.invincibilityTime -= dT;
            if (this.invincibilityTime <= 0) {
                invincible = false;
            }
        }
        Point nsp = speed;
        if (ie instanceof KeyEvent k) switch (k.getKeyCode()) {
            case KeyEvent.VK_W -> nsp = new Point(0, -2);
            case KeyEvent.VK_S -> nsp = new Point(0, 2);
            case KeyEvent.VK_D -> nsp = new Point(2, 0);
            case KeyEvent.VK_A -> nsp = new Point(-2, 0);
        }

        Intersection col = Client.ENGINE.getInterAt(igameObject.collider().centroid());

        if ("Player".equals(this.igameObject.name())
                && (col != null || nsp.equals(speed.scaleOrigin(-1)))) {
            speed = nsp;
        }
        if ((speed.getX() + speed.getY()) != 0 && col != null && !col.list().contains(speed))
            speed = new Point(0, 0);

        PlayerShape shape = (PlayerShape) igameObject.shape();
        switch ((int) speed.getX()) {
            case -2:
                shape.setDirection("LEFT");
                break;
            case 0:
                if (speed.getY() < 0)
                    shape.setDirection("UP");
                else if (speed.getY() > 0)
                    shape.setDirection("DOWN");
                break;
            case 2:
                shape.setDirection("RIGHT");
                break;
        }

        ((GameObject) igameObject).move(speed,0);
    }

    /**
     * Chamado quando ocorre uma colisão com outros GameObjects.
     * @param gameObjects Lista de GameObjects colididos.
     */
    @Override
    public void onCollision(List<IGameObject> gameObjects) {
        ICollider c1 = gameObject().collider(), c2;
        if (c1 == null) return;
        for (IGameObject gameObject : gameObjects) {
            if ((c2 = gameObject.collider()) != null && c1.isColliding(c2))
               switch (gameObject.name()) {
                   case "Point" -> {
                       this.score.incrementScore(10);
                       Client.ENGINE.destroy(gameObject);
                       return;
                   }
                   case "Tomato" -> {
                       playSE(2);
                       invincible = true;
                       invincibilityTime = 60;
                       Client.ENGINE.destroy(gameObject);
                       return;
                   }
                   case "Onion" -> {
                       playSE(2);
                       Client.ENGINE.disable(Client.ENGINE.randomObject(o -> o instanceof Enemy));
                       Client.ENGINE.destroy(gameObject);
                       return;
                   }
                   case "Cheese" -> {
                       playSE(2);
                       playerSpeed = Client.RANDOM.nextBoolean() ? 0.8 : 1.2;
                       playerSpeedTime = 60;
                       Client.ENGINE.destroy(gameObject);
                       return;
                   }
                   case "Pickle" -> {
                       playSE(2);
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
                   case "Inter" -> {
                       Intersection i = (Intersection) gameObject;
                       if (!i.list().contains(speed)) speed = new Point(0, 0);
                       else i.setLastPlayerDir(speed);
                   }
                   default -> {}
               }
        }
    }

    @Override
    public void onInit() {
        System.out.println("PlayerBehaviour inicializado!");
        // Inicializa propriedades padrões
        invincible = false;
        invincibilityTime = 0;
        playerSpeed = 1;
        playerSpeedTime = 0;
    }

    @Override
    public void onEnabled() {
        System.out.println("PlayerBehaviour ativado!");
        onInit();
        Client.ENGINE.enable(gameObject());

    }

    @Override
    public void onDisabled() {
        System.out.println("PlayerBehaviour desativado!");
        if (lives != null) {
            playDead();
            this.lives.decreaseLives();
        }
        Client.ENGINE.disable(gameObject());
    }

    @Override
    public void onDestroy() {
        System.out.println("PlayerBehaviour destruído!");
        playSound();
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
        return playerSpeedTime;
    }

    public void slowDown() {
        playerSpeed = 0.8;
        playerSpeedTime = 60;
    }

    /**
     * for tests
     */
    public void setInvincible(double time) {
        invincible = true;
        invincibilityTime = time;
    }

    private void playSound() {
        audioPlayer.setFile(1);
        audioPlayer.play();
        audioPlayer.loop();
    }

    private void playDead() {
        audioPlayer.stop();
        audioPlayer.setFile(0);
        audioPlayer.play();
    }

    private void playSE(int i) {
        audioPlayer.setFile(i);
        audioPlayer.play();
    }
}