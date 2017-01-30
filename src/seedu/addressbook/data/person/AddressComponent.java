package seedu.addressbook.data.person;

abstract class AddressComponent {
	protected final String value;
	
	AddressComponent(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
