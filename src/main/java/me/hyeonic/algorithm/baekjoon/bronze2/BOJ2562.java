package me.hyeonic.algorithm.baekjoon.bronze2;

import java.util.Scanner;

public class BOJ2562 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int index = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= 9; i++) {
            int number = scanner.nextInt();
            if (max < number) {
                max = number;
                index = i;
            }
        }

        System.out.println(max);
        System.out.println(index);
    }
}