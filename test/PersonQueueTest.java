import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Comparator;
import java.lang.reflect.Field;
import java.util.List;

/**
 * JUnit tests for Person and PersonQueue.
 */
public class PersonQueueTest {

    @Test
    public void testValidPerson() {
        Person p = new Person("Gamze", "Köksal", 30);
        assertEquals("Gamze", p.getFirst());
        assertEquals("Köksal", p.getLast());
        assertEquals(30, p.getAge());
    }

    @Test
    public void testInvalidPersonData() {
        assertThrows(IllegalArgumentException.class, () -> new Person("", "Wick", 35));
        assertThrows(IllegalArgumentException.class, () -> new Person("Harry", "", -10));
    }

    @Test
    public void testSortByAgeDescending() throws Exception {
        PersonQueue q = new PersonQueue();
        q.add(new Person("John", "Wick", 45));
        q.add(new Person("Harry", "Potter", 20));
        q.add(new Person("Anakin", "Skywalker", 35));

        q.quickSort(Comparator.comparingInt(Person::getAge));

        // Access internal list for checking
        Field f = PersonQueue.class.getDeclaredField("items");
        f.setAccessible(true);
        List<Person> list = (List<Person>) f.get(q);

        assertEquals("John", list.get(0).getFirst());
    }

    @Test
    public void testSortByLastNameDescending() throws Exception {
        PersonQueue q = new PersonQueue();
        q.add(new Person("Santosh", "Gottipamula", 40));
        q.add(new Person("Gamze", "Köksal", 29));
        q.add(new Person("Harry", "Potter", 25));

        q.quickSort(Comparator.comparing(Person::getLast));

        Field f = PersonQueue.class.getDeclaredField("items");
        f.setAccessible(true);
        List<Person> list = (List<Person>) f.get(q);

        assertEquals("Potter", list.get(0).getLast());
    }
}