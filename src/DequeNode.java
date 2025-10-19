/**
 * Represents a single node in the CustomDeque.
 * Each node stores an integer value and links to its previous and next nodes.
 */
public class DequeNode {
    int value;
    DequeNode next, prev;

    DequeNode(int value) { this.value = value; }
}