import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the Student class.
 */
public class StudentTest {

    @Test
    void compareTo_ordersByNameAscending() {
        Student ahmet = new Student("Ahmet", "Ankara", 3.0);
        Student mehmet = new Student("Mehmet", "Izmir", 3.5);

        // Ahmet should come before Mehmet
        assertTrue(ahmet.compareTo(mehmet) < 0);
    }

    @Test
    void toString_includesAllFields() {
        Student zeynep = new Student("Zeynep", "Istanbul", 3.0);

        String text = zeynep.toString();

        assertTrue(text.contains("Zeynep"));
        assertTrue(text.contains("Istanbul"));
        assertTrue(text.contains("3.0"));
    }
}