package me.hyeonic.algorithm.baekjoon.silver1;

import java.util.Scanner;

public class BOJ9465 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();

            int[][] array = new int[2][n + 1];

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < n; j++) {
                    array[i][j] = scanner.nextInt();
                }
            }

            int[][] dp = new int[2][n + 1];
            dp[0][0] = array[0][0];
            dp[1][0] = array[1][0];
            dp[0][1] = array[1][0] + array[0][1];
            dp[1][1] = array[0][0] + array[1][1];
            for (int i = 2; i < n; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + array[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + array[1][i];
            }

            System.out.println(Math.max(dp[0][n - 1], dp[1][n - 1]));
        }
    }
}