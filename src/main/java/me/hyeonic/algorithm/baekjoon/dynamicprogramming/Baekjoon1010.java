package me.hyeonic.algorithm.baekjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon1010 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine()); // 테스트 케이스 T

        for (int i = 0; i < t; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            int[][] dp = new int[n + 1][m + 1];

            for (int  j = 1; j <= n; j++) {
                for (int k = 1; k <= m; k++) {
                    if (j == 1) {
                        dp[j][k] = k;
                    } else if (k == 1) {
                        dp[j][k] = 0;
                    } else {
                        dp[j][k] = dp[j][k - 1] + dp[j - 1][k - 1];
                    }
                }
            }
            bufferedWriter.write(dp[n][m] + "\n");
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}