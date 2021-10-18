package me.hyeonic.algorithm.baekjoon.silver2;

import java.util.Scanner;

public class BOJ1912 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] array = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        dp[0] = array[0];
        int max = array[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}