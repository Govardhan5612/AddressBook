package com.bridgelabz;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

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
         * In this method store multi address books with unique name
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
    }

    public void searchAddressBooksDetails() {
        /**
         * this method used to search the user details use java streams
         */
        System.out.println("1.Search in city");
        System.out.println("2.Search in state");
        System.out.println("3.Search person");
        System.out.println("4.Number of persons in city");
        System.out.println("5.Number of persons in state");
        System.out.println("6.Sort the contact list use firstname");
        System.out.println("7.Sort contact details by city, state and zip code");
        System.out.println("8.Exit");
        System.out.println();
        System.out.print("Enter option : ");
        int option = input.nextInt();
        while (option != 8) {
            switch (option) {
                case 1:
                    System.out.print("Enter city name : ");//8
                    String cityName = input.next();
                    for (List contact : books.values()) {
                        List<ContactDetails> list = contact;
                        list.stream().filter(city -> city.getCity().equalsIgnoreCase(cityName)).forEach(x -> System.out.println(x));
                    }
                    break;
                case 2:
                    System.out.print("Enter State name : ");//8
                    String stateName = input.next();
                    for (List contact : books.values()) {
                        List<ContactDetails> list = contact;
                        list.stream().filter(state -> state.getState().equalsIgnoreCase(stateName)).forEach(x -> System.out.println(x));
                    }
                    break;
                case 3:
                    System.out.print("Enter person first name : ");//9
                    String firstName = input.next();
                    for (List contact : books.values()) {
                        List<ContactDetails> list = contact;
                        list.stream().filter(name -> name.getFirstName().equalsIgnoreCase(firstName)).forEach(x -> System.out.println(x));
                    }
                    break;
                case 4:
                    System.out.print("Enter city name : ");//10
                    String cityPersons = input.next();
                    List<ContactDetails> listSizeInCity = new ArrayList<>();
                    for (List contact : books.values()) {
                        List<ContactDetails> list = contact;
                        list.stream().filter(city -> city.getCity().equalsIgnoreCase(cityPersons)).forEach(x -> listSizeInCity.add(x));
                    }
                    System.out.println("Number of persons in city : " + listSizeInCity.size());
                    break;
                case 5:
                    System.out.print("Enter state name : ");///10
                    String statePersons = input.next();
                    List<ContactDetails> listSizeInState = new ArrayList<>();
                    for (List contact : books.values()) {
                        List<ContactDetails> list = contact;
                        list.stream().filter(state -> state.getState().equalsIgnoreCase(statePersons)).forEach(x -> listSizeInState.add(x));
                    }
                    System.out.println("Number of persons in state : " + listSizeInState.size());
                    break;
                case 6:
                    List<ContactDetails> contactList = new ArrayList<>();
                    for (List contact : books.values()) {
                        List<ContactDetails> list = contact;
                        list.stream().forEach(x -> contactList.add(x));
                    }
                    List<ContactDetails> collect = contactList.stream().sorted(Comparator.comparing(ContactDetails::getFirstName)).collect(Collectors.toList());
                    System.out.println(collect);
                    break;
                case 7:
                    List<ContactDetails> stateCityZipList = new ArrayList<>();
                    for (List contact : books.values()) {
                        List<ContactDetails> list = contact;
                        list.stream().forEach(x -> stateCityZipList.add(x));
                    }
                    System.out.println("Sorted order by state : ");
                    List<ContactDetails> stateList = stateCityZipList.stream().sorted(Comparator.comparing(ContactDetails::getState)).collect(Collectors.toList());
                    System.out.println(stateList);
                    System.out.println("Sorted order by city : ");
                    List<ContactDetails> cityList = stateCityZipList.stream().sorted(Comparator.comparing(ContactDetails::getCity)).collect(Collectors.toList());
                    System.out.println(cityList);
                    System.out.println("Sorted order by zip code : ");
                    List<ContactDetails> zipList = stateCityZipList.stream().sorted(Comparator.comparing(ContactDetails::getZip)).collect(Collectors.toList());
                    System.out.println(zipList);
                    break;
                default:
                    System.out.println("Enter correct value");

            }
            System.out.println("1.Search in city");
            System.out.println("2.Search in state");
            System.out.println("3.Search person");
            System.out.println("4.Number of persons in city");
            System.out.println("5.Number of persons in state");
            System.out.println("6.Sort the contact list use firstname");
            System.out.println("7.Sort contact details by city, state and zip code");
            System.out.println("8.Exit");
            System.out.print("Enter option : ");
            option = input.nextInt();
        }
    }

    public void write(Map<String, List> map, String path) {
        /**
         * This method used to write data in given file
         */
        File file = new File(path);
        BufferedWriter write = null;
        try {
            write = new BufferedWriter(new FileWriter(file));
            for (Map.Entry<String, List> entry : map.entrySet()) {
                write.write(entry.getKey() + " : " + entry.getValue());
                write.newLine();
            }
            write.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read(String path) throws IOException {
        /**
         * This method used to print data in given file
         */
        File file = new File(path);
        BufferedReader read = new BufferedReader(new FileReader(file));
        String word;
        while ((word = read.readLine()) != null) {
            System.out.println(word);
        }
    }

    public static void main(String[] args) throws IOException {
        AddressBooks books = new AddressBooks();
        books.addressBooksAdd();
        books.searchAddressBooksDetails();
        /**
         * Read and write operations on .txt file
         */
        String TextPath = "C:\\Users\\govar\\OneDrive\\Desktop\\BridgeLabz Daily Assignments\\RFP229_AddressBook\\src\\BooksTEXT.txt";
        System.out.println("Writing the Address books values in .txt file");
        books.write(books.books, TextPath);
        books.read(TextPath);
        /**
         * Read and write operations on .csv file
         */
        String csvPath = "C:\\Users\\govar\\OneDrive\\Desktop\\BridgeLabz Daily Assignments\\RFP229_AddressBook\\src\\BooksCSV.csv";
        System.out.println("Writing the Address books values in .csv file");
        books.write(books.books, csvPath);
        books.read(csvPath);
    }


}
