/**
 * Demo program to show how the Bag class works
 * using a library checkout example, with minimal validation.
 */
public class BagDemo {
    public static void main(String[] args) {
        Bag<String> books = new Bag<>();

        try {
            // Add books (with duplicates)
            books.add("Harry Potter");
            books.add("The Hobbit");
            books.add("Harry Potter");
            books.add("1984");
            books.add("Harry Potter");
            // books.add("");   // example invalid input
            // books.add(null); // example invalid input

            System.out.println("Library checkout bag:");
            books.printBag();

            // Check if certain books are in the bag
            System.out.println("Contains Harry Potter? " + books.contains("Harry Potter"));
            System.out.println("Contains Dune? " + books.contains("Dune"));

            // Count book frequencies
            System.out.println("Count of Harry Potter: " + books.count("Harry Potter"));
            System.out.println("Count of The Hobbit: " + books.count("The Hobbit"));

            // Remove a book (with validation)
            String toRemove = "Harry Potter";
            if (toRemove != null && !toRemove.isBlank()) {
                books.remove(toRemove);
            } else {
                System.out.println("Invalid book title, cannot remove.");
            }

            System.out.println("\nBag after returning one Harry Potter:");
            books.printBag();

            // Check again
            System.out.println("Contains Harry Potter? " + books.contains("Harry Potter"));
            System.out.println("Count of Harry Potter: " + books.count("Harry Potter"));

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
