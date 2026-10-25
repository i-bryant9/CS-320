/*
Isaiah Bryant
CS 320 
Professor Norman

*/
package Contact;

public class Contact {
	// variables- with id final as it can only be set once, all private as getters
	// and setters must be used
	private final String contactId;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;

// constructor
	public Contact(String contactId, String firstName, String lastName, String phone, String address) {
		// checks if contactID is null or length is more than the required 10
		if (contactId == null || contactId.length() > 10) {
			// Exception is thrown if these aren't met
			throw new IllegalArgumentException("Invalid contact ID");
		}
		this.contactId = contactId;
		setFirstName(firstName);
		setLastName(lastName);
		setPhone(phone);
		setAddress(address);
	}

// Getters 

	public String getContactId() {
		return contactId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

// setters with requirement checks 

	public void setFirstName(String firstName) {
		// if first name is null or greater than 10 exception is thrown
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		// else the variable is set
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		// if last name is null or greater than 10 exception is thrown
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		// else the variable is set
		this.lastName = lastName;
	}

	public void setPhone(String phone) {
		// phone must be a length of 10 and composed of digits and not null
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		// checks for digits
		for (char c : phone.toCharArray()) {
			if (!Character.isDigit(c)) {
				throw new IllegalArgumentException("Invalid phone number");
			}
		}
		// else the variable is set
		this.phone = phone;
	}

	public void setAddress(String address) {
		// address must be at most a length of 30 and not null
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		// else the variable is set
		this.address = address;
	}
}