package simpleabstractclass;

/**
 * Represents a sphere with a given radius.
 */
public class Sphere extends Shape {
    double rad;

    /**
     * Creates a sphere.
     * @param r radius of the sphere
     */
    Sphere(double r) {
        if (r <= 0) throw new IllegalArgumentException("Radius must be positive");
        rad = r;
    }

    double surface_area() { return 4 * Math.PI * rad * rad; }

    double volume() { return (4.0 / 3) * Math.PI * rad * rad * rad; }

    @Override
    public String toString() {
        // Prints shape details
        return "Sphere -> Surface Area: " + surface_area() + " | Volume: " + volume();
    }
}