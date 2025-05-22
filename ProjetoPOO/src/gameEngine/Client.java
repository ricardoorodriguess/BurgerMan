package gameEngine;

import collisions.Point;
import gameEngine.gui.GUI;
import gameEngine.object.*;

import java.util.ArrayList;
import java.util.Random;

public class Client {
    public static final GameEngine ENGINE = new GameEngine();
    public static final Random RANDOM = new Random();

    public static void main(String[] args) {
        ENGINE.add(new Score());
        ENGINE.add(new Lives());
        ENGINE.add(new Player(new Point(30, 30)));
        ENGINE.add(new Enemy(new Point(200, 200), EnemyType.GRAY_TRASH));
        ENGINE.add(new Collectible(Type.CHEESE, new Point(200, 300)));
        ENGINE.add(new Collectible(Type.POINT, new Point(400, 400)));
        ENGINE.add(new Collectible(Type.TOMATO, new Point(500, 500)));
        ENGINE.add(new Collectible(Type.ONION, new Point(600, 600)));
        ENGINE.add(new Collectible(Type.PICKLE, new Point(230, 400)));

        Point up = new Point(0, -1), down = new Point(0, 1), left = new Point(-1, 0), right = new Point(1, 0);
        Point[] dirs = new Point[]{up, down, left, right};
        int[][] inters = new int[][]{
                new int[]{30, 30, 0, 2, 0, 1},
                new int[]{130, 30, 0, 2, 1, 1},
                new int[]{250, 30, 0, 2, 1, 0},
                new int[]{310, 30, 0, 2, 0, 1},
                new int[]{430, 30, 0, 2, 1, 1},
                new int[]{530, 30, 0, 2, 1, 0},
                new int[]{30, 110, 1, 1, 0, 2},
                new int[]{130, 110, 1, 1, 1, 2},
                new int[]{190, 110, 1, 1, 1, 2},
                new int[]{250, 110, 1, 0, 2, 1},
                new int[]{310, 110, 1, 0, 1, 2},
                new int[]{370, 110, 0, 2, 1, 1},
                new int[]{430, 110, 1, 1, 2, 1},
                new int[]{530, 110, 1, 1, 2, 0},
                new int[]{30, 170, 1, 0, 0, 2},
                new int[]{130, 170, 1, 2, 1, 0},
                new int[]{190, 170, 1, 0, 0, 2},
                new int[]{250, 170, 0, 2, 1, 0},
                new int[]{310, 170, 0, 2, 0, 1},
                new int[]{370, 170, 1, 0, 2, 0},
                new int[]{430, 170, 1, 2, 0, 1},
                new int[]{530, 170, 1, 0, 2, 0},
                new int[]{190, 230, 0, 1, 0, 2},
                new int[]{250, 230, 1, 0, 1, 2},
                new int[]{280, 230, 0, 2, 1, 1},
                new int[]{310, 230, 1, 0, 2, 1},
                new int[]{370, 230, 0, 1, 2, 0},
                new int[]{130, 290, 1, 1, 0, 2},
                new int[]{190, 290, 2, 1, 1, 0},
                new int[]{370, 290, 2, 1, 0, 1},
                new int[]{430, 290, 1, 1, 2, 0},
                new int[]{190, 350, 2, 1, 0, 1},
                new int[]{370, 350, 2, 1, 1, 0},
                new int[]{30, 410, 0, 1, 0, 2},
                new int[]{130, 410, 1, 1, 1, 2},
                new int[]{190, 410, 2, 0, 1, 1},
                new int[]{250, 410, 0, 1, 2, 0},
                new int[]{310, 410, 0, 1, 0, 2},
                new int[]{370, 410, 2, 0, 1, 1},
                new int[]{430, 410, 1, 1, 2, 1},
                new int[]{530, 410, 0, 1, 2, 0},
                new int[]{30, 470, 2, 0, 0, 1},
                new int[]{70, 470, 0, 1, 2, 0},
                new int[]{130, 470, 2, 1, 0, 1},
                new int[]{190, 470, 0, 1, 1, 2},
                new int[]{250, 470, 2, 0, 1, 1},
                new int[]{310, 470, 2, 0, 1, 1},
                new int[]{370, 470, 0, 1, 2, 1},
                new int[]{430, 470, 2, 1, 1, 0},
                new int[]{490, 470, 0, 1, 0, 2},
                new int[]{530, 470, 2, 0, 1, 0},
                new int[]{30, 530, 0, 1, 0, 2},
                new int[]{70, 530, 2, 0, 1, 1},
                new int[]{130, 530, 2, 0, 1, 0},
                new int[]{190, 530, 2, 0, 0, 1},
                new int[]{250, 530, 0, 1, 2, 0},
                new int[]{310, 530, 0, 1, 0, 2},
                new int[]{370, 530, 2, 0, 1, 0},
                new int[]{430, 530, 2, 0, 0, 1},
                new int[]{490, 530, 2, 0, 1, 1},
                new int[]{530, 530, 0, 1, 2, 0},
                new int[]{30, 590, 2, 0, 0, 1},
                new int[]{250, 590, 2, 0, 1, 1},
                new int[]{310, 590, 2, 0, 1, 1},
                new int[]{530, 590, 2, 0, 1, 0}
        };
        for (int[] a : inters) {
            Point p = new Point(a[0], a[1]);
            ArrayList<Point> list = new ArrayList<>();
            for (int i = 2; i < 6; i++)
                if (a[i] == 2)
                    list.add(dirs[i - 2]);
            for (int i = 2; i < 6; i++)
                if (a[i] == 1)
                    list.add(dirs[i - 2]);
            ENGINE.add(new Intersection(p, list));
        }


        ENGINE.setGUI(new GUI());
        ENGINE.run();
    }
}