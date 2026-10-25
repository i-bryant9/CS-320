/*
Isaiah Bryant
CS 320 
Professor Norman

*/
package Contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactServiceTest {

	// Small helper to reduce redundancy
	private Contact makeContact(String id) {
		return new Contact(id, "Isaiah", "Bryant", "8675309867", "123 Main St");
	}

//test establishing new contact is added to the map
	@Test
	void addContactStoresIt() {
		ContactService service = new ContactService();
		Contact contact = makeContact("1");
		service.addContact(contact);
		assertEquals(contact, service.getContact("1"));
	}

//test multiple contacts are added 
	@Test
	void addMultipleContactsStoresAll() {
		ContactService service = new ContactService();
		Contact first = makeContact("1");
		Contact second = makeContact("2");
		service.addContact(first);
		service.addContact(second);
		assertEquals(first, service.getContact("1"));
		assertEquals(second, service.getContact("2"));
	}

//test no two contacts with same id can be added 
	@Test
	void addDuplicateIdIsRejected() {
		ContactService service = new ContactService();
		service.addContact(makeContact("1"));
		assertThrows(IllegalArgumentException.class, () -> service.addContact(makeContact("1")));
	}

//test null contact cannot be added 
	@Test
	void addNullContactIsRejected() {
		ContactService service = new ContactService();
		assertThrows(IllegalArgumentException.class, () -> service.addContact(null));
	}

//test contact is successfully removed
	@Test
	void deleteContactRemovesIt() {
		ContactService service = new ContactService();
		service.addContact(makeContact("1"));
		service.deleteContact("1");
		assertNull(service.getContact("1"));
	}

//test deleting a contact that doesn't exist fails
	@Test
	void deleteMissingIdIsRejected() {
		ContactService service = new ContactService();
		assertThrows(IllegalArgumentException.class, () -> service.deleteContact("99"));
	}

//test first name of contact is successfully changed
	@Test
	void updateFirstNameChangesIt() {
		ContactService service = new ContactService();
		service.addContact(makeContact("1"));
		service.updateFirstName("1", "Jordan");
		assertEquals("Jordan", service.getContact("1").getFirstName());
	}

//test last name of contact is successfully changed 
	@Test
	void updateLastNameChangesIt() {
		ContactService service = new ContactService();
		service.addContact(makeContact("1"));
		service.updateLastName("1", "Smith");
		assertEquals("Smith", service.getContact("1").getLastName());
	}

//test phone is successfully changed 
	@Test
	void updatePhoneChangesIt() {
		ContactService service = new ContactService();
		service.addContact(makeContact("1"));
		service.updatePhone("1", "8675309868");
		assertEquals("8675309868", service.getContact("1").getPhone());
	}

//test successful address change
	@Test
	void updateAddressChangesIt() {
		ContactService service = new ContactService();
		service.addContact(makeContact("1"));
		service.updateAddress("1", "456 Oak Ave");
		assertEquals("456 Oak Ave", service.getContact("1").getAddress());
	}

//test update first name of non existing contact
	@Test
	void updateFirstNameMissingIdIsRejected() {
		ContactService service = new ContactService();
		assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("99", "Jordan"));
	}

	// test update last name of non existing contact
	@Test
	void updateLastNameMissingIdIsRejected() {
		ContactService service = new ContactService();
		assertThrows(IllegalArgumentException.class, () -> service.updateLastName("99", "Smith"));
	}

	// test update phone of non existing contact
	@Test
	void updatePhoneMissingIdIsRejected() {
		ContactService service = new ContactService();
		assertThrows(IllegalArgumentException.class, () -> service.updatePhone("99", "5559876543"));
	}

	// test update address of non existing contact
	@Test
	void updateAddressMissingIdIsRejected() {
		ContactService service = new ContactService();
		assertThrows(IllegalArgumentException.class, () -> service.updateAddress("99", "456 Oak Ave"));
	}

//test update with invalid first name
	@Test
	void updateFirstNameWithInvalidValueIsRejected() {
		ContactService service = new ContactService();
		service.addContact(makeContact("1"));
		assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("1", null));
	}

//test update with invalid last name
	@Test
	void updateLastNameWithInvalidValueIsRejected() {
		ContactService service = new ContactService();
		service.addContact(makeContact("1"));
		assertThrows(IllegalArgumentException.class, () -> service.updateLastName("1", "Abcdefghijk"));
	}

//test update with phone too short 
	@Test
	void updatePhoneWithInvalidValueIsRejected() {
		ContactService service = new ContactService();
		service.addContact(makeContact("1"));
		assertThrows(IllegalArgumentException.class, () -> service.updatePhone("1", "123"));
	}

//test address update with value to long
	@Test
	void updateAddressWithInvalidValueIsRejected() {
		ContactService service = new ContactService();
		service.addContact(makeContact("1"));
		assertThrows(IllegalArgumentException.class,
				() -> service.updateAddress("1", "1234567890123456789012345678901"));
	}
}