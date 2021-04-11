package edu.sabana.poob.shapes;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CubeTest {

    private static Cube c1;
    private static Cube c2;
    private static Cube c3;
    private static Cube c4;



    @BeforeAll
    public static void setUp() throws ShapeException {
        c1 = new Cube(20);
        c2 = new Cube("red");
        c3 = new Cube("red",40);
        c4 = new Cube();
    }

    @Test
    public void shouldCalculateArea() {
        assertEquals(400, (int) c1.getArea());
        assertEquals(1, (int) c2.getArea());
        assertEquals(1600, (int) c3.getArea());
        assertEquals(1, (int) c4.getArea());

    }

    @Test
    public void shouldCalculatePerimeter() {

        assertEquals(80, (int) c1.getPerimeter());
        assertEquals(4, (int) c2.getPerimeter());
        assertEquals(160, (int) c3.getPerimeter());
        assertEquals(4, (int) c4.getPerimeter());


    }

    @Test
    public void shouldCalculateDiagonal() {

        assertEquals(28, (int) c1.getDiagonal());
        assertEquals(1, (int) c2.getDiagonal());
        assertEquals(56, (int) c3.getDiagonal());
        assertEquals(1, (int) c4.getDiagonal());


    }

    @Test
    public void shouldCalculateVolume() {

        assertEquals(8000, (int) c1.getVolume());
        assertEquals(1, (int) c2.getVolume());
        assertEquals(64000, (int) c3.getVolume());
        assertEquals(1, (int) c4.getVolume());

    }

    @Test
    public void shouldCalculateSuperficialArea() {

        assertEquals(2400, (int) c1.getSuperficialArea());
        assertEquals(6, (int) c2.getSuperficialArea());
        assertEquals(9600, (int) c3.getSuperficialArea());
        assertEquals(6, (int) c4.getSuperficialArea());

    }
    @Test
    public void shouldPrintCube() {

        assertTrue(c1.toStringGeometricShape3D().contains("This is a Cube"));
        assertTrue(c2.toStringGeometricShape3D().contains("This is a Cube"));
        assertTrue(c3.toStringGeometricShape3D().contains("This is a Cube"));
        assertTrue(c4.toStringGeometricShape3D().contains("This is a Cube"));



    }
    @Test
    public void shouldNorCreateCylinderWithRadiusNegative() {

        try {
            new Cube(-1);
        } catch (ShapeException e) {
            assertEquals(ShapeException.BAD_DIMENSION_SIDE, e.getMessage());
        }
    }

    @Test
    public void shouldNorCreateCircleWithRadiusZero() {

        Exception e = assertThrows(ShapeException.class, () -> new Cube(0));
        assertEquals(ShapeException.BAD_DIMENSION_SIDE, e.getMessage());
    }
}
