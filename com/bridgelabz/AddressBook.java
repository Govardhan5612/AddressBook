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
        String firstName = input.next();
        boolean status = false;
        for (ContactDetails contactDetails : listOfContacts) {
            if (contactDetails.getFirstName().equals(firstName) == true) {
                status = true;
                break;
            }
        }
        if (status == true) {
            System.out.println(firstName + " already exits");
            addContactDetails();

        } else {
            details.setFirstName(firstName);
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
            ContactDetails contact1 = new ContactDetails(details.getFirstName(), details.getLastName(), details.getAddress(), details.getCity(), details.getState(), details.getZip(), details.getPhoneNumber(), details.getEmail());
            listOfContacts.add(contact1);
        }
    }


    @Override
    public void printContactDetails() {
        /**
         * print the contact details
         */
        for (ContactDetails contact : listOfContacts) {
            System.out.println(contact.toString());
        }
    }

    @Override
    public void editContactDetails() {
        System.out.print("Enter first name : ");
        String firstName = input.next();
        int number = 0;
        for (ContactDetails details : listOfContacts) {
            if (details.getFirstName().equals(firstName)) {
                listOfContacts.remove(details);
                number = 1;
                break;
            }
        }
        if (number == 0) {
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
                number = 1;
                break;
            }
        }
        if (number == 0) {
            System.out.println(firstName + " Contact list not found");
        } else {
            System.out.println("Delete " + firstName + " contact details");
        }

    }
}
