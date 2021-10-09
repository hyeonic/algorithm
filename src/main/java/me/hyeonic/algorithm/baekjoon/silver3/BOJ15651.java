package me.hyeonic.algorithm.baekjoon.silver3;

import java.util.Scanner;

public class BOJ15651 {

    private static int n, m;
    private static int[] result;
    private static StringBuilder stringBuilder;

    private static void backtracking(int depth) {

        if (depth == m) {
            for (int i = 0; i < depth; i++) {
                stringBuilder.append(result[i]).append(" ");
            }
            stringBuilder.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            result[depth] = i;
            backtracking(depth + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        stringBuilder = new StringBuilder();
        result = new int[n];

        backtracking(0);

        System.out.println(stringBuilder);
    }
}