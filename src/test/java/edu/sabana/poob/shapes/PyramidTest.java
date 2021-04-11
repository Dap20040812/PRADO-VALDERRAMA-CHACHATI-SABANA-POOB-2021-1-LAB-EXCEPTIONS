package edu.sabana.poob.shapes;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PyramidTest {

    private static Pyramid c1;
    private static Pyramid c2;
    private static Pyramid c3;
    private static Pyramid c4;

    @BeforeAll
    public static void setUp() throws ShapeException{

        c1 = new Pyramid("red");
        c2 = new Pyramid("red",24,24,38,60);
        c3 = new Pyramid();
        c4 = new Pyramid(30,30,30,40);
    }

    @Test
    public void shouldCalculateArea() {
        assertEquals(0, (int) c1.getArea());
        assertEquals(278, (int) c2.getArea());
        assertEquals(0, (int) c3.getArea());
        assertEquals(389, (int) c4.getArea());
    }
    @Test
    public void shouldCalculatePerimeter() {

        assertEquals(3, (int) c1.getPerimeter());
        assertEquals(86, (int) c2.getPerimeter());
        assertEquals(3, (int) c3.getPerimeter());
        assertEquals(90, (int) c4.getPerimeter());

    }
    @Test
    public void shouldCalculateVolume() {

        assertEquals(0, (int) c1.getVolume());
        assertEquals(5571, (int) c2.getVolume());
        assertEquals(0, (int) c3.getVolume());
        assertEquals(5196, (int) c4.getVolume());

    }

    @Test
    public void shouldCalculateSuperficialArea() {

        assertEquals(1, (int) c1.getSuperficialArea());
        assertEquals(2580, (int) c2.getSuperficialArea());
        assertEquals(1, (int) c3.getSuperficialArea());
        assertEquals(1800, (int) c4.getSuperficialArea());

    }
    @Test
    public void shouldPrintPyramid() {

        assertTrue(c1.toStringGeometricShape3D().contains("This is a Pyramid"));
        assertTrue(c2.toStringGeometricShape3D().contains("This is a Pyramid"));
        assertTrue(c3.toStringGeometricShape3D().contains("This is a Pyramid"));
        assertTrue(c4.toStringGeometricShape3D().contains("This is a Pyramid"));

    }
    @Test
    public void shouldNorCreatePyramidWitHeightNegative() {

        try {
            new Pyramid(20,40,34,-1);
        } catch (ShapeException e) {
            assertEquals(ShapeException.BAD_DIMENSION_SIDE, e.getMessage());
        }
    }
    @Test
    public void shouldNorCreatePyramidWitHeightZero() {

        Exception e = assertThrows(ShapeException.class, () -> new Pyramid(20,40,34,0));
        assertEquals(ShapeException.BAD_DIMENSION_SIDE, e.getMessage());
    }


}

