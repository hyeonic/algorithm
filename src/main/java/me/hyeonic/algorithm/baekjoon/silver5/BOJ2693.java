package me.hyeonic.algorithm.baekjoon.silver5;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2693 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int[] array = new int[10];
            for (int i = 0; i < 10; i++) {
                array[i] = scanner.nextInt();
            }

            Arrays.sort(array);

            System.out.println(array[7]);
        }
    }
}