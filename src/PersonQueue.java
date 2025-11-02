import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Simple queue-like container for Person objects
 * that can be sorted using quick sort.
 */
public class PersonQueue {

    private final List<Person> items = new ArrayList<>();

    /** Adds a person to the end of the queue. */
    public void add(Person p) {
        if (p == null) {
            throw new IllegalArgumentException("Person cannot be null.");
        }
        items.add(p);
    }

    /** Prints all people currently in the queue. */
    public void display(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("  (no people in queue)");
            return;
        }
        for (Person p : items) {
            System.out.println("  " + p);
        }
    }

    /** Sorts the queue using quick sort with the given comparator. */
    public void quickSort(Comparator<Person> comp) {
        if (items.size() <= 1) {
            return; // nothing to sort
        }
        sortHelper(items, 0, items.size() - 1, comp);
    }

    // Recursive quick sort
    private void sortHelper(List<Person> list, int low, int high, Comparator<Person> comp) {
        if (low >= high) return;
        int split = partition(list, low, high, comp);
        sortHelper(list, low, split - 1, comp);
        sortHelper(list, split + 1, high, comp);
    }

    // Partition step (descending because we compare > 0)
    private int partition(List<Person> list, int low, int high, Comparator<Person> comp) {
        Person pivot = list.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (comp.compare(list.get(j), pivot) > 0) {
                i++;
                Collections.swap(list, i, j);
            }
        }
        Collections.swap(list, i + 1, high);
        return i + 1;
    }
}