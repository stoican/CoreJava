package bankproject.model;

import bankproject.interfaces.Borrower;
import bankproject.interfaces.Lender;
import bankproject.interfaces.PremiumCustomer;

import java.util.Scanner;

public class Customer extends Human implements Borrower, PremiumCustomer {
    private int customerID;
    private String passportID;
    private boolean isPremiumCustomer = false;
    private String country;
    private String city;
    private String zipCode;
    private double balance;

    public Customer(String fn, String ln, int customerID) {
        super(fn, ln);
        this.customerID = customerID;
    }

    @Override
    public boolean openLoan() {
        return false;
    }

    @Override
    public boolean closeLoan() {
        return false;
    }



    @Override
    public String toString() {
        final String sep = ",";
        StringBuilder s = new StringBuilder(this.getFirstName());
        s.append(sep)
                .append(this.getLastName())
                .append(sep).append(customerID)
                .append(sep).append(country)
                .append(sep).append(city)
                .append(sep).append(zipCode)
                .append(sep).append(passportID)
                .append(sep).append(balance)
                .append(sep).append(isPremiumCustomer);

        return s.toString();
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassportID() {
        return passportID;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void print() {
        StringBuilder s = new StringBuilder(this.getFirstName());
        s.append(" ")
                .append(this.getLastName())
                .append(" ").append(customerID)
                .append(" ").append(country)
                .append(" ").append(city)
                .append(" ").append(zipCode)
                .append(" ").append("private")
                .append(" ").append("private")
                .append(" ").append(isPremiumCustomer);
        System.out.println(s.toString());
    }

    @Override
    public boolean isPremiumCustomer() {

        return isPremiumCustomer;
    }

    @Override
    public void setPremiumCustomer(boolean premiumCustomer) {
        this.isPremiumCustomer = premiumCustomer;
    }
}
