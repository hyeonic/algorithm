package me.hyeonic.algorithm.baekjoon.bronze3;

import java.util.Scanner;

public class BOJ2439 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = n - i; j > 0; j--) {
                stringBuilder.append(" ");
            }

            for (int j = i; j > 0; j--) {
                stringBuilder.append("*");
            }

            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder);
    }
}