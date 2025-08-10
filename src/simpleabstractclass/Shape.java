package simpleabstractclass;

/**
 * Abstract base class for all shapes.
 * Requires methods to calculate surface area and volume.
 */
public abstract class Shape {
    /** @return surface area of the shape */
    abstract double surface_area();

    /** @return volume of the shape */
    abstract double volume();
}