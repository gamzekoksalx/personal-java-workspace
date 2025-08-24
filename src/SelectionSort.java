import java.util.*;

/**
 * Utility class with a custom selection sort implementation and demo.
 */
public class SelectionSort {
    /**
     * Sorts a list using the selection sort algorithm.
     *
     * How it works:
     * 1) Treat the list as two parts: sorted prefix [0..i-1] and unsorted suffix [i..end).
     * 2) Find the smallest element in the unsorted part.
     * 3) Swap it into position i.
     * 4) Repeat for i = 0..n-2.
     *
     * @param list list to sort (must not be null)
     * @param cmp comparator to decide order (must not be null)
     * @param <T> element type
     * @throws IllegalArgumentException if list or cmp is null
     * @throws RuntimeException if comparator throws during compare (wrapped with indices)
     */
    public static <T> void selectionSort(List<T> list, Comparator<? super T> cmp) {
        if (list == null) throw new IllegalArgumentException("list is null");
        if (cmp == null)  throw new IllegalArgumentException("comparator is null");

        // Outer loop: the position where the next smallest element should go.
        for (int i = 0; i < list.size() - 1; i++) {
            int min = i; // assume current i is the smallest in the unsorted suffix

            // Inner loop: find the index of the smallest element in [i+1 .. end)
            for (int j = i + 1; j < list.size(); j++) {
                T a = list.get(j), b = list.get(min);
                int c;
                try {
                    c = cmp.compare(a, b);
                } catch (Exception e) {
                    // Add indices to help debug bad comparator or data
                    throw new RuntimeException("compare failed at indices j=" + j + ", min=" + min, e);
                }
                if (c < 0) min = j; // found a new minimum
            }

            // Swap the found minimum into position i (manual swap, no library helpers)
            if (min != i) {
                T tmp = list.get(i);
                list.set(i, list.get(min));
                list.set(min, tmp);
            }
        }
    }

    /**
     * Demo: builds 10 students, validates size, and sorts by name then rollno.
     * Catches and reports errors without crashing the program.
     */
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            // Build data (Student constructor performs validation)
            students.add(new Student(5,  "Omer",  "Ankara"));
            students.add(new Student(2,  "Charlie","Izmir"));
            students.add(new Student(9,  "Bob",    "Istanbul"));
            students.add(new Student(1,  "Ece",    "Bursa"));
            students.add(new Student(7,  "Deniz",  "Adana"));
            students.add(new Student(10, "Alice", "Konya"));
            students.add(new Student(3,  "Gizem",  "Antalya"));
            students.add(new Student(8,  "Hakan",  "Mersin"));
            students.add(new Student(6,  "Zeynep",   "Trabzon"));
            students.add(new Student(4,  "Jane", "Eskisehir"));

            if (students.size() != 10) {
                System.err.println("Expected 10 students, found " + students.size());
                return;
            }

            System.out.println("Original:");
            students.forEach(System.out::println);

            try {
                selectionSort(students, new ByName());
                System.out.println("\nSorted by name:");
                students.forEach(System.out::println);
            } catch (RuntimeException e) {
                System.err.println("Sort by name failed: " + e.getMessage());
            }

            try {
                selectionSort(students, new ByRollNo());
                System.out.println("\nSorted by rollno:");
                students.forEach(System.out::println);
            } catch (RuntimeException e) {
                System.err.println("Sort by rollno failed: " + e.getMessage());
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid student data: " + e.getMessage());
        } catch (Exception e) {
            // Last-resort guard
            System.err.println("Unexpected error: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
}