import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Bag class.
 * Tests adding, removing, counting, and checking elements.
 */
class BagDemoTest {

    /**
     * Test that adding elements increases their count correctly.
     */
    @Test
    void testAddAndCount() {
        Bag<String> bag = new Bag<>();
        bag.add("Book");
        bag.add("Book");
        assertEquals(2, bag.count("Book"));
    }

    /**
     * Test that removing an element decreases its count.
     */
    @Test
    void testRemove() {
        Bag<String> bag = new Bag<>();
        bag.add("Book");
        bag.add("Book");
        bag.remove("Book");
        assertEquals(1, bag.count("Book"));
    }

    /**
     * Test that contains() works for present and absent elements.
     */
    @Test
    void testContains() {
        Bag<String> bag = new Bag<>();
        bag.add("Book");
        assertTrue(bag.contains("Book"));
        assertFalse(bag.contains("Magazine"));
    }
}