import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Bag class.
 */
class BagTest {

    /** Testing how to add duplicates, merge two bags, and verify the total size and contents. */
    @Test
    void testMergeAndSize() {
        // Initializing bag structures
        Bag<String> bag1 = new Bag<>();
        Bag<String> bag2 = new Bag<>();

        bag1.add("New York");
        bag1.add("New York");
        bag2.add("Istanbul");

        // Before merge
        assertEquals(2, bag1.size());
        assertEquals(1, bag2.size());

        // Merging bag2 into bag1
        bag1.merge(bag2);

        // After merge, as bag1 should contain 3 items
        assertEquals(3, bag1.size());
        assertTrue(bag1.contains("Istanbul"));
    }
}