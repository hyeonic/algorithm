package me.hyeonic.algorithm.kstudy.week2;

import java.util.Scanner;

public class BOJ23827v2 {

    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        long totalNumber = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int number = scanner.nextInt();
            sum = (sum + number * totalNumber) % MOD;
            totalNumber += number;
        }

        System.out.println(sum);
    }
}
