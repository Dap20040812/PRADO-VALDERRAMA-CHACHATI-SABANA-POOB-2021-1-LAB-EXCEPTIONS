package edu.sabana.poob.shapes;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangleSolidTest {

    private static RectangleSolid c1;
    private static RectangleSolid c2;
    private static RectangleSolid c3;
    private static RectangleSolid c4;



    @BeforeAll
    public static void setUp() throws ShapeException {
        c1 = new RectangleSolid(20,40,60);
        c2 = new RectangleSolid("red",30,45.67,50);
        c3 = new RectangleSolid("red");
        c4 = new RectangleSolid();
    }

    @Test
    public void shouldCalculateArea() {
        assertEquals(800, (int) c1.getArea());
        assertEquals(1370, (int) c2.getArea());
        assertEquals(1, (int) c3.getArea());
        assertEquals(1, (int) c4.getArea());

    }

    @Test
    public void shouldCalculatePerimeter() {

        assertEquals(120, (int) c1.getPerimeter());
        assertEquals(151, (int) c2.getPerimeter());
        assertEquals(4, (int) c3.getPerimeter());
        assertEquals(4, (int) c4.getPerimeter());


    }

    @Test
    public void shouldCalculateDiagonal() {

        assertEquals(44, (int) c1.getDiagonal());
        assertEquals(54, (int) c2.getDiagonal());
        assertEquals(1, (int) c3.getDiagonal());
        assertEquals(1, (int) c4.getDiagonal());


    }

    @Test
    public void shouldCalculateVolume() {

        assertEquals(48000, (int) c1.getVolume());
        assertEquals(68505, (int) c2.getVolume());
        assertEquals(1, (int) c3.getVolume());
        assertEquals(1, (int) c4.getVolume());

    }

    @Test
    public void shouldCalculateSuperficialArea() {

        assertEquals(8800, (int) c1.getSuperficialArea());
        assertEquals(10307, (int) c2.getSuperficialArea());
        assertEquals(6, (int) c3.getSuperficialArea());
        assertEquals(6, (int) c4.getSuperficialArea());

    }
    @Test
    public void shouldPrintRectangleSolid() {

        assertTrue(c1.toStringGeometricShape3D().contains("This is a RectangleSolid"));
        assertTrue(c2.toStringGeometricShape3D().contains("This is a RectangleSolid"));
        assertTrue(c3.toStringGeometricShape3D().contains("This is a RectangleSolid"));
        assertTrue(c4.toStringGeometricShape3D().contains("This is a RectangleSolid"));
    }
    @Test
    public void shouldNorCreateRectangleSolidWithDimensionsNegative() {

        try {
            new RectangleSolid(2,4,-1);
        } catch (ShapeException e) {
            assertEquals(ShapeException.BAD_DIMENSION_SIDE, e.getMessage());
        }
    }

    @Test
    public void shouldNorCreateRectangleSolidWithDimensionsZero() {

        Exception e = assertThrows(ShapeException.class, () -> new RectangleSolid(2,4,0));
        assertEquals(ShapeException.BAD_DIMENSION_SIDE, e.getMessage());
    }
}
