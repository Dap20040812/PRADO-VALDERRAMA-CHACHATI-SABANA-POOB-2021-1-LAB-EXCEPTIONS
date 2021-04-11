package edu.sabana.poob.shapes;

public class Triangle extends Shape implements GeometricShape2D {

    private double side1 = 1;
    private double side2 = 1;
    private double side3 = 1;
    public Triangle(){}
    public Triangle(String color)
    {
        super(color);
    }
    public Triangle(double side1, double side2, double side3) throws ShapeException
    {
        if(side1+side2 < side3 && side1-side2 > side3) {

            throw new ShapeException(ShapeException.BAD_DIMENSION_SIDE);
        }
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;

    }
    public Triangle(String color, double side1, double side2, double side3) throws ShapeException
    {
        super(color);
        if(side1+side2 < side3 && side1-side2 > side3) {

            throw new ShapeException(ShapeException.BAD_DIMENSION_SIDE);
        }
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;

    }

    /**
     * Verifica que un triangulo se isosceles
     * @return True si el triangulo es isosceles False si no es isosceles
     */
    public boolean isIsoceles()
    {
        boolean is = false;
        if((side1 == side2 && side2 != side3) || (side1 == side3 && side3 != side2) || (side2 == side3 && side3 != side1))
        {
            is = true;
        }
        return is;
    }
    /**
     * Verifica que un triangulo se equilatero
     * @return True si el triangulo es equilatero False si no es equilatero
     */
    public boolean isEquilatera()
    {
        boolean is = false;
        if(side1 == side2 && side2 == side3)
        {
            is = true;
        }
        return is;
    }
    /**
     * Calcula el area de un triangulo de lados definidos
     * @return double A = Area del circulo si el triangulo existe, si los lados del triangulo forman un triangulo que no existe devuelve 0.
     */
    @Override
    public double getArea() {
        double p = getPerimeter()/2;
        double a= 0;
        a = Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
        return a;

    }
    /**
     * Calcula el perimetro de un triangulo de lados definidos
     * @return double P = Perimetro del circulo si el triangulo existe, si los lados del triangulo forman un triangulo que no existe devuelve 0.
     */
    @Override
    public double getPerimeter() {

        double b =0;
        if(side1+side2> side3 && side1-side2<side3 )
        {
            b = side1+side2+side3;
        }
        return b;
    }
    /**
     * Sobreescribe el metodo toString de la clase Shape agregando el tipo de triangulo
     *
     * @return Si el triangulo existe devuelve las caracteristicas ,
     * si el triangulo no existe regresa que el triangulo con la dimenciones dadas no existe
     *
     */
    @Override
    public String toString() {
        if(side1+side2> side3 && side1-side2<side3 )
        {
            return (super.toString() + (isEquilatera() ? " and is an equilateral triangle" : isIsoceles() ? " and is an isosceles triangle" : " and is an scalene triangle" ));

        }
        else
        {
            return "The triangle with the dimensions " +side1+" "+side2+" "+side3+" doesn't exist";

        }
    }

}
