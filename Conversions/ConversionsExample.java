import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConversionsExample {
    public static void main(String[] args) {
        // 1) Collections -> primitive arrays arr[]
        System.out.println("Collections -> primitive arrays");
        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6);
        // convert List<Integer> to int[]
        int[] intArr = list1.stream().mapToInt(i -> i).toArray();
        System.out.println(Arrays.toString(intArr)); // [1,2,3,4,5,6]

        List<Double> list2 = Arrays.asList(1.03,2.3,3.2,4.5,5.908,6.0);
        double[] floatArr = list2.stream().mapToDouble(d -> d).toArray();
        System.out.println(Arrays.toString(floatArr)); 
        
        List<Long> list3 = Arrays.asList(100L, 200l, 300L, 400L); // l samll or capital L no matter it seems
        long[] longArr = list3.stream().mapToLong(l -> l).toArray();
        System.out.println(Arrays.toString(longArr));

        List<String> list4 = Arrays.asList("Asam","Pavan","kumar","reddy");
        String[] strArr = list4.toArray(new String[0]);
        System.out.println(Arrays.toString(strArr));

        List<String> list5 = Arrays.asList("SLN", "Omh", "Shivaya");
        String[] strArr1 = list5.toArray(new String[0]);
        System.out.println(Arrays.toString(strArr1));

        // 2) Collections -> Integer[]
        // List<Integer> lst1 = Arrays.asList(4,3,2,1);
        System.out.println("Collections -> Integer[]");
        Integer[] wrapInt = list1.toArray(new Integer[0]);
        Double[] wrapDou = list2.toArray(new Double[0]);
        Long[] wrapLong = list3.toArray(new Long[0]);
        System.out.println(Arrays.toString(wrapInt));
        System.out.println(Arrays.toString(wrapDou));
        System.out.println(Arrays.toString(wrapLong));

        // 3) Converts List, Set, or Map to a readable string.
        // Arrays.toString(collection.toArray())   
        List<String> frtList = Arrays.asList("apple","banana","cherry");
        System.out.println(Arrays.toString(frtList.toArray())); // [apple, banana, cherry]

        // 4) Str -> str[] array (str.split(","))
        String name = "Asam,Pavan,Kumar,Reddy";
        String[] fruits = name.split(",");
        System.out.println(Arrays.toString(fruits)); //  Output: [apple, banana, cherry]

        // 5) str[] -> Str (str.join(","))
        String[] s1 = {"apple","bat","cat","dog"};
        String res1 = String.join(" ",s1);
        System.out.println(res1);

        // Advanced conversoins
        // 6) int[] to Integer[] (BOXING)
        // Because int[] is primitive, we must use Streams for conversion.
        int[] intArr1 = {11,12,13,14};
        Integer[] integerArr = Arrays.stream(intArr1).boxed().toArray(Integer[]::new);
        System.out.println("\nint[] to Integer[] BOXING");
        System.out.println(Arrays.toString(integerArr));

        // 7) Integer[] to int[] (UNBOXING)
        // For converting Integer[] to int[], use mapToInt().
        Integer[] integerArray1 = {111,222,333,444};
        int[] intArrx = Arrays.stream(integerArray1).mapToInt(Integer::intValue).toArray();
        System.out.println("\nInteger[] to int[] Unboxing");
        System.out.println(Arrays.toString(intArrx));

        // Sample Map displaing example using labda function forEach
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"Apple");
        map.put(2,"Boxing");
        System.out.println("\n Map for each example");
        map.forEach((key,value) -> System.out.println(key+" -> "+ value));



    }
}
