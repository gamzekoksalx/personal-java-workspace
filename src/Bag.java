import java.util.HashMap;
import java.util.Map;

/**
 * A simple generic Bag (multiset) implementation.
 * A Bag allows duplicate elements and does not enforce order.
 * Each element is stored with its frequency count.
 *
 * @param <T> the type of elements stored in the bag
 */
class Bag<T> {
    private Map<T, Integer> items = new HashMap<>();

    /**
     * Adds an item to the bag.
     * If the item already exists, its count increases by one.
     *
     * @param item the element to add (must not be null)
     * @throws IllegalArgumentException if the item is null
     */
    public void add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        items.put(item, items.getOrDefault(item, 0) + 1);
    }

    /**
     * Removes one occurrence of the given item from the bag.
     * If the item count reaches zero, it is removed completely.
     *
     * @param item the element to remove (must not be null)
     * @throws IllegalArgumentException if the item is null
     */
    public void remove(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        if (items.containsKey(item)) {
            int count = items.get(item);
            if (count > 1) {
                items.put(item, count - 1);
            } else {
                items.remove(item);
            }
        }
    }

    /**
     * Checks whether the bag contains the given item.
     *
     * @param item the element to check (must not be null)
     * @return true if the item exists, false otherwise
     * @throws IllegalArgumentException if the item is null
     */
    public boolean contains(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        return items.containsKey(item);
    }

    /**
     * Returns how many times the given item appears in the bag.
     *
     * @param item the element to count (must not be null)
     * @return the number of occurrences
     * @throws IllegalArgumentException if the item is null
     */
    public int count(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        return items.getOrDefault(item, 0);
    }

    /**
     * Prints all items in the bag along with their counts.
     */
    public void printBag() {
        if (items.isEmpty()) {
            System.out.println("The bag is empty.");
            return;
        }
        for (Map.Entry<T, Integer> entry : items.entrySet()) {
            System.out.println(entry.getKey() + " x" + entry.getValue());
        }
    }
}