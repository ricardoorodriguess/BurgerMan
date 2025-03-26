public class Transform implements ITransform
{
    private Point centroid;
    private int layer;
    private double angle;
    private double scale;

    /**
     * CONSTRUTOR
     * @param centroid
     * @param layer
     * @param angle
     * @param scale
     */
    public Transform(Point centroid, int layer, double angle, double scale)
    {
        this.centroid = centroid;
        this.layer = layer;
        if (angle >= 0 || angle <= 360) this.angle = angle; //mudar patra rad caso se trabalhe em rad para evitar fazer conversoes
        this.scale = scale;
    }

    @Override
    public void move(Point dPos, int dlayer)
    {

    }

    @Override
    public void rotate(double dTheta)
    {

    }

    @Override
    public void scale(double dScale)
    {

    }

    @Override
    public Point position() { return centroid; }

    @Override
    public int layer() { return this.layer; }

    @Override
    public double angle() { return this.angle; }

    @Override
    public double scale() {return this.scale;}
}
