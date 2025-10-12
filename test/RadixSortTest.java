import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class RadixSortTest {

    // Tests normal unsorted input with mixed digit lengths
    @Test
    void testNormalArray() {
        int[] input = {783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94};
        int[] expected = {94, 99, 182, 264, 295, 356, 472, 491, 543, 692, 783};
        RadixSort.radixSort(input);
        assertArrayEquals(expected, input);
    }

    // Tests when input is already sorted
    @Test
    void testAlreadySortedArray() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        RadixSort.radixSort(input);
        assertArrayEquals(expected, input);
    }

    // Tests smallest possible case (one element)
    @Test
    void testSingleElementArray() {
        int[] input = {42};
        int[] expected = {42};
        RadixSort.radixSort(input);
        assertArrayEquals(expected, input);
    }

    // Tests handling of duplicate values
    @Test
    void testArrayWithDuplicates() {
        int[] input = {5, 3, 5, 1, 3};
        int[] expected = {1, 3, 3, 5, 5};
        RadixSort.radixSort(input);
        assertArrayEquals(expected, input);
    }
}