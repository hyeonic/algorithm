package me.hyeonic.algorithm.baekjoon.silver1;

import java.util.Scanner;

public class BOJ10844 {

    public static final long DIV = 1_000_000_000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long[][] dp = new long[n + 1][10];

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {

                if (j == 0) {
                    dp[i][0] = dp[i - 1][1] % DIV;
                    continue;
                }

                if (j == 9) {
                    dp[i][9] = dp[i - 1][8] % DIV;
                    continue;
                }

                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % DIV;
            }
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[n][i];
        }

        System.out.println(sum % DIV);
    }
}