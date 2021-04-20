package taxiproject.model;

public class Taxi {
    String model;
    String country;
    int year;
    int mileage;
    boolean isSport;
    int weight;
    int topSpeed;
    int seats;
    double cost;

    public Taxi(String model, String country, int year) {
        this.model = model;
        this.country = country;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public boolean isSport() {
        return isSport;
    }

    public void setSport(boolean sport) {
        isSport = sport;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void printTaxi() {
        System.out.println("\nModel: " + model);
        System.out.println("Country: " + country);
        System.out.println("Year: " + year);
        System.out.println("Mileage: " + mileage);
        System.out.println("Sport Car: " + ((isSport) ? "Yes" : "No"));
        System.out.println("Weight: " + weight);
        System.out.println("Max Speed: " + topSpeed);
        System.out.println("Seat Count: " + seats);
        System.out.println("Cost: " + cost);
    }


}
