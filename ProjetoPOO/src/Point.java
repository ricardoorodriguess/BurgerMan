import java.awt.geom.Point2D;
import java.lang.Cloneable;
import java.io.Serializable;

public class Point extends Point2D
{
    private double x;
    private double y;

    @Override
    public double getX() {return this.x;}

    @Override
    public double getY() {return this.y;}

    @Override
    public void setLocation(double x, double y)
    {

    }
}
