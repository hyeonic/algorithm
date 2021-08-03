package me.hyeonic.algorithm.baekjoon.bronze1;

import java.util.Scanner;

public class BOJ11050 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i == 0 || i == 1) {
                dp[i] = 1;
            } else {
                dp[i] = i * dp[i - 1];
            }
        }

        System.out.println(dp[n] / (dp[k] * dp[n - k]));
    }
}