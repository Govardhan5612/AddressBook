package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Govardhan Reddy
 */
public class AddressBooks {
    /**
     * Create hash map to store multiple books
     */
    HashMap<String, ArrayList> map = new HashMap<>();
    AddressBookMain main = new AddressBookMain();
    Scanner input = new Scanner(System.in);
    public void addressBooksAdd() {
        /**
         * To store unique person first name details
         */
        int number = 1;
        while (number == 1) {
            System.out.println("1.Add Address Book");
            System.out.println("2.Exit Address book system");
            System.out.println();
            System.out.print("Enter choice : ");
            number = input.nextInt();
            if (number == 1) {
                System.out.print("Enter address book name : ");
                String name = input.next();
                if (map.containsKey(name) == false) {
                    map.put(name, main.manageContactDetails());
                } else {
                    System.out.println(name + " book is already exits");
                }
            } else {
                break;
            }
        }
        System.out.println(map);
    }

    public static void main(String[] args) {
        AddressBooks books = new AddressBooks();
        books.addressBooksAdd();
    }


}
