package me.hyeonic.algorithm.baekjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon1932 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] arr = new int[n][n];
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i + 1; j++) {
                if (i == n - 1) {
                    dp[i][j] = arr[i][j];
                } else {
                    dp[i][j] = arr[i][j] + Math.max(dp[i + 1][j], dp[i + 1][j + 1]);
                }
            }
        }

        bufferedWriter.write(String.valueOf(dp[0][0]));

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}

/**
 요구사항
  - 맨 위층 시작해서 아래에 있는 수 중 하나를 선택하여 아래층으로 내려올 때, 이제까지 선택된 수의 합이 최대가 되는
 경로를 구하는 프로그램을 작성한다. 아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에
 있는 것 중에서만 선택할 수 있다.

 입력
  - 첫째 줄에 삼각형의 크기 n(1 ≤ n ≤ 500)이 주어지고, 둘째 줄부터 n+1번째 줄까지 정수 삼각형이 주어진다.

 출력
  - 첫째 줄에 합이 최대가 되는 경로에 있는 수의 합을 출력한다.
 */