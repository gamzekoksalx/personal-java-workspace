/**
 * Represents a student with roll number, name, and address.
 */
public class Student {
    private final int rollno;
    private final String name;
    private final String address;

    /**
     * Creates a student with basic validation.
     * @param rollno student roll number (> 0)
     * @param name student name (non-blank)
     * @param address student address (non-blank)
     * @throws IllegalArgumentException if inputs are invalid
     */
    public Student(int rollno, String name, String address) {
        if (rollno <= 0) throw new IllegalArgumentException("rollno must be > 0");
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("name required");
        if (address == null || address.trim().isEmpty()) throw new IllegalArgumentException("address required");
        this.rollno = rollno;
        this.name = name.trim();
        this.address = address.trim();
    }

    public int getRollno() { return rollno; }
    public String getName() { return name; }
    public String getAddress() { return address; }

    @Override public String toString() { return rollno + " - " + name + " (" + address + ")"; }
}