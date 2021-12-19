package me.hyeonic.algorithm.baekjoon.silver1;

import java.util.Scanner;

public class BOJ16953 {
    private static int a;
    private static int b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        a = scanner.nextInt();
        b = scanner.nextInt();

        int count = 0;
        while (b != 0) {
            if (b == a) {
                System.out.println(count + 1);
                return;
            }

            count++;
            if (b % 2 == 0) {
                b = b / 2;
            } else if (b % 10 == 1) {
                b = (b - 1) / 10;
            } else {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(-1);
    }
}
