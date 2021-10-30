package me.hyeonic.algorithm.baekjoon.silver1;

import java.util.Scanner;

public class BOJ1629 {

    private static long c;

    // a^b
    private static long pow(long a, long b) {
        if (b == 1) {
            return a % c;
        }

        long half = pow(a, b / 2);

        if (b % 2 == 0) {
            return half * half % c;
        }
        return (half * half % c) * a % c;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long a = scanner.nextInt();
        long b = scanner.nextInt();
        c = scanner.nextInt();

        System.out.println(pow(a, b));
    }
}