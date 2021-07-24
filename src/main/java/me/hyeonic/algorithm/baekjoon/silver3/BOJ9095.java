package me.hyeonic.algorithm.baekjoon.silver3;

import java.util.Scanner;

public class BOJ9095 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dp = new int[11];
        int t = scanner.nextInt();

        for (int i = 1; i < dp.length; i++) {
            if (i == 1) {
                dp[i] = 1;
            } else if (i == 2) {
                dp[i] = 2;
            } else if (i == 3) {
                dp[i] = 4;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            System.out.println(dp[n]);
        }
    }
}