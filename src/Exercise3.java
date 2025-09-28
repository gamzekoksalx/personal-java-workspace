public class Exercise3 {
    public static void main(String[] args) {
        // Compare two programs: A=1000n² vs B=2ⁿ
        for (int n = 15; n <= 20; n++) {
            long progA = 1000L * n * n;         // grows quadratically
            long progB = (long) Math.pow(2, n); // grows exponentially
            System.out.println("n=" + n + " → A=" + progA + ", B=" + progB);
        }
    }
}