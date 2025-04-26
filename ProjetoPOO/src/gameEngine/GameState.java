package gameEngine;

public class GameState {
    private static int totalScore = 0;
    private static int totalLives = 3;

    public static void incrementScore(int points) {
        totalScore += points;
    }

    public static void updateLives(int lives) {
        totalLives = lives;
    }

    public static int getScore() {
        return totalScore;
    }

    public static int getLives() {
        return totalLives;
    }

    public static void resetScore()
    {
        totalScore = 0;
    }

    public static void resetLives(){
        totalLives = 0;
    }
}
