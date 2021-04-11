package edu.sabana.poob.shapes;

public class ShapeException extends Exception{

    public static final String BAD_DIMENSION_SIDE = "The dimension of a shape should be greater than 0.";

    public ShapeException(String message) {
        super(message);
    }
}
