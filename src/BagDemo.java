/**
 * Demonstrates the usage of the Bag class with city names.
 */
public class BagDemo {
    public static void main(String[] args) {
        Bag<String> bag1 = new Bag<>();
        Bag<String> bag2 = new Bag<>();

        // Add cities (with duplicates)
        bag1.add("New York");
        bag1.add("New York");
        bag1.add("Los Angeles");

        bag2.add("Istanbul");
        bag2.add("Ankara");
        bag2.add("Ankara");

        // Print sizes of both bags
        System.out.println("Bag1 size: " + bag1.size());
        System.out.println("Bag2 size: " + bag2.size());

        // Merge bag2 into bag1 and print results
        bag1.merge(bag2);
        System.out.println("Merged Bag contents:");
        bag1.printBag();

        // Create distinct bag and print results
        Bag<String> distinctBag = bag1.distinct();
        System.out.println("Distinct Bag contents:");
        distinctBag.printBag();
    }
}