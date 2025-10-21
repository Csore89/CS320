package contactservice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {

    @Test
    void testAddAndGetContact() {
        ContactService service = new ContactService();
        Contact c = new Contact("1", "John", "Doe", "1234567890", "123 Street");
        service.addContact(c);
        assertEquals(c, service.getContact("1"));
    }

    @Test
    void testDeleteContact() {
        ContactService service = new ContactService();
        Contact c = new Contact("1", "John", "Doe", "1234567890", "123 Street");
        service.addContact(c);
        service.deleteContact("1");
        assertNull(service.getContact("1"));
    }

    @Test
    void testUpdateContact() {
        ContactService service = new ContactService();
        Contact c = new Contact("1", "John", "Doe", "1234567890", "123 Street");
        service.addContact(c);
        service.updateContact("1", "Jane", null, null, null);
        assertEquals("Jane", service.getContact("1").getFirstName());
    }

    @Test
    void testAddDuplicateContact() {
        ContactService service = new ContactService();
        Contact c1 = new Contact("1", "John", "Doe", "1234567890", "123 Street");
        Contact c2 = new Contact("1", "Jane", "Smith", "0987654321", "456 Avenue");
        service.addContact(c1);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(c2));
    }
}
