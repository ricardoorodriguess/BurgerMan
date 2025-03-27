public class LineSegment extends Line {
    public LineSegment(Point a, Point b) {
        super(a, b);
    }

    public double length() {
        return a.dist(b);
    }

    @Override
    protected double closestRatio(Point point, boolean interior) {
        double k = super.closestRatio(point, interior);
        if (!interior) return k;
        if (k > 1) return 1;
        if (k < 0) return 0;
        return k;
    }

    @Override
    public boolean intersects(LineSegment segment) {
        if (!super.intersects(segment)) return false;
        double dx1 = b.getX() - a.getX(), dy1 = b.getY() - a.getY(),
                dx2 = segment.b.getX() - segment.a.getX(), dy2 = segment.b.getY() - segment.a.getY(),
                dx3 = segment.a.getX() - a.getX(), dy3 = segment.a.getY() - a.getY();
        if (dx1 * dy2 == dy1 * dx2) return false;
        double k2 = (dy1 * dx3 - dx1 * dy3) / (dx1 * dy2 - dy1 * dx2);
        if (k2 < 0 || k2 > 1) return false;
        double k1 = dx1 == 0 ? (dy3 + k2 * dy2) / dy1 : (dx3 + k2 * dx2) / dx1;
        return 0 <= k1 && k1 <= 1;
    }
}
