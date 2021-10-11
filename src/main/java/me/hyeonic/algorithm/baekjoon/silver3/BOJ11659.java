package me.hyeonic.algorithm.baekjoon.silver3;

import java.util.Scanner;

public class BOJ11659 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 배열의 개수
        int m = scanner.nextInt(); // 합을 구해야 하는 횟수

        int[] array = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            array[i] = array[i - 1] + scanner.nextInt();
        }

        while (m-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            System.out.println(array[b] - array[a - 1]);
        }
    }
}