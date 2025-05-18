package gameEngine.gui;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class backgroundPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());

        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/map.png")));
        Image image = icon.getImage();
        int x = (getWidth() - image.getWidth(null)) / 2;
        int y = (getHeight() - image.getHeight(null)) / 2;

        g.drawImage(image, x, y, null);
        //VER ALGUMA MANEIRA DE ESCALAR A IMAGEM PARA O TAMANHO DO PAINEL
    }
}
