/**
 * Represents a student with roll number, name, and address.
 */
public class Student {
    private final int rollno;
    private final String name;
    private final String address;

    /**
     * Creates a student with validation.
     * @param rollno student roll number (must not be negative or zero)
     * @param name student name (must not be null or blank)
     * @param address student address (must not be null or blank)
     * @throws IllegalArgumentException if inputs are invalid
     */
    public Student(int rollno, String name, String address) {
        if (rollno < 0) {
            throw new IllegalArgumentException("rollno cannot be negative");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("name cannot be null or blank");
        }
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("address cannot be null or blank");
        }
        this.rollno = rollno;
        this.name = name.trim();
        this.address = address.trim();
    }

    public int getRollno() { return rollno; }
    public String getName() { return name; }
    public String getAddress() { return address; }

    @Override
    public String toString() {
        return rollno + " - " + name + " (" + address + ")";
    }
}