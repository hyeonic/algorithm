package me.hyeonic.algorithm.baekjoon.silver1;

import java.util.Scanner;

public class BOJ15486 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] t = new int[n + 2];
        int[] p = new int[n + 2];
        int[] dp = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            t[i] = scanner.nextInt();
            p[i] = scanner.nextInt();
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n + 1; i++) {
            max = Math.max(max, dp[i]);

            int day = i + t[i];
            if (day <= n + 1) {
                dp[day] = Math.max(dp[day], max + p[i]);
            }
        }

        System.out.println(max);
    }
}