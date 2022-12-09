package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Govardhan Reddy
 */
public class AddressBook implements AddressBookInterface {
    /**
     * ability to manage the contact details
     */
    Scanner input = new Scanner(System.in);
    ContactDetails details = new ContactDetails();
    ArrayList<ContactDetails> listOfContacts = new ArrayList<>();

    @Override
    public void addContactDetails() {
        /**
         * Enter the contact details using Scanner object
         */
        System.out.print("Enter the first name : ");
        details.setFirstName(input.next());
        System.out.print("Enter the last name : ");
        details.setLastName(input.next());
        System.out.print("Enter the address : ");
        details.setAddress(input.next());
        System.out.print("Enter the city name : ");
        details.setCity(input.next());
        System.out.print("Enter the state name : ");
        details.setState(input.next());
        System.out.print("Enter the zip(6 numbers) : ");
        details.setZip(input.next());
        System.out.print("Enter the Mobile number(10 numbers) : ");
        details.setPhoneNumber(input.next());
        System.out.print("Enter the email : ");
        details.setEmail(input.next());
        ContactDetails contact1 = new ContactDetails(details.getFirstName(), details.getLastName(), details.getAddress(), details.getCity(), details.getState(), details.getPhoneNumber(), details.getZip(), details.getEmail());
        listOfContacts.add(contact1);
    }

    @Override
    public void printContactDetails() {
        /**
         * print the contact details
         */
        System.out.println(listOfContacts);
    }

    @Override
    public void editContactDetails() {
        System.out.print("Enter first name : ");
        String firstName = input.next();
        int number = 0;
        for (ContactDetails details : listOfContacts) {
            if (details.getFirstName().equals(firstName)) {
                listOfContacts.remove(details);
                number =1;
                break;
            }
        }
        if (number== 0) {
            System.out.println(firstName + " Contact list not found");
        } else {
            addContactDetails();
            System.out.println("Edit " + firstName + " contact details");
        }
    }


    @Override
    public void deleteContactDetails() {
        System.out.print("Enter first name : ");
        String firstName = input.next();
        int number = 0;
        for (ContactDetails details : listOfContacts) {
            if (details.getFirstName().equals(firstName)) {
                listOfContacts.remove(details);
                number=1;
                break;
            }
        }
        if (number ==0) {
            System.out.println(firstName + " Contact list not found");
        } else {
            System.out.println("Delete " + firstName + " contact details");
        }

    }
}
