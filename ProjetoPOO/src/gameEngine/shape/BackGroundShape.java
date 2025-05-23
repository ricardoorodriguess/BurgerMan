package gameEngine.shape;

import gameEngine.object.BackGround;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class BackGroundShape extends Shape {
    private final Image background;

    public BackGroundShape(BackGround background) {
        super(background);
        this.background = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/map.png"))).getImage();
    }

    @Override
    public void render(Graphics2D g) {
        // Renderiza o fundo centralizado
        int x = -background.getWidth(null) / 2;
        int y = -background.getHeight(null) / 2;

        //int x = (getWidth() - BACKGROUND.getWidth(null)) / 2;
        //int y = (getHeight() - BACKGROUND.getHeight(null)) / 2;
        g.drawImage(background, x, y, null);
    }
}