package me.hyeonic.algorithm.thisiscodingtest.chapter08;

import java.util.Scanner;

public class Practice8_6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] foods = new int[n];
        for (int i = 0; i < n; i++) {
            foods[i] = scanner.nextInt();
        }

        int[] dp = new int[100];
        dp[0] = foods[0];
        dp[1] = Math.max(foods[0], foods[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + foods[i]);
        }

        System.out.println(dp[n - 1]);
    }
}

/*
입력
4
1 3 1 5

출력
8
*/