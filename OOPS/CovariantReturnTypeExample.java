package OOPS;

/*
========================================
COVARIANT RETURN TYPE
========================================

Definition:
-----------
While overriding a method,
the child class can return
its own child type instead of
the parent's return type.

Condition:
----------
Returned object must follow IS-A relationship.

Meaning:
--------
Child return type must be subtype
of parent return type.

========================================
WITHOUT COVARIANT RETURN TYPE
========================================

Parent method returns:
Animal

Child method also returns:
Animal

Valid but less specific.

========================================
WITH COVARIANT RETURN TYPE
========================================

Parent method returns:
Animal

Child method returns:
Dog

This is allowed because:
Dog extends Animal

========================================
ADVANTAGES
========================================

1. More specific return types
2. Reduces type casting
3. Better readability
4. Better polymorphism support

========================================
INTERVIEW ONE-LINER
========================================

Covariant return type allows an overridden method
to return a subtype of the original method's return type.

========================================
*/

class Animal {

    Animal getObject() {

        System.out.println("Animal Object");

        return new Animal();
    }
}

class Dog extends Animal {

    // Covariant Return Type
    // Returning Dog instead of Animal

    @Override
    Dog getObject() {

        System.out.println("Dog Object");

        return new Dog();
    }
}

public class CovariantReturnTypeExample {

    public static void main(String[] args) {

        Animal a = new Animal();
        a.getObject();

        System.out.println();

        Dog d = new Dog();
        d.getObject();
    }
}