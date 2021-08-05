package me.hyeonic.algorithm.thisiscodingtest.chapter08;

import java.util.Scanner;

public class Practice8_5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        // 앞서 계산된 결과를 저장하기 위한 DP 테이블 초기화
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            // 현재의 수에서 1을 빼는 경우
            dp[i] = dp[i - 1] + 1;

            if (i % 2 == 0) { // 현재의 수가 2로 나누어 떨어지는 경우
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            } else if (i % 3 == 0) { // 현재의 수가 3으로 나누어 떨어지는 경우
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            } else if (i % 5 == 0) { // 현재의 수가 5로 나누어 떨어지는 경우
                dp[i] = Math.min(dp[i], dp[i / 5] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}