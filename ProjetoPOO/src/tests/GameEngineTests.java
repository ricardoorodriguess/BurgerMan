package tests;

import collisions.Point;
import gameEngine.GameEngine;
import gameEngine.Transform;
import gameEngine.object.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
        IGameObject obj = new GameObject("Obj", Transform.simpleTransform(new Point(0,0)), null, null);
        engine.addEnabled(obj);
        assertTrue(engine.getEnabled().contains(obj));
        assertEquals(1, engine.getEnabled().size());

    }

    @Test
    void addDisabled() {
        IGameObject obj = new GameObject("Obj", Transform.simpleTransform(new Point(0,0)), null, null);
        engine.addDisabled(obj);
        assertTrue(engine.getDisabled().contains(obj));
        assertEquals(1, engine.getDisabled().size());

    }

    @Test
    void enable() {
        IGameObject obj = new GameObject("Obj", Transform.simpleTransform(new Point(0,0)), null, null);
        engine.addDisabled(obj);
        engine.enable(obj);
        assertTrue(engine.isEnabled(obj));

    }

    @Test
    void disable() {
        IGameObject obj = new GameObject("Obj", Transform.simpleTransform(new Point(0,0)), null, null);
        engine.addEnabled(obj);
        engine.disable(obj);
        assertTrue(engine.isDisabled(obj));

    }

    @Test
    void isEnabled() {
        IGameObject obj = new GameObject("Obj", Transform.simpleTransform(new Point(0,0)), null, null);
        engine.addEnabled(obj);
        assertTrue(engine.isEnabled(obj));
        assertFalse(engine.isDisabled(obj));

    }

    @Test
    void isDisabled() {
        IGameObject obj = new GameObject("Obj", Transform.simpleTransform(new Point(0,0)), null, null);
        engine.addDisabled(obj);
        assertTrue(engine.isDisabled(obj));
        assertFalse(engine.isEnabled(obj));

    }

    @Test
    void getEnabled() {
        IGameObject obj = new GameObject("Obj", Transform.simpleTransform(new Point(0,0)), null, null);
        IGameObject obj2 = new GameObject("Obj2", Transform.simpleTransform(new Point(1,1)), null, null);
        engine.addEnabled(obj);
        engine.addEnabled(obj2);
        List<IGameObject> enabled = engine.getEnabled();
        assertEquals(2, enabled.size());
        assertTrue(enabled.contains(obj));
        assertTrue(enabled.contains(obj2));

    }

    @Test
    void getDisabled() {
        IGameObject obj = new GameObject("Obj", Transform.simpleTransform(new Point(0,0)), null, null);
        IGameObject obj2 = new GameObject("Obj2", Transform.simpleTransform(new Point(1,1)), null, null);

        engine.addDisabled(obj);
        engine.addDisabled(obj2);

        List<IGameObject> disabled = engine.getDisabled();
        assertEquals(2, disabled.size());
        assertTrue(disabled.contains(obj));
        assertTrue(disabled.contains(obj2));
    }

    @Test
    void testDestroy() {
        engine.add(player);
        assertFalse(engine.getLoadedObjects().isEmpty());
        engine.destroy(player);
        assertTrue(engine.getLoadedObjects().isEmpty());
    }

    @Test
    void destroyAll() {
        for (int i = 0; i < 100; i++)
            engine.add(player);
        assertFalse(engine.getLoadedObjects().isEmpty());
        engine.destroyAll();
        assertTrue(engine.getLoadedObjects().isEmpty());
    }

    @Test
    void run() {
        //TODO on a more advanced stage
    }

    @Test
    void checkCollisions() {
        GameObject obj1 = new GameObject("A", Transform.simpleTransform(new Point(0,0)), null, null);
        GameObject obj2 = new GameObject("B", Transform.simpleTransform(new Point(0,0)), null, null);
        engine.addEnabled(obj1);
        engine.addEnabled(obj2);
        engine.checkCollisions();
        //MUITO ABSTRATO MAS A IDEIA E ALGO DESTE GENERO
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
        engine.incrementScore(100);
        assertEquals(100, engine.getScore());

    }

    @Test
    void getLives() {
        engine.updateLives(5);
        assertEquals(5, engine.getLives());

    }

    @Test
    void resetScore() {
        engine.incrementScore(20);
        engine.resetScore();
        assertEquals(0, engine.getScore());

    }

    @Test
    void resetLives() {
        engine.updateLives(5);
        engine.resetLives();
        assertEquals(3, engine.getLives());

    }
}