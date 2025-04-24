package game;

import collisions.Point;

public class Scoreboard extends GameObject {
    int lives, score;

    public Scoreboard() {
        super("Position", new Transform(new Point(0, 0), 1, 0, 1), null, false, false, true);
        lives = 3;
        score = 0;
    }

    public void increment(int x) {
        score += x;
    }

    public void onDeath() {
        lives--;
    }
}
