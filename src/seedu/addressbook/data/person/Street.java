package seedu.addressbook.data.person;

/**
 * Represents the street of a Person's Address.
 */

public class Street {
  private final String _value;

  public Street(String street) {
    this._value = street;
  }

  public String getStreet() {
    return this._value;
  }
}
