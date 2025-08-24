import java.util.Comparator;

/**
 * Comparator to sort students by roll number (ascending).
 * Null students come last.
 */
public class ByRollNo implements Comparator<Student> {
    @Override public int compare(Student a, Student b) {
        if (a == b) return 0;
        if (a == null) return 1;
        if (b == null) return -1;
        return Integer.compare(a.getRollno(), b.getRollno());
    }
}