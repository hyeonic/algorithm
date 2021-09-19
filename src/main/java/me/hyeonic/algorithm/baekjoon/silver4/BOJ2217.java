package me.hyeonic.algorithm.baekjoon.silver4;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2217 {

    private static int n;
    private static int[] weights;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt(); // 로프의 개수
        weights = new int[n];

        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }

        Arrays.sort(weights);

        int weight = Integer.MIN_VALUE;
        int sumWeight;
        for (int i = n - 1; i >= 0; i--) {
            sumWeight = weights[i] * (n - i);

            if (weight < sumWeight) {
                weight = sumWeight;
            }
        }

        System.out.println(weight);
    }
}