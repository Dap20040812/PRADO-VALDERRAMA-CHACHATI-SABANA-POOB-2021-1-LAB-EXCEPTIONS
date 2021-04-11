package edu.sabana.poob.shapes;

import java.text.DecimalFormat;

public class Rectangle extends Shape implements GeometricShape2D {

    protected double width = 1;
    protected double length = 1;

    public Rectangle(){}

    public Rectangle(String color)
    {
        super(color);
    }
    public Rectangle(double width, double length) throws ShapeException
    {
        if(length <= 0 && width <= 0)
        {
            throw new ShapeException(ShapeException.BAD_DIMENSION_SIDE);
        }
        this.length = length;
        this.width = width;
    }
    public Rectangle(String color, double width, double length) throws ShapeException
    {
        super(color);
        if(length <= 0 && width <= 0)
        {
            throw new ShapeException(ShapeException.BAD_DIMENSION_SIDE);
        }
        this.length = length;
        this.width = width;
    }

    /**
     * Calcula la diagonal de un rectangulo o cuadrado, dado de su ancho y largo definidos
     * @return double La diagonas de un rectangulo o cuadrado
     */
    public double getDiagonal()
    {
        if(this.length < 0)
        {
            this.length=this.length*-1;
        }
        if(this.width < 0)
        {
            this.width=this.width*-1;
        }
        return Math.sqrt(Math.pow(this.width,2)+Math.pow(this.length,2));
    }

    /**
     * Calcula el area de un rectangulo o cuadrado, dado de su ancho y largo definidos
     * @return double El area de un rectangulo o cuadrado
     */
    @Override
    public double getArea() {
        double A;
        if(this.length < 0)
        {
            this.length=this.length*-1;
        }
        if(this.width < 0)
        {
            this.width=this.width*-1;
        }
        A = this.width*this.length;
        return A;
    }

    /**
     * Calcula el perimetro de un rectangulo o cuadrado, dado de su ancho y largo definidos
     * @return double El Perimetro de un rectangulo o cuadrado
     */
    @Override
    public double getPerimeter() {

        double P;
        if(this.length < 0)
        {
            this.length=this.length*-1;
        }
        if(this.width < 0)
        {
            this.width=this.width*-1;
        }
        P = 2*width + 2*length;
        return P;
    }

    /**
     * Sobreescribe el metodo toString de la clase Shape agregando la diagonal de un triangulo o cuadrado
     * @return  Las caracteristicas del rectangulo o cuadrado.
     *
     */
    @Override
    public String toString() {

        DecimalFormat f = new DecimalFormat("#.00");
        if((int)getDiagonal()== getDiagonal())
        {
            return (super.toString()+" and diagonal "+ (int)getDiagonal());
        }
        else
        {
            return (super.toString()+" and diagonal "+ f.format(getDiagonal()));
        }
    }






}
