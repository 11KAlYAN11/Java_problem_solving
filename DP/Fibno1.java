import java.util.Arrays;

public class Fibno1 {

    // Declare memoArray as a static variable to access it in main
    private static long[] memoArray;

    private static int[] dp;

    public static void main(String[] args) {
        long num = fibMemo(5);

        // 1st way ⭐⭐ Recursion + Memoization (Top-down DP)
        System.out.println("1st way ⭐⭐ Recursion + Memoization (Top-down DP)");
        System.out.println("Fibonacci result: " + num);
        System.out.println("Memoization array: " + Arrays.toString(memoArray));

        // ⭐⭐⭐ 3) Iterative DP / Tabulation (Bottom-up DP)
        System.out.println("⭐⭐⭐ 3) Iterative DP / Tabulation (Bottom-up DP)");
        int res2 = fibDP(5);
        System.out.println("Fibonacci rsult2: "+ res2);
        System.out.println("Array: "+Arrays.toString(dp));

    }

  

    public static long fibMemo(int n) {
        // 1) Create a memo array of size n+1 to store results for fib(0)..fib(n).
        memoArray = new long[n + 1];

        // 2) Initialize it with a sentinel value (-1) meaning "not computed".
        //    We use -1 because valid Fibonacci results are >= 0.
        Arrays.fill(memoArray, -1);

        // 3) Kick off the recursive helper which will use the memo array.
        return fibMemoHelper(n, memoArray);
    }

    private static long fibMemoHelper(int n, long[] memo) {
        // Base cases: fib(0)=0, fib(1)=1
        if (n <= 1) return n;

        // If we already computed fib(n), return it directly (avoid recomputation).
        if (memo[n] != -1) return memo[n];

        // Otherwise compute recursively, store the result in memo[n], and return it.
        memo[n] = fibMemoHelper(n - 1, memo) + fibMemoHelper(n - 2, memo);
        return memo[n];
    }

    public static int fibDP(int n) {
        dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

}


/*
fibMemoHelper(5)               // memo: [-1,-1,-1,-1,-1,-1]
  -> needs fib(4) and fib(3)
  fibMemoHelper(4)             // memo: [-1,-1,-1,-1,-1,-1]
    -> needs fib(3) and fib(2)
    fibMemoHelper(3)           // memo: [-1,-1,-1,-1,-1,-1]
      -> needs fib(2) and fib(1)
      fibMemoHelper(2)         // memo: [-1,-1,-1,-1,-1,-1]
        -> needs fib(1) and fib(0)
        fibMemoHelper(1) -> returns 1  // base case
        fibMemoHelper(0) -> returns 0  // base case
        // now memo[2] = 1 + 0 = 1
        memo becomes: [-1,-1,1,-1,-1,-1]
      // back to fib(3): fib(2) is now in memo -> returned instantly (1)
      fibMemoHelper(1) -> returns 1
      // memo[3] = fib(2) + fib(1) = 1 + 1 = 2
      memo becomes: [-1,-1,1,2,-1,-1]
    // back to fib(4): need fib(3) (found in memo -> 2) and fib(2) (found in memo -> 1)
    // memo[4] = 2 + 1 = 3
    memo becomes: [-1,-1,1,2,3,-1]
  // back to fib(5): need fib(4) (3) and fib(3) (2)
  // memo[5] = 3 + 2 = 5
  memo becomes: [-1,-1,1,2,3,5]

 */
