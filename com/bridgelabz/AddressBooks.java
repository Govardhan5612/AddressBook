package com.bridgelabz;

import java.util.*;

/**
 * @author Govardhan Reddy
 */
public class AddressBooks {
    /**
     * Create hash map to store multiple books
     */
    HashMap<String, List> books = new HashMap<>();
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
                if (books.containsKey(name) == false) {
                    books.put(name, main.manageContactDetails());

                } else {
                    System.out.println(name + " book is already exits");
                }
            } else {
                break;
            }
        }
        System.out.println(books);
        System.out.println("1.Search in city");
        System.out.println("2.Search in state");
        System.out.println("3.Search person");
        System.out.println("4.Exit");
        System.out.println();
        System.out.print("Enter option : ");
        int option = input.nextInt();
        while (option != 4) {
            switch (option) {
                case 1:
                    System.out.print("Enter city name : ");
                    String cityName = input.next();
                    for (List contact : books.values()) {
                        List<ContactDetails> list = contact;
                        list.stream().filter(city -> city.getCity().equalsIgnoreCase(cityName)).forEach(x -> System.out.println(x));
                    }
                    break;
                case 2:
                    System.out.print("Enter State name : ");
                    String stateName = input.next();
                    for (List contact : books.values()) {
                        List<ContactDetails> list = contact;
                        list.stream().filter(state -> state.getState().equalsIgnoreCase(stateName)).forEach(x -> System.out.println(x));
                    }
                    break;
                case 3:
                    System.out.print("Enter person first name : ");
                    String firstName = input.next();
                    for (List contact : books.values()) {
                        List<ContactDetails> list = contact;
                        list.stream().filter(name -> name.getFirstName().equalsIgnoreCase(firstName)).forEach(x -> System.out.println(x));
                    }
                    break;
                default:
                    System.out.println("Enter correct value");

            }
            System.out.println("1.Search in city");
            System.out.println("2.Search in state");
            System.out.println("3.Search person");
            System.out.println("4.Exit");
            System.out.print("Enter option : ");
            option = input.nextInt();
        }
    }

    public static void main(String[] args) {
        AddressBooks books = new AddressBooks();
        books.addressBooksAdd();
    }


}
