package me.hyeonic.algorithm.baekjoon.bronze3;

import java.util.Scanner;

public class BOJ2446 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for (int i = 0; i < (n * 2) - 1; i++) {
            if (i < n) {
                printBlank(i);
                printStar((n * 2) - 1 - (i * 2));
                continue;
            }

            printBlank((n * 2) - 1 - i - 1);
            printStar((n * 2) - 1 - ((n * 2) - 1 - i - 1) * 2);
        }
    }

    private static void printBlank(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(" ");
        }
    }

    private static void printStar(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
