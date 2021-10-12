package me.hyeonic.algorithm.baekjoon.silver1;

import java.util.Scanner;

public class BOJ11660 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] array = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                array[i][j] = array[i][j - 1] + scanner.nextInt();
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (m-- > 0) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();

            int result = 0;
            for (int i = x1; i <= x2; i++) {
                result += array[i][y2] - array[i][y1 - 1];
            }

            stringBuilder.append(result).append("\n");
        }

        System.out.println(stringBuilder);
    }
}

class BOJ11660DP {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = scanner.nextInt() + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (m-- > 0) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();

            int result = dp[x2][y2] + dp[x1 - 1][y1 - 1] - dp[x1 - 1][y2] - dp[x2][y1 - 1];

            stringBuilder.append(result).append("\n");
        }

        System.out.println(stringBuilder);
    }
}