class privateClass { //class is a defualt class
    private int data = 10;
    private void display() {
        System.out.println("Private class");
    }
    public static void main(String[] args) {
        privateClass obj = new privateClass();
        System.out.println(obj.data); //Allowed
        obj.display(); //Allowed
    }
}

class Test {
    public static void main(String[] args) {
        privateClass obj2 = new privateClass();
        //System.out.println(obj2.data);
        //obj2.display();
    }
}
