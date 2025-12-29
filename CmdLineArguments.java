package com.learning.java.basics;

public class CmdLineArguments {
    public static void main(String[] args) {
        for(int i=0; i<args.length; i++) {
            System.out.println("Argument: "+i+ " "+ args[i]);
        }
       /*  int a = 10;
        //autoboxing primitive to wrapper (Object)
        Integer b = new Integer(a);
        //Unboxing Wrapper(Object) -> primitive
        int c = b.intValue(); */
        //but all these after java 5 depreciated. instead we are doing like
        int a=10;
        Integer b = a;
        System.out.println(b);
        int c = b;
        System.out.println(c);

        String s = "abc";
        String s1 = new String(s);
        System.out.println(s1);
        String s2 = s1;
        System.out.println(s2);


    }
}
