package gameEngine;

import collisions.Point;
import gameEngine.gui.GUI;
import gameEngine.gui.IGUI;
import gameEngine.gui.View;
import gameEngine.object.Collectible;
import gameEngine.object.Type;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Client {
    public static final GameEngine ENGINE = new GameEngine(null);
    public static final Random RANDOM = new Random();

    public static void main(String[] args) {
        View view = new View();
    }
}