package me.hyeonic.algorithm.baekjoon.silver3;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ15657 {

    private static int n, m;
    private static int[] array;
    private static int[] result;

    private static void backtracking(int depth, int index) {

        if (depth == m) {
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = index; i < n; i++) {
            result[depth] = array[i];
            backtracking(depth + 1, i);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        array = new int[n];
        result = new int[m];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        Arrays.sort(array);


        backtracking(0, 0);
    }
}