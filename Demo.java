import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
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
        

    }
}
