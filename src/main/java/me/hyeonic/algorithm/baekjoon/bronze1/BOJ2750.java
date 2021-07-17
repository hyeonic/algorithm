package me.hyeonic.algorithm.baekjoon.bronze1;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2750 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers);
        Arrays.stream(numbers)
                .forEach(System.out::println);
    }
}