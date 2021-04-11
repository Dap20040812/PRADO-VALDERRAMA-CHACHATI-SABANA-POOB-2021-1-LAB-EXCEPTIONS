package edu.sabana.poob.shapes;

public class Pyramid extends Triangle implements GeometricShape3D {

    private double height = 1;
    public Pyramid(){}
    public Pyramid(String color)
    {
        super(color);
    }
    public Pyramid(double side1, double side2, double side3, double height) throws ShapeException
    {
        super(side1, side2, side3);
        if(height <= 0)
        {
            throw new ShapeException(ShapeException.BAD_DIMENSION_SIDE);
        }
        this.height = height;
    }
    public Pyramid(String color, double side1, double side2, double side3, double height) throws ShapeException
    {
        super(color,side1, side2, side3);
        if(height <= 0)
        {
            throw new ShapeException(ShapeException.BAD_DIMENSION_SIDE);
        }
        this.height = height;
    }
    /**
     * Calcula el volumen de una piramide tetraedro de un triagulo base y una altura definida
     * @return double = Volumen de la piramide
     */
    @Override
    public double getVolume() {
        return (getArea()*height)/3;
    }
    /**
     * Calcula el Area Superficial de una piramide tetraedro de un triagulo base y una altura definida
     * @return double = Area Superficial de la piramide
     */
    @Override
    public double getSuperficialArea() {
        return (getPerimeter()*height)/2;
    }
}
