import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Demonstrates how to use the CustomDeque class.
 */
public class DequeDemo {
    public static void main(String[] args) {
        CustomDeque numbers = new CustomDeque();

        // Insert elements from an array of 10 integers
        int[] data = {42, 17, 89, 63, 25, 74, 56, 91, 38, 10};
        for (int n : data) {
            numbers.enqueueRear(n);
        }

        System.out.println("Deque (front → rear):");
        for (int x : numbers) System.out.print(x + " ");

        // Remove elements safely
        System.out.println("Removed from front: " + numbers.dequeueFront());
        System.out.println("Removed from rear: " + numbers.dequeueRear());
        System.out.println("Size now: " + numbers.size());

        // Iterate manually using iterator
        System.out.println("Remaining elements:");
        Iterator<Integer> walk = numbers.iterator();
        while (walk.hasNext()) System.out.print(walk.next() + " ");

        System.out.println("Attempting to remove until empty:");
        try {
            while (true) System.out.print(numbers.dequeueFront() + " ");
        } catch (NoSuchElementException ex) {
            System.out.println("Handled safely: " + ex.getMessage());
        }
    }
}