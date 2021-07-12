package me.hyeonic.algorithm.baekjoon.bronze1;

import java.util.Scanner;

public class BOJ2839 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 설탕 n 킬로그램

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= 1000; i++) {
            for (int j = 0; j <= 1667; j++) {
                if (n == (i * 5 + j * 3)) {
                    min = Math.min(min, i + j);
                }
            }
        }

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}