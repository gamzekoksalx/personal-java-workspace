/**
 * LSD Radix Sort (base 10).
 * Overall time: O(d * (n + k))  where
 *   n = number of elements, d = # of digit places of max value, k = radix (=10).
 * For fixed-size ints (d, k constant) → O(n). Space: O(n + k) ≈ O(n). Stable: YES.
 */
public class RadixSort {

    public static void radixSort(int[] numbers) {
        int n = numbers.length;

        // --- NEW: support negatives by shifting to non-negative range ---
        int minValue = numbers[0];
        for (int v : numbers) if (v < minValue) minValue = v;
        int shift = (minValue < 0) ? -minValue : 0; // shift >= 0
        if (shift != 0) {
            for (int i = 0; i < n; i++) numbers[i] += shift; // make all values >= 0
        }

        // --- Step 0: Find max to know how many digit places we need ---
        // Cost: O(n)
        int maxValue = findMax(numbers);

        // digitPlace iterates over 1, 10, 100, ... up to the most significant digit.
        int digitPlace = 1; // ones → tens → hundreds ...
        int[] output = new int[n]; // Space: O(n)

        // --- Outer loop over digit places ---
        // Number of passes = d (digits in maxValue) → runs O(d) times.
        while (maxValue / digitPlace > 0) { // O(d) passes overall
            int[] count = new int[10];     // Space: O(k), here k=10

            // --- Step 1: Count digit frequencies at current place ---
            // One pass over the array → O(n)
            for (int value : numbers) {
                int currentDigit = (value / digitPlace) % 10;
                count[currentDigit]++;
            }

            // --- Step 2: Prefix sums on count to get final positions ---
            // Single pass over radix (0..9) → O(k)
            for (int dgt = 1; dgt < 10; dgt++) {
                count[dgt] += count[dgt - 1];
            }

            // --- Step 3: Stable placement into output (right-to-left) ---
            // One pass over the array → O(n)
            for (int i = n - 1; i >= 0; i--) {
                int currentDigit = (numbers[i] / digitPlace) % 10;
                output[--count[currentDigit]] = numbers[i];
            }

            // --- Step 4: Copy back to original array for next digit pass ---
            // One pass over the array → O(n)
            System.arraycopy(output, 0, numbers, 0, n);

            // Move to next digit place. (Loop control; constant work) → O(1)
            digitPlace *= 10;
        }
        // Summing per pass: O(n + k)
        // Over d passes: O(d * (n + k))  → with constant k=10 → O(dn)

        // --- NEW: undo shift so original values (incl. negatives) are restored ---
        if (shift != 0) {
            for (int i = 0; i < n; i++) numbers[i] -= shift;
        }
    }

    /**
     * Returns the maximum value in the array. Runs in O(n).
     * @param arr input array (non-empty)
     * @return largest element found
     */
    private static int findMax(int[] arr) {
        int max = arr[0];
        for (int v : arr) {
            if (v > max) max = v; // comparisons are O(1) each
        }
        return max;
    }
}