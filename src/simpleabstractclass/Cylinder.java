package simpleabstractclass;

/**
 * Represents a cylinder with a given radius and height.
 */
public class Cylinder extends Shape {
    double rad, ht;

    /**
     * Creates a cylinder.
     * @param r radius of the base
     * @param h height of the cylinder
     */
    Cylinder(double r, double h) {
        if (r <= 0 || h <= 0) throw new IllegalArgumentException("Radius and height must be positive");
        rad = r;
        ht = h;
    }

    double surface_area() { return 2 * Math.PI * rad * (rad + ht); }

    double volume() { return Math.PI * rad * rad * ht; }

    @Override
    public String toString() {
        return "Cylinder -> Surface Area: " + surface_area() + " | Volume: " + volume();
    }
}