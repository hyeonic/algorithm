package me.hyeonic.algorithm.baekjoon.silver3;

import java.util.Scanner;

public class BOJ14501 {

    private static int n, result;
    private static int[] t, p;

    private static void dfs(int day, int pay) {

        if (day == n + 1) {
            result = Math.max(result, pay);
        }

        if (day > n) {
            return;
        }

        dfs(day + t[day], pay + p[day]);
        dfs(day + 1, pay);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();

        t = new int[n + 1];
        p = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            t[i] = scanner.nextInt();
            p[i] = scanner.nextInt();
        }

        dfs(1, 0);

        System.out.println(result);
    }
}