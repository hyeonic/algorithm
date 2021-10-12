package me.hyeonic.algorithm.baekjoon.silver3;

import java.util.Scanner;

public class BOJ11441 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            array[i] = array[i - 1] + scanner.nextInt();
        }

        StringBuilder stringBuilder = new StringBuilder();
        int m = scanner.nextInt();
        while (m-- > 0) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();

            stringBuilder.append(array[j] - array[i - 1]).append("\n");
        }

        System.out.println(stringBuilder);
    }
}