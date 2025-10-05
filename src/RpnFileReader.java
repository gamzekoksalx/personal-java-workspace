import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Utility to evaluate multiple postfix expressions from a fixed file in the project root.
 */
public class RpnFileReader {

    // Always point to a file in the project root
    private static final Path FILE_PATH = Paths.get("./input.txt").toAbsolutePath().normalize();

    /**
     * Read expressions from the fixed file and evaluate them in order.
     *
     * @param eval evaluator instance
     */
    public static void run(RpnEvaluator eval) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH.toFile()))) {
            String line;
            int i = 1;
            while ((line = br.readLine()) != null) {
                String expr = line.trim();
                if (expr.isEmpty()) {
                    i++;
                    continue;
                }
                try {
                    int v = eval.calc(expr);
                    System.out.println("Line " + i + ": " + v);
                } catch (IllegalArgumentException e) {
                    System.out.println("Line " + i + ": Error - " + e.getMessage());
                }
                i++;
            }
        } catch (IOException e) {
            System.out.println("File error - " + e.getMessage());
        }
    }
}