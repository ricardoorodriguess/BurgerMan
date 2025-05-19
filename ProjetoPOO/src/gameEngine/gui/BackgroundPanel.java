package gameEngine.gui;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class BackgroundPanel extends JPanel {
    final Image BACKGROUND =
            new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/map.png"))).getImage();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());

        int x = (getWidth() - BACKGROUND.getWidth(null)) / 2;
        int y = (getHeight() - BACKGROUND.getHeight(null)) / 2;

        g.drawImage(BACKGROUND, x, y, null);
    }
}
