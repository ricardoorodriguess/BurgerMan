import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class PolygonTest {

    // Helper method to create a sample polygon (triangle)
    private Polygon createSamplePolygon() {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(0, 0));
        points.add(new Point(4, 0));
        points.add(new Point(2, 3));
        return new Polygon(points);
    }

    @Test
    void constructor_ThrowsIllegalArgumentException_ForInvalidPoints() {
        // Less than 3 points
        ArrayList<Point> invalidPoints1 = new ArrayList<>();
        invalidPoints1.add(new Point(0, 0));
        invalidPoints1.add(new Point(1, 1));
        assertThrows(IllegalArgumentException.class, () -> new Polygon(invalidPoints1));

        // Collinear points
        ArrayList<Point> collinearPoints = new ArrayList<>();
        collinearPoints.add(new Point(0, 0));
        collinearPoints.add(new Point(1, 1));
        collinearPoints.add(new Point(2, 2));
        assertThrows(IllegalArgumentException.class, () -> new Polygon(collinearPoints));
    }

    @Test
    void getPoints_ReturnsCorrectPoints() {
        Polygon polygon = createSamplePolygon();
        ArrayList<Point> expected = new ArrayList<>();
        expected.add(new Point(0, 0));
        expected.add(new Point(4, 0));
        expected.add(new Point(2, 3));

        assertEquals(expected.size(), polygon.getPoints().size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).getX(), polygon.getPoints().get(i).getX(), 1e-9);
            assertEquals(expected.get(i).getY(), polygon.getPoints().get(i).getY(), 1e-9);
        }
    }

    @Test
    void getSegments_CreatesCorrectSegments() {
        Polygon polygon = createSamplePolygon();
        ArrayList<LineSegment> segments = polygon.getSegments();

        assertEquals(3, segments.size());
        // Verify first segment
        assertEquals(0.0, segments.get(0).getA().getX(), 1e-9);
        assertEquals(4.0, segments.get(0).getB().getX(), 1e-9);
    }

    @Test
    void contains_DetectsPointCorrectly() {
        Polygon polygon = createSamplePolygon();

        // Point inside
        assertTrue(polygon.contains(new Point(2, 1)));

        // Point outside
        assertFalse(polygon.contains(new Point(5, 5)));
    }

    @Test
    void collides_DetectsCollisionsCorrectly() {
        Polygon polygon = createSamplePolygon();
        Circle circleInside = new Circle(new Point(2, 1), 0.5);
        Circle circleOutside = new Circle(new Point(10, 10), 1);

        // Circle collision
        assertTrue(polygon.collides(circleInside));
        assertFalse(polygon.collides(circleOutside));

        // Polygon collision
        ArrayList<Point> otherPoints = new ArrayList<>();
        otherPoints.add(new Point(3, 1));
        otherPoints.add(new Point(5, 1));
        otherPoints.add(new Point(4, 2));
        Polygon overlappingPolygon = new Polygon(otherPoints);

        assertTrue(polygon.collides(overlappingPolygon));
    }

    @Test
    void move_TranslatesAllPoints() {
        Polygon polygon = createSamplePolygon();
        Point delta = new Point(2, 3);

        polygon.move(delta);

        assertEquals(2.0, polygon.getPoints().getFirst().getX(), 1e-9);
        assertEquals(3.0, polygon.getPoints().getFirst().getY(), 1e-9);
    }

    @Test
    void centroid_CalculatesCorrectCenter() {
        Polygon polygon = createSamplePolygon();
        Point centroid = polygon.centroid();

        // Expected centroid for sample triangle
        assertEquals(2.0, centroid.getX(), 1e-9);
        assertEquals(1.0, centroid.getY(), 1e-9);
    }

    @Test
    void rotate_RotatesPointsCorrectly() {
        Polygon polygon = createSamplePolygon();
        polygon.rotate(90); // Rotate 90 degrees counter-clockwise
        // Check if points were rotated around centroid
        Point p0 = polygon.getPoints().getFirst();
        assertEquals(3.0, p0.getX(), 0.1); // Approximate due to floating point
        assertEquals(-1.0, p0.getY(), 0.1);
    }

    @Test
    void scale_ScalesPointsCorrectly() {
        Polygon polygon = createSamplePolygon();
        Point centroid = new Point(polygon.centroid().getX(), polygon.centroid().getY());

        polygon.scale(2); // Double size

        Point p0 = polygon.getPoints().getFirst();
        assertEquals(-2.0, p0.getX(), 1e-9); // (0-2)*2 + 2 = -2
        assertEquals(-1.0, p0.getY(), 1e-9); // (0-1)*2 + 1 = -1

        assertEquals(centroid.getX(), polygon.centroid().getX());
        assertEquals(centroid.getY(), polygon.centroid().getY());
    }

    @Test
    void toString_FormatsCorrectly() {
        Polygon polygon = createSamplePolygon();
        String expected = "(0.00,0.00) (4.00,0.00) (2.00,3.00)";
        assertEquals(expected, polygon.toString());
    }
}