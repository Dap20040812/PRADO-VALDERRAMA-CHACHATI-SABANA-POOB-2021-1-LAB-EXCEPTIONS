package edu.sabana.poob.shapes;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

    private static Triangle c1;
    private static Triangle c2;
    private static Triangle c3;
    private static Triangle c4;
    private static Triangle c5;
    private static Triangle c6;

    @BeforeAll
    public static void setUp() throws ShapeException{
        c1 = new Triangle(24,24,38);
        c2 = new Triangle(30,30,30);
        c3 = new Triangle("red");
        c4 = new Triangle("red",34,54,67);
        c5 = new Triangle();
        c6 = new Triangle(24,17,100);
    }

    @Test
    public void shouldCalculateArea() {
        assertEquals(278, (int) c1.getArea());
        assertEquals(389, (int) c2.getArea());
        assertEquals(0, (int) c3.getArea());
        assertEquals(912, (int) c4.getArea());
        assertEquals(0, (int) c5.getArea());

    }
    @Test
    public void shouldNotCalculateArea() {

        assertEquals(0, (int) c6.getArea());
    }

    @Test
    public void shouldCalculatePerimeter() {

        assertEquals(86, (int) c1.getPerimeter());
        assertEquals(90, (int) c2.getPerimeter());
        assertEquals(3, (int) c3.getPerimeter());
        assertEquals(155, (int) c4.getPerimeter());
        assertEquals(3, (int) c5.getPerimeter());

    }

    @Test
    public void shouldNotCalculatePerimeter() {

        assertEquals(0, (int) c6.getPerimeter());

    }

   @Test
   public void shouldBeIsosceles(){

       assertTrue(c1.isIsoceles());
       assertFalse(c2.isIsoceles());
       assertFalse(c3.isIsoceles());
       assertFalse(c4.isIsoceles());
       assertFalse(c5.isIsoceles());
   }

    @Test
    public void shouldBeEquilateral(){

        assertFalse(c1.isEquilatera());
        assertTrue(c2.isEquilatera());
        assertTrue(c3.isEquilatera());
        assertFalse(c4.isEquilatera());
        assertTrue(c5.isEquilatera());
    }


    @Test
    public void shouldPrintTriangle() {

        assertEquals("This is a Triangle with color NONE and is an isosceles triangle", c1.toString());
        assertEquals("This is a Triangle with color NONE and is an equilateral triangle", c2.toString());
        assertEquals("This is a Triangle with color red and is an equilateral triangle", c3.toString());
        assertEquals("This is a Triangle with color red and is an scalene triangle", c4.toString());
        assertEquals("This is a Triangle with color NONE and is an equilateral triangle", c5.toString());
        assertEquals("The triangle with the dimensions 24.0 17.0 100.0 doesn't exist", c6.toString());


    }
    @Test
    public void shouldNorCreateBadTriangleDimensions() {

        try {
            new Triangle(2,40,2);
        } catch (ShapeException e) {
            assertEquals(ShapeException.BAD_DIMENSION_SIDE, e.getMessage());
        }
    }


}
