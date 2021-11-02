package me.hyeonic.algorithm.baekjoon.gold4;

import java.util.Scanner;

public class BOJ1896 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 10 <= n < 100_000
        int s = scanner.nextInt(); // 0 < S <= 100_000_000. int 표현범위 -2,147,483,648 ~ 2,147,483,647

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        int start = 0;
        int end = 0;
        int sum = array[0];
        int length = Integer.MAX_VALUE;
        while (true) {

//            System.out.println("start -> " + start + " end -> " + end + " sum -> " + sum);

            if (sum >= s) {
                length = Math.min(length, end - start + 1);
                sum -= array[start++];
            } else {
                end++;

                if (end == n) {
                    break;
                }

                sum += array[end];
            }
        }

        if (length == Integer.MAX_VALUE) {
            System.out.println(0);
            return;
        }

        System.out.println(length);
    }
}