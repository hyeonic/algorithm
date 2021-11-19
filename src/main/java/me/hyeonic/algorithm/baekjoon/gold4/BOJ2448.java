package me.hyeonic.algorithm.baekjoon.gold4;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2448 {

    private static char[][] map;

    private static void draw(int row, int col, int size) {
        if (size == 3) {
            map[row][col] = '*';

            map[row + 1][col - 1] = '*';
            map[row + 1][col + 1] = '*';

            map[row + 2][col - 2] = '*';
            map[row + 2][col - 1] = '*';
            map[row + 2][col] = '*';
            map[row + 2][col + 1] = '*';
            map[row + 2][col + 2] = '*';
            return;
        }

        int newSize = size / 2;

        // 위 삼각형
        draw(row, col, newSize);
        // 아래 왼쪽 삼각형
        draw(row + newSize, col - newSize, newSize);
        // 아래 오른쪽 삼각형
        draw(row + newSize, col + newSize, newSize);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        map = new char[n][2 * n - 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], ' ');
        }

        draw(0, n - 1, n);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                stringBuilder.append(map[i][j]);
            }
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder);
    }
}