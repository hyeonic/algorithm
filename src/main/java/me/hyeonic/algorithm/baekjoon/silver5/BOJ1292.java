package me.hyeonic.algorithm.baekjoon.silver5;

import java.util.Scanner;

public class BOJ1292 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = new int[1001];

        calculate(array);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(array[b] - array[a - 1]);
    }

    private static void calculate(int[] array) {
        int number = 1;
        int remainNumber = number;
        for (int i = 1; i <= 1000; i++) {
            array[i] = number + array[i - 1];
            remainNumber--;

            if (remainNumber == 0) {
                number++;
                remainNumber = number;
            }
        }
    }
}
