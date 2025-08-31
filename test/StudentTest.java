import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Student class.
 * Each test verifies that inputs are validated correctly
 * and valid inputs create a Student successfully.
 */
class StudentTest {

    /**
     * A student with roll number 0 (allowed), valid name, and valid address
     * should be created successfully.
     */
    @Test
    void shouldCreateStudent_whenInputsAreValidAndZeroRollnoAllowed() {
        Student student = new Student(0, "Ayse", "Ankara");
        assertEquals(0, student.getRollno());
        assertEquals("Ayse", student.getName());
        assertEquals("Ankara", student.getAddress());
    }

    /**
     * Negative roll numbers should throw IllegalArgumentException.
     */
    @Test
    void shouldThrowException_whenRollnoIsNegative() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> new Student(-1, "Mehmet", "Istanbul")
        );
        assertTrue(ex.getMessage().toLowerCase().contains("negative"));
    }

    /**
     * Null names should throw IllegalArgumentException.
     */
    @Test
    void shouldThrowException_whenNameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Student(1, null, "Izmir"));
    }

    /**
     * Blank names (spaces only) should throw IllegalArgumentException.
     */
    @Test
    void shouldThrowException_whenNameIsBlank() {
        assertThrows(IllegalArgumentException.class, () -> new Student(1, "   ", "Izmir"));
    }

    /**
     * Null addresses should throw IllegalArgumentException.©
     */
    @Test
    void shouldThrowException_whenAddressIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Student(1, "Elif", null));
    }

    /**
     * Blank addresses (spaces only) should throw IllegalArgumentException.
     */
    @Test
    void shouldThrowException_whenAddressIsBlank() {
        assertThrows(IllegalArgumentException.class, () -> new Student(1, "Elif", "   "));
    }

    /**
     * Leading and trailing spaces in name or address
     * should be trimmed automatically when creating a Student.
     */
    @Test
    void shouldTrimWhitespace_whenNameAndAddressContainExtraSpaces() {
        Student student = new Student(5, "  Deniz  ", "  Adana  ");
        assertEquals("Deniz", student.getName());
        assertEquals("Adana", student.getAddress());
    }
}