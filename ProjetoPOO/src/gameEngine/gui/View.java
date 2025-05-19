package gameEngine.gui;

import gameEngine.Client;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class View extends JFrame {
    public View() {
        super("Hamburger-Man");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(672, 744);
        setLocationRelativeTo(null); // Center the window on the screen
        setResizable(false);

        setContentPane(new BackgroundPanel());
        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/burgerUp.png")))
                .getImage());

        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Client._GUI.display(Client.ENGINE.getEnabled(), g);
    }
}