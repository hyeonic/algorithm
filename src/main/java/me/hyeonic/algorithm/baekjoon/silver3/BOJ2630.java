package me.hyeonic.algorithm.baekjoon.silver3;

import java.util.Scanner;

public class BOJ2630 {

    private static int white, blue;
    private static int[][] board;

    private static void partition(int row, int col, int size) {

        if (isSameColor(row, col, size)) {
            if (board[row][col] == 0) {
                white++;
            } else if (board[row][col] == 1) {
                blue++;
            }
            return;
        }

        int halfSize = size / 2;
        partition(row, col + halfSize, halfSize); // 1사분면
        partition(row, col, halfSize); // 2사분면
        partition(row + halfSize, col, halfSize); // 3사분면
        partition(row + halfSize, col + halfSize, halfSize); // 4사분면
    }

    private static boolean isSameColor(int row, int col, int size) {

        int color = board[row][col]; // color 기준

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (board[i][j] != color) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        partition(0, 0, n);

        System.out.println(white);
        System.out.println(blue);
    }
}