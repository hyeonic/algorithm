package me.hyeonic.algorithm.baekjoon.silver5;

import java.util.Scanner;

public class BOJ1436 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int number = 666;
        int count = 1;

        while (count != n) {
            number++;
            if (String.valueOf(number).contains("666")) {
                count++;
            }
        }

        System.out.println(number);
    }
}
