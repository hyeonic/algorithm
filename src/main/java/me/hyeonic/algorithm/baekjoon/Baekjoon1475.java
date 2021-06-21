package me.hyeonic.algorithm.baekjoon;

import java.util.Scanner;

public class Baekjoon1475 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        int[] numbers = new int[10];

        for (int i = 0; i < number.length(); i++) {
            numbers[number.charAt(i) - '0']++;
        }

        int sum = numbers[6] + numbers[9];

        if (sum % 2 == 0) {
            numbers[6] = sum / 2;
            numbers[9] = sum / 2;
        } else {
            numbers[6] = (sum / 2) + 1;
            numbers[9] = (sum / 2) + 1;
        }

        int max = Integer.MIN_VALUE;
        for (int value : numbers) {
            max = Math.max(max, value);
        }

        System.out.println(max);
    }
}