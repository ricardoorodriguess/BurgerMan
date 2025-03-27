public class Line {
    protected Point a, b;

    public Line(Point a, Point b)
    {
        if (a.equals(b)) throw new IllegalArgumentException();
        this.a = a;
        this.b = b;
    }

    public Line(Point a, Line l)
    {
        this(a, l.closest(a, false));
    }

    public Point getA()
    {
        return a;
    }

    public Point getB()
    {
        return b;
    }

    public boolean contains(Point point) {
        return (point.getX() - a.getX()) * (b.getY() - a.getY()) == (point.getY() - a.getY()) * (b.getX() - a.getX());
    }

    protected double closestRatio(Point point, boolean interior)
    {
        double dx = b.getX() - a.getX(), dy = b.getY() - a.getY();
        return (dx * (point.getX() - a.getX()) + dy * (point.getY() - a.getY())) / (dx * dx + dy * dy);
    }

    public Point closest(Point point)
    {
        return closest(point, true);
    }

    public Point closest(Point point, boolean interior)
    {
        double dx = b.getX() - a.getX(), dy = b.getY() - a.getY(), k = closestRatio(point, interior);
        return new Point(a.getX() + k * dx, b.getY() + k * dy);
    }

    public boolean intersects(Circle circle)
    {
        return closest(circle.centroid()).dist(circle.centroid()) <= circle.getRadius();
    }

    public boolean intersects(Polygon polygon)
    {
        for (LineSegment segment : polygon.getSegments()) if (intersects(segment)) return true;
        return false;
    }

    public boolean intersects(LineSegment segment)
    {
        double dx = b.getX() - a.getX(), dy = b.getY() - a.getY();
        double dz = b.getX() * a.getY() - b.getY() * a.getX();
        Point a = segment.getA(), b = segment.getB();
        return (dx * a.getY() - dy * a.getX() - dz) * (dx * b.getY() - dy * b.getX() - dz) <= 0;
    }
}
