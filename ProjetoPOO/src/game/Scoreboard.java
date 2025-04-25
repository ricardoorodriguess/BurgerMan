package game;

import collisions.Point;

public class Scoreboard extends GameObject {
    private int lives, score;

    public Scoreboard() {
        super("Scoreboard", new Transform(new Point(0, 0), 1, 0, 1), null, false, false, false, true);
        lives = 3;
        score = 0;
    }

    public void increment(int x) {
        score += x;
    }

    public void onDeath() {
        if (lives != 0) lives--;
    }

    public int getScore() {return this.score;}

    public int getLives() {return this.lives;}
}
