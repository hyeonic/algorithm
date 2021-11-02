package me.hyeonic.algorithm.baekjoon.silver3;

import java.util.Scanner;

public class BOJ2003 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 10 <= n < 100_000
        int s = scanner.nextInt(); // 0 < S <= 300_000_000. int 표현범위 -2,147,483,648 ~ 2,147,483,647

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        int start = 0;
        int end = 0;
        int sum = array[0];
        int count = 0;
        while (true) {
            if (sum >= s) {

                if (sum == s) {
                    count++;
                }

                sum -= array[start++];
            } else {
                end++;

                if (end == n) {
                    break;
                }

                sum += array[end];
            }
        }

        System.out.println(count);
    }
}