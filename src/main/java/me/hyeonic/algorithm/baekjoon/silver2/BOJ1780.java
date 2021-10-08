package me.hyeonic.algorithm.baekjoon.silver2;

import java.util.Scanner;

public class BOJ1780 {

    private static int n;
    private static int[][] board;
    private static int minus, zero, plus;

    private static void partition(int row, int col, int size) {

        if (isSameNumber(row, col, size)) {
            if (board[row][col] == -1) {
                minus++;
            } else if (board[row][col] == 0) {
                zero++;
            } else {
                plus++;
            }

            return;
        }

        int halfSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                partition(row + (i * halfSize), col + (j * halfSize), halfSize);
            }
        }
    }

    private static boolean isSameNumber(int row, int col, int size) {

        int number = board[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (board[i][j] != number) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        partition(0, 0, n);

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }
}