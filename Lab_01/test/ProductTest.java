import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product p1, p2, p3;
    @BeforeEach
    void setUp() {
        p1 = new Product("1", "Product 1", "Description 1", 10.0);
        p2 = new Product("2", "Product 2", "Description 2", 20.0);
        p3 = new Product("3", "Product 3", "Description 3", 30.0);
    }

    @Test
    void setID() {
       p1.setID("4");
        assertEquals("4", p1.getID());
        p2.setID("5");
        assertEquals("5", p2.getID());
        p3.setID("6");
        assertEquals("6", p3.getID());
    }

    @Test
    void setName() {
        p1.setName("Product 4");
        assertEquals("Product 4", p1.getName());
        p2.setName("Product 5");
        assertEquals("Product 5", p2.getName());
        p3.setName("Product 6");
        assertEquals("Product 6", p3.getName());
    }

    @Test
    void setDescription() {
        p1.setDescription("Description 4");
        assertEquals("Description 4", p1.getDescription());
        p2.setDescription("Description 5");
        assertEquals("Description 5", p2.getDescription());
        p3.setDescription("Description 6");
        assertEquals("Description 6", p3.getDescription());
    }

    @Test
    void setCost() {
        p1.setCost(40.0);
        assertEquals(40.0, p1.getCost());
        p2.setCost(50.0);
        assertEquals(50.0, p2.getCost());
        p3.setCost(60.0);
        assertEquals(60.0, p3.getCost());
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
}