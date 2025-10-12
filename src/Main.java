import java.util.Arrays;

/**
 * Radix Sort Demo
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94};

        System.out.println("Original array: " + Arrays.toString(arr));

        // Call the method from RadixSort class
        RadixSort.radixSort(arr);

        System.out.println("Sorted array:   " + Arrays.toString(arr));
    }
}