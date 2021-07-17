package me.hyeonic.algorithm.baekjoon.silver5;

import java.util.Scanner;

public class BOJ1475 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[10];
        String roomNumber = scanner.nextLine();

        for (int i = 0; i < roomNumber.length(); i++) {
            numbers[roomNumber.charAt(i) - '0']++;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (i == 6 || i == 9) {
                max = Math.max((numbers[6] + numbers[9] + 1) / 2, max);
            } else {
                max = Math.max(numbers[i], max);
            }
        }

        System.out.println(max);
    }
}