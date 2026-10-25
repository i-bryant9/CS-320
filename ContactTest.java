/*
Isaiah Bryant
CS 320 
Professor Norman

*/
package Contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactTest {

	// values reused by most tests, so each test only changes one thing
	private static final String ID = "1";
	private static final String FIRST = "Isaiah";
	private static final String LAST = "Bryant";
	private static final String PHONE = "8675309867";
	private static final String ADDRESS = "123 Main St";

	private Contact createContact() {
		return new Contact(ID, FIRST, LAST, PHONE, ADDRESS);
	}

//test establishing that contact is successfully stored 
	@Test
	void validContactStoresAllValues() {
		Contact contact = new Contact(ID, FIRST, LAST, PHONE, ADDRESS);
		assertEquals("1", contact.getContactId());
		assertEquals("Isaiah", contact.getFirstName());
		assertEquals("Bryant", contact.getLastName());
		assertEquals("8675309867", contact.getPhone());
		assertEquals("123 Main St", contact.getAddress());
	}

//edge case test for max length
	@Test
	void maximumLengthValuesAreAccepted() {
		// ID, first, and last are exactly 10 characters; address is exactly 30
		Contact contact = new Contact("1234567890", "Abcdefghij", "Klmnopqrst", "8675309867",
				"123456789012345678901234567890");
		assertEquals("1234567890", contact.getContactId());
		assertEquals("Abcdefghij", contact.getFirstName());
		assertEquals("Klmnopqrst", contact.getLastName());
		assertEquals("123456789012345678901234567890", contact.getAddress());
	}

	// test to reject null ID
	@Test
	void nullContactIdIsRejected() {
		assertThrows(IllegalArgumentException.class, () -> new Contact(null, FIRST, LAST, PHONE, ADDRESS));
	}

//test with an ID too long
	@Test
	void contactIdTooLongIsRejected() {
		assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", FIRST, LAST, PHONE, ADDRESS));
	}

	// test null first name is rejected
	@Test
	void nullFirstNameIsRejected() {
		assertThrows(IllegalArgumentException.class, () -> new Contact(ID, null, LAST, PHONE, ADDRESS));
	}

	// test first name is too long
	@Test
	void firstNameTooLongIsRejected() {
		assertThrows(IllegalArgumentException.class, () -> new Contact(ID, "Abcdefghijk", LAST, PHONE, ADDRESS));
	}

	// test rejecting null last name

	@Test
	void nullLastNameIsRejected() {
		assertThrows(IllegalArgumentException.class, () -> new Contact(ID, FIRST, null, PHONE, ADDRESS));
	}

	// test catching a last name too long
	@Test
	void lastNameTooLongIsRejected() {
		assertThrows(IllegalArgumentException.class, () -> new Contact(ID, FIRST, "Abcdefghijk", PHONE, ADDRESS));
	}

	// test for null phone number
	@Test
	void nullPhoneIsRejected() {
		assertThrows(IllegalArgumentException.class, () -> new Contact(ID, FIRST, LAST, null, ADDRESS));
	}

	// test for phone number too short
	@Test
	void phoneTooShortIsRejected() {
		assertThrows(IllegalArgumentException.class, () -> new Contact(ID, FIRST, LAST, "867530986", ADDRESS));
	}

	// test phone number too long
	@Test
	void phoneTooLongIsRejected() {
		assertThrows(IllegalArgumentException.class, () -> new Contact(ID, FIRST, LAST, "86753098675", ADDRESS));
	}

	// test a character in the phone number
	@Test
	void phoneWithLetterIsRejected() {
		assertThrows(IllegalArgumentException.class, () -> new Contact(ID, FIRST, LAST, "867530986a", ADDRESS));
	}

	// test a null address
	@Test
	void nullAddressIsRejected() {
		assertThrows(IllegalArgumentException.class, () -> new Contact(ID, FIRST, LAST, PHONE, null));
	}

	// test an address too long
	@Test
	void addressTooLongIsRejected() {
		assertThrows(IllegalArgumentException.class,
				() -> new Contact(ID, FIRST, LAST, PHONE, "1234567890123456789012345678901"));
	}

	// test successful setting of first name
	@Test
	void setFirstNameValue() {
		Contact contact = createContact();
		contact.setFirstName("Jordan");
		assertEquals("Jordan", contact.getFirstName());
	}

	// test last name setter is successful
	@Test
	void setLastNameValue() {
		Contact contact = createContact();
		contact.setLastName("Smith");
		assertEquals("Smith", contact.getLastName());
	}

	// test phone setter is successful
	@Test
	void setPhoneValue() {
		Contact contact = createContact();
		contact.setPhone("5559876543");
		assertEquals("5559876543", contact.getPhone());
	}

	// test address setter is successful
	@Test
	void setAddressValue() {
		Contact contact = createContact();
		contact.setAddress("456 Oak Ave");
		assertEquals("456 Oak Ave", contact.getAddress());
	}

	// test first name setter with null
	@Test
	void setFirstNameRejectsNull() {
		Contact contact = createContact();
		assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
	}

	// test first name setter with too long
	@Test
	void setFirstNameRejectsTooLong() {
		Contact contact = createContact();
		assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("Abcdefghijk"));
	}

	// test last name setter with null
	@Test
	void setLastNameRejectsNull() {
		Contact contact = createContact();
		assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
	}

	// test last name setter with value too long
	@Test
	void setLastNameRejectsTooLong() {
		Contact contact = createContact();
		assertThrows(IllegalArgumentException.class, () -> contact.setLastName("Abcdefghijk"));
	}

	// test phone setter rejects null value
	@Test
	void setPhoneRejectsNull() {
		Contact contact = createContact();
		assertThrows(IllegalArgumentException.class, () -> contact.setPhone(null));
	}

	// test phone setter with character
	@Test
	void setPhoneRejectsWrongFormat() {
		Contact contact = createContact();
		assertThrows(IllegalArgumentException.class, () -> contact.setPhone("2567028d65"));
	}

	// test phone number setter with value to short
	@Test
	void setPhoneRejectsTooShort() {
		Contact contact = createContact();
		assertThrows(IllegalArgumentException.class, () -> contact.setPhone("256"));
	}

	// test address setter rejects null
	@Test
	void setAddressRejectsNull() {
		Contact contact = createContact();
		assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
	}

	// test address setter with value too long
	@Test
	void setAddressRejectsTooLong() {
		Contact contact = createContact();
		assertThrows(IllegalArgumentException.class, () -> contact.setAddress("1234567890123456789012345678901"));
	}
}