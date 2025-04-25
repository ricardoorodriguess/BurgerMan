package tests;
import collisions.Point;
import game.Player;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PlayerTests {
    @Test
    void constructorTest() {
        Player player = new Player(new Point(1, 1));
        assertNotNull(player);
        assertInstanceOf(Player.class, player);
        assertEquals("(1.00,1.00) 0 0.00 1.00", player.transform().toString());
        assertNotNull(player.collider());
        assertEquals("(1.00,1.00) 1.00", player.collider().toString());
        assertTrue(player.isPlayer());
        assertFalse(player.isEnemy());
        assertFalse(player.isSolid());
        assertFalse(player.isScoreboard());
        assertEquals("Player vx=0.0, vy=0.0", player.toString()); //testa logo o toString do player
    }

    @Test
    void changeSpeed() {
        Player player = new Player(new Point(1, 1));
        player.changeSpeed(2,2);
        assertEquals(2, player.getVx());
        assertEquals(2, player.getVy());
    }

    @Test
    void getVx(){
        Player player = new Player(new Point(1, 1));
        assertEquals(0, player.getVx());
        player.changeSpeed(10,10);
        assertEquals(10, player.getVx());
    }

    @Test
    void getVy() {
        Player player = new Player(new Point(1, 1));
        assertEquals(0, player.getVy());
        player.changeSpeed(10,20);
        assertEquals(20, player.getVy());
    }
}