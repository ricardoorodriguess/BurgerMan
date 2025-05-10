package tests;

import gameEngine.behaviour.LivesBehaviour;
import gameEngine.object.Lives;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LivesBehaviourTests {
    Lives lives = new Lives();
    LivesBehaviour livesBehaviour = new LivesBehaviour(lives);

    @Test
    void testConstructor() {
        assertInstanceOf(LivesBehaviour.class, livesBehaviour);
        assertNotNull(livesBehaviour);
        assertEquals(lives, livesBehaviour.gameObject());
    }

    @Test
    void getLives() {
        livesBehaviour.onInit();
        assertEquals(3, livesBehaviour.getLives());
        livesBehaviour.decreaseLives();
        assertEquals(2, livesBehaviour.getLives());
        livesBehaviour.decreaseLives();
        assertEquals(1, livesBehaviour.getLives());
    }

    @Test
    void decreaseLives() {
        livesBehaviour.onInit();
        assertEquals(3, livesBehaviour.getLives());
        livesBehaviour.decreaseLives();
        assertEquals(2, livesBehaviour.getLives());
        livesBehaviour.decreaseLives();
        assertEquals(1, livesBehaviour.getLives());
        livesBehaviour.decreaseLives();
        assertEquals(0, livesBehaviour.getLives());
        assertThrows(IndexOutOfBoundsException.class, () -> livesBehaviour.decreaseLives());
    }

    @Test
    void onUpdate() {
    }

    @Test
    void onCollision() {
    }

    @Test
    void onInit() {
        livesBehaviour.onInit();
        assertEquals(3, livesBehaviour.getLives());
        livesBehaviour.decreaseLives();
        livesBehaviour.decreaseLives();
        assertEquals(1, livesBehaviour.getLives());
        livesBehaviour.onInit();
        assertEquals(3, livesBehaviour.getLives());
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