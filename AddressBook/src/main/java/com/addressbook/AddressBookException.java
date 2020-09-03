package com.addressbook;

public class AddressBookException extends Exception {
    public enum ExceptionType {EMPTY_VALUE, FILE_WRITING_PROBLEM, INVALID_OPTION, ERROR_IN_OPENING, ERROR_IN_CREATION, ERROR_IN_SAVING, CONTACT_NOT_FOUND}
    public ExceptionType exceptionType;

    public AddressBookException(ExceptionType exceptionType, String message) {
        super(message);
        this.exceptionType=exceptionType;
    }


}
