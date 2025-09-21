import java.util.HashMap;
import java.util.Map;

/**
 * A simple generic Bag (multiset) implementation.
 * Allows duplicate elements and does not enforce order.
 */
class Bag<T> {
    private Map<T, Integer> items = new HashMap<>();

    /** Adds an item to the bag - duplicates increase the count */
    public void add(T item) {
        if (item == null) throw new IllegalArgumentException("Item cannot be null");
        items.put(item, items.getOrDefault(item, 0) + 1);
    }

    /** Removes one occurrence of an item. Removes fully if count reaches zero */
    public void remove(T item) {
        if (item == null) throw new IllegalArgumentException("Item cannot be null");
        items.computeIfPresent(item, (k, v) -> v > 1 ? v - 1 : null);
    }

    /** Checks if the bag contains the item */
    public boolean contains(T item) {
        if (item == null) throw new IllegalArgumentException("Item cannot be null");
        return items.containsKey(item);
    }

    /** Counts how many times an item occurs */
    public int count(T item) {
        if (item == null) throw new IllegalArgumentException("Item cannot be null");
        return items.getOrDefault(item, 0);
    }

    /** Prints items and their counts */
    public void printBag() {
        if (items.isEmpty()) {
            System.out.println("The bag is empty.");
        } else {
            items.forEach((k, v) -> System.out.println(k + " x" + v));
        }
    }

    /** Returns total number of elements including duplicates */
    public int size() {
        return items.values().stream().mapToInt(Integer::intValue).sum();
    }

    /** Merges another bag into the given bag */
    public void merge(Bag<T> otherBag) {
        if (otherBag == null) throw new IllegalArgumentException("Other bag cannot be null");
        otherBag.items.forEach((k, v) -> items.put(k, items.getOrDefault(k, 0) + v));
    }

    /** Returns a new bag with only distinct elements */
    public Bag<T> distinct() {
        Bag<T> distinctBag = new Bag<>();
        items.keySet().forEach(distinctBag::add);
        return distinctBag;
    }
}