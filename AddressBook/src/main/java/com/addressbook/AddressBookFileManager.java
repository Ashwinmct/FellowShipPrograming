package com.addressbook;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddressBookFileManager {
    private static String currentFileName="AddressBook";

    public void saveAddressBook(List<ContactDetail> addressBookList) throws AddressBookException {
        try {
            File addressBookFile=new File(getFilePath());
            addressBookFile.createNewFile();
            String addressBook=new Gson().toJson(addressBookList);
            FileWriter addressBookWriter=new FileWriter(addressBookFile);
            addressBookWriter.write(addressBook);
            addressBookWriter.close();
        } catch (IOException e) {
            throw new AddressBookException(AddressBookException.ExceptionType.ERROR_IN_SAVING,"Cannot save addressbook");
        }
    }

    public void saveAddressBook(List<ContactDetail> addressBookList, String addressBookName) throws AddressBookException {
        currentFileName=addressBookName;
        saveAddressBook(addressBookList);
    }

    public ArrayList<ContactDetail> getAddressBook(String addressBookName) throws AddressBookException {
        currentFileName=addressBookName;
        String fileData;
        try {
            fileData = readFileData(getFilePath());
        } catch (IOException e) {
            throw new AddressBookException(AddressBookException.ExceptionType.ERROR_IN_OPENING,"Error in opening address book");
        }
        return new ArrayList<>(Arrays.asList(new Gson().fromJson(fileData,ContactDetail[].class)));
    }

    public ArrayList<ContactDetail> getNewAddressBook(String newAddressBookName) throws AddressBookException {
        ArrayList<ContactDetail> newAddressBook=new ArrayList<>();
        saveAddressBook(newAddressBook,newAddressBookName);
        return newAddressBook;
    }

    private String readFileData(String addressBookFilePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(addressBookFilePath)));
    }

    private String getFilePath() {
        String defaultPath = ".\\src\\main\\resources\\";
        return defaultPath +currentFileName+".json";
    }
    
}
