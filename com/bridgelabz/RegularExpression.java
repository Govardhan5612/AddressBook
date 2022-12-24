package com.bridgelabz;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author Govardhan Reddy
 */
public class RegularExpression {
    Scanner input = new Scanner(System.in);

    public String validFirstName() {
        System.out.print("Enter first name (First letter Upper case and minimum three letters) : ");
        String firstName = input.next();
        boolean status = Pattern.compile("[A-Z]{1}[a-z]{2,15}").matcher(firstName).matches();
        if (status == true) {
            System.out.println(firstName + " is valid first name");
        } else {
            System.out.println(firstName + " is not valid first name");
            validFirstName();
        }
        return firstName;
    }

    public String validLastName() {
        System.out.print("Enter last name (First letter Upper case and minimum three letters) : ");
        String lastName = input.next();
        boolean status = Pattern.compile("[A-Z]{1}[a-z]{2,15}").matcher(lastName).matches();
        if (status == true) {
            System.out.println(lastName + " is valid last name");
        } else {
            System.out.println(lastName + " is not valid last name");
            validFirstName();
        }
        return lastName;
    }

    public String validAddress() {
        System.out.print("Enter Address (First letter Upper case and minimum three letters) : ");
        String address = input.next();
        boolean status = Pattern.compile("[A-Z]{1}[a-z]{2,15}").matcher(address).matches();
        if (status == true) {
            System.out.println(address + " is valid address");
        } else {
            System.out.println(address + " is not valid address");
            validFirstName();
        }
        return address;
    }

    public String validCity() {
        System.out.print("Enter city (First letter Upper case and minimum three letters) : ");
        String city = input.next();
        boolean status = Pattern.compile("[A-Z]{1}[a-z]{2,15}").matcher(city).matches();
        if (status == true) {
            System.out.println(city + " is valid city");
        } else {
            System.out.println(city + " is not valid city");
            validFirstName();
        }
        return city;
    }

    public String validState() {
        System.out.print("Enter state (First letter Upper case and minimum three letters) : ");
        String state = input.next();
        boolean status = Pattern.compile("[A-Z]{1}[a-z]{2,15}").matcher(state).matches();
        if (status == true) {
            System.out.println(state + " is valid state");
        } else {
            System.out.println(state + " is not valid state");
            validFirstName();
        }
        return state;
    }

    public String validZip() {
        System.out.print("Enter ZIP code (six numbers) : ");
        String zip = input.next();
        boolean status = Pattern.compile("[1-9]{1}[0-9]{5}").matcher(zip).matches();
        if (status == true) {
            System.out.println(zip + " is valid zip");
        } else {
            System.out.println(zip + " is not valid zip");
            validFirstName();
        }
        return zip;
    }

    public String validMobileNumber() {
        System.out.print("Enter mobile number (ten numbers) : ");
        String mobileNumber = input.next();
        boolean status = Pattern.compile("[7-9]{1}[0-9]{9}").matcher(mobileNumber).matches();
        if (status == true) {
            System.out.println(mobileNumber + " is valid mobile number");
        } else {
            System.out.println(mobileNumber + " is not valid mobile number");
            validFirstName();
        }
        return mobileNumber;
    }

    public String valid_email() {
        System.out.print("Enter email (govardhan1998@gmail.com) : ");
        String email = input.next();
        boolean status = Pattern.compile("[a-z]{2,20}[0-9]{0,5}[@]{1}[gmail]{5}[.]{1}[com]{3}").matcher(email).matches();
        if (status == true) {
            System.out.println(email + " is valid email");
        } else {
            System.out.println(email + " is not valid email");
            validFirstName();
        }
        return email;
    }
}
