package edu.sabana.poob.shapes;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectangleTest {

    private static Rectangle c1;
    private static Rectangle c2;
    private static Rectangle c3;
    private static Rectangle c4;
    private static Rectangle c5;
    private static Rectangle c10;



    @BeforeAll
    public static void setUp() throws Exception{
        c1 = new Rectangle(20,40);
        c2 = new Rectangle(30,45.67);
        c3 = new Rectangle("red");
        c4 = new Rectangle("red",40,56.7);
        c5 = new Rectangle();
        c10= new Rectangle(-20,40);
    }

    @Test
    public void shouldCalculateArea() {
        assertEquals(800, (int) c1.getArea());
        assertEquals(1370, (int) c2.getArea());
        assertEquals(1, (int) c3.getArea());
        assertEquals(2268, (int) c4.getArea());
        assertEquals(1, (int) c5.getArea());
        assertEquals(800, (int) c10.getArea());

    }

    @Test
    public void shouldCalculatePerimeter() {

        assertEquals(120, (int) c1.getPerimeter());
        assertEquals(151, (int) c2.getPerimeter());
        assertEquals(4, (int) c3.getPerimeter());
        assertEquals(193, (int) c4.getPerimeter());
        assertEquals(4, (int) c5.getPerimeter());
        assertEquals(120, (int) c10.getPerimeter());


    }

    @Test
    public void shouldCalculateDiagonal() {

        assertEquals(44, (int) c1.getDiagonal());
        assertEquals(54, (int) c2.getDiagonal());
        assertEquals(1, (int) c3.getDiagonal());
        assertEquals(69, (int) c4.getDiagonal());
        assertEquals(1, (int) c5.getDiagonal());
        assertEquals(44, (int) c10.getDiagonal());


    }

    @Test
     public void shouldPrintCircle() {

        assertEquals("This is a Rectangle with color NONE and diagonal 44,72", c1.toString());
        assertEquals("This is a Rectangle with color NONE and diagonal 54,64", c2.toString());
        assertEquals("This is a Rectangle with color red and diagonal 1,41", c3.toString());
        assertEquals("This is a Rectangle with color red and diagonal 69,39", c4.toString());
        assertEquals("This is a Rectangle with color NONE and diagonal 1,41", c5.toString());

    }
    @Test
    public void shouldNorCreateRectangleWithDimensionsNegative() {

        try {
            new Rectangle(-1,-1);
        } catch (ShapeException e) {
            assertEquals(ShapeException.BAD_DIMENSION_SIDE, e.getMessage());
        }
    }

    @Test
    public void shouldNorCreateRectangleWithDimensionsZero() {

        Exception e = assertThrows(ShapeException.class, () -> new Rectangle(0,0));
        assertEquals(ShapeException.BAD_DIMENSION_SIDE, e.getMessage());
    }


}
