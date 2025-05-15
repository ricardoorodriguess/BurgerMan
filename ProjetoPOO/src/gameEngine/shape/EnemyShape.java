package gameEngine.shape;

import gameEngine.object.EnemyType;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EnemyShape extends Shape {
    private final Map<String, BufferedImage> images = new HashMap<>();
    private final EnemyType enemyType;
    private String currentDirection = "DOWN"; // Direção padrão

    public EnemyShape(EnemyType type) {
        super(null); // O GameObject será associado depois
        this.enemyType = type;

        try {
            if (type == EnemyType.GREEN_TRASH) {
                images.put("UP", loadImage("/images/greenTrashUp.png"));
                images.put("DOWN", loadImage("/images/greenTrashDown.png"));
                images.put("LEFT", loadImage("/images/greenTrashLeft.png"));
                images.put("RIGHT", loadImage("/images/greenTrashRight.png"));
            } else if (type == EnemyType.GRAY_TRASH) {
                images.put("UP", loadImage("/images/greyTrashUp.png"));
                images.put("DOWN", loadImage("/images/greyTrashDown.png"));
                images.put("LEFT", loadImage("/images/greyTrashLeft.png"));
                images.put("RIGHT", loadImage("/images/greyTrashRight.png"));
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load enemy images", e);
        }
    }

    private BufferedImage loadImage(String path) {
        try {
            return javax.imageio.ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(path)));
        } catch (Exception e) {
            throw new RuntimeException("Failed to load image: " + path, e);
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