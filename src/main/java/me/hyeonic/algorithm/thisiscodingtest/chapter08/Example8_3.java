package me.hyeonic.algorithm.thisiscodingtest.chapter08;

public class Example8_3 {

    static long[] dp = new long[100];

    private static long fibonacci(int x) {

        System.out.print("f(" + x + ") ");
        if (x == 1 || x == 2) {
            return 1;
        }

        if (dp[x] != 0) {
            return dp[x];
        }

        dp[x] = fibonacci(x - 1) + fibonacci(x - 2);
        return dp[x];
    }

    public static void main(String[] args) {
        fibonacci(6);
    }
}