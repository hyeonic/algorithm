package me.hyeonic.algorithm.baekjoon.silver5;

import java.util.Scanner;

public class BOJ2435 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 온도를 측정한 전체 날짜의 수
        int k = scanner.nextInt(); // k는 합을 구하기 위한 연속적인 날짜의 수

        int[] temperatures = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            temperatures[i] = temperatures[i - 1] + scanner.nextInt();
        }

        int max = Integer.MIN_VALUE;
        for (int i = k; i <= n; i++) {
            max = Math.max(max, temperatures[i] - temperatures[i - k]);
        }

        System.out.println(max);
    }
}