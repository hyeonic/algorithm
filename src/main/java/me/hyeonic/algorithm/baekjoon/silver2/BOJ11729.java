package me.hyeonic.algorithm.baekjoon.silver2;

import java.util.Scanner;

public class BOJ11729 {

    private static StringBuilder stringBuilder = new StringBuilder();

    private static void hanoi(int n, int start, int mid, int to) {
        if (n == 1) {
            stringBuilder.append(start)
                    .append(" ")
                    .append(to)
                    .append("\n");

            return;
        }

        hanoi(n - 1, start, to, mid);

        stringBuilder.append(start)
                .append(" ")
                .append(to)
                .append("\n");

        hanoi(n - 1, mid, start, to);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        stringBuilder.append((int) (Math.pow(2, n) - 1)).append("\n");

        hanoi(n, 1, 2, 3);

        System.out.println(stringBuilder);
    }
}