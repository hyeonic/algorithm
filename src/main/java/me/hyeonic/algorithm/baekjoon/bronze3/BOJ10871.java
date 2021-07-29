package me.hyeonic.algorithm.baekjoon.bronze3;

import java.util.Scanner;

public class BOJ10871 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int x = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int number = scanner.nextInt();
            if (number < x) {
                System.out.print(number + " ");
            }
        }
    }
}