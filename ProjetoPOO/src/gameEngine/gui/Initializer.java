package gameEngine.gui;

import collisions.Point;
import gameEngine.GameEngine;
import gameEngine.object.*;

import java.util.ArrayList;

/**
 * This class initializes the game objects and intersections for the Burger game.
 * It sets up the player, enemies, collectibles, and intersections on the game grid.
 *
 * @author Rodrigo Linhas
 * @author Ricardo Rodrigues
 * @author Tiago Tome
 * @version May 24, 2025
 */
public class Initializer {

    private static final Point up = new Point(0, -2);
    private static final Point down = new Point(0, 2);
    private static final Point left = new Point(-2, 0);
    private static final Point right = new Point(2, 0);
    private static final Point[] dirs = new Point[]{up, down, left, right};

    /**
     * This class initializes the game objects and intersections for
     * the Burger
     */
    private static final int[][] inters = new int[][]{
        new int[]{85, 105, 0, 2, 0, 1},
        new int[]{185, 105, 0, 2, 1, 1},
        new int[]{305, 105, 0, 2, 1, 0},
        new int[]{365, 105, 0, 2, 0, 1},
        new int[]{485, 105, 0, 2, 1, 1},
        new int[]{585, 105, 0, 2, 1, 0},
        new int[]{85, 185, 1, 1, 0, 2},
        new int[]{185, 185, 1, 1, 1, 2},
        new int[]{245, 185, 1, 1, 1, 2},
        new int[]{305, 185, 1, 0, 2, 1},
        new int[]{365, 185, 1, 0, 1, 2},
        new int[]{425, 185, 0, 2, 1, 1},
        new int[]{485, 185, 1, 1, 2, 1},
        new int[]{585, 185, 1, 1, 2, 0},
        new int[]{85, 245, 1, 0, 0, 2},
        new int[]{185, 245, 1, 2, 1, 0},
        new int[]{245, 245, 1, 0, 0, 2},
        new int[]{305, 245, 0, 2, 1, 0},
        new int[]{365, 245, 0, 2, 0, 1},
        new int[]{425, 245, 1, 0, 2, 0},
        new int[]{485, 245, 1, 2, 0, 1},
        new int[]{585, 245, 1, 0, 2, 0},
        new int[]{245, 305, 0, 1, 0, 2},
        new int[]{305, 305, 1, 0, 1, 2},
        new int[]{335, 305, 0, 2, 1, 1},
        new int[]{365, 305, 1, 0, 2, 1},
        new int[]{425, 305, 0, 1, 2, 0},
        new int[]{185, 365, 1, 1, 0, 2},
        new int[]{245, 365, 2, 1, 1, 0},
        new int[]{425, 365, 2, 1, 0, 1},
        new int[]{485, 365, 1, 1, 2, 0},
        new int[]{245, 425, 2, 1, 0, 1},
        new int[]{425, 425, 2, 1, 1, 0},
        new int[]{85, 485, 0, 1, 0, 2},
        new int[]{185, 485, 1, 1, 1, 2},
        new int[]{245, 485, 2, 0, 1, 1},
        new int[]{305, 485, 0, 1, 2, 0},
        new int[]{365, 485, 0, 1, 0, 2},
        new int[]{425, 485, 2, 0, 1, 1},
        new int[]{485, 485, 1, 1, 2, 1},
        new int[]{585, 485, 0, 1, 2, 0},
        new int[]{85, 545, 2, 0, 0, 1},
        new int[]{125, 545, 0, 1, 2, 0},
        new int[]{185, 545, 2, 1, 0, 1},
        new int[]{245, 545, 0, 1, 1, 2},
        new int[]{305, 545, 2, 0, 1, 1},
        new int[]{365, 545, 2, 0, 1, 1},
        new int[]{425, 545, 0, 1, 2, 1},
        new int[]{485, 545, 2, 1, 1, 0},
        new int[]{545, 545, 0, 1, 0, 2},
        new int[]{585, 545, 2, 0, 1, 0},
        new int[]{85, 605, 0, 1, 0, 2},
        new int[]{125, 605, 2, 0, 1, 1},
        new int[]{185, 605, 2, 0, 1, 0},
        new int[]{245, 605, 2, 0, 0, 1},
        new int[]{305, 605, 0, 1, 2, 0},
        new int[]{365, 605, 0, 1, 0, 2},
        new int[]{425, 605, 2, 0, 1, 0},
        new int[]{485, 605, 2, 0, 0, 1},
        new int[]{545, 605, 2, 0, 1, 1},
        new int[]{585, 605, 0, 1, 2, 0},
        new int[]{85, 665, 2, 0, 0, 1},
        new int[]{305, 665, 2, 0, 1, 1},
        new int[]{365, 665, 2, 0, 1, 1},
        new int[]{585, 665, 2, 0, 1, 0}
    };

    private static final int[][] points = new int[][]{
        new int[]{285, 185},
        new int[]{265, 185},
        new int[]{245, 185},
        new int[]{225, 185},
        new int[]{205, 185},
        new int[]{185, 185},
        new int[]{165, 185},
        new int[]{145, 185},
        new int[]{125, 185},
        new int[]{105, 185},
        new int[]{85, 185},
        new int[]{305, 185},
        new int[]{325, 185},
        new int[]{345, 185},
        new int[]{365, 185},
        new int[]{385, 185},
        new int[]{405, 185},
        new int[]{425, 185},
        new int[]{445, 185},
        new int[]{465, 185},
        new int[]{485, 185},
        new int[]{505, 185},
        new int[]{525, 185},
        new int[]{545, 185},
        new int[]{565, 185},
        new int[]{105, 105},
        new int[]{125, 105},
        new int[]{145, 105},
        new int[]{165, 105},
        new int[]{205, 105},
        new int[]{225, 105},
        new int[]{245, 105},
        new int[]{265, 105},
        new int[]{285, 105},
        new int[]{385, 105},
        new int[]{405, 105},
        new int[]{425, 105},
        new int[]{445, 105},
        new int[]{465, 105},
        new int[]{505, 105},
        new int[]{525, 105},
        new int[]{545, 105},
        new int[]{565, 105},
        new int[]{105, 245},
        new int[]{125, 245},
        new int[]{145, 245},
        new int[]{165, 245},
        new int[]{265, 245},
        new int[]{285, 245},
        new int[]{385, 245},
        new int[]{405, 245},
        new int[]{505, 245},
        new int[]{525, 245},
        new int[]{545, 245},
        new int[]{565, 245},
        new int[]{185, 305},
        new int[]{320, 305},
        new int[]{285, 305},
        new int[]{265, 305},
        new int[]{350, 305},
        new int[]{385, 305},
        new int[]{405, 305},
        new int[]{485, 305},

    };


    /**
     * Initializes the game objects for the Burger game.
     * This method adds the background, score, lives, player, enemies, and collectibles to the game engine.
     *
     * @param engine The game engine where the objects will be added.
     */
    public static void initializeGameObjects(GameEngine engine) {
        engine.add(new BackGround());
        engine.add(new Score());
        engine.add(new Lives());
        engine.add(new Player(new Point(85, 105)));
        engine.add(new Enemy(new Point(485, 245), EnemyType.GRAY_TRASH));

        //engine.add(new Collectible(Type.POINT, new Point(285, 190)));
        //engine.add(new Collectible(Type.POINT, new Point(305, 185))); -> posição original do intersection
        //engine.add(new Collectible(Type.POINT, new Point(305, 190)));
        for (int[] inter: inters)
            engine.add(new Collectible(Type.POINT, new Point(inter[0], inter[1])));

        for (int[] point: points)
            engine.add(new Collectible(Type.POINT, new Point(point[0], point[1])));




        engine.add(new Collectible(Type.CHEESE, new Point(200, 300)));
        engine.add(new Collectible(Type.TOMATO, new Point(500, 500)));
        engine.add(new Collectible(Type.ONION, new Point(600, 600)));
        engine.add(new Collectible(Type.PICKLE, new Point(230, 400)));
    }

    /**
     * Initializes the intersections for the Burger game.
     * This method creates intersections based on predefined coordinates and directions,
     * allowing the player and enemies to navigate through the game grid.
     *
     * @param engine The game engine where the intersections will be added.
     */
    public static void initializeIntersections(GameEngine engine) {
        for (int[] a : inters) {
            Point p = new Point(a[0], a[1]);
            ArrayList<Point> list = new ArrayList<>();
            for (int i = 2; i < 6; i++) {
                if (a[i] == 2) list.add(dirs[i - 2]);
                if (a[i] == 1) list.add(dirs[i - 2]);
            }
            engine.add(new Intersection(p, list));
        }
    }
}
