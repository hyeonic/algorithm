package me.hyeonic.algorithm.baekjoon.silver1;

import java.util.Scanner;

public class BOJ2156 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] wines = new int[10_001];
        int[] dp = new int[10_001];

        for (int i = 1; i <= n; i++) {
            wines[i] = scanner.nextInt();
        }

        dp[1] = wines[1];
        dp[2] = wines[1] + wines[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(
                        dp[i - 1],
                        Math.max(
                            dp[i - 2] + wines[i],
                            dp[i - 3] + wines[i - 1] + wines[i])
            );
        }

        int max = Integer.MIN_VALUE;
        for (int i : dp) {
            max = Math.max(i, max);
        }

        System.out.println(max);
    }
}