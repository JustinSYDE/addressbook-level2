package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Contact from which Person, Email and Address inherit 
 */
public abstract class Contact {
	public final String value;
	private boolean isPrivate;
	
	/**
     * Validates given contact.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Contact(String contact, boolean isPrivate) {
        String trimmedContact = contact.trim();
        this.isPrivate = isPrivate;
        // Assuming that we can't change the method declaration of Address, Email and Phone constructors
        // then have the subclasses carry out field validation
        this.value = trimmedContact;
    }
    
    @Override
    public int hashCode() {
        return value.hashCode();
    }
    
    public boolean isPrivate() {
        return isPrivate;
    }
    
    @Override
    public String toString() {
        return value;
    }
    
    @Override
    public boolean equals(Object other) {
    	return other == this // short circuit if same object
    			|| (getClass().isInstance(other) 
    			&& this.value.equals(getClass().cast(other).value));
    }
}
