public class Exercise4 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5}; // missing 3
        int n = 5; // numbers range 1..n

        int xorAll = 0, xorArr = 0;

        // First loop: XOR all numbers from 1..n (n iterations)
        for (int i = 1; i <= n; i++) {
            xorAll ^= i;
        }

        // Second loop: XOR all numbers in array (n-1 iterations)
        for (int val : arr) {
            xorArr ^= val;
        }

        // Result = XOR of full set vs given set
        int missing = xorAll ^ xorArr;
        System.out.println("Missing number: " + missing);
    }
}