package simpleabstractclass;

/**
 * Driver class to test different shapes.
 */
public class ShapeArray {
    public static void main(String[] args) {
        // Create an array of shapes (null-safe)
        Shape[] shapeArray = new Shape[3];
        try {
            shapeArray[0] = new Sphere(4.5);
            shapeArray[1] = new Cylinder(2.2, 7.1);
            shapeArray[2] = new Cone(3.3, 6.0);
        } catch (IllegalArgumentException e) {
            System.err.println("Error creating shape: " + e.getMessage());
        }

        // Loop through and print details
        for (Shape s : shapeArray) {
            if (s != null) { // null check
                System.out.println(s);
            }
        }
    }
}
