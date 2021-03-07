package me.hyeonic.algorithm.baekjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon11057 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] dp = new int[n + 1][10];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (i == 1) {
                    dp[i][j] = 1;
                    continue;
                }

                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
                dp[i][j] %= 10007;
            }
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[n][i];
        }

        System.out.println(sum % 10007);

        bufferedReader.close();
    }
}