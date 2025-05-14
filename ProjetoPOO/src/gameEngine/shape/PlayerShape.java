package gameEngine.shape;

import gameEngine.object.IGameObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class PlayerShape extends Shape {
    private BufferedImage img;

    /**
     * Constructor that associates a GameObject to this shape.
     * @param player GameObject that has this shape.
     */
    public PlayerShape(IGameObject player) {
        super(player);
        try {
            img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("Imagens/Burger.png")));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void render(Graphics2D g) {
        if (img != null) {
            g.drawImage(img, -img.getWidth() / 2, -img.getHeight() / 2, null);
        }
    }
}