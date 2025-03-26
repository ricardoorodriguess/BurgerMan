public class Transform implements ITransform
{
    private Point position;
    private int layer;
    private double angle;
    private double scale;

    /**
     * CONSTRUTOR
     * @param position
     * @param layer
     * @param angle
     * @param scale
     */
    public Transform(Point position, int layer, double angle, double scale)
    {
        this.position = position;
        this.layer = layer;
        if (angle >= 0 || angle <= 360) this.angle = angle; //mudar para rad caso se trabalhe em rad para evitar fazer conversoes
        this.scale = scale;
    }

    @Override
    public void move(Point dPos, int dlayer)
    {
        this.position.move(dPos); //mover ponto consoante dPos
        this.layer += dlayer; //aplicar o dlayer a layer
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
    public Point position() { return position; }

    @Override
    public int layer() { return this.layer; }

    @Override
    public double angle() { return this.angle; }

    @Override
    public double scale() {return this.scale;}
}
