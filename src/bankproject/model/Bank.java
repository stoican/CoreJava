package bankproject.model;

public class Bank {
    private String nameOfBank;
    private String address;
    private String country;
    private String city;
    private int numberOfBranches;

    public Bank( String name, String country, String city) {
        this.nameOfBank = name;
        this.country = country;
        this.city = city;
    }

    public String getNameOfBank() {
        return nameOfBank;
    }

    public void setNameOfBank(String nameOfBank) {
        this.nameOfBank = nameOfBank;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public int getNumberOfBranches() {
        return numberOfBranches;
    }

    public void setNumberOfBranches(int numberOfBranches) {
        this.numberOfBranches = numberOfBranches;
    }
}
