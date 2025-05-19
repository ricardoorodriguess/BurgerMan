package gameEngine;

import collisions.Point;
import gameEngine.gui.GUI;
import gameEngine.object.Player;

import java.util.Random;

public class Client {
    public static final GameEngine ENGINE = new GameEngine();
    public static final Random RANDOM = new Random();

    public static void main(String[] args) {
        ENGINE.add(new Player(new Point(100, 100)));
        ENGINE.setGUI(new GUI());
        while (true) {
            ENGINE.run();
        }
    }
}