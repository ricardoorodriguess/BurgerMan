package tests;

import game.Scoreboard;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ScoreboardTests {
    @Test
    void constructorTest() {
        Scoreboard scoreboard = new Scoreboard();
        assertInstanceOf(Scoreboard.class, scoreboard);
        assertEquals("Scoreboard", scoreboard.name());
        assertEquals("(0.00,0.00) 1 0.00 1.00", scoreboard.transform().toString());
        assertNull(scoreboard.collider());
        assertFalse(scoreboard.isPlayer());
        assertFalse(scoreboard.isEnemy());
        assertFalse(scoreboard.isSolid());
        assertTrue(scoreboard.isScoreboard());
        assertEquals(0, scoreboard.getScore()); //aqui ja testa o getScore
        assertEquals(3, scoreboard.getLives()); //aqu ja testa o getLifes
    }

    @Test
    void increment() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.increment(10);
        scoreboard.increment(10);
        assertEquals(20, scoreboard.getScore());
        scoreboard.increment(20);
        assertEquals(40, scoreboard.getScore());
    }

    @Test
    void onDeath() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.onDeath();
        assertEquals(2, scoreboard.getLives());
        scoreboard.onDeath();
        assertEquals(1, scoreboard.getLives());
        scoreboard.onDeath();
        assertEquals(0, scoreboard.getLives());
    }
}