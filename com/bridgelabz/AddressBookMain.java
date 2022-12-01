package com.bridgelabz;

import java.util.Scanner;

/**
 * @author Govardhan Reddy
 */
public class AddressBookMain {
    /**
     * Ability to manage the contact details
     */
    public void manageContactDetails() {
        AddressBook book = new AddressBook();
        int option;
        do {
            System.out.println("Welcome to Address Book");
            Scanner input = new Scanner(System.in);
            System.out.println("1.Add contact details  2.print contact details  3.Edit contact details");
            System.out.print("Select a option : ");
            option = input.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter the contact details : ");
                    book.addContactDetails();
                    break;
                case 2:
                    book.printContactDetails();
                    break;
                case 3:
                    book.editContactDetails();
                    break;
                default:
                    System.out.println("Enter valid details");
                    break;
            }
            System.out.println("1.Not exit  2.Exit ");
            System.out.print("Enter the choice : ");
            option = input.nextInt();

        } while (option != 2);
    }

    public static void main(String[] args) {
        AddressBookMain main = new AddressBookMain();
        main.manageContactDetails();
    }
}