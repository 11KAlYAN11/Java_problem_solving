

class Person {
    String name;
    Person(String name) {
        this.name = name;
        System.out.println("Person constructor is called: ");
    }
}

class Employee extends Person {
    int id;

    public Employee(int id, String name) {
        super(name); // Using the parent constructor as good practice
        this.id = id;
    }

    void display() {
        System.out.println("ID: "+id+", Name: "+name);
    }
    
}
public class ParentToChildChaining {
    public static void main(String[] args) {
        Employee e1 = new Employee(1, "Asam");
        e1.display();
    }
}
