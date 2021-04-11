package edu.sabana.poob.shapes;

public class Cylinder extends Circle implements GeometricShape3D {

    private double height;

    public Cylinder() {
        super();
        this.height = 1;
    }

    public Cylinder(double radius, double height) throws ShapeException {
        super(radius);
        if(height <= 0)
        {
            throw new ShapeException(ShapeException.BAD_DIMENSION_SIDE);
        }
        this.height = height;
    }

    public Cylinder(String color, double radius, double height) throws  ShapeException{
        super(color, radius);
        if(height <= 0)
        {
            throw new ShapeException(ShapeException.BAD_DIMENSION_SIDE);
        }
        this.height = height;
    }
    /**
     * Calcula el volumen de un cilindro de un radio definido y una alturo
     * @return double = Volumen del cilindro si el cilindro existe, si no retorna 0
     */
    @Override
    public double getVolume() {

        if(radius > 0 && height > 0)
        {
            return getArea()*this.height;

        }
        return 0;
    }
    /**
     * Calcula el Area Superficial de un cilindro de un radio definido y una alturo
     * @return double = Area Superficial del cilindro si el cilindro existe, si no retorna 0
     */
    @Override
    public double getSuperficialArea() {

        if(radius > 0 && height > 0) {
            return 2 * getArea() + 2 * PI * this.radius * this.height;
        }

        return 0;
    }
}
