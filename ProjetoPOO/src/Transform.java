/**
 * ESCREVER
 * This class represent a simple circle
 * @author Ricardo Rodrigues
 * @author Rodrigo Linhas
 * @author Tiago Tome
 * @version March 26, 2025
 */
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

        //pensar aqui se o ângulo é dado em sentido anti-horaio ou nao, se for, temos que somar 360 ate nao seja menor que 0
        //e assim temos que mudar o if
        if (angle >= 0 || angle <= 360) this.angle = angle; //stored in degrees, because method angle of interface return angle in degrees
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
        this.angle = (this.angle + dTheta) % 360;
        if (this.angle < 0) this.angle += 360;
    }

    @Override
    public void scale(double dScale)
    {
        this.scale += dScale;
    }

    @Override
    public Point position() { return position; }

    @Override
    public int layer() { return this.layer; }

    @Override
    public double angle() { return this.angle; }

    @Override
    public double scale() {return this.scale;}

    @Override
    public String toString()
    {
        return this.position.toString() + " " + this.layer + " " + this.angle + " " + this.scale;
    }
}
