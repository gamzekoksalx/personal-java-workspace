/**
 * Represents a person with first name, last name, and age.
 */
public class Person {
    private String first;
    private String last;
    private int age;

    public Person(String first, String last, int age) {
        // basic validation to avoid bad objects
        if (first == null || first.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty.");
        }
        if (last == null || last.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty.");
        }
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be positive.");
        }
        this.first = first.trim();
        this.last = last.trim();
        this.age = age;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return first + " " + last + " - " + age + " years old";
    }
}