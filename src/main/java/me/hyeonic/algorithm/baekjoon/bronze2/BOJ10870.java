package me.hyeonic.algorithm.baekjoon.bronze2;

import java.util.Scanner;

public class BOJ10870 {

    // bottom-up 방식
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] dp = new int[21];

        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[n]);
    }
}

class BOJ10870TopDown {

    static int[] dp = new int[21];

    private static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        System.out.println(fibonacci(n));
    }
}