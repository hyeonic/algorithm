package me.hyeonic.algorithm.old.baekjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon9095 {

    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine());

        dp = new int[11]; // n은 양수이며 11보다 작다. 0 ~ 10

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        dp[4] = 7;

        for (int i = 5; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp [i - 3];
        }

        for (int i = 0; i < t; i++) {
            int num = Integer.parseInt(bufferedReader.readLine());
            bufferedWriter.write(dp[num] + "\n");
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}