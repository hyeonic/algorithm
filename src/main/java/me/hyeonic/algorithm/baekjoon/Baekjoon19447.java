package me.hyeonic.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon19447 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine().split(" ");
        int h = Integer.parseInt(input[0]); // 초기 비용
        int y = Integer.parseInt(input[1]); // 투자 기간
        int[] dp = new int[y + 1];

        dp[0] = h; // 초기 비용 0년차

        for (int i = 1; i <=y; i++) {
            dp[i] = (int) (dp[i - 1] * 1.05);
            if (i >= 3) dp[i] = (int) Math.max(dp[i], dp[i - 3] * 1.2);
            if (i >= 5) dp[i] = (int) Math.max(dp[i], dp[i - 5] * 1.35);
        }

        System.out.println(dp[y]);

        bufferedReader.close();
    }
}