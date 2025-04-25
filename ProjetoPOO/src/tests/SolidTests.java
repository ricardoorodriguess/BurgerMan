package tests;

import collisions.Point;
import game.Solid;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolidTests {
    @Test
    void testConstructor() {
        Solid solid = new Solid(new Point(1, 1), 2.5, 3.5);
        assertEquals("Solid: <TRANSFORM: (1.00,1.00) 0 0.00 1.00> <COLLIDER: (1.00,1.00) (3.50,1.00) (3.50,4.50) (1.00,4.50)>", solid.toString());
        assertFalse(solid.isPlayer());
        assertFalse(solid.isEnemy());
        assertFalse(solid.isScoreboard());
        assertTrue(solid.isSolid());
    }
}