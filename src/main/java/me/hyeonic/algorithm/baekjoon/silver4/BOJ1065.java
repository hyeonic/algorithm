package me.hyeonic.algorithm.baekjoon.silver4;

import java.util.Scanner;

public class BOJ1065 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isArithmeticSequence(i)) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean isArithmeticSequence(int number) {
        if (number < 100) {
            return true;
        } else if (number == 1000) {
            return false;
        } else {
            int hundred = number / 100;
            int ten = (number % 100) / 10;
            int one = number % 10;

            if ((hundred - ten) == (ten - one)) {
                return true;
            }
        }

        return false;
    }
}