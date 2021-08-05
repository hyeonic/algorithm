package me.hyeonic.algorithm.thisiscodingtest.chapter08;

import java.util.Arrays;
import java.util.Scanner;

public class Practice8_8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 화폐의 종류
        int m = scanner.nextInt(); // 가치의 합

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }

        int[] dp = new int[m + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= m; j++) {
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }

        if (dp[m] == Integer.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(dp[m]);
        }
    }
}

/*
입력
2 15
2
3

출력
5

입력
3 4
3
5
7

출력
-1
*/