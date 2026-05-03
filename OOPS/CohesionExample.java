package OOPS;

/*
========================================
COHESION EXAMPLE
========================================

Cohesion:
---------
Cohesion defines how closely related
the responsibilities inside a class are.

Types:
1. Low/Bad Cohesion   -> Bad Design
2. High/Good Cohesion -> Good Design

========================================
1. BAD COHESION
========================================

Problem:
--------
Employee class is doing EVERYTHING:
- salary calculation
- database connection
- email sending
- report printing

These responsibilities are unrelated.

Effects:
--------
- Hard to maintain
- Difficult to debug
- Difficult to reuse
- Violates Single Responsibility Principle

This is called LOW COHESION.

========================================
2. GOOD COHESION
========================================

Solution:
---------
Separate responsibilities into dedicated classes.

Now:
- SalaryService -> only salary
- EmailService  -> only email
- ReportService -> only reports

Benefits:
---------
- Cleaner design
- Easier maintenance
- Better readability
- Easier testing
- Reusable components

This is HIGH COHESION.

========================================
INTERVIEW ONE-LINER
========================================

High Cohesion:
A class should have closely related responsibilities.

Low Cohesion:
A class performing unrelated tasks.

Preferred:
----------
Always prefer HIGH cohesion.

========================================
*/

/* ========================================
   BAD COHESION EXAMPLE
   ======================================== */

class BadEmployeeService {

    void calculateSalary() {
        System.out.println("Calculating Salary");
    }

    void sendEmail() {
        System.out.println("Sending Email");
    }

    void printReport() {
        System.out.println("Printing Report");
    }

    void connectDatabase() {
        System.out.println("Connecting Database");
    }
}

/* ========================================
   GOOD COHESION EXAMPLE
   ======================================== */

class SalaryService {

    void calculateSalary() {
        System.out.println("Calculating Salary");
    }
}

class EmailService {

    void sendEmail() {
        System.out.println("Sending Email");
    }
}

class ReportService {

    void printReport() {
        System.out.println("Printing Report");
    }
}

class DatabaseService {

    void connectDatabase() {
        System.out.println("Connecting Database");
    }
}

/* ========================================
   MAIN CLASS
   ======================================== */

public class CohesionExample {

    public static void main(String[] args) {

        System.out.println("===== Bad Cohesion =====");

        BadEmployeeService bad = new BadEmployeeService();

        bad.calculateSalary();
        bad.sendEmail();
        bad.printReport();
        bad.connectDatabase();

        System.out.println();

        System.out.println("===== Good Cohesion =====");

        SalaryService salaryService = new SalaryService();
        EmailService emailService = new EmailService();
        ReportService reportService = new ReportService();
        DatabaseService databaseService = new DatabaseService();

        salaryService.calculateSalary();
        emailService.sendEmail();
        reportService.printReport();
        databaseService.connectDatabase();
    }
}