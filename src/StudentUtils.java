import java.util.Scanner;

/**
 * Utility class for validating input.
 */
public class StudentUtils {

    /** Ensures GPA input is numeric and between 0.0 and 4.0. */
    public static double promptValidGpa(Scanner input) {
        while (true) {
            System.out.print("Enter GPA (0.0 - 4.0 scale): ");
            String token = input.nextLine().trim();
            try {
                double gpaValue = Double.parseDouble(token);
                if (gpaValue >= 0.0 && gpaValue <= 4.0) {
                    return gpaValue;
                } else {
                    System.out.println("GPA must be between 0.0 and 4.0. Try again.");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid entry. Please enter a numeric GPA.");
            }
        }
    }
}