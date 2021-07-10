package me.hyeonic.algorithm.old.baekjoon.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon10942 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = new int[n + 1];
        int[][] dp = new int[n + 1][n + 1];

        String[] input = bufferedReader.readLine().split(" ");
        for (int i = 1; i <= input.length; i++)
            numbers[i] = Integer.parseInt(input[i - 1]);

        for (int i = 1; i <= n; i++) // S ~ E의 길이가 1일 때, 팰린드롬에 만족한다.
            dp[i][i] = 1;

        for (int i = 1; i <= n - 1; i++) // S ~ E의 길이가 2일 때, 서로 같은 수이면 팰린드롬에 만족한다.
            if (numbers[i] == numbers[i + 1]) dp[i][i + 1] = 1;

        for (int i = 3; i <= n; i++) { // S ~ E의 길이가 3이상 일 때,
            for (int j = 1; j <= n - i + 1; j++) {
                int k = j + i - 1;

                // 현 위치의 값이 같고, 이전 값들이 팰린드롬에 만족해야 팰린드롬을 만족한다.
                if(numbers[j] == numbers[k] && dp[j + 1][k - 1] == 1)
                    dp[j][k] = 1;

            }
        }

        n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            input = bufferedReader.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            bufferedWriter.write(dp[s][e] + "\n");
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}