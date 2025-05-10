package gameEngine.behaviour;

import gameEngine.object.Score;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreBehaviourTests {
    Score score = new Score();
    ScoreBehaviour scoreBehaviour = new ScoreBehaviour(score);

    @Test
    void testConstructor() {
        assertInstanceOf(ScoreBehaviour.class, scoreBehaviour);
        assertNotNull(scoreBehaviour);
        assertEquals(score, scoreBehaviour.gameObject());
    }

    @Test
    void onUpdate() {
    }

    @Test
    void onCollision() {
    }

    @Test
    void onInit() {
        scoreBehaviour.onInit();
        assertEquals(0 ,scoreBehaviour.getScore());
        scoreBehaviour.incrementScore(1000);
        assertEquals(1000 ,scoreBehaviour.getScore());
        scoreBehaviour.incrementScore(10);
        assertEquals(1010 ,scoreBehaviour.getScore());
        scoreBehaviour.onInit();
        assertEquals(0 ,scoreBehaviour.getScore());
    }

    @Test
    void onEnabled() {
    }

    @Test
    void onDisabled() {
    }

    @Test
    void onDestroy() {
    }

    @Test
    void incrementScore() {
        scoreBehaviour.onInit();
        assertEquals(0 ,scoreBehaviour.getScore());
        scoreBehaviour.incrementScore(10);
        scoreBehaviour.incrementScore(10);
        scoreBehaviour.incrementScore(20);
        scoreBehaviour.incrementScore(20);
        scoreBehaviour.incrementScore(0);
        scoreBehaviour.incrementScore(50);
        scoreBehaviour.incrementScore(100);
        assertEquals(210 ,scoreBehaviour.getScore());
        assertThrows(IllegalArgumentException.class, () -> scoreBehaviour.incrementScore(-1));
    }

    @Test
    void getScore() {
        scoreBehaviour.onInit();
        assertEquals(0,scoreBehaviour.getScore());
        scoreBehaviour.incrementScore(10);
        assertEquals(10 ,scoreBehaviour.getScore());
    }
}