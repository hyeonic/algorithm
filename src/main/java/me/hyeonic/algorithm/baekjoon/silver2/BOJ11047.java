package me.hyeonic.algorithm.baekjoon.silver2;

import java.util.Scanner;

public class BOJ11047 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 동전의 종류 n개
        int k = scanner.nextInt(); // 가치의 합
        int[] coins = new int[n]; // 동전의 가치

        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }

        int result = 0;
        for (int i = n - 1; i >= 0; i--) {
            result += k / coins[i];
            k = k % coins[i];
        }

        System.out.println(result);
    }
}