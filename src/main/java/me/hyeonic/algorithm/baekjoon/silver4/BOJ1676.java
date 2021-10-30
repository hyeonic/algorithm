package me.hyeonic.algorithm.baekjoon.silver4;

import java.util.Scanner;

public class BOJ1676 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        int count = 0;
        while (num >= 5) {
            count += num / 5;
            num /= 5;
        }

        System.out.println(count);
    }
}