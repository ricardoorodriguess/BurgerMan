package gameEngine.gui;

import javax.swing.*;
import java.util.Objects;

public class View {
    private JFrame frame;

    public View() {
        frame = new JFrame("Hamburger-Man");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(672, 744);
        frame.setLocationRelativeTo(null); // Center the window on the screen
        frame.setResizable(false);

        frame.setContentPane(new BackgroundPanel());
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/burgerUp.png")));
        frame.setIconImage(icon.getImage());

        frame.setVisible(true);
    }
}