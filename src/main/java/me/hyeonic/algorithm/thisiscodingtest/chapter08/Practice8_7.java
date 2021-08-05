package me.hyeonic.algorithm.thisiscodingtest.chapter08;

import java.util.Scanner;

public class Practice8_7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        // 앞서 계산된 결과를 저장하기 위한 DP 테이블 초기화
        int[] dp = new int[n + 1];

        // 다이나믹 프로그래밍 진행 (바텀업)
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + (dp[i - 2] * 2)) % 796796;
        }

        System.out.println(dp[n]);
    }
}