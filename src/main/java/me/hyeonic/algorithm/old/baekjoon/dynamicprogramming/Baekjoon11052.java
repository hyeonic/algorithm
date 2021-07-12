package me.hyeonic.algorithm.old.baekjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon11052 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] p = new int[n + 1];
        int[] dp = new int[n + 1];

        String[] input = bufferedReader.readLine().split(" ");
        for (int i = 1; i <= n; i++)
            p[i] = Integer.parseInt(input[i - 1]);

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= i; j++)
                dp[i] = Math.max(dp[i], dp[i - j] + p[j]);

        System.out.println(dp[n]);

        bufferedReader.close();
    }
}