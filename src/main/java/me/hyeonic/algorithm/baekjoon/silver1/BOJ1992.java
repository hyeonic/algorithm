package me.hyeonic.algorithm.baekjoon.silver1;

import java.util.Scanner;

public class BOJ1992 {

    private static int n;
    private static int[][] image;
    private static StringBuilder stringBuilder = new StringBuilder();

    private static void quadTree(int row, int col, int size) {

        // 압축 가능한 경우 하나의 색으로 압축
        if (isSameColor(row, col, size)) {
            stringBuilder.append(image[row][col]);
            return;
        }

        int newSize = size / 2;

        stringBuilder.append("(");

        quadTree(row, col, newSize);
        quadTree(row, col + newSize, newSize);
        quadTree(row + newSize, col, newSize);
        quadTree(row + newSize, col + newSize, newSize);

        stringBuilder.append(")");
    }

    private static boolean isSameColor(int row, int col, int size) {
        int value = image[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (image[i][j] != value) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        image = new int[n][n];

        for (int i = 0; i < n; i++) {
            String string = scanner.next();
            for (int j = 0; j < n; j++) {
                image[i][j] = string.charAt(j) - '0';
            }
        }

        quadTree(0, 0, n);

        System.out.println(stringBuilder);
    }
}