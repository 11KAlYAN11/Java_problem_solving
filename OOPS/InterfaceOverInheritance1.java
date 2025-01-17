package OOPS;

interface RideService {
    void bookRide(String pickup, String destination);
}
class Bikes implements RideService {
    @Override
    public void bookRide(String pickup, String destination) {
        System.out.println("Bike was booked from "+ pickup + " to destination " + destination);
    }
}
class Cars implements RideService {
    @Override
    public void bookRide(String pickup, String destination) {
        System.out.println("Car was booked from "+ pickup + " to destination " + destination);
    }
}
class Autos implements RideService {
    @Override
    public void bookRide(String pickup, String destination) {
        System.out.println("Auto was booked from "+ pickup + " to destination " + destination);
    }
}

// User class (not tied to any vehicle directly)
class User {
    //Here we will define the variable as per req. & that defined RiderService DataType
    String name;
    RideService rideService; //Reference to any RiderService implementation

    User(String name, RideService rideService) {
        this.name = name;
        this.rideService = rideService;
    }

    //We are defineing the one method to request a ride 
    void requestRide(String pickup, String destination) {
        rideService.bookRide(pickup, destination);
    }

}
public class InterfaceOverInheritance1 {
    public static void main(String[] args) {
        //User books a car ride
        User user1 = new User("pavan", new Cars());
        //Here User is parent reference, for sub class cars() while run time it will go under overriding from User() to Cars()
        user1.requestRide("Marthalli", "E-City");

        //User switches to bike ride
        user1.rideService = new Bikes();
        // above changes the user1 child class refernce from Cars() -> Bikes() so that Bikes() class respective method will be called
        user1.requestRide("MG Road", "Whitefield");

        User user2 = new User("Ram", new Cars());
        user2.requestRide("Marthalli", "Koramangala");
    }
}
