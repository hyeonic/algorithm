package me.hyeonic.algorithm.baekjoon.bronze2;

import java.util.Scanner;

public class BOJ5585 {

    private static int[] moneys = new int[]{500, 100, 50, 10, 5, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pay = scanner.nextInt(); // 지불할 돈

        int change = 1_000 - pay;

        int count = 0;
        for (int money : moneys) {
            count += change / money;
            change %= money;
        }

        System.out.println(count);
    }
}