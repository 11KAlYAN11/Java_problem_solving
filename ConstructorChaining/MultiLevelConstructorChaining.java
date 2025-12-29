package ConstructorChaining;

class A {
    A() {
        System.out.println("Constructor A");
    }
}

class B extends A {
    B() {
        System.out.println("Constructor B");
    }
}

class MultiLevelConstructorChaining extends B {
    MultiLevelConstructorChaining() {
        System.out.println("Constructor C");
    }

    public static void main(String[] args) {
        new MultiLevelConstructorChaining();
    }
}

