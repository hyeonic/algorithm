package me.hyeonic.algorithm.baekjoon.bronze2;

import java.util.Scanner;

public class BOJ2231 {

    static int n;
    static int[] d = new int[1_000_001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();

        for (int i = 0; i < 1_000_000; i++) {
            if (isConstructor(i)) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);
    }

    private static boolean isConstructor(int number) {
        int sum = number;
        String[] numbers = String.valueOf(number).split("");
        for (String num : numbers) {
            sum += Integer.parseInt(num);
        }

        if (sum == n) {
            return true;
        }

        return false;
    }
}