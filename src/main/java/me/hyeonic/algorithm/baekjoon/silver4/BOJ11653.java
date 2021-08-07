package me.hyeonic.algorithm.baekjoon.silver4;

import java.util.Scanner;

public class BOJ11653 {

    private static boolean isPrimeNumber(int x) {

        if (x <= 1) {
            return false;
        }

        int end = (int) Math.sqrt(x);

        for (int i = 2; i <= end; i++) {
            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        while (n != 1) {
            for (int i = 2; i <= n; i++) {
                if (n % i == 0 && isPrimeNumber(i)) {
                    n /= i;
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}