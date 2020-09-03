package com.addressbook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;


public class AddressBook {

    private static final EnumMap<Option,Comparator<ContactDetail>> comparatorMap =new EnumMap<>(AddressBook.Option.class);
    static{
        comparatorMap.put(Option.FIRST_NAME,Comparator.comparing(contactDetail -> contactDetail.firstName));
        comparatorMap.put(Option.ZIP_CODE,Comparator.comparing(contactDetail -> contactDetail.zipCode));
    }
    public enum Option {ZIP_CODE, CITY, STATE, FIRST_NAME, PHONE_NUMBER}
    List<ContactDetail> addressBook;
    private final int unknownContactPosition =-1;
    private static final AddressBookFileManager addressBookFileManager =new AddressBookFileManager();

    public AddressBook() {
        this.addressBook =  new ArrayList<>();
    }

    public void addContact(String firstName, String lastName, String phoneNumber, String city, String state, String zipCode) throws AddressBookException {
        if(firstName.length()==0 || phoneNumber.length()==0)
            throw new AddressBookException(AddressBookException.ExceptionType.EMPTY_VALUE,"Name or phone number can't be empty");
        addressBook.add(new ContactDetail(firstName, lastName, phoneNumber, city, state, zipCode));
    }

    public int getAddressBookSize() {
        return this.addressBook.size();
    }

    public String getContactDetailsOf(String firstName) throws AddressBookException {
        int positionOfContact=getPositionOf(firstName);
        if(positionOfContact!= unknownContactPosition)
            return addressBook.get(positionOfContact)
                                  .toString();
        throw new AddressBookException(AddressBookException.ExceptionType.CONTACT_NOT_FOUND,"Required contact is not present in book");
    }

    public int getPositionOf(String firstName) {
        for(int position = 0; position < getAddressBookSize(); position++ )
            if(addressBook.get(position)
                              .firstName
                              .equalsIgnoreCase(firstName))
                return position;
        return unknownContactPosition;
    }

    public boolean searchContact(String firstName) {
        for(ContactDetail contact: addressBook){
            if(contact.firstName.equalsIgnoreCase(firstName))
                return true;
        }
        return false;
    }

    public void deleteContact(String firstName) {
        if(searchContact(firstName))
            addressBook.remove(getPositionOf(firstName));
    }

    public void edit(Option option, String contactName, String value) {
        if (searchContact(contactName)) {
            int contactPosition = getPositionOf(contactName);
            switch (option) {
                case PHONE_NUMBER:
                    addressBook.get(contactPosition).phoneNumber= value ;
                    break;
                case ZIP_CODE:
                    addressBook.get(contactPosition).zipCode= value ;
                    break;
                case CITY:
                    addressBook.get(contactPosition).city= value ;
                    break;
                case STATE:
                    addressBook.get(contactPosition).state= value ;
                    break;
                default:
                    break;
            }
        }
    }

    public void sort(Option option) throws AddressBookException {
        try{
            this.addressBook = addressBook.stream()
                                                 .sorted(comparatorMap.get(option))
                                                 .collect(Collectors.toList());
        }catch (NullPointerException exception){
            throw new AddressBookException(AddressBookException.ExceptionType.INVALID_OPTION,"Invalid option for sorting");
        }
    }

    public void save() throws AddressBookException {
        this.sort(Option.FIRST_NAME);
        addressBookFileManager.saveAddressBook(addressBook);
    }

    public void saveAs(String addressBookName) throws AddressBookException {
        this.sort(Option.FIRST_NAME);
        addressBookFileManager.saveAddressBook(addressBook,addressBookName);
    }

    public void open(String addressBookName) throws AddressBookException {
        this.addressBook= addressBookFileManager.getAddressBook(addressBookName);
    }

    public void createNewAddressBook(String newAddressBookName) throws AddressBookException {
        this.addressBook=addressBookFileManager.getNewAddressBook(newAddressBookName);
    }

}
