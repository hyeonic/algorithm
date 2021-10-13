package me.hyeonic.algorithm.baekjoon.silver3;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ15654 {

    private static int n, m;
    private static int[] array;
    private static int[] result;
    private static boolean[] visited;
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void backtracking(int depth) {
        if (depth == m) {
            for (int i : result) {
                stringBuilder.append(i).append(" ");
            }
            stringBuilder.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = array[i];
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        array = new int[n];
        result = new int[m];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        Arrays.sort(array);

        backtracking(0);

        System.out.println(stringBuilder);
    }
}