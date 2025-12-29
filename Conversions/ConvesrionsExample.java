package Conversions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


public class ConvesrionsExample {
    public static void main(String[] args) {
        // 1) arr[] to ArrList[]
        String[] arr = {"A","B","c"};
        // Convert arr[] to arrList
        List<String> arrList = new ArrayList<>(Arrays.asList(arr)); 
        // Output: A B c
        arrList.forEach(System.out::println);

        int[] intArr = {1,2,3,4};
        // If you need to convert a primitive array like int[] into an ArrayList, you'll need to manually box the elements:
        // List<Integer> intList = new ArrayList<>(Arrays.asList(intArr));
        List<Integer> intList = new ArrayList<>();
        for(int num: intArr) {
            intList.add(num); // Boxing the int values
        }
        // Output: 1 2 3 4
        intList.forEach(System.out::println);

        // 2) arr[], arrList[] to String
        String[] strArr = {"A","B","C", "D"};
        String arrayString = Arrays.toString(strArr); // "[A,B,C,D]" 
        // Output: [A, B, C, D]
        System.out.println(arrayString);

        int[] intArr1 = {5,4,3,2,1};
        String intArrToStr = Arrays.toString(intArr1); 
        // Output: [5, 4, 3, 2, 1]
        System.out.println(intArrToStr);

        List<String> asam1 = new ArrayList<>(Arrays.asList("a","b","c","d","e"));
        String strAsam1 = asam1.toString(); 
        // Output: [a, b, c, d, e]
        System.out.println(strAsam1);
        
        List<Integer> asam2 = new ArrayList<>(Arrays.asList(1,2,3,9,8,7,5)); 
        String strAsam2 = asam2.toString(); 
        // Output: [1, 2, 3, 9, 8, 7, 5]
        System.out.println(strAsam2);

        // 3) String to arr[] & ArrList[]
        List<String> strArr1 = new ArrayList<>();

        String name = "Asam Pavan Kumar Reddy";
        String[] nameArr = name.split(" ");
        for(String str: nameArr) {
            System.out.println(str);
            // Output: Asam
            // Output: Pavan
            // Output: Kumar
            // Output: Reddy
            strArr1.add(str);
        }
        strArr1.forEach(System.out::println);
        conversionsMtd();
       
    }

    public static void conversionsMtd() {
        // 1) ArrayList to Array
        List<String> arrList = new ArrayList<>(Arrays.asList("A","B","C","D")); // This is modifiable
        List<String> arrList1 = Arrays.asList("A","S","A","M"); // this will create fixed length not modifiable
        //List<Integer> arrList2 = Arrays.asList(7,5,6,9,9,0);
        
        String[] arr = arrList.toArray(new String[0]);
        String[] arr1 = arrList1.toArray(new String[0]);
        // int[] arr2 = arrList2.toArray(new int[0]);
        printElements(arr);
        // Output: A B C D
        printElements(arr1);
        // Output: A S A M

        // 2) String to charArray
        String str1 = "Hello";
        char[] charArray = str1.toCharArray();
        printElements(charArray);
        // Output: H e l l o
        
        // 3) CharArray to string
        char[] char1 = {'a','s','a','m'};
        String s = new String(char1); // char -> String
        System.out.println(s);
        // Output: asam

        // Integer to String vice versa
        String numStr = "1234";
        int num = Integer.parseInt(numStr); // Str -> int
        // Output: 1234
        numStr = Integer.toString(num); // int -> Str

        // 4) String to ArrayList of Characters
        String stra = "Hello";
        List<Character> charList = new ArrayList<>();
        for(char c: stra.toCharArray()) {
            charList.add(c);
        }
        charList.forEach(System.out::println);
        // Output: H e l l o
        charList.forEach(ch -> System.out.println(ch));
        // Output: H e l l o
        
        // 5) ArrayList of Characters -> String
        StringBuilder sb = new StringBuilder();
        for(char c: charList) {
            sb.append(c);
        }
        System.out.println(sb.toString());
        // Output: Hello
    }

    // This method is just to display the elements
    public static void printElements(Object input) {
        if(input instanceof Collection) {
            for(Object element: (Collection<?>) input) {
                System.out.print(element+" ");
            }
            System.out.println();
        }
        else if(input instanceof int[]) {
            for(int element: (int[]) input) {
                System.out.print(element+" ");
            }
            System.out.println();
        }
        else if(input instanceof float[]) {
            for(float element: (float[]) input) {
                System.out.print(element+"f ");
            }
            System.out.println();
        }
        else if(input instanceof double[]) {
            for(double element: (double[]) input) {
                System.out.print(element+" ");
            }
            System.out.println();
        }
        else if(input instanceof String[]) {
            for(String element: (String[])input) {
                System.out.print(element+" ");
            }
            System.out.println();
        }
        else if(input instanceof char[]) {
            for(char element: (char[])input) {
                System.out.print(element+" ");
            }
            System.out.println();
        }
        else {
            System.out.println("Unsupported type!..");
        }
    }
}
