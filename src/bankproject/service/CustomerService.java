package bankproject.service;

import bankproject.model.Customer;

import java.util.*;

public class CustomerService {

    public static Customer create() {
        Scanner s = new Scanner(System.in);
        System.out.println("First Name: ");
        String fn = s.next();
        System.out.println("Last Name: ");
        String ln = s.next();
        System.out.println("Set your customer ID (0-1000): ");
        int cID = s.nextInt();
        System.out.println("Your country: ");
        String country = s.next();
        System.out.println("Your city: ");
        String city = s.next();
        System.out.println("Your zipCode (1-9999)");
        String zipCode = s.next();
        System.out.println("Your Passport ID");
        String pID = s.next();
        System.out.println("Initial deposit amount: ");
        double balance = s.nextDouble();
        System.out.println("Premium Customer Service ($100 fee): y/n");
        boolean premium = s.next().charAt(0) == 'y';
        Customer c = new Customer(fn, ln, cID);
        c.setCountry(country);
        c.setCity(city);
        c.setZipCode(zipCode);
        c.setPassportID(pID);
        c.setBalance(balance);
        c.setPremiumCustomer(premium);

        return c;
    }

    public static Customer convert(String line) {
        String[] l = line.split(",");
        final String fn = l[0];
        final String ln = l[1];
        final int cID = Integer.parseInt(l[2]);
        final Customer c = new Customer(fn, ln, cID);
        c.setCountry(l[3]);
        c.setCity(l[4]);
        c.setZipCode(l[5]);
        c.setPassportID(l[6]);
        c.setBalance(Double.parseDouble(l[7]));
        c.setPremiumCustomer(Boolean.parseBoolean(l[8]));

        return c;
    }

    public static List<Customer> convertLinesToCustomers(List<String> list) {
        List<Customer> c = new java.util.ArrayList<>(Collections.emptyList());

        for (String line : list) {
            c.add(convert(line));
        }

        return c;
    }

    public static void printAllCustomerData(List<Customer> customers) {
        final StringBuilder columns = new StringBuilder("Full Name");
        columns.append(" | ")
                .append("CustomerID")
                .append(" | ")
                .append("Country")
                .append(" | ")
                .append("City")
                .append(" | ")
                .append("Zip Code")
                .append(" | ")
                .append("Passport ID")
                .append(" | ")
                .append("Balance")
                .append(" | ")
                .append("Premium Customer");
        System.out.println(columns);
        for (Customer c : customers) {
            c.print();
        }
    }

    public static boolean editCustomerData (int id, List<Customer> customers) {
        Iterator it = customers.iterator();
        while (it.hasNext()) {
            Customer c = (Customer) it.next();
            if (c.getCustomerID() == id) {
                boolean isActive = true;

                Scanner s = new Scanner(System.in);
                while (isActive) {
                        System.out.println("\n1. Change First Name");
                        System.out.println("2. Change Last Name");
                        System.out.println("3. Change Country");
                        System.out.println("4. Change City");
                        System.out.println("5. Edit Zip code");
                        System.out.println("6. Go Back");
                        int ch = s.nextInt();

                        switch (ch) {
                            case 1:
                                c.setFirstName(s.next());
                                System.out.println("Changes are successfully recorded!");
                                break;
                            case 2:
                                c.setLastName(s.next());
                                System.out.println("Changes are successfully recorded!");
                                break;
                            case 3:
                                c.setCountry(s.next());
                                System.out.println("Changes are successfully recorded!");
                                break;
                            case 4:
                                c.setCity(s.next());
                                System.out.println("Changes are successfully recorded!");
                                break;
                            case 5:
                                c.setZipCode(s.next());
                                System.out.println("Changes are successfully recorded!");
                                break;
                            case 6:
                                isActive = false;
                                break;
                            default:
                                System.out.println("Please enter valid option");

                        }
                }
                return true;
            }
        }

        System.out.println("Invalid customer ID. Try again!");
        return false;

    }

    public static boolean deposit(int id, double depositAmount, List<Customer> customers) {
        Iterator<Customer> it = customers.iterator();
        while (it.hasNext()) {
            Customer c = it.next();
            if (c.getCustomerID() == id) {
                c.setBalance(c.getBalance() + depositAmount);
                return true;
            }
        }

      System.out.println("Invalid customer ID. Please try again!");
      return false;
    }

    public static boolean withdraw(int id, double withdrawalAmount, List<Customer> customers) {
        Iterator<Customer> it = customers.iterator();
        while (it.hasNext()) {
            Customer c = it.next();
            if (c.getCustomerID() == id) {
                if (c.getBalance() - withdrawalAmount >= 0) {
                    c.setBalance(c.getBalance() - withdrawalAmount);
                    return true;
                }
                System.out.println("Not enough funds to withdraw. Try again");
                return false;
            }
        }
        System.out.println("Invalid customer ID. Please try again!");
        return false;
    }

    public static boolean takeLoan(int cId, String pID, double loanAmount, List<Customer> customers) {
        Iterator it = customers.iterator();
        while (it.hasNext()) {
            Customer c = (Customer) it.next();
            if (c.getCustomerID() == cId && c.getPassportID().equals(pID)) {
                // an arbitrary formula to decide if the customer is eligible for a loan
                if (loanAmount <= c.getBalance() * 5) {
                    c.setBalance(c.getBalance() + loanAmount);
                    System.out.println(loanAmount + " USD is added to your balance!");
                    return true;
                }

                System.out.println("You're not eligible for the loan. Sorry for inconvenience!");
                return false;
            }
        }
        System.out.println("Invalid customer or passport ID. Please try again!");
        return false;
    }

    public static List<String> convertToListOfStrings(List<Customer> customers) {
        List<String> ss = new ArrayList<>(Collections.emptyList());

        Iterator it = customers.iterator();
        while (it.hasNext()) {
            ss.add(it.next().toString());
        }

        return ss;

    }

}
