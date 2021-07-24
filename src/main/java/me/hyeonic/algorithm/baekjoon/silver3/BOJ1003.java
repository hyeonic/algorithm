package me.hyeonic.algorithm.baekjoon.silver3;

import java.util.Scanner;

public class BOJ1003 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] dp = new int[41][2];

        int t = scanner.nextInt();

        dp[0][0] = 1; dp[0][1] = 0;
        dp[1][0] = 0; dp[1][1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            System.out.println(dp[n][0] + " " + dp[n][1]);
        }
    }
}