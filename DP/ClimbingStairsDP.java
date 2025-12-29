import java.util.Arrays;
package com.learning.java.dp;

public class ClimbingStairsDP {
    // will take 2 static arrays to access accross class
     private static int[] res;
     private static int[] res2; 
    public static void main(String[] args) {

        // 1) Top -Down memoization // 1st way ⭐⭐ Recursion + Memoization (Top-down DP)
        int ans = climbStairs(6);
        System.out.println("Ans: "+ans);
        System.out.println("Res1: "+Arrays.toString(res));

        // 2)  // ⭐⭐⭐ 3) Iterative DP / Tabulation (Bottom-up DP)
        int ans2 = goClimb(10);
        System.out.println("Ans: "+ans2);
        System.out.println("Res2: "+Arrays.toString(res2));
    }
    public static int climbStairs(int n) {
        res = new int[n+1];
        Arrays.fill(res, -1);
        return climb(n, res);
    }

    public static int climb(int n, int[] res) {
        // base case
        if(n<=2) return n;

        if(res[n] != -1) return res[n]; // reuse the same result

        res[n] = climb(n-1, res) + climb(n-2, res);

        return res[n];
    }
    public static int goClimb(int n) {
        res2 = new int[n+1];
        Arrays.fill(res, -1);
        res2[0] = 1;
        res2[1] = 1;

        for(int i=2; i<=n; i++) {
            res2[i] = res2[i-1] + res2[i-2];
        }
        return res2[n];
    }
}
