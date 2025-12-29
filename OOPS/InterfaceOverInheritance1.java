package com.learning.java.oops;

// RideService interface defines a method for booking rides.
interface RideService {
    void bookRide(String pickup, String destination); // Method to book a ride from pickup to destination
}

// Bikes class implements the RideService interface
class Bikes implements RideService {
    @Override
    public void bookRide(String pickup, String destination) {
        // Implementation of the bookRide method for Bikes
        System.out.println("Bike was booked from " + pickup + " to destination " + destination);
    }
}

// Cars class implements the RideService interface
class Cars implements RideService {
    @Override
    public void bookRide(String pickup, String destination) {
        // Implementation of the bookRide method for Cars
        System.out.println("Car was booked from " + pickup + " to destination " + destination);
    }
}

// Autos class implements the RideService interface
class Autos implements RideService {
    @Override
    public void bookRide(String pickup, String destination) {
        // Implementation of the bookRide method for Autos
        System.out.println("Auto was booked from " + pickup + " to destination " + destination);
    }
}

// User class (not tied to any vehicle directly)
class User {
    String name; // User's name
    RideService rideService; // Reference to any RideService implementation

    // Constructor for User
    User(String name, RideService rideService) {
        this.name = name;
        this.rideService = rideService;
    }

    // Method to request a ride
    void requestRide(String pickup, String destination) {
        rideService.bookRide(pickup, destination); // Calls the bookRide method of the associated ride service
    }
}

public class InterfaceOverInheritance1 {
    public static void main(String[] args) {
        // User books a car ride
        User user1 = new User("Pavan", new Cars());
        // Here User is parent reference, for subclass Cars() while runtime it will go under overriding from User() to Cars()
        user1.requestRide("Marthalli", "E-City");

        // User switches to bike ride
        user1.rideService = new Bikes();
        // Above changes the user1 child class reference from Cars() to Bikes() so that Bikes() class respective method will be called
        user1.requestRide("MG Road", "Whitefield");

        // New user joins with a car ride
        User user2 = new User("Ram", new Cars());
        user2.requestRide("Marthalli", "Koramangala");
    }
}
