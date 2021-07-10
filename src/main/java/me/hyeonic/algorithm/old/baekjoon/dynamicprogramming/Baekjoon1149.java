package me.hyeonic.algorithm.old.baekjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon1149 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] rgbArray = new int[n][3];
        int[][] dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            String[] rgb = bufferedReader.readLine().split(" ");
            rgbArray[i][0] = Integer.parseInt(rgb[0]); // red
            rgbArray[i][1] = Integer.parseInt(rgb[1]); // green
            rgbArray[i][2] = Integer.parseInt(rgb[2]); // blue
        }

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][0] = rgbArray[i][0];
                dp[i][1] = rgbArray[i][1];
                dp[i][2] = rgbArray[i][2];
            } else {
                dp[i][0] = rgbArray[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
                dp[i][1] = rgbArray[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
                dp[i][2] = rgbArray[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
            }
        }

        bufferedWriter.write(String.valueOf(Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2])));

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}