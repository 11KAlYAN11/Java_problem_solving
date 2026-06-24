package Exceptions;

public class A {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(minJumps(arr));
    }

    public static int minJumps(int[] arr) {
        // code here
        int len = arr.length;
        if(arr[0] == 0) return -1;
        
        int left = 0;
        int right = len;
        int idx = 0;
        int count = 0;
        
        while(left < right) {
            
            idx = arr[left]; // 1 -> 3 -> 9
            
            for(int i=0; i<idx; i++) {
                left++; // 1 -> 2 , 3, 4 -> 13
            }
            // idx = left;
            count++; // 1-> 2 -> 
        }
        
        return count;
    }
}