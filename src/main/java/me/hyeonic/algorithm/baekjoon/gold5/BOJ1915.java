package me.hyeonic.algorithm.baekjoon.gold5;

import java.util.Scanner;

public class BOJ1915 {

    private static int n, m;
    private static int[][] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        dp = new int[n + 1][m + 1];
        int result = 0;
        for (int i = 1; i <= n; i++) {
            String next = scanner.next();
            for (int j = 1; j <= m; j++) {
                int value = next.charAt(j - 1) - '0';
                if (value == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }

        for (int[] ints : dp) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        System.out.println(result * result);
    }
}