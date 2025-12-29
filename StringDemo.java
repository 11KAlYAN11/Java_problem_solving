import java.util.*;

package com.learning.java.basics;

public class StringDemo {
    
    public static void main(String[] args) {
        System.out.println("Anu numbers printing"); 



        //System.out.println(removeDups("pavan"));
        //Array To String Array.toString()
        int[] numbers = {1,2,3,4,5};
        String str = Arrays.toString(numbers);
        System.out.println(str);
        
        //Array to Sting.join(" ")
        String[] names = {"John","Mary","Peter"};
        String res = String.join(" ",names);
        System.out.println(res);

        StringBuilder sb = new StringBuilder();
        for(String name: names) {
            sb.append(name).append(" ");
        }
       System.out.println(sb);
       String res1 = sb.toString().trim();
       System.out.println(res1);
       String st1 = "ABC";
       String st2 = "ABC";
       System.out.println(st1.equals(st2));
       StringBuilder sb1 = new StringBuilder("asam");
       StringBuilder sb2 = new StringBuilder("asam");
       System.out.println(sb1.equals(sb2)); // here as sb1 & 2 objects it is comparing with memory references
       System.out.println(sb1.toString().equals(sb2.toString()));
       StringBuffer sbb1 = new StringBuffer("kalyan");
       StringBuffer sbb2 = new StringBuffer("kalyan");
       System.out.println(sbb1.toString().equals(sbb2.toString()));


       //List<Integer> arr = new ArrayList<>();
       List<Integer> arr2 = new LinkedList<>();
       arr2.add(0,10);
       System.out.println(arr2);
       //Set<String> set = new HashSet<>();
       
    
       ArrayList<Integer> arrx = new ArrayList<>();
       arrx.add(10);
       arrx.add(20);
       System.out.println(arrx);
       //LinkedList<Integer> arrx = new LinkedList<>(); compilation exception
       //arrx = new LinkedList<>(); //Compilation Exception
       // Later, if you want to switch to LinkedList, you have to change everywhere
       //but if we defined as List<Integer> arrx = new ArrayList<>(); we can

       List<Integer> arry = new ArrayList<>();
       arry.add(100);
       arry.add(200);
       System.out.println(arry);
       arry.add(1,299);
       arry.add(null);
       System.out.println(arry);
       
       
       //Since arr is declared as List<Integer>, it can access new features added to List in future versions.
       //If we had declared ArrayList<Integer>, we could not access List.of() directly.
       arry = List.of(1,2,3,4,5,6,7,8,9,10);
       System.out.println(arry);
       //If want to switch we can
       arry = new LinkedList<>();
       arry.add(1000);
       arry.add(2000);
       System.out.println(arry);
       arry = new Vector<>();
       arry.add(50);
       arry.add(25);
       System.out.println(arry);
       //We can switch implementations easily (ArrayList → LinkedList → Vector) without changing the variable type.

       ArrayList arr = new ArrayList();
       arr.add(10);
       arr.add("Pavan");
       arr.add(20.89);
       //as here we dont have any generic type safety won't be there.
       System.out.println(arr.toString());
       //List<Employee> list = new ArrayList<>();
       System.out.println(Math.ceil(3.14));

       List<Integer> lst1 = new ArrayList<>(List.of(1,2,3,4));
       List<Integer> lst2 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
       //Iterating lst1 with arrow function introduced in java 8
       lst1.forEach(a -> System.out.print(a));
       lst1.forEach(b -> System.out.print(b));
       //Iteration lst2 with method reference introuced in java 8
       lst2.forEach(System.out::print);
       lst2.forEach(System.out::print);
        int pairCount = 0;
       String jhon = "kalyan";
       String jhon1 = "knlyaa";
       //Map<Character,Integer> counts = new LinkedHashMap<>();
       List<Integer> list = new ArrayList<>();
       for(int i=0; i<jhon.length(); i++) { // as both str are same take anyone
        if(jhon.charAt(i) != jhon1.charAt(i)) {
            list.add(i); 
        }
       } // list = [1,6]
       if(list.size() != 2) { // if(list.size() <=1 || list.size()>2)
        System.out.println("Not possible false");
       }
       // else
       System.out.println();
       System.out.println();
       char[] ch = jhon1.toCharArray(); // list =  [0,6] {k,n,l,y,a,a} 
        char temp = ch[list.get(0)];
        ch[list.get(0)] = ch[list.get(1)]; // n = a
        ch[list.get(1)] = temp; // a = n
       jhon1 = new String(ch);
       System.out.println(jhon1);
       jhon1 = ch.toString();
       System.out.println(jhon1);
      /*  char first = jhon.charAt(0);
       char last = jhon.charAt(jhon.length()-1);
       String middle = jhon.substring(1,jhon.length()-1);
       String ress = last+middle+first;
       System.out.println();
       System.out.println(ress);
       System.out.println(jhon.equals(ress)); */

       String[] names1 = {"vikram","asam", "asnil","bob","jhon"};
       Arrays.sort(names1); // lexiographically sorting
       System.out.println(Arrays.toString(names1));
    }
}
