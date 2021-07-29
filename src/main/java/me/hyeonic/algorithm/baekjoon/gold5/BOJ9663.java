package me.hyeonic.algorithm.baekjoon.gold5;

import java.util.Scanner;

public class BOJ9663 {

    private static int[] array;
    private static int n;
    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        array = new int[n];

        nQueen(0);

        System.out.println(count);
    }

    private static void nQueen(int row) {
        if (row == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            array[row] = i;
            if (isPossibility(row)) {
                nQueen(row + 1);
            }
        }
    }

    private static boolean isPossibility(int col) {
        for (int i = 0; i < col; i++) {

            if (array[col] == array[i]) {
                return false;
            } else if (Math.abs(col - i) == Math.abs(array[col] - array[i])) {
                return false;
            }
        }

        return true;
    }
}