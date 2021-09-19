package me.hyeonic.algorithm.baekjoon.silver5;

import java.util.Scanner;

public class BOJ1789 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long s = scanner.nextLong();

        long count = 1;
        long sum = 1;

        while (sum < s) {
            sum += ++count;
        }

        if (sum > s) {
            count--;
        }

        System.out.println(count);
    }
}