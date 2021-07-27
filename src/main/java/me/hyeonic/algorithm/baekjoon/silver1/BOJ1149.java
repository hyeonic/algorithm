package me.hyeonic.algorithm.baekjoon.silver1;

import java.util.Scanner;

public class BOJ1149 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] rgbs = new int[n][3];
        int[][] dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            int r = scanner.nextInt();
            int g = scanner.nextInt();
            int b = scanner.nextInt();

            rgbs[i][0] = r;
            rgbs[i][1] = g;
            rgbs[i][2] = b;
        }

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][0] = rgbs[i][0];
                dp[i][1] = rgbs[i][1];
                dp[i][2] = rgbs[i][2];
                continue;
            }

            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + rgbs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + rgbs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + rgbs[i][2];
        }

        int min = Integer.MAX_VALUE;
        for (int value : dp[n - 1]) {
            if (min > value) {
                min = value;
            }
        }

        System.out.println(min);
    }
}