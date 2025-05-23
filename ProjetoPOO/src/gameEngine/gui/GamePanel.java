package gameEngine.gui;

import gameEngine.object.IGameObject;
import gameEngine.shape.IShape;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GamePanel extends JPanel {
    private final List<IGameObject> gameObjects;

    public GamePanel(List<IGameObject> gameObjects) {
        this.gameObjects = gameObjects;
        setBackground(Color.BLACK); // Fundo preto para layer -2
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Desenhar os objetos por layer
        gameObjects.stream()
                .sorted((o1, o2) -> Integer.compare(o1.transform().layer(), o2.transform().layer()))
                .forEach(go -> {
                    IShape shape = go.shape();
                    if (shape != null) {
                        shape.draw(g2d);
                    }
                });
    }
}