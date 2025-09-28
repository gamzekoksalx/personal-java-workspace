public class Exercise1 {
    public static void main(String[] args) {
        for (int n : new int[]{10, 20, 40, 80}) {
            int steps = 0;

            // Loop starts at n and decreases by 2 each time
            // Runs about n/2 times → proportional to n
            for (int counter = n; counter > 0; counter -= 2) {
                steps++; // constant-time operation
            }

            System.out.println("n=" + n + " → steps=" + steps);
        }
    }
}