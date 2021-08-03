package me.hyeonic.algorithm.baekjoon.bronze1;

import java.util.Scanner;

public class BOJ2748 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long[] dp = new long[n + 1];

        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                dp[i] = 0;
            } else if (i == 1) {
                dp[i] = 1;
            } else if (i == 2) {
                dp[i] = 1;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }

        System.out.println(dp[n]);
    }
}