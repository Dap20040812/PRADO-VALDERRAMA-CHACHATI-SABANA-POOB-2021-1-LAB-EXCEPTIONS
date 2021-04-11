package edu.sabana.poob.shapes;

public class Cube extends RectangleSolid {

    public Cube(){}

    public Cube(String color)
    {
        super(color);
    }

    public Cube(double side) throws ShapeException
    {
        if(side <= 0)
        {
            throw new ShapeException(ShapeException.BAD_DIMENSION_SIDE);
        }
        this.length = side;
        this.width = side;
        this.depth = side;
    }
    public Cube(String color, double side) throws ShapeException
    {
        super(color);
        if(side <= 0)
        {
            throw new ShapeException(ShapeException.BAD_DIMENSION_SIDE);
        }
        this.length = side;
        this.width = side;
        this.depth = side;
    }

}
