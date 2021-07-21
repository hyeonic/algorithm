package me.hyeonic.algorithm.baekjoon.bronze1;

import java.util.Scanner;

public class BOJ1546 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        double[] numbers = new double[n];

        double max = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
            max = Math.max(max, numbers[i]);
        }

        double sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = numbers[i] / max * 100;
            sum += numbers[i];
        }

        System.out.println(sum / n);
    }
}