package me.hyeonic.algorithm.old.baekjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10844 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine()); // 수의 길이
        long[][] dp = new long[n + 1][10];
        long mod = 1000000000;

        for( int i = 1; i <= 9; ++i ) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0)
                    dp[i][j] = dp[i - 1][j + 1] % mod;
                else if (j == 9)
                    dp[i][j] = dp[i - 1][j - 1] % mod;
                else
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 9; j++)
                System.out.print(dp[i][j] + " ");
            System.out.println();
        }

        long sum = 0;
        for (long value : dp[n]) sum += value;

        System.out.println(sum % mod);

        bufferedReader.close();
    }
}