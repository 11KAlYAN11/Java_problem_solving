package General_Problems.RecurssionPrblms;

import java.util.stream.IntStream;


public class PrintWoLoop {
    static void print(int i) {
        if(i>100) return;
        System.out.print(i+" ");
        print(i+1);
    }
    public static void main(String[] args) {
        print(1);


        // Method2:
        IntStream.rangeClosed(1, 100).forEach(System.out::print);
        
    }
}
