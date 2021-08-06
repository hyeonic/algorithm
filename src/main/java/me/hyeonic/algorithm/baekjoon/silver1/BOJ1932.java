package me.hyeonic.algorithm.baekjoon.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1932 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = bufferedReader.readLine().split(" ");

            if (i == 0) {
                dp[0][0] = Integer.parseInt(input[0]);
                continue;
            }

            for (int j = 0; j <= i; j++) {

                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + Integer.parseInt(input[j]);
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + Integer.parseInt(input[j]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + Integer.parseInt(input[j]);
                }
            }
        }

        int max = Arrays.stream(dp[n - 1]).max().getAsInt();
        System.out.println(max);
    }
}