package gameEngine;

import collisions.Point;
import gameEngine.gui.GUI;
import gameEngine.gui.View;
import gameEngine.object.Player;

import java.util.Random;

public class Client {
    public static final GUI _GUI = new GUI();
    public static final GameEngine ENGINE = new GameEngine(_GUI);
    public static final Random RANDOM = new Random();

    public static void main(String[] args) {
        ENGINE.add(new Player(new Point(100, 100)));
        new View();
        ENGINE.run();
    }
}