package tests;

import collisions.Point;
import gameEngine.GameEngine;
import gameEngine.object.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class GameEngineTests {
    GameEngine engine = new GameEngine();
    Player player = new Player(new Point(1, 1));
    Random random = new Random();

    @Test
    void add() {
        engine.add(player);
        engine.add(new Enemy(new Point(5, 5)));
        engine.add(new Collectible(Type.POINT, new Point(1, 1)));
        assertEquals(engine.getLoadedObjects().size(), 3);
    }

    @Test
    void destroy() {
        Collectible collectible;
        engine.add(collectible = new Collectible(Type.POINT, new Point(0, 0)));
        assertFalse(engine.getLoadedObjects().isEmpty());
        engine.destroy(collectible);
        assertTrue(engine.getLoadedObjects().isEmpty());
    }

    @Test
    void getLoadedObjects() {
        engine.add(player);
        for (int i = 0; i < 4; i++)
            engine.add(new Enemy(new Point(random.nextDouble(), random.nextDouble())));
        ArrayList<GameObject> list = new ArrayList<>();
        for (GameObject g : engine.getLoadedObjects())
            if (g instanceof Enemy)
                list.add(g);
        for (GameObject g : list)
            engine.destroy(g);
        assertEquals(engine.getLoadedObjects().size(), 1);
    }

    @Test
    void addEnabled() {
    }

    @Test
    void addDisabled() {
    }

    @Test
    void enable() {
    }

    @Test
    void disable() {
    }

    @Test
    void isEnabled() {
    }

    @Test
    void isDisabled() {
    }

    @Test
    void getEnabled() {
    }

    @Test
    void getDisabled() {
    }

    @Test
    void testDestroy() {
        engine.add(player);
        engine.destroy(player);
        assertTrue(engine.getLoadedObjects().isEmpty());
    }

    @Test
    void destroyAll() {
        for (int i = 0; i < 100; i++)
            engine.add(player);
        engine.destroyAll();
        assertTrue(engine.getLoadedObjects().isEmpty());
    }

    @Test
    void run() {
    }

    @Test
    void checkCollisions() {
    }

    @Test
    void randomObject() {
        engine.add(player);
        assertEquals(player, engine.randomObject(_ -> true));
    }

    @Test
    void incrementScore() {
        engine.incrementScore(1);
        assertEquals(engine.getScore(), 1);
        engine.incrementScore(1543243);
        assertEquals(engine.getScore(), 1543244);
        engine.incrementScore(1);
        assertEquals(engine.getScore(), 1543245);
    }

    @Test
    void updateLives() {
        engine.updateLives(6);
        assertEquals(engine.getLives(), 6);
    }

    @Test
    void getScore() {
    }

    @Test
    void getLives() {
    }

    @Test
    void resetScore() {
    }

    @Test
    void resetLives() {
    }
}