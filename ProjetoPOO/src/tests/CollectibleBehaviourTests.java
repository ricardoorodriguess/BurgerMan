package tests;

import collisions.Point;
import gameEngine.behaviour.CollectibleBehaviour;
import gameEngine.object.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CollectibleBehaviourTests {
    Collectible c1 = new Collectible(Type.TOMATO, new Point(1, 1));
    CollectibleBehaviour cb = new CollectibleBehaviour(c1);

    Collectible c2 = new Collectible(Type.PICKLE, new Point(1, 1));
    CollectibleBehaviour cb1 = new CollectibleBehaviour(c2);

    @Test
    void testConstructor() {
        assertInstanceOf(CollectibleBehaviour.class, cb);
        assertNotNull(cb);
        assertEquals(c1, cb.gameObject());


        assertInstanceOf(CollectibleBehaviour.class, cb1);
        assertNotNull(cb1);
        assertEquals(c2, cb1.gameObject());
    }

    @Test
    void onUpdate() {
        cb.onUpdate(0.1,null);
        assertEquals(Type.TOMATO, c1.getType());
        cb1.onUpdate(0.1,null);
        assertEquals(Type.PICKLE, c2.getType());
    }

    @Test
    void onCollision() {
        List<IGameObject> gameObjects = new java.util.ArrayList<>(List.of());
        Player player = new Player(new Point(1,1));
        Enemy enemy = new Enemy(new Point(2,2));
        gameObjects.add(player);
        gameObjects.add(enemy);
        cb.onCollision(gameObjects);
        assertTrue(cb.isCollected());

        //agr pickle e enemy
        cb1.onCollision(gameObjects);
        assertTrue(cb1.isCollected());
    }

    @Test
    void onInit() {
        cb.onInit();
        assertFalse(cb.isInitialized());
        assertFalse(cb.isCollected());
        assertSame(Type.TOMATO, c1.getType());


        cb1.onInit();
        assertFalse(cb1.isInitialized());
        assertFalse(cb1.isCollected());
        assertSame(Type.PICKLE, c2.getType());
    }

    @Test
    void onEnabled() {
    }

    @Test
    void onDisabled() {
    }

    @Test
    void onDestroy() {
        cb.onDestroy();
        assertFalse(cb.isInitialized());
        cb1.onDestroy();
        assertFalse(cb1.isInitialized());
    }
}