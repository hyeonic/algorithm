package me.hyeonic.algorithm.baekjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon9465 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine()); // 테스트 케이스의 개수 T

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(bufferedReader.readLine()); // n
            int[][] stickers = new int[2][n];
            int[][] dp = new int[2][n];

            String[] input = bufferedReader.readLine().split(" ");
            for (int j = 0; j < n; j++)
                stickers[0][j] = Integer.parseInt(input[j]);

            input = bufferedReader.readLine().split(" ");
            for (int j = 0; j < n; j++)
                stickers[1][j] = Integer.parseInt(input[j]);

            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[0][j] = stickers[0][j];
                    dp[1][j] = stickers[1][j];
                } else if (j == 1) {
                    dp[0][j] = stickers[0][j] + dp[1][j - 1];
                    dp[1][j] = stickers[1][j] + dp[0][j - 1];
                } else {
                    dp[0][j] = Math.max(
                            Math.max(stickers[0][j] + dp[0][j - 2], stickers[0][j] + dp[1][j - 2]),
                            stickers[0][j] + dp[1][j - 1]);
                    dp[1][j] = Math.max(
                            Math.max(stickers[1][j] + dp[0][j - 2], stickers[1][j] + dp[1][j - 2]),
                            stickers[1][j] + dp[0][j - 1]);
                }
            }

            System.out.println(Math.max(dp[0][n - 1], dp[1][n - 1]));
        }
        bufferedReader.close();
    }
}