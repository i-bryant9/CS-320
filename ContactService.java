/*
Isaiah Bryant
CS 320 
Professor Norman

*/
package Contact;

import java.util.HashMap;
import java.util.Map;

//map to store values 
public class ContactService {
	private final Map<String, Contact> contacts = new HashMap<>();

	// adds a contact throws if the contact is null or the ID already exists
	public void addContact(Contact contact) {
		if (contact == null) {
			throw new IllegalArgumentException("Contact cannot be null");
		}
		if (contacts.putIfAbsent(contact.getContactId(), contact) != null) {
			throw new IllegalArgumentException("Contact ID already exists");
		}
	}

// method for deleting contact if contact is not found throws exception
	public void deleteContact(String contactId) {
		if (contacts.remove(contactId) == null) {
			throw new IllegalArgumentException("Contact not found");
		}
	}

//method for updating first name 
	public void updateFirstName(String contactId, String firstName) {
		findContact(contactId).setFirstName(firstName);
	}

//method for updating last name
	public void updateLastName(String contactId, String lastName) {
		findContact(contactId).setLastName(lastName);
	}

//method for updating phone
	public void updatePhone(String contactId, String phone) {
		findContact(contactId).setPhone(phone);
	}

//method for updating address
	public void updateAddress(String contactId, String address) {
		findContact(contactId).setAddress(address);
	}

//method for getting contact
	public Contact getContact(String contactId) {
		return contacts.get(contactId);
	}

// method for ContactService to address a specific contact
	private Contact findContact(String contactId) {
		Contact contact = contacts.get(contactId);
		if (contact == null) {
			throw new IllegalArgumentException("Contact not found");
		}
		return contact;
	}
}