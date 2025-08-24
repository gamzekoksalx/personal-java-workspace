import java.util.Comparator;

/**
 * Comparator to sort students by name (case-insensitive).
 * Null students come last; null names are treated as empty strings.
 */
public class ByName implements Comparator<Student> {
    @Override public int compare(Student a, Student b) {
        if (a == b) return 0;
        if (a == null) return 1;
        if (b == null) return -1;
        String na = a.getName(), nb = b.getName();
        if (na == null) na = "";
        if (nb == null) nb = "";
        return na.compareToIgnoreCase(nb);
    }
}