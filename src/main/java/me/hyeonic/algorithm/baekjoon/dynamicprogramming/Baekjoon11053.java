package me.hyeonic.algorithm.baekjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11053 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        int[] sequence = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < sequence.length; i++)
            sequence[i] = Integer.parseInt(stringTokenizer.nextToken());

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (sequence[i] > sequence[j] && dp[i] <= dp[j]) dp[i] = dp[j] + 1;
            }
        }

        int max = 0;
        for (int i : dp) max = Math.max(max, i);

        System.out.println(max);

        bufferedReader.close();
    }
}