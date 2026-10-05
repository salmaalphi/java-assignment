public class Car {

    private String plateNumber;
    private String carModel;
    private double dailyRate;
    private boolean rent;


    public static String companyName = "JUST Rentals";
    public static int totalCars = 0;


    public Car() {
        this.plateNumber = "Unknown";
        this.carModel = "Unknown";
        this.dailyRate = 0.0;
        this.rent = false; // Car is available by default
        totalCars++; // Increase total cars count
    }


    public Car(String plateNumber, String carModel, double dailyRate) {
        this.plateNumber = plateNumber;
        this.carModel = carModel;
        if (dailyRate < 0) {
            System.out.println("Error: Daily rate cannot be negative. Setting rate to 0.0");
            this.dailyRate = 0.0;
        } else {
            this.dailyRate = dailyRate;
        }

        this.rent = false;
        totalCars++;
    }
    public String getPlateNumber() {
        return plateNumber;
    }

    public String getModel() {
        return carModel;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public boolean isRented() {
        return rent;
    }

    public void setDailyRate(double rate) {
        if (rate < 0) {
            System.out.println("Error: Daily rate cannot be negative!");
        } else {
            this.dailyRate = rate;
            System.out.println("Daily rate updated successfully to $" + rate + " for " + carModel);
        }
    }


    public void rent() {
        if (this.rent) {
            System.out.println("Sorry, the car (" + carModel + " - " + plateNumber + ") is ALREADY rented!");
        } else {
            this.rent = true;
            System.out.println("Success: You have successfully rented " + carModel + " (" + plateNumber + ").");
        }
    }


    public void returnCar() {
        if (!this.rent) {
            System.out.println("This car (" + carModel + ") was not rented.");
        } else {
            this.rent = false;
            System.out.println("Success: " + carModel + " (" + plateNumber + ") has been returned.");
        }
    }


    public void displayInfo() {
        System.out.println("-----------------------------------");
        System.out.println("Plate Number : " + plateNumber);
        System.out.println("Car Model    : " + carModel);
        System.out.println("Daily Rate   : $" + dailyRate);
        System.out.println("Status       : " + (rent ? "Rented" : "Available"));
        System.out.println("-----------------------------------");
    }


    public static void displayCompanyName() {
        System.out.println("===================================");
        System.out.println("Rental Company: " + companyName);
        System.out.println("===================================");
    }

    public static void displayTotalCars() {
        System.out.println("Total Cars in Fleet: " + totalCars);
    }
}
class TestCar {
    public static void main(String[] args) {
        Car.displayCompanyName();
    System.out.println("\n--- Creating Cars ---");
    Car car1 = new Car("123-ABC", "Toyota Corolla", 45.0);
    Car car2 = new Car("456-XYZ", "Honda Civic", 50.0);
    Car.displayTotalCars();

    System.out.println("\n--- Displaying Initial Car Information ---");
    car1.displayInfo();
    car2.displayInfo();
    System.out.println("\n--- Renting Cars ---");
    car1.rent();
    car1.rent();
    System.out.println("\n--- Returning Cars ---");
    car1.returnCar();
    System.out.println("\n--- Updating Daily Rates ---");
    car2.setDailyRate(55.0);
    car2.setDailyRate(-20.0);
    System.out.println("\n--- Updated Car Info ---");
    car2.displayInfo();
}
}