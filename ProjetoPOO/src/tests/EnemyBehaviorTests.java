package tests;

import collisions.Point;
import gameEngine.behaviour.EnemyBehavior;
import gameEngine.behaviour.PlayerBehaviour;
import gameEngine.object.Enemy;
import gameEngine.object.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyBehaviorTests {
    Enemy e1 = new Enemy(new Point(1, 1));
    EnemyBehavior eb = new EnemyBehavior(e1);

    @Test
    void testConstructor() {
        assertInstanceOf(EnemyBehavior.class, eb);
        assertNotNull(eb);
        assertEquals(e1, eb.gameObject());
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