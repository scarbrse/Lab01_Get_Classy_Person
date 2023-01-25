import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person p1, p2, p3;
    @BeforeEach
    void setUp() {

        p1 = new Person("00000A", "Bob", "Tester1", "Mr.", 1955);
        p2 = new Person("00000A", "Sally", "Tester2", "Mrs.", 1975);
        p3 = new Person("00000A", "John", "Tester3", "Esq.", 1960);

    }

    @Test
    void setIDSeed() {
        p1.setID("00000B");
        assertEquals("00000B", p1.getID());
    }

    @Test
    void setID() {
        p1.setID("00000B");
        assertEquals("00000B", p1.getID());
    }

    @Test
    void setFirstName() {
        p1.setFirstName("Bob");
        assertEquals("Bob", p1.getFirstName());
    }

    @Test
    void setLastName() {
        p2.setLastName("Tester2");
        assertEquals("Tester2", p2.getLastName());
    }

    @Test
    void setTitle() {
        p3.setTitle("Esq.");
        assertEquals("Esq.", p3.getTitle());
    }

    @Test
    void setYob() {
        p3.setYob(1960);
        assertEquals(1960, p3.getYob());
    }

    @Test
    void testToString() {
        p1.setFirstName("Bob");
        assertEquals("Bob", p1.getFirstName());
    }

    @Test
    void fullName() {
        p1.setFirstName("Bob");
        p1.setLastName("Tester1");
        assertEquals("Bob Tester1", p1.fullName());
    }

    @Test
    void formalName() {
        p2.setTitle("Mrs.");
        p2.fullName();
        assertEquals("Mrs. Sally Tester2", p2.formalName());
    }

    @Test
    void toCSV() {
        assertEquals("00000A, Bob, Tester1, Mr., 1955", p1.toCSV());
    }
}