package me.hyeonic.algorithm.old.baekjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon1912 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        String[] input = bufferedReader.readLine().split(" ");

        int[] sequence = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < sequence.length; i++)
            sequence[i] = Integer.parseInt(input[i]);

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i] = sequence[i];
                continue;
            }

            if (sequence[i] <= dp[i - 1] + sequence[i])
                dp[i] = dp[i - 1] + sequence[i];
            else
                dp[i] = sequence[i];
        }

        Arrays.sort(dp);

        System.out.println(dp[n - 1]);

        bufferedReader.close();
    }
}
