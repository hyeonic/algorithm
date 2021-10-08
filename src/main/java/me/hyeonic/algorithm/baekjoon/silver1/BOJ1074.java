package me.hyeonic.algorithm.baekjoon.silver1;

import java.util.Scanner;

public class BOJ1074 {

    private static int n, r, c, count;

    private static void partition(int row, int col, int size) {

        if (row == r && col == c) {
            System.out.println(count);
            return;
        }

        if (isValidScope(row, col, size)) {
            int halfSize = size / 2;
            partition(row, col, halfSize); // 2사분면
            partition(row, col + halfSize, halfSize); // 1사분면
            partition(row + halfSize, col, halfSize); // 3사분면
            partition(row + halfSize, col + halfSize, halfSize); // 4사분면
        } else {
            count += size * size;
        }
    }

    private static boolean isValidScope(int row, int col, int size) {
        if (row > r || row + size <= r || col > c || col + size <= c) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        r = scanner.nextInt();
        c = scanner.nextInt();
        int size = (int) Math.pow(2, n);

        partition(0, 0, size);
    }
}