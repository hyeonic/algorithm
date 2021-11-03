package me.hyeonic.algorithm.baekjoon.bronze1;

import java.util.Scanner;

public class BOJ1977 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = m; i <= n; i++) {
            if (i == Math.pow((int) Math.sqrt(i), 2)) {
                sum += i;
                min = Math.min(min, i);
            }
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(sum);
        System.out.println(min);
    }
}