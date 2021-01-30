package me.hyeonic.algorithm.baekjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon2579 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] stairs = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++)
            stairs[i] = Integer.parseInt(bufferedReader.readLine());

        if (n == 1) {
            dp[0] = stairs[0];
        } else if (n == 2) {
            dp[0] = stairs[0];
            dp[1] = stairs[0] + stairs[1];
        } else if (n >= 3) {
            dp[0] = stairs[0];
            dp[1] = stairs[0] + stairs[1];
            dp[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);

            for (int i = 3; i < n; i++) {
                dp[i] = Math.max(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i - 1] + stairs[i]);
            }
        }
        
        bufferedWriter.write(String.valueOf(dp[n - 1]));

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}