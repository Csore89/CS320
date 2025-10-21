package contactservice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    @Test
    void testValidContactCreation() {
        Contact c = new Contact("1", "John", "Doe", "1234567890", "123 Street");
        assertEquals("John", c.getFirstName());
    }

    @Test
    void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "John", "Doe", "1234567890", "123 Street"));
    }

    @Test
    void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "John", "Doe", "12345", "123 Street"));
    }

    @Test
    void testUpdateFirstName() {
        Contact c = new Contact("1", "John", "Doe", "1234567890", "123 Street");
        c.setFirstName("Jane");
        assertEquals("Jane", c.getFirstName());
    }
}
