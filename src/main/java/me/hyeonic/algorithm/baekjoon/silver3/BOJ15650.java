package me.hyeonic.algorithm.baekjoon.silver3;

import java.util.Scanner;

public class BOJ15650 {

    static int n, m;
    static int[] result;
    static boolean[] visited;

    private static void backtracking(int depth, int prev) {

        if (depth == m) {
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = prev; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                backtracking(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        result = new int[m];
        visited = new boolean[n + 1];

        backtracking(0, 1);
    }
}