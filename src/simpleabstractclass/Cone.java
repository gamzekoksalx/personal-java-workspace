package simpleabstractclass;

/**
 * Represents a cone with a given radius and height.
 */
public class Cone extends Shape {
    double rad, ht;

    /**
     * Creates a cone.
     * @param r radius of the base
     * @param h height of the cone
     */
    Cone(double r, double h) {
        if (r <= 0 || h <= 0) throw new IllegalArgumentException("Radius and height must be positive");
        rad = r;
        ht = h;
    }

    double surface_area() {
        return Math.PI * rad * (rad + Math.sqrt(ht * ht + rad * rad));
    }

    double volume() { return Math.PI * rad * rad * ht / 3; }

    @Override
    public String toString() {
        return "Cone -> Surface Area: " + surface_area() + " | Volume: " + volume();
    }
}