package me.hyeonic.algorithm.baekjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon1003 {

    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine());

        dp = new int[41][2]; // n은 40보다 작거나 같은 자연수 또는 0의 0과 1의 개수를 저장하는 dp 배열

        dp[0][0] = 1; dp[0][1] = 0; // 0 1번 1 0번
        dp[1][0] = 0; dp[1][1] = 1; // 0 0번 1 1번

        for (int i = 2; i < dp.length; i++) {
            fibonacci(i);
        }

        for (int i = 0; i < t; i++) {
            int num = Integer.parseInt(bufferedReader.readLine());
            bufferedWriter.write(dp[num][0] + " " + dp[num][1] + "\n");
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }

    private static void fibonacci(int n) {
        dp[n][0] = dp[n - 1][0] + dp[n - 2][0];
        dp[n][1] = dp[n - 1][1] + dp[n - 2][1];
    }
}

/**
 요구사항
  - fibonacci(3)을 호출하면 다음과 같은 일이 일어난다.
   fibonacci(3)은 fibonacci(2)와 fibonacci(1) (첫 번째 호출)을 호출한다.
   fibonacci(2)는 fibonacci(1) (두 번째 호출)과 fibonacci(0)을 호출한다.
   두 번째 호출한 fibonacci(1)은 1을 출력하고 1을 리턴한다.
   fibonacci(0)은 0을 출력하고, 0을 리턴한다.
   fibonacci(2)는 fibonacci(1)과 fibonacci(0)의 결과를 얻고, 1을 리턴한다.
   첫 번째 호출한 fibonacci(1)은 1을 출력하고, 1을 리턴한다.
   fibonacci(3)은 fibonacci(2)와 fibonacci(1)의 결과를 얻고, 2를 리턴한다.
   1은 2번 출력되고, 0은 1번 출력된다. N이 주어졌을 때, fibonacci(N)을 호출했을 때,
   0과 1이 각각 몇 번 출력되는지 구하는 프로그램을 작성한다.

 입력
  - 첫째 줄에 테스트 케이스의 개수 T가 주어진다.
  각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다. N은 40보다 작거나 같은 자연수 또는 0이다.

 출력
  - 각 테스트 케이스마다 0이 출력되는 횟수와 1이 출력되는 횟수를 공백으로 구분해서 출력한다.
 */