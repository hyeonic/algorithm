package me.hyeonic.algorithm.baekjoon.bronze1;

import java.util.Scanner;

public class BOJ2167 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] array = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                array[i][j] = array[i][j - 1] + scanner.nextInt();
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        int t = scanner.nextInt();
        while (t-- > 0) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            int result = 0;
            for (int a = i; a <= x; a++) {
                result += array[a][y] - array[a][j - 1];
            }

            stringBuilder.append(result).append("\n");
        }

        System.out.println(stringBuilder);
    }
}

class BOJ2167DP {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = scanner.nextInt() + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        int t = scanner.nextInt();
        while (t-- > 0) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            int result = dp[x][y] + dp[i - 1][j - 1] - dp[i - 1][y] - dp[x][j - 1];

            stringBuilder.append(result).append("\n");
        }

        System.out.println(stringBuilder);
    }
}