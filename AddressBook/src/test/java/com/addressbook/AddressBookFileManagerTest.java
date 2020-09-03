package com.addressbook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class AddressBookFileManagerTest {
    private static final String ADDRESS_BOOK_NAME ="AddressBook2" ;
    private static final String EMPTY_ADDRESS_BOOK_CREATION_NAME ="EmptyAddressBook" ;
    private static final String WRONG_ADDRESS_BOOK_FILE_NAME ="wrongAddressBookFile" ;
    private AddressBookFileManager addressBookFileManager;

    @Before
    public void setUp()  {
        addressBookFileManager=new AddressBookFileManager();
    }

    @Test
    public void givenAddressBookFile_whenLoaded_ShouldReturnRespectiveAmountOfContacts() {
        try {
            List<ContactDetail> expectedContactDetailsList=new ArrayList<>();
            expectedContactDetailsList.add(new ContactDetail("Ashwin","B","1234567890","Bangalore","Karnataka","560 100"));
            expectedContactDetailsList.add(new ContactDetail("Vicky","G","1234567890","Bangalore","Karnataka","560 200"));
            List<ContactDetail> openedAddressBookDataList=addressBookFileManager.getAddressBook(ADDRESS_BOOK_NAME);
            Assert.assertEquals(expectedContactDetailsList.size(),openedAddressBookDataList.size());
        } catch (AddressBookException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void givenAddressBookFileName_whenCreatedNewAddressBook_ShouldReturnEmptyContact() {
        try {
            ArrayList<ContactDetail> emptyList=new ArrayList<>();
            ArrayList<ContactDetail> createdAddressBookDataList=addressBookFileManager.getNewAddressBook(EMPTY_ADDRESS_BOOK_CREATION_NAME);
            Assert.assertEquals(emptyList,createdAddressBookDataList);
        } catch (AddressBookException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenNonExistingAddressBookName_whenLoaded_shouldThrowException() {
        try {
            addressBookFileManager.getAddressBook(WRONG_ADDRESS_BOOK_FILE_NAME);
        } catch (AddressBookException e) {
            Assert.assertEquals(AddressBookException.ExceptionType.ERROR_IN_OPENING,e.exceptionType);
        }
    }
}
