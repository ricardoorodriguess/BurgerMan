package tests;

import collisions.Point;
import gameEngine.behaviour.CollectibleBehaviour;
import gameEngine.behaviour.EnemyBehavior;
import gameEngine.behaviour.PlayerBehaviour;
import gameEngine.object.Collectible;
import gameEngine.object.Player;
import gameEngine.object.Type;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollectibleBehaviourTests {
    Collectible c1 = new Collectible(Type.TOMATO, new Point(1, 1));
    CollectibleBehaviour cb = new CollectibleBehaviour(c1);

    @Test
    void testConstructor() {
        assertInstanceOf(CollectibleBehaviour.class, cb);
        assertNotNull(cb);
        assertEquals(c1, cb.gameObject());
    }

    @Test
    void onUpdate() {
    }

    @Test
    void onCollision() {
    }

    @Test
    void onInit() {
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
}