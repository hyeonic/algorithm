package me.hyeonic.algorithm.old.baekjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon11727 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine()); // 1 <= n <= 1_000
        int[] dp = new int[n + 2];

        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] * 2 + dp[i - 1]) % 10_007;
        }

        System.out.println(dp[n]);

        bufferedReader.close();
    }
}