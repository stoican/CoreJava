package bankproject.service;

import bankproject.model.Bank;
import bankproject.model.Customer;

import java.util.ArrayList;
import java.util.Scanner;

public class BankService {

    public Bank create() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter name of the bank: ");
        String name = s.next();
        System.out.println("Enter country");
        String country = s.next();
        System.out.println("Enter city: ");
        String city = s.next();
        System.out.println("Enter address (street, apartment etc): ");
        String address = s.next();
        System.out.println("Enter amount of branches of the bank: ");
        int numberOfBranches = s.nextInt();

        Bank b = new Bank(name, country, city);
        b.setAddress(address);
        b.setNumberOfBranches(numberOfBranches);

        return b;
    }

}
