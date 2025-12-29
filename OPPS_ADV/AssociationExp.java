package OOPS_ADV;

/*
 * =======================
 * Project class
 * =======================
 * Independent class
 * Does NOT depend on Employee
 */
class Project {

    String projectName;
    int durationMonths;

    public Project(String projectName, int durationMonths) {
        this.projectName = projectName;
        this.durationMonths = durationMonths;
    }

    public void displayProject() {
        System.out.println(
            "Project Name     : " + projectName +
            ", Duration       : " + durationMonths + " months"
        );
    }
}

/*
 * =======================
 * Employee class
 * =======================
 * Employee is ASSOCIATED with Project
 * No ownership, no creation, no lifecycle control
 */
class Employee {

    int id;
    String name;

    // 🔥 Association
    // Just a reference, no creation here
    Project project;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Assign project later
    public void assignProject(Project project) {
        this.project = project;
    }

    public void displayEmployee() {
        System.out.println("\nEmployee ID   : " + id);
        System.out.println("Employee Name : " + name);

        if (project != null) {
            System.out.println("---- Project Details ----");
            project.displayProject();
        } else {
            System.out.println("No project assigned");
        }
    }
}

/*
 * =======================
 * Main class
 * =======================
 */
public class AssociationExp {

    public static void main(String[] args) {

        // Create independent objects
        Employee e1 = new Employee(1, "Asam");
        Employee e2 = new Employee(2, "Pavan");

        Project p1 = new Project("Banking App", 12);
        Project p2 = new Project("E-Commerce App", 8);

        // 🔥 Association established here
        e1.assignProject(p1);
        e2.assignProject(p2);

        e1.displayEmployee();
        e2.displayEmployee();

        /*
         * IMPORTANT POINTS:
         * 1. Employee does NOT create Project
         * 2. Project does NOT depend on Employee
         * 3. Either object can exist independently
         * 4. This is Association
         */
    }
}
