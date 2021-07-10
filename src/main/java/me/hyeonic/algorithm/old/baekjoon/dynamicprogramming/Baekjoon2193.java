package me.hyeonic.algorithm.old.baekjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon2193 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        long[] dp = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            if (i == 1 || i == 2) dp[i] = 1;
            else dp[i] = dp[i - 1] + dp[i - 2];
        }

        bufferedWriter.write(String.valueOf(dp[n]));

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}