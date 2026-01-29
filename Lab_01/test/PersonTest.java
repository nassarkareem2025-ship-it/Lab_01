import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
Person p1,p2,p3;

@BeforeEach
void setUp() {
    p1 = new Person("0000000A", "John", "Doe", "Dr.", 1980);
    p2 = new Person("0000000B", "Jane", "Smith", "Prof.", 1975);
    p3 = new Person("0000000C", "Alice", "Johnson", "Prof.", 1985);
}

    @Test
    void setIDNum() {
    p1.setIDNum("0000000D");
    assertEquals("0000000D", p1.getIDNum());
    p2.setIDNum("0000000E");
    assertEquals("0000000E", p2.getIDNum());
    p3.setIDNum("0000000F");
    assertEquals("0000000F", p3.getIDNum());
    }

    @Test
    void setFirstName() {
    p1.setFirstName("Johnny");
    assertEquals("Johnny", p1.getFirstName());
    p2.setFirstName("Jane");
    assertEquals("Jane", p2.getFirstName());
    p3.setFirstName("Alice");
    assertEquals("Alice", p3.getFirstName());
    }

    @Test
    void setLastname() {
    p1.setLastname("Smith");
    assertEquals("Smith", p1.getLastname());
    p2.setLastname("Johnson");
    assertEquals("Johnson", p2.getLastname());
    p3.setLastname("Williams");
    assertEquals("Williams", p3.getLastname());
    }

    @Test
    void setTitle() {
    p1.setTitle("Mr.");
    assertEquals("Mr.", p1.getTitle());
    p2.setTitle("Mrs.");
    assertEquals("Mrs.", p2.getTitle());
    p3.setTitle("Ms.");
    assertEquals("Ms.", p3.getTitle());
    }

    @Test
    void setYOB() {
    p1.setYOB(1981);
    assertEquals(1981, p1.getYOB());
    p2.setYOB(1976);
    assertEquals(1976, p2.getYOB());
    p3.setYOB(1986);
    assertEquals(1986, p3.getYOB());
    }

    @Test
    void testToString() {
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
    }

    @Test
    void toCSVRecord() {
        System.out.println(p1.toCSVRecord());
        System.out.println(p2.toCSVRecord());
        System.out.println(p3.toCSVRecord());
    }

    @Test
    void toJSONRecord() {
        System.out.println(p1.toJSONRecord());
        System.out.println(p2.toJSONRecord());
        System.out.println(p3.toJSONRecord());
    }

    @Test
    void toXML() {
        System.out.println(p1.toXML());
        System.out.println(p2.toXML());
        System.out.println(p3.toXML());
    }

    @Test
    void fullName() {
        System.out.println(p1.fullName());
        System.out.println(p2.fullName());
        System.out.println(p3.fullName());
    }

    @Test
    void formalName() {
        System.out.println(p1.FormalName());
        System.out.println(p2.FormalName());
        System.out.println(p3.FormalName());
    }

    @Test
    void getAge() {
        System.out.println(p1.getAge());
        System.out.println(p2.getAge());
        System.out.println(p3.getAge());
    }

    @Test
    void testGetAge() {
        System.out.println(p1.getAge());
        System.out.println(p2.getAge());
        System.out.println(p3.getAge());
    }
}