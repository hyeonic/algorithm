package me.hyeonic.algorithm.baekjoon.bronze4;

import java.util.Scanner;

public class BOJ10162 {

    private static int t;
    private static int[] times = new int[]{60 * 5, 60, 10};
    private static int[] results = new int[3];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        t = scanner.nextInt();

        for (int i = 0; i < 3; i++) {
            results[i] += t / times[i];
            t %= times[i];
        }

        if (t != 0) {
            System.out.println(-1);
        } else {
            for (int result : results) {
                System.out.print(result + " ");
            }
        }
    }
}