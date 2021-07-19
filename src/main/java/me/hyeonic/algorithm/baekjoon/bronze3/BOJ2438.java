package me.hyeonic.algorithm.baekjoon.bronze3;

import java.util.Scanner;

public class BOJ2438 {

    public static void main(String[] args) {
        long beforeTime = System.currentTimeMillis();

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime)/1000;
        System.out.println("시간차이(m) : "+secDiffTime);
    }
}

class BOJ2438DP {

    public static void main(String[] args) {
        long beforeTime = System.currentTimeMillis();

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String[] dp = new String[n + 1];

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[1] = "*";
            } else {
                dp[i] = "*" + dp[i - 1];
            }

            System.out.println(dp[i]);
        }

        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime)/1000;
        System.out.println("시간차이(m) : "+secDiffTime);
    }
}