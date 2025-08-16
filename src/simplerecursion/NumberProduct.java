package simplerecursion;
import java.util.Scanner;

public class NumberProduct {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please enter 5 integers:");
            System.out.println("The total product is: " + calculateProduct(scanner, 5));
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }

    /**
     * Recursively calculates the product of user-entered integers.
     */
    static int calculateProduct(Scanner scanner, int numbersLeft) {
        if (numbersLeft < 0) {
            throw new IllegalArgumentException("numbersLeft cannot be negative");
        }
        if (numbersLeft == 0) return 1; // base case

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer:");
            scanner.next(); // discard invalid token
        }

        return scanner.nextInt() * calculateProduct(scanner, numbersLeft - 1);
    }
}
