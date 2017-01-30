package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Block;
import seedu.addressbook.data.person.Street;
import seedu.addressbook.data.person.Unit;
import seedu.addressbook.data.person.PostalCode;


/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must contain (in order) block, street, unit and postal code";
    public static final String ADDRESS_VALIDATION_REGEX = ".+, .+, .+, .+";

    private final String ADDRESS_COMPONENT_SPLITTER = ", ";
    private boolean _isPrivate;
    private Block _block;
    private Street _street;
    private Unit _unit;
    private PostalCode _postalCode;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean _isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this._isPrivate = _isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }

        String[] componentsOfAddress = trimmedAddress.split(ADDRESS_COMPONENT_SPLITTER);

        _block = new Block(componentsOfAddress[0]);
        _street = new Street(componentsOfAddress[1]);
        _unit = new Unit(componentsOfAddress[2]);
        _postalCode = new PostalCode(componentsOfAddress[3]);
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        String[] componentsOfAddress = {_block.getBlock(), _street.getStreet(), _unit.getUnit(), _postalCode.getPostalCode()};
        return String.join(", ", componentsOfAddress);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.toString().equals(((Address) other).toString())); // state check
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    public boolean isPrivate() {
        return _isPrivate;
    }
}
