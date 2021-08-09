package me.hyeonic.algorithm.baekjoon.silver2;

import java.util.Scanner;

public class BOJ1929 {

    static long[] numbers = new long[1_000_001];

    private static void primeNumberSieve() {
        for (int i = 2; i <= 1_000_000; i++) {
            numbers[i] = i;
        }

        for (int i = 2; i <= 1_000_000; i++) {
            if (numbers[i] == 0) {
                continue;
            }

            for (int j = i + i; j <= 1_000_000; j+= i) {
                numbers[j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();

        primeNumberSieve();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = m; i <= n; i++) {
            if (numbers[i] != 0) {
                stringBuilder.append(i).append("\n");
            }
        }

        System.out.println(stringBuilder);
    }
}