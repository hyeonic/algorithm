package me.hyeonic.algorithm.baekjoon.silver4;

import java.util.Scanner;

public class BOJ13305 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        long[] distance = new long[n - 1];
        long[] cost = new long[n];

        for (int i = 0; i < n - 1; i++) {
            distance[i] = scanner.nextLong();
        }

        for (int i = 0; i < n; i++) {
            cost[i] = scanner.nextLong();
        }

        long min = cost[0];
        for (int i = 1; i < n; i++) {
            if (cost[i] < min) {
                min = cost[i];
                continue;
            }

            cost[i] = min;
        }

        long result = 0;
        for (int i = 0; i < n - 1; i++) {
            result += cost[i] * distance[i];
        }

        System.out.println(result);
    }
}