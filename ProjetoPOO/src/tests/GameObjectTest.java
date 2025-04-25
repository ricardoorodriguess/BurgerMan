package tests;

import collisions.Circle;
import collisions.Colisor;
import collisions.Point;
import collisions.Polygon;
import game.GameObject;
import game.Transform;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class GameObjectTest {
    static Transform transform = new Transform(new Point(1, 2), 1, 0, 1);
    static Colisor circle = new Circle(new Point(2, 3), 3);
    static GameObject gameObject = new GameObject("gameObject1", transform, circle);

    @Test
    void name()
    {
        Assertions.assertEquals("gameObject1", gameObject.name());
    }

    @Test
    void transform()
    {
        Assertions.assertEquals(transform, gameObject.transform());
    }

    @Test
    void collider()
    {
        Assertions.assertEquals(circle, gameObject.collider());

        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(-1, 0));
        points.add(new Point(5, 0));
        points.add(new Point(2, 4));
        Colisor polygon = new Polygon(points);
        GameObject gameObject2 = new GameObject("gameObject2", transform, polygon);
        Assertions.assertEquals(polygon, gameObject2.collider());
    }

    @Test
    void isPlayer(){
        Assertions.assertFalse(gameObject.isPlayer());
        GameObject gameObjectToTestIsMethods = new GameObject("gameObjectToTestIsMethods", transform, circle, true, false, false, false);
        Assertions.assertTrue(gameObjectToTestIsMethods.isPlayer());
    }

    @Test
    void isEnemy(){
        Assertions.assertFalse(gameObject.isEnemy());
        GameObject gameObjectToTestIsMethods = new GameObject("gameObjectToTestIsMethods", transform, circle, false, true, false, false);
        Assertions.assertTrue(gameObjectToTestIsMethods.isEnemy());
    }

    @Test
    void isSolid(){
        Assertions.assertFalse(gameObject.isSolid());
        GameObject gameObjectToTestIsMethods = new GameObject("gameObjectToTestIsMethods", transform, circle, false, false, true, false);
        Assertions.assertTrue(gameObjectToTestIsMethods.isSolid());
    }

    @Test
    void isScoreboard(){
        Assertions.assertFalse(gameObject.isScoreboard());
        GameObject gameObjectToTestIsMethods = new GameObject("gameObjectToTestIsMethods", transform, circle, false, false, false, true);
        Assertions.assertTrue(gameObjectToTestIsMethods.isScoreboard());
    }
}