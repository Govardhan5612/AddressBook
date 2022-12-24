package com.bridgelabz;

import java.util.*;

/**
 * @author Govardhan Reddy
 */
public class AddressBookMain {
    /**
     * Ability to manage the contact details
     */
    public ArrayList manageContactDetails() {
        AddressBook book = new AddressBook();
        int option;
        do {
            System.out.println("Welcome to Address Book");
            Scanner input = new Scanner(System.in);
            System.out.println("1.Add contact details  2.print contact details  3.Edit contact details  4.Delete contact details");
            System.out.print("Select a option : ");
            option = input.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Enter how many employee details add : ");
                    int number = input.nextInt();
                    for (int i = 1; i <= number; i++) {
                        System.out.println("Enter " + i + " contact details : ");
                        book.addContactDetails();
                    }
                    break;
                case 2:
                    book.printContactDetails();
                    break;
                case 3:
                    book.editContactDetails();
                    break;
                case 4:
                    book.deleteContactDetails();
                    break;
                default:
                    System.out.println("Enter valid details");
                    break;
            }
            System.out.println("1.Not exit  2.Exit ");
            System.out.print("Enter the choice : ");
            option = input.nextInt();

        } while (option == 1);
        return book.listOfContacts;
    }

}
