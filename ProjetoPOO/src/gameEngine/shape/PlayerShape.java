package gameEngine.shape;

import gameEngine.object.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PlayerShape extends Shape {
    private final Map<String, BufferedImage> images = new HashMap<>();
    private String currentDirection = "UP";

    public PlayerShape(Player player) {
        super(player);
        try {
            images.put("UP", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/burgerUp.png"))));
            images.put("DOWN", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/burgerDown.png"))));
            images.put("LEFT", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/burgerLeft.png"))));
            images.put("RIGHT", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/burgerRight.png"))));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load player images", e);
        }
    }

    public void setDirection(String direction) {
        if (images.containsKey(direction)) {
            currentDirection = direction;
        }
    }

    @Override
    public void render(Graphics2D g) {
        BufferedImage img = images.get(currentDirection);
        if (img != null) {
            g.drawImage(img, -img.getWidth() / 2, -img.getHeight() / 2, null);
        }
    }
}