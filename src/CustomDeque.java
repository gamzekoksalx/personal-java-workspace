import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Simple double-ended queue for integers with front/rear operations and custom iterator support.
 */
public class CustomDeque implements Iterable<Integer> {
    private DequeNode head; // front
    private DequeNode tail; // rear
    private int size;

    public void enqueueFront(int data) {
        DequeNode node = new DequeNode(data);
        if (head == null) head = tail = node;
        else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    public void enqueueRear(int data) {
        DequeNode node = new DequeNode(data);
        if (tail == null) head = tail = node;
        else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    /**
     * Removes and returns value from the front.
     * @throws NoSuchElementException if empty
     */
    public int dequeueFront() {
        checkEmpty("Deque is empty (front).");
        int val = head.value;
        head = head.next;
        if (head == null) tail = null;
        else head.prev = null;
        size--;
        return val;
    }

    /**
     * Removes and returns value from the rear.
     * @throws NoSuchElementException if empty
     */
    public int dequeueRear() {
        checkEmpty("Deque is empty (rear).");
        int val = tail.value;
        tail = tail.prev;
        if (tail == null) head = null;
        else tail.next = null;
        size--;
        return val;
    }

    public boolean isEmpty() { return size == 0; }

    public int size() { return size; }

    private void checkEmpty(String msg) {
        if (isEmpty()) throw new NoSuchElementException(msg);
    }

    /** Returns an iterator from front to rear. */
    @Override
    public Iterator<Integer> iterator() {
        return new DequeIterator(head);
    }
}