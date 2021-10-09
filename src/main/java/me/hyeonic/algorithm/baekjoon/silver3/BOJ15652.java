package me.hyeonic.algorithm.baekjoon.silver3;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ15652 {

    private static int n, m;
    private static int[] array;

    private static void backtracking(int depth) {

        if (depth == m) {
            Arrays.stream(array).forEach(i -> System.out.print(i + " "));
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (depth == 0 || i >= array[depth - 1]) {
                array[depth] = i;
                backtracking(depth + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        array = new int[m];

        backtracking(0);
    }
}