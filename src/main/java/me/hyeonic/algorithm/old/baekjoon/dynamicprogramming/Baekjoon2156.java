package me.hyeonic.algorithm.old.baekjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon2156 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] wines = new int[n + 1];
        int[] dp = new int[n + 1];

        for( int i = 1; i <= n; ++i )
            wines[i] = Integer.parseInt(bufferedReader.readLine());

        if (n == 1) {
            dp[1] = wines[1];
        } else if (n == 2) {
            dp[1] = wines[1];
            dp[2] = wines[1] + wines[2];
        } else if (n >= 3) {
            dp[1] = wines[1];
            dp[2] = wines[1] + wines[2];
            dp[3] = max(dp[2], wines[1] + wines[3], wines[2] + wines[3]);

            for (int i = 4; i <= n; i++) { // 마시지 않는 경우를 포함
                dp[i] = max(dp[i - 1], dp[i - 2] + wines[i], dp[i - 3] + wines[i - 1] + wines[i]);
            }
        }

        bufferedWriter.write(String.valueOf(dp[n]));

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }

    static int max(int a, int b, int c) {

        if(a >= b) {
            if(a >= c) return a;
            else return c;
        } else {
            if(b >= c) return b;
            else return c;
        }
    }
}