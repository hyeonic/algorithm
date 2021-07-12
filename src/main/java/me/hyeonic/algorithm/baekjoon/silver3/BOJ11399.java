package me.hyeonic.algorithm.baekjoon.silver3;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ11399 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        Arrays.sort(array);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += array[i] * (n - i);
        }

        System.out.println(sum);
    }
}