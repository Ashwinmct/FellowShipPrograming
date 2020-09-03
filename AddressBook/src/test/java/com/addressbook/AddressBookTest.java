package com.addressbook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.io.File;
import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;


@RunWith(MockitoJUnitRunner.Silent.class)
public class AddressBookTest {
    private static final String ADDRESS_BOOK_NAME_TO_OPEN ="AddressBook2" ;
    private static final String WRONG_ADDRESS_BOOK_NAME ="WrongAddressBook" ;
    private static final String NEW_ADDRESS_BOOK_NAME ="NewAddressBook" ;
    private static final String EMPTY_ADDRESS_BOOK_CREATION_NAME ="EmptyAddressBook" ;
    private static final String DEFAULT_FILE_PATH =".\\src\\main\\resources\\" ;

    @Rule
    public MockitoRule mockitoRule= MockitoJUnit.rule().silent();
    @Mock
    public AddressBookFileManager addressBookFileManager=new AddressBookFileManager();
    @InjectMocks
    public AddressBook addressBook;

    @Before
    public void setUp(){
        addressBook=new AddressBook();
    }

    @Test
    public void checkingNewContactIsAddedToAddressBookOrNot() {
        int addressBookSizeBeforeAddingContacts=addressBook.getAddressBookSize();
        try {
            addressBook.addContact("Ashwin","B","1234567890","Bangalore","Karnataka","560 100");
            addressBook.addContact("Vicky","G","1234567890","Bangalore","Karnataka","560 200");
        } catch (AddressBookException e) {
            e.printStackTrace();
        }
        int addressBookSizeAfterAddingContacts=addressBook.getAddressBookSize();
        Assert.assertEquals(addressBookSizeAfterAddingContacts,addressBookSizeBeforeAddingContacts+2);
    }

    @Test
    public void givenContactsFirstNameOrPhoneNumberIsEmpty_whenAddedToAddressBook_shouldThrowException() {
        try {
            addressBook.addContact("","B","1234567890","Bangalore","Karnataka","560 100");
            addressBook.addContact("Vicky","G","","Bangalore","Karnataka","560 200");
        } catch (AddressBookException e) {
            Assert.assertEquals(AddressBookException.ExceptionType.EMPTY_VALUE,e.exceptionType);
        }
    }

    @Test
    public void givenFirstNameOfContact_ifPresentInAddressBook_shouldReturnRespectiveContactDetailString() {
            try {
                addressBook.addContact("Ashwin","B","1234567890","Bangalore","Karnataka","560 100");
                addressBook.addContact("Vicky","G","1234567890","Bangalore","Karnataka","560 200");
                String contactDetails= addressBook.getContactDetailsOf("Ashwin");
                Assert.assertEquals("ContactDetail{ firstName:Ashwin, lastName:B, city:Bangalore, state:Karnataka, zipCode:560 100, phoneNumber:1234567890}", contactDetails);
            } catch (AddressBookException e) {
                e.printStackTrace();
            }
    }

    @Test
    public void givenFirstNameOfContact_ifAbsentInAddressBook_shouldThrowException() {
        try {
            addressBook.addContact("Ashwin","B","1234567890","Bangalore","Karnataka","560 100");
            addressBook.getContactDetailsOf("vicky");
        } catch (AddressBookException e) {
            Assert.assertEquals(AddressBookException.ExceptionType.CONTACT_NOT_FOUND,e.exceptionType);
        }
    }

    @Test
    public void givenFirstNameOfContact_ifExistInAddressBook_shouldReturnTrue() {
        try {
            addressBook.addContact("Ashwin","B","1234567890","Bangalore","Karnataka","560 100");
            addressBook.addContact("Vicky","G","1234567890","Bangalore","Karnataka","560 200");
        } catch (AddressBookException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(addressBook.searchContact("Ashwin"));
    }

    @Test
    public void givenFirstNameOfContact_ifNotExistInAddressBook_shouldReturnFalse() {
        try {
            addressBook.addContact("Ashwin","B","1234567890","Bangalore","Karnataka","560 100");
            addressBook.addContact("Vicky","G","1234567890","Bangalore","Karnataka","560 200");
        } catch (AddressBookException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(addressBook.searchContact("Raj"));
    }

    @Test
    public void givenFirstNameOfContact_whenDeleted_shouldRemovedFromAddressBook() {
        try {
            addressBook.addContact("Ashwin","B","1234567890","Bangalore","Karnataka","560 100");
            addressBook.addContact("Vicky","G","1234567890","Bangalore","Karnataka","560 200");
        } catch (AddressBookException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(addressBook.searchContact("Ashwin"));
        addressBook.deleteContact("Ashwin");
        Assert.assertFalse(addressBook.searchContact("Ashwin"));
    }

    @Test
    public void givenContacts_whenEditedByPhoneNumber_shouldUpdateExistingContact() {
        try {
            addressBook.addContact("Ashwin","B","1234567890","Bangalore","Karnataka","560 100");
            addressBook.edit(AddressBook.Option.PHONE_NUMBER,"Ashwin","9234567890");
            Assert.assertEquals("ContactDetail{ firstName:Ashwin, lastName:B, city:Bangalore, state:Karnataka, zipCode:560 100, phoneNumber:9234567890}",addressBook.getContactDetailsOf("Ashwin"));
        } catch (AddressBookException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenContacts_whenEditedByZIPCode_shouldUpdateExistingContact() {
        try {
            addressBook.addContact("Ashwin","B","1234567890","Bangalore","Karnataka","560 100");
            addressBook.edit(AddressBook.Option.ZIP_CODE,"Ashwin","641 001");
            Assert.assertEquals("ContactDetail{ firstName:Ashwin, lastName:B, city:Bangalore, state:Karnataka, zipCode:641 001, phoneNumber:1234567890}",addressBook.getContactDetailsOf("Ashwin"));
        } catch (AddressBookException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenContacts_whenEditedByCityName_shouldUpdateExistingContact() {
        try {
            addressBook.addContact("Ashwin","B","1234567890","Mysore","Karnataka","560 001");
            addressBook.edit(AddressBook.Option.CITY,"Ashwin","Mysore");
            Assert.assertEquals("ContactDetail{ firstName:Ashwin, lastName:B, city:Mysore, state:Karnataka, zipCode:560 001, phoneNumber:1234567890}",addressBook.getContactDetailsOf("Ashwin"));
        } catch (AddressBookException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenContacts_whenEditedByStateName_shouldUpdateExistingContact() {
        try {
            addressBook.addContact("Ashwin","B","1234567890","Coimbatore","Karnataka","641 001");
            addressBook.edit(AddressBook.Option.STATE,"Ashwin","TamilNadu");
            Assert.assertEquals("ContactDetail{ firstName:Ashwin, lastName:B, city:Coimbatore, state:TamilNadu, zipCode:641 001, phoneNumber:1234567890}",addressBook.getContactDetailsOf("Ashwin"));
        } catch (AddressBookException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenContacts_whenSortedByContactName_shouldReturnSortedData() {
        try {
            addressBook.addContact("Vicky","G","1234567890","Bangalore","Karnataka","560 200");
            addressBook.addContact("Ashwin","B","1234567890","Bangalore","Karnataka","560 100");
            addressBook.sort(AddressBook.Option.FIRST_NAME);
            Assert.assertEquals(0,addressBook.getPositionOf("Ashwin"));
        } catch (AddressBookException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenContacts_whenSortedByZIPCode_shouldReturnSortedData() {
        try {
            addressBook.addContact("Vicky","G","1234567890","Bangalore","Karnataka","560 200");
            addressBook.addContact("Ashwin","B","1234567890","Bangalore","Karnataka","560 100");
            addressBook.sort(AddressBook.Option.ZIP_CODE);
            Assert.assertEquals(0,addressBook.getPositionOf("Ashwin"));
        } catch (AddressBookException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenContacts_whenSortedByWrongOption_shouldThrowException() {
        try {
            addressBook.addContact("Vicky","G","1234567890","Bangalore","Karnataka","560 200");
            addressBook.addContact("Ashwin","B","1234567890","Bangalore","Karnataka","560 100");
            addressBook.sort(AddressBook.Option.PHONE_NUMBER);
        } catch (AddressBookException e) {
            Assert.assertEquals(AddressBookException.ExceptionType.INVALID_OPTION,e.exceptionType);
        }
    }

    @Test
    public void givenContacts_whenSaved_shouldSavedInJSONFormatFile() {
        try {
            addressBook.addContact("Vicky","G","1234567890","Bangalore","Karnataka","560 200");
            addressBook.addContact("Ashwin","B","1234567890","Bangalore","Karnataka","560 100");
            addressBook.save();
        } catch (AddressBookException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenAddressBookFile_whenOpened_shouldReturnTotalEntriesInRespectiveFile() {
        try {
            addressBook.open(ADDRESS_BOOK_NAME_TO_OPEN);
        } catch (AddressBookException e) {
            e.printStackTrace();
        }
        int addressBookSize=addressBook.getAddressBookSize();
        Assert.assertEquals(2,addressBookSize);
    }

    @Test
    public void givenNonExistingAddressBookName_whenOpened_shouldThrowException() {
        try {
            addressBook.open(WRONG_ADDRESS_BOOK_NAME);
        } catch (AddressBookException e) {
            Assert.assertEquals(AddressBookException.ExceptionType.ERROR_IN_OPENING,e.exceptionType);
        }
    }

    @Test
    public void givenContacts_whenSavedAs_shouldSavedAsNewJSONFormatFile() {
        try {
            addressBook.addContact("Vicky","G","1234567890","Bangalore","Karnataka","560 200");
            addressBook.addContact("Ashwin","B","1234567890","Bangalore","Karnataka","560 100");
            addressBook.saveAs(NEW_ADDRESS_BOOK_NAME);
            boolean fileExistenceValue=new File(DEFAULT_FILE_PATH +NEW_ADDRESS_BOOK_NAME+".json").exists();
            Assert.assertTrue(fileExistenceValue);
        } catch (AddressBookException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenCreatedNewAddressBook_shouldCreateNewFile() {
        try {
            Mockito.when(addressBookFileManager.getNewAddressBook(anyString())).thenReturn(new ArrayList<>());
            addressBook.createNewAddressBook(EMPTY_ADDRESS_BOOK_CREATION_NAME);
            int emptyAddressBookSize=0;
            boolean fileExistenceValue=new File(DEFAULT_FILE_PATH +EMPTY_ADDRESS_BOOK_CREATION_NAME+".json").exists();
            Assert.assertTrue(fileExistenceValue);
            Assert.assertEquals(emptyAddressBookSize,addressBook.getAddressBookSize());
        } catch (AddressBookException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenOpenAddressBook_shouldReturnRespectiveFileData() {
        try {
            ArrayList<ContactDetail> contactDetailsList=new ArrayList<>();
            contactDetailsList.add(new ContactDetail("Ashwin","B","1234567890","Bangalore","Karnataka","560 100"));
            contactDetailsList.add(new ContactDetail("Vicky","G","1234567890","Bangalore","Karnataka","560 200"));
            Mockito.when(addressBookFileManager.getAddressBook(any())).thenReturn(contactDetailsList);
            addressBook.open(ADDRESS_BOOK_NAME_TO_OPEN);
            int openedAddressBookSize=2;
            Assert.assertEquals(openedAddressBookSize,addressBook.getAddressBookSize());
        } catch (AddressBookException e) {
            e.printStackTrace();
        }
    }
}
