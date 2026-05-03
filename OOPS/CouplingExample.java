package OOPS;

/*
========================================
COUPLING EXAMPLE
========================================

Coupling:
----------
Coupling defines how much one class depends on another class.

Types:
1. Tight Coupling  -> Bad Design
2. Loose Coupling  -> Good Design

========================================
1. TIGHT COUPLING
========================================

Problem:
--------
Car class directly creates PetrolEngine object.

Effects:
--------
- Hard to change implementation
- Difficult to test
- Difficult to extend
- Violates flexibility

If tomorrow we need:
- DieselEngine
- ElectricEngine
- HybridEngine

Then Car class must be modified.

This creates HIGH DEPENDENCY.

========================================
2. LOOSE COUPLING
========================================

Solution:
---------
Use abstraction (interface).

Benefits:
---------
- Flexible
- Easily replace implementations
- Better maintainability
- Easier unit testing
- Follows Dependency Injection principle

Now Car depends on interface, NOT concrete class.

========================================
INTERVIEW ONE-LINER
========================================

Tight Coupling:
Classes are highly dependent on each other.

Loose Coupling:
Classes depend on abstraction rather than concrete implementation.

Preferred:
----------
Always prefer LOW / LOOSE coupling.

========================================
*/

interface Engine {
    void start();
}

/* ========================================
   TIGHT COUPLING EXAMPLE
   ======================================== */

class PetrolEngine {

    void start() {
        System.out.println("Petrol Engine Started");
    }
}

class TightCoupledCar {

    // Direct dependency on concrete class
    PetrolEngine engine = new PetrolEngine();

    void drive() {
        engine.start();
        System.out.println("Car is Driving");
    }
}

/* ========================================
   LOOSE COUPLING EXAMPLE
   ======================================== */

class DieselEngine implements Engine {

    public void start() {
        System.out.println("Diesel Engine Started");
    }
}

class ElectricEngine implements Engine {

    public void start() {
        System.out.println("Electric Engine Started");
    }
}

class LooseCoupledCar {

    // Depends on abstraction
    private Engine engine;

    // Dependency Injection
    LooseCoupledCar(Engine engine) {
        this.engine = engine;
    }

    void drive() {
        engine.start();
        System.out.println("Car is Driving");
    }
}

/* ========================================
   MAIN CLASS
   ======================================== */

public class CouplingExample {

    public static void main(String[] args) {

        System.out.println("===== Tight Coupling =====");

        TightCoupledCar car1 = new TightCoupledCar();
        car1.drive();

        System.out.println();

        System.out.println("===== Loose Coupling =====");

        LooseCoupledCar dieselCar =
                new LooseCoupledCar(new DieselEngine());

        dieselCar.drive();

        System.out.println();

        LooseCoupledCar electricCar =
                new LooseCoupledCar(new ElectricEngine());

        electricCar.drive();
    }
}
