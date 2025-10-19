import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterates through a CustomDeque from front to rear.
 */
public class DequeIterator implements Iterator<Integer> {
    private DequeNode current;

    public DequeIterator(DequeNode start) {
        this.current = start;
    }

    public boolean hasNext() {
        return current != null;
    }

    public Integer next() {
        if (!hasNext()) throw new NoSuchElementException("No more items.");
        int val = current.value;
        current = current.next;
        return val;
    }
}