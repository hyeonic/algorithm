package me.hyeonic.algorithm.baekjoon.silver3;

import java.util.Scanner;

public class BOJ14889 {

    private static int n;
    private static int[][] s;
    private static boolean[] visited;
    private static int min = Integer.MAX_VALUE;

    private static void backtracking(int index, int depth) {

        if (depth == n / 2) {
            int teamStart = 0;
            int teamLink = 0;

            for (int i = 1; i < n; i++) {
                for (int j = i; j <= n; j++) {
                    if (visited[i] && visited[j]) {
                        teamStart += s[i][j];
                        teamStart += s[j][i];
                    } else if (!visited[i] && !visited[j]) {
                        teamLink += s[i][j];
                        teamLink += s[j][i];
                    }
                }
            }

            min = Math.min(min, Math.abs(teamStart - teamLink));
            return;
        }

        for (int i = index; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();

        s = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                s[i][j] = scanner.nextInt();
            }
        }

        visited = new boolean[n + 1];

        backtracking(1, 0);

        System.out.println(min);
    }
}