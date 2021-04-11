package edu.sabana.poob.shapes;

public class RectangleSolid extends Rectangle implements GeometricShape3D {

    protected double depth = 1;

    public RectangleSolid(){}

    public RectangleSolid(String color)
    {
        super(color);
    }

    public RectangleSolid(double width, double length, double depth) throws ShapeException
    {
        super(width, length);
        if(depth <= 0)
        {
            throw new ShapeException(ShapeException.BAD_DIMENSION_SIDE);
        }
        this.depth = depth;
    }
    public RectangleSolid(String color, double width, double length, double depth) throws ShapeException
    {
        super(color, width, length);
        if(depth <= 0)
        {
            throw new ShapeException(ShapeException.BAD_DIMENSION_SIDE);
        }
        this.depth = depth;
    }
    /**
     * Calcula el volumen de un rectangulo solido de un ancho , largo y profundidad definidos
     * @return double = Volumen de la rectangulo solido
     */
    @Override
    public double getVolume() {
        return width*length*depth;
    }
    /**
     * Calcula el Area Superficial de un rectangulo solido de un ancho , largo y profundidad definidos
     * @return double = Area Superficial de la rectangulo solido
     */
    @Override
    public double getSuperficialArea() {
        return 2*(width*length + length*depth + width*depth);
    }
}
