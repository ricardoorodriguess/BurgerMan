package gameEngine.gui;

import javax.swing.*;
import java.util.Objects;

public class View {
    private JFrame frame;

    public View() {
        frame = new JFrame("Hamburger-Man");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the window on the screen
        frame.setResizable(false);

        BackgroundPanel panel = new BackgroundPanel();
        frame.setContentPane(panel);
        frame.setSize(panel.BACKGROUND.getWidth(null), panel.BACKGROUND.getHeight(null) + 50);

        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/burgerUp.png")));
        frame.setIconImage(icon.getImage());

        frame.setVisible(true);
    }
}
