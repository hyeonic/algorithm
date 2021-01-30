package me.hyeonic.algorithm.example.dynamicprogramming;

public class FibonacciByDynamic {

    static long[] dp = new long[51];

    public static void main(String[] args) {

        for (int i = 1; i <= 50; i++) {
            System.out.println(fibonacci(i));
        }
    }

    private static long fibonacci(int n) {

        if (n == 1 || n == 2) {
            dp[n] = 1;
        } else {
            dp[n] = dp[n - 1] + dp[n - 2];
        }

        return dp[n];
    }
}