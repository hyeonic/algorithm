package me.hyeonic.algorithm.baekjoon.bronze1;

import java.util.Scanner;

public class BOJ1110 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        if (n < 10) {
            n *= 10;
        }

        int temp = n;
        int count = 0;
        while (true) {

            count++;
            temp = (temp % 10) * 10 + ((temp / 10) + (temp % 10)) % 10;

            if (n == temp) {
                break;
            }
        }

        System.out.println(count);
    }
}