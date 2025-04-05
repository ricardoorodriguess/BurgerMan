import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GameEngine engine = new GameEngine();
        ArrayList<Double> velocities = new ArrayList<>();

        int f = Integer.parseInt(sc.nextLine());
        int n = Integer.parseInt(sc.nextLine());
        sc.nextLine(); //consume newline

        for (int i = 0; i < n; i++)
        {
            String name = sc.nextLine();
            ITransform transform = new Transform(new Point(sc.nextDouble(), sc.nextDouble()),
                    sc.nextInt(), sc.nextDouble(), sc.nextDouble());
            sc.nextLine();

            String colliderLine = sc.nextLine();
            String[] colliderParts = colliderLine.split(" ");
            ArrayList<Double> values = new ArrayList<Double>();

            for (String value : colliderParts)
            {
                values.add(Double.parseDouble(value));
            }

            ICollider collider;
            if (values.size() == 3)
            {
                collider = new Circle(new Point(values.get(0), values.get(1)), values.get(2));
            }
            else if (values.size() >= 6 && values.size() % 2 == 0)
            {
                ArrayList<Point> points = new ArrayList<>();
                for (int j = 0; j < values.size(); j += 2)
                {
                    points.add(new Point(values.get(j), values.get(j + 1)));
                }
                collider = new Polygon(points);
            }
            else
            {
                throw new IllegalArgumentException("INVALID COLLIDER ARGUMENTS\n");
            }

            String velocity = sc.nextLine();
            String[] velocityParts = velocity.split(" ");
            double dx = Double.parseDouble(velocityParts[0]);
            double dy = Double.parseDouble(velocityParts[1]);
            int dLayer = Integer.parseInt(velocityParts[2]);
            double dAngle = Double.parseDouble(velocityParts[3]);
            double dScale = Double.parseDouble(velocityParts[4]);
            velocities.add(dx);
            velocities.add(dy);
            velocities.add((double)dLayer);
            velocities.add(dAngle);
            velocities.add(dScale);

            GameObject gameObject = new GameObject(name, transform, collider);
            Point delta = new Point(transform.position().getX() - collider.centroid().getX(),
                    transform.position().getY() - collider.centroid().getY());
            collider.move(delta);
            collider.rotate(transform.angle());
            collider.scale(transform.scale());

            engine.add(gameObject);
        }

        ArrayList<GameObject> gameObjects =  engine.getLoadedObjects();
    }
}