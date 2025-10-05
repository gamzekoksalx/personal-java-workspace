/**
 * Entry point for running postfix (RPN) calculations.
 * <p>
 * Supports both inline demo expressions and optional file-based input.
 * </p>
 */
public class PostfixCalculator {
    public static void main(String[] args) {
        RpnEvaluator eval = new RpnEvaluator();

        // demo runs
        show(eval, "42*3+", "Out 1");
        show(eval, "53+7*", "Out 2");
        show(eval, "42*+",  "Out 3");

        // multi-digit examples (require spaces)
        show(eval, "12 3 + 4 *", "Out 4");
        show(eval, "100 7 % 5 +", "Out 5");
        show(eval, "9 0 /",       "Out 6");

        // file mode if filename is passed
        if (args.length > 0) {
            RpnFileReader.run(eval);
        }
    }

    /**
     * Helper to evaluate an expression and print the result or error.
     */
    private static void show(RpnEvaluator eval, String expr, String tag) {
        try {
            int v = eval.calc(expr);
            System.out.println(tag + ": " + v);
        } catch (IllegalArgumentException e) {
            System.out.println(tag + ": Error - " + e.getMessage());
        }
    }
}