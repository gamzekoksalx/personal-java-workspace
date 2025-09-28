public class Exercise2 {
    public static void main(String[] args) {
        for (int n : new int[]{10, 20, 40}) {
            int steps = 0;

            // Outer loop: n iterations
            for (int i = 0; i < n; i++) {
                // Middle loop: n iterations for each i
                for (int j = 0; j < n; j++) {
                    // Inner loop: fixed 9 iterations (constant)
                    for (int k = 0; k < 9; k++) {
                        steps++; // constant-time operation
                    }
                }
            }

            System.out.println("n=" + n + " → steps=" + steps);
        }
    }
}