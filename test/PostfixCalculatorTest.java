import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the RPN calculator.
 */
public class PostfixCalculatorTest {

    private final RpnEvaluator eval = new RpnEvaluator();

    @Test
    void testSimpleExpressions() {
        assertEquals(11, eval.calc("4 2 * 3 +"));   // (4*2)+3
        assertEquals(56, eval.calc("5 3 + 7 *"));   // (5+3)*7
        assertThrows(IllegalArgumentException.class, () -> eval.calc("4 2 * +")); // invalid
    }

    @Test
    void testMultiDigitExpressions() {
        assertEquals(60, eval.calc("12 3 + 4 *"));   // (12+3)*4
        assertEquals(7, eval.calc("100 7 % 5 +"));   // (100%7)+5
    }

    @Test
    void testDivideAndModuloByZero() {
        assertThrows(IllegalArgumentException.class, () -> eval.calc("9 0 /"));
        assertThrows(IllegalArgumentException.class, () -> eval.calc("9 0 %"));
    }

    @Test
    void testFileReader() {
        RpnEvaluator eval = new RpnEvaluator();

        // capture output
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream oldOut = System.out;
        System.setOut(new PrintStream(out));
        try {
            RpnFileReader.run(eval);
        } finally {
            System.setOut(oldOut);
        }

        String output = out.toString().trim();

        // assertions that match file contents
        assertTrue(output.contains("Line 1: Error - need two numbers before '*'"));
        assertTrue(output.contains("Line 2: Error - need two numbers before '+'"));
        assertTrue(output.contains("Line 3: Error - need two numbers before '*'"));
        assertTrue(output.contains("Line 4: 60"));
        assertTrue(output.contains("Line 5: Error - divide by 0"));
    }
}