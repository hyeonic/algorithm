package me.hyeonic.algorithm.old.baekjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon2748 {

    static long[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());

        dp = new long[n + 1];

        for (int i = 0; i <= n; i++) {
            fibonacci(i);
        }

        bufferedWriter.write(String.valueOf(dp[n]));

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }

    private static void fibonacci(int i) {
        if (i == 0) {
            dp[i] = 0;
        } else if (i == 1) {
            dp[i] = 1;
        } else {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
    }
}
