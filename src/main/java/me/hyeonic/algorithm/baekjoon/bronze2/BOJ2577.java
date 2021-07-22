package me.hyeonic.algorithm.baekjoon.bronze2;

import java.util.Scanner;

public class BOJ2577 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[10];

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        String mul = String.valueOf(a * b * c);
        for (int i = 0; i < mul.length(); i++) {
            numbers[mul.charAt(i) - '0']++;
        }

        for (int number : numbers) {
            System.out.println(number);
        }
    }
}