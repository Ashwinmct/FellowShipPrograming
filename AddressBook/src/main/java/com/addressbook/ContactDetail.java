package com.addressbook;

public class ContactDetail {

    public String firstName;
    public String lastName;
    public String fullName;
    public String phoneNumber;
    public String city;
    public String state;
    public String zipCode;

    public ContactDetail(String firstName, String lastName, String phoneNumber, String city, String state, String zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + lastName;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "ContactDetail{" +
                " firstName:" + firstName +
                ", lastName:" + lastName +
                ", city:" + city +
                ", state:" + state +
                ", zipCode:" + zipCode +
                ", phoneNumber:" + phoneNumber +
                '}';
    }
}
