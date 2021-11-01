package me.hyeonic.algorithm.baekjoon.silver3;

import java.util.Scanner;

public class BOJ1699 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j <= i / 2; j++) {
                if (j * j == i) {
                    dp[i] = 1;
                    break;
                }

                dp[i] = Math.min(dp[i], dp[i - j] + dp[j]);
            }
        }

        System.out.println(dp[n]);
    }
}