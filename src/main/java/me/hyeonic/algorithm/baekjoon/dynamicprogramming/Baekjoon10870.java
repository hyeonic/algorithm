package me.hyeonic.algorithm.baekjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10870 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] dp = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            if (i == 0) dp[i] = 0;
            else if (i == 1) dp[i] = 1;
            else dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[n]);

        bufferedReader.close();
    }
}