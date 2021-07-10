package me.hyeonic.algorithm.old.baekjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon1463 {
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = bufferedReader.readLine();
        int n = Integer.parseInt(input);

        dp = new int[n + 4];

        for (int i = 0; i < dp.length; i++) {
            divide(i);
        }

        bufferedWriter.write(String.valueOf(dp[n]));

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }

    private static int divide(int n) {

        if (n == 0 || n == 1) {
            dp[n] = 0;
        } else if (n == 2 || n == 3) {
            dp[n] = 1;
        } else if (n % 2 == 0 && n % 3 == 0) {
            int temp1 = Math.min(dp[n / 3] + 1, dp[n / 2] + 1);
            int temp2 = dp[n - 1] + 1;

            dp[n] = Math.min(temp1, temp2);
        } else if (n % 2 == 0) {
            dp[n] = Math.min(dp[n / 2] + 1, dp[n - 1] + 1);
        } else if (n % 3 == 0) {
            dp[n] = Math.min(dp[n / 3] + 1, dp[n - 1] + 1);
        } else {
            dp[n] = dp[n - 1] + 1;
        }

        return dp[n];
    }
}
