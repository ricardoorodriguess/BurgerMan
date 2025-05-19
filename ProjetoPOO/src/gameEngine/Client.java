package gameEngine;

import collisions.Point;
import gameEngine.gui.GUI;
import gameEngine.object.*;

import java.util.Random;

public class Client {
    public static final GameEngine ENGINE = new GameEngine();
    public static final Random RANDOM = new Random();

    public static void main(String[] args) {
        ENGINE.add(new Player(new Point(100, 100)));
        ENGINE.add(new Enemy(new Point(200, 200), EnemyType.GRAY_TRASH));
        ENGINE.add(new Collectible(Type.CHEESE, new Point(200, 300)));
        ENGINE.add(new Collectible(Type.POINT, new Point(400, 400)));
        ENGINE.add(new Collectible(Type.TOMATO, new Point(500, 500)));
        ENGINE.add(new Collectible(Type.ONION, new Point(600, 600)));
        ENGINE.add(new Collectible(Type.PICKLE, new Point(230, 400)));

        ENGINE.setGUI(new GUI());
        while (true) {
            ENGINE.run();
        }
    }
}