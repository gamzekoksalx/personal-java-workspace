import java.util.Comparator;
import java.util.Scanner;

/**
 * Main class that reads 5 people, shows the queue,
 * then sorts by last name (descending) and by age (descending).
 */
public class PeopleSorter {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PersonQueue queue = new PersonQueue();

        System.out.println("Enter details for five individuals below.");

        int count = 0;
        while (count < 5) {
            System.out.println("Person " + (count + 1));
            String first = readNonEmpty(input, "First name: ");
            String last = readNonEmpty(input, "Last name: ");
            int age = readPositiveInt(input, "Age: ");

            try {
                Person p = new Person(first, last, age);
                queue.add(p);
                count++;
                System.out.println();
            } catch (IllegalArgumentException ex) {
                // should not normally happen because we validated, but keep it safe
                System.out.println("Could not add person: " + ex.getMessage());
            }
        }

        // original order
        queue.display("Queue before sorting:");

        // sort by last name, descending (Z → A)
        queue.quickSort(new Comparator<Person>() {
            @Override
            public int compare(Person a, Person b) {
                return a.getLast().compareToIgnoreCase(b.getLast());
            }
        });
        queue.display("Queue sorted by last name (Z to A):");

        // sort by age, descending (older first)
        queue.quickSort(new Comparator<Person>() {
            @Override
            public int compare(Person a, Person b) {
                return Integer.compare(a.getAge(), b.getAge());
            }
        });
        queue.display("Queue sorted by age (oldest to youngest):");
    }

    // read non-empty string from user
    private static String readNonEmpty(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine();
            if (line != null && !line.trim().isEmpty()) {
                return line.trim();
            }
            System.out.println("Please enter a value.");
        }
    }

    // read positive integer from user
    private static int readPositiveInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine();
            try {
                int val = Integer.parseInt(line.trim());
                if (val > 0) {
                    return val;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Please enter a valid positive number.");
        }
    }
}