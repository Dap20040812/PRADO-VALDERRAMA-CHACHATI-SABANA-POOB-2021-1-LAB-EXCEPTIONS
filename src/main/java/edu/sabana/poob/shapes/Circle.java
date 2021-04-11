package edu.sabana.poob.shapes;
/**
 * Represents a Circle. <br><br>
 * Invariants:
 * 1. PI = 3.14.....
 * 2. radius > 0 <br><br>
 *
 */

public class Circle extends Shape implements GeometricShape2D {

    protected double radius;

    public Circle() {
        this.radius = 1.0;
    }

    public Circle(double radius) throws ShapeException{

        if(radius <= 0)
        {
            throw new ShapeException(ShapeException.BAD_DIMENSION_SIDE);
        }
        this.radius = radius;


    }

    public Circle(String color, double radius) throws ShapeException {

        super(color);
        if(radius <= 0)
        {
            throw new ShapeException(ShapeException.BAD_DIMENSION_SIDE);
        }
        this.radius = radius;

    }
    /**
     * Calcula el area de un ciruclo de un radio definido por radius
     * @return double A = Area del circulo
     */
    @Override
    public double getArea() {

        return PI*Math.pow(this.radius,2);
    }
    /**
     * Calcula el perimetro de un ciruclo de un radio definido por radius
     * @return double P = perimetro del circulo
     */
    @Override
    public double getPerimeter() {
        return 2*PI*this.radius;
    }
    /**
     * Calcula el diametro de un ciruclo de un radio definido por radius
     * @return double diametro del circulo
     */
    public double getDiameter() { return 2*this.radius; }
    /**
     * Sobreescribe el metodo toString de la clase Shape agregando el radio del circulo
     *
     * @return Si el radio existe devuelve las caracteristicas del circulo,
     * si el radio no existe regresa que el circulo del radio dado no existe
     *
     */
    @Override
    public String toString() {

        if(this.radius == (int)this.radius)
        {
            return super.toString() +" and radius "+(int)this.radius;
        }
        else
        {
            return super.toString() +" and radius "+this.radius;
        }
    }
}

