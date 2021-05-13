package bankproject.model;


import bankproject.interfaces.Borrower;

public abstract class Employee extends Human implements Borrower {
    private String position;
    private String department;
    private double salary;
    public Employee(String fn, String ln) {
        super(fn, ln);
    }
}
