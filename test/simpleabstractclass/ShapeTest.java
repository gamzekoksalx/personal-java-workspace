package simpleabstractclass;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Simple unit tests for Sphere, Cylinder, and Cone classes.
 * Using small values (radius = 1, height = 1) for easy math checks.
 */
public class ShapeTest {

    /**
     * Test Sphere with radius 1.
     * Delta (0.001) is used to allow for tiny floating-point rounding errors.
     */
    @Test
    public void testSphereCalculations() {
        Shape sphere = new Sphere(1);
        assertEquals(4 * Math.PI, sphere.surface_area(), 0.001);   // 4πr²
        assertEquals((4.0 / 3) * Math.PI, sphere.volume(), 0.001); // (4/3)πr³
    }

    /**
     * Test Cylinder with radius 1, height 1.
     * Delta prevents test failures caused by floating-point precision issues.
     */
    @Test
    public void testCylinderCalculations() {
        Shape cylinder = new Cylinder(1, 1);
        assertEquals(4 * Math.PI, cylinder.surface_area(), 0.001); // 2πr(r+h) = 4π
        assertEquals(Math.PI, cylinder.volume(), 0.001);           // πr²h
    }

    /**
     * Test Cone with radius 1, height 1.
     * Using Math.PI in expected values to match exact formula results.
     */
    @Test
    public void testConeCalculations() {
        Shape cone = new Cone(1, 1);
        assertEquals(Math.PI * (1 + Math.sqrt(2)), cone.surface_area(), 0.001); // πr(r+√(h²+r²))
        assertEquals(Math.PI / 3, cone.volume(), 0.001);                        // (πr²h)/3
    }

    /** Test that invalid radius throws an exception */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidSphere() {
        new Sphere(0); // radius must be > 0
    }
}