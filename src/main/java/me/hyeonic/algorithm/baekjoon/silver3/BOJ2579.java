package me.hyeonic.algorithm.baekjoon.silver3;

import java.util.Scanner;

public class BOJ2579 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] stairs = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < stairs.length; i++) {
            stairs[i] = scanner.nextInt();
        }

        for (int i = 0; i < stairs.length; i++) {
            if (i == 0) {
                dp[i] = stairs[i];
            } else if (i == 1) {
                dp[i] = dp[i - 1] + stairs[i];
            } else if (i == 2) {
                dp[i] = Math.max(stairs[i - 1], stairs[i - 2]) + stairs[i];
            } else {
                dp[i] = Math.max(dp[i - 3] + stairs[i - 1], dp[i - 2]) + stairs[i];
            }
        }

        System.out.println(dp[n - 1]);
    }
}