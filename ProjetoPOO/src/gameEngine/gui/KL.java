package gameEngine.gui;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KL extends JFrame implements KeyListener {
    public KL() {
        addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(e);
    }

    public static void main(String[] args) {
        KL kl = new KL();
        while (true) {}
    }
}
