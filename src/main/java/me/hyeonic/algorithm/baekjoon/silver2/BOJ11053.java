package me.hyeonic.algorithm.baekjoon.silver2;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ11053 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] numbers = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i <  n; i++) {
            numbers[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (numbers[j] < numbers[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = Arrays.stream(dp)
                .max()
                .orElse(0);
        System.out.println(max);
    }
}