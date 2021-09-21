package me.hyeonic.algorithm.baekjoon.silver5;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1037 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] divisors = new int[n];
        for (int i = 0; i < n; i++) {
            divisors[i] = scanner.nextInt();
        }

        Arrays.sort(divisors);

        System.out.println(divisors[0] * divisors[divisors.length - 1]);
    }
}