package me.hyeonic.algorithm.baekjoon.silver4;

import java.util.Scanner;

public class BOJ1978 {

    private static boolean isPrimeNumber(int x) {

        if (x <= 1) {
            return false;
        }

        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int count = 0;
        for (int i = 0 ; i < n; i++) {
            if (isPrimeNumber(scanner.nextInt())) {
                count++;
            }
        }

        System.out.println(count);
    }
}

class BOJ1978v2 {

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

        int count = 0;
        for (int i = 0 ; i < n; i++) {
            if (isPrimeNumber(scanner.nextInt())) {
                count++;
            }
        }

        System.out.println(count);
    }
}