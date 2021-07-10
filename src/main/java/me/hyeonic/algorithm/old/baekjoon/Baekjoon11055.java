package me.hyeonic.algorithm.old.baekjoon;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon11055 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] sequence = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            sequence[i] = scanner.nextInt();
        }

        dp[0] = sequence[0];
        for (int i = 1; i < n; i++) {
            dp[i] = sequence[i];
            for (int j = 0; j < i; j++) {
                if (sequence[i] > sequence[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + sequence[i]);
                }
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());

        scanner.close();
    }
}