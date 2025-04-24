package game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameFrame extends Frame implements KeyListener {
    public GameFrame() {
        setTitle("Burger Man");
        setSize(400, 200);
        setLayout(new FlowLayout());
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> Client.ENGINE.alertPlayer(player -> player.changeSpeed(0, -1));
            case KeyEvent.VK_A -> Client.ENGINE.alertPlayer(player -> player.changeSpeed(-1, 0));
            case KeyEvent.VK_S -> Client.ENGINE.alertPlayer(player -> player.changeSpeed(0, 1));
            case KeyEvent.VK_D -> Client.ENGINE.alertPlayer(player -> player.changeSpeed(1, 0));
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
