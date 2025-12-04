import java.util.Arrays;

public class Fibno1 {
    public static void main(String[] args) {
        long res = fibMemo(5);
        System.out.println("Fibonacci result: " + res);
        System.out.println("Memoization array: " + Arrays.toString(memoArray));
    }

    // Declare memoArray as a static variable to access it in main
    private static long[] memoArray;

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
}
