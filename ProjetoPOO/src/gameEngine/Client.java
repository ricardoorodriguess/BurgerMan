package gameEngine;

import collisions.Point;
import gameEngine.gui.View;
import gameEngine.object.Player;
import gameEngine.shape.PlayerShape;

import java.awt.*;
import java.util.Random;

public class Client {
    public static final GameEngine ENGINE = new GameEngine(null);
    public static final Random RANDOM = new Random();

    public static void main(String[] args) {
        View view = new View();
    }
}