package gameEngine;

import collisions.Point;
import gameEngine.gui.GUI;
import gameEngine.object.Collectible;
import gameEngine.object.Type;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Client {
    public static final GUI _GUI = new GUI();
    public static final GameEngine ENGINE = new GameEngine(_GUI);
    public static final Random RANDOM = new Random();

    public static void main(String[] args) {

    }
}