import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Evaluates postfix (Reverse Polish Notation) arithmetic expressions.
 * <p>
 * Supported operators: +, -, *, /, %.
 * Operands can be single-digit (no spaces) or multi-digit (space-separated).
 * </p>
 */
public class RpnEvaluator {

    /**
     * Evaluate a postfix expression string and return the integer result.
     *
     * @param s postfix expression, e.g., "42*3+" or "12 3 + 4 *"
     * @return result of evaluation
     * @throws IllegalArgumentException if the expression is invalid
     */
    public int calc(String s) {
        if (s == null) throw new IllegalArgumentException("empty input");
        Deque<Integer> st = new ArrayDeque<>();
        int n = s.length();

        for (int i = 0; i < n; ) {
            char c = s.charAt(i);

            if (Character.isWhitespace(c)) { i++; continue; }

            if (Character.isDigit(c)) {
                int v = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    v = v * 10 + (s.charAt(i) - '0');
                    i++;
                }
                st.push(v);
                continue;
            }

            if (isOp(c)) {
                if (st.size() < 2) throw new IllegalArgumentException("need two numbers before '" + c + "'");
                int b = st.pop();
                int a = st.pop();
                st.push(apply(a, b, c));
                i++;
                continue;
            }

            throw new IllegalArgumentException("bad token: " + c);
        }

        if (st.size() != 1) throw new IllegalArgumentException("bad expression (leftover stuff)");
        return st.pop();
    }

    /** Check if a character is a supported operator. */
    private boolean isOp(char c) { return c=='+'||c=='-'||c=='*'||c=='/'||c=='%'; }

    /**
     * Apply an arithmetic operation to two operands.
     * @throws IllegalArgumentException if divide/mod by zero occurs
     */
    private int apply(int a, int b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': if (b == 0) throw new IllegalArgumentException("divide by 0"); return a / b;
            case '%': if (b == 0) throw new IllegalArgumentException("mod by 0");    return a % b;
        }
        throw new IllegalArgumentException("unknown op");
    }
}