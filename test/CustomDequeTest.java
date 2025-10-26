import org.junit.jupiter.api.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the CustomDeque class.
 * Verifies enqueue/dequeue operations, size, and iterator behavior.
 */
class CustomDequeTest {

    /** Tests adding/removing elements from both ends. */
    @Test
    void testEnqueueAndDequeueFrontRear() {
        CustomDeque deque = new CustomDeque();

        // Add to both front and rear
        deque.enqueueFront(10);
        deque.enqueueRear(20);
        deque.enqueueFront(5);

        assertEquals(3, deque.size());
        // Remove one from front, one from rear
        assertEquals(5, deque.dequeueFront());
        assertEquals(20, deque.dequeueRear());
        assertEquals(1, deque.size());
    }

    /** Checks empty state and size tracking. */
    @Test
    void testIsEmptyAndSize() {
        CustomDeque deque = new CustomDeque();
        assertTrue(deque.isEmpty());
        deque.enqueueRear(1);
        assertFalse(deque.isEmpty());
        assertEquals(1, deque.size());
    }

    /** Ensures dequeFront throws when empty. */
    @Test
    void testDequeueFrontThrowsWhenEmpty() {
        CustomDeque deque = new CustomDeque();
        assertThrows(NoSuchElementException.class, deque::dequeueFront);
    }

    /** Ensures dequeRear throws when empty. */
    @Test
    void testDequeueRearThrowsWhenEmpty() {
        CustomDeque deque = new CustomDeque();
        assertThrows(NoSuchElementException.class, deque::dequeueRear);
    }

    /** Tests correct front-to-rear iteration order and safe end handling. */
    @Test
    void testIteratorOrder() {
        CustomDeque deque = new CustomDeque();
        int[] values = {1, 2, 3};
        for (int v : values) deque.enqueueRear(v);

        Iterator<Integer> it = deque.iterator();
        assertTrue(it.hasNext());
        assertEquals(1, it.next());
        assertEquals(2, it.next());
        assertEquals(3, it.next());
        assertFalse(it.hasNext());
        // No more items should throw exception
        assertThrows(NoSuchElementException.class, it::next);
    }
}