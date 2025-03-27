// TODO REVIEW

import java.util.ArrayList;
import java.util.List;

/**
 * This class represent a polygon witch contains 3 or more points
 * @author Ricardo Rodrigues
 * @author Rodrigo Linhas
 * @author Tiago Tome
 * @version March 27, 2025
 */

public class Polygon extends Collider{

    private ArrayList<Point> points;
    private ArrayList<LineSegment> segments;

    //TODO REVIEW
    /**
     * Construtor of the class
     * @param points
     */
    public Polygon(ArrayList<Point> points) {
        this.points = new ArrayList<>(points);
        this.segments = new ArrayList<>();
        // Criar segmentos conectando os pontos
        for (int i = 0; i < points.size(); i++) {
            Point current = points.get(i);
            Point next = points.get((i + 1) % points.size());
            segments.add(new LineSegment(current, next));
        }
        check(this.points);
    }

    //TODO REVIEW
    /**
     * Checker to determine if the given polygon is valid
     * @param points (should be 3 or more and not collinear)
     *
     */
    private static void check(ArrayList<Point> points) {
        if (points.size() < 3)          throw new IllegalArgumentException("Poligono:vi\n");
        //verificar se são colineares
        Point a = points.get(0);
        Point b = points.get(1);
        Point c = points.get(2);
        double area = (a.getX() * (b.getY() - c.getY())
                + b.getX() * (c.getY() - a.getY())
                + c.getX() * (a.getY() - b.getY()));
        if (area == 0) throw new IllegalArgumentException("Poligono:vi\n");
        // Verificar se todos os pontos estão na mesma linha
        double dx = b.getX() - a.getX();
        double dy = b.getY() - a.getY();
        for (Point p : points) {
            if ((p.getX() - a.getX()) * dy == (p.getY() - a.getY()) * dx)
                throw new IllegalArgumentException("Poligono:vi\n");;
        }
    }

    /**
     * Getter points
     * @return points
     *
     */
    public ArrayList<Point> getPoints() {
        return points;
    }

    /**
     * Getter segments
     * @return segments
     *
     */
    public ArrayList<LineSegment> getSegments() {
        return segments;
    }

    /**
     * Method to check contains a certain point
     * @param point
     * @return true if contains
     *         false otherwise
     */
    public boolean contains(Point point) {
        Line line;
        for (LineSegment seg : segments) {
            line = new Line(point, seg);
            boolean b = false;
            for (LineSegment other : segments) if (line.intersects(other)) {
                b = true;
                break;
            }
            if (!b) return false;
        }
        return true;
    }

    //TODO REVIEW (ALGORITMO GERADO PELO DEEPSEEK E NÃO ESTOU MESMO A PERCEBER O COLLIDES)
    /**
     * Simple method to check if collide with another collider
     * @return boolean depending on the situation
     *         true if it happens
     *         false otherwise
     */
    @Override
    boolean collides(Collider collider) {
        if (collider instanceof Circle) return collider.collides(this);
        if (collider instanceof Polygon p)
            for (Point po : points)
                if (p.contains(po)) return true;
        return false;
    }

    //TODO REVIEW
    /**
     * Method to move a certain point
     * @param point
     */
    @Override
    public void move(Point point) {
        for (Point p : points)  p.move(point);
    }

    //TODO REVIEW
    /**
     * Method to calculate the centroid
     * @return centroid point
     */
    @Override
    public Point centroid() {
        double area = 0, cx = 0, cy = 0;
        int n = points.size();
        for (int i = 0; i < n; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % n);
            double cross = p1.getX() * p2.getY() - p2.getX() * p1.getY();
            area += cross;
            cx += (p1.getX() + p2.getX()) * cross;
            cy += (p1.getY() + p2.getY()) * cross;
        }
        area /= 2;
        cx /= (6 * area);
        cy /= (6 * area);
        return new Point(cx, cy);
    }

    //TODO REVIEW
    /**
     * Method to rotate a certain angle
     * @param angle
     */
    @Override
    public void rotate(double angle) {
        Point centroid = centroid();
        double cx = centroid.getX();
        double cy = centroid.getY();
        double radians = Math.toRadians(angle);
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);

        for (Point p : points) {
            double xOffset = p.getX() - cx;
            double yOffset = p.getY() - cy;
            double newX = cx + (xOffset * cos - yOffset * sin);
            double newY = cy + (xOffset * sin + yOffset * cos);
            p.move(new Point(newX - p.getX(), newY - p.getY()));
        }
    }

    //TODO REVIEW
    /**
     * Method to scale the polygon
     * @param scale
     */
    @Override
    public void scale(double scale) {
        Point centroid = centroid();
        double cx = centroid.getX();
        double cy = centroid.getY();

        for (Point p : points) {
            double newX = cx + (p.getX() - cx) * scale;
            double newY = cy + (p.getY() - cy) * scale;
            p.move(new Point(newX - p.getX(), newY - p.getY()));
        }
    }

    //TODO REVIEW
    /**
     * Method to scale the polygon
     * @return string
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Point p : points) {
            sb.append(p.toString()).append(" ");
        }
        return sb.toString().trim();
    }
}