package bankproject;

import bankproject.model.Customer;
import bankproject.service.CustomerService;
import bankproject.service.FileService;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class BankTest {
    private final static String PATH = new File("").getAbsolutePath() + File.separator + "customers.txt";

    public static void main(String[] args) {
        /*

        0. Create new customer account
        1. View the list of all customer data
        2. Edit customer data (input customer ID)
        3. Top-up money to your account
        4. Withdraw money from your account
        5. Borrow Money

        SOME FEATURES ARE NOT IMPLEMENTED YET

         */
        List<Customer> customers = null;
        try {
            customers = CustomerService.convertLinesToCustomers(FileService.read(PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // ****************MENU*****************
        Scanner s = new Scanner(System.in);
        boolean isActive = true;
        while (isActive) {
            System.out.println("\n1. Create new customer account: ");
            System.out.println("2. Show list of all customer data");
            System.out.println("3. Edit customer data using customer ID: ");
            System.out.println("4. Deposit to a bank account (customer ID required): ");
            System.out.println("5. Withdraw from a bank account (customer ID and passport ID required): ");
            System.out.println("6. Apply for a loan (customer ID and passport ID required): ");
            System.out.println("7. Exit");
            int ch = s.nextInt();

            switch (ch) {
                case 1:
                    Customer newCustomer = CustomerService.create();
                    assert customers != null;
                    customers.add(newCustomer);
                    try {
                        FileService.append(PATH, newCustomer.toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Account with customer ID successfully created!");
                    break;
                case 2:
                    assert customers != null;
                    CustomerService.printAllCustomerData(customers);
                    break;
                case 3:
                    System.out.println("Enter customer ID");
                    assert customers != null;
                    CustomerService.editCustomerData(s.nextInt(), customers);
                    try {
                        FileService.write(PATH, CustomerService.convertToListOfStrings(customers));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    System.out.println("Enter customer ID: ");
                    int id = s.nextInt();
                    System.out.println("Enter deposit amount: ");
                    double am = s.nextDouble();
                    assert customers != null;
                    CustomerService.deposit(id, am, customers);
                    try {
                        FileService.write(PATH, CustomerService.convertToListOfStrings(customers));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    System.out.println("Enter customer ID: ");
                    int id2 = s.nextInt();
                    System.out.println("Enter withdrawal amount: ");
                    double am2 = s.nextDouble();
                    assert customers != null;
                    CustomerService.withdraw(id2, am2, customers);
                    try {
                        FileService.write(PATH, CustomerService.convertToListOfStrings(customers));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    System.out.println("Enter customer ID: ");
                    int id3 = s.nextInt();
                    System.out.println("Enter passport ID: ");
                    String pId = s.next();
                    System.out.println("Requested loan amount in USD: ");
                    double am3 = s.nextDouble();
                    assert customers != null;
                    CustomerService.takeLoan(id3, pId, am3, customers);
                    try {
                        FileService.write(PATH, CustomerService.convertToListOfStrings(customers));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    isActive = false;
                    break;
                default:
                    System.out.println("Please enter valid option");
            }
        }
    }
}

