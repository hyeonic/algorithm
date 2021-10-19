package me.hyeonic.algorithm.baekjoon.silver2;

import java.util.Scanner;

public class BOJ6603 {

    private static int k;
    private static int[] array;
    private static int[] result;

    private static void backtracking(int index, int depth) {

        if (depth == 6) {
            print();
            return;
        }

        for (int i = index; i < k; i++) {
            if (depth == 0 || array[i] > result[depth - 1]) {
                result[depth] = array[i];
                backtracking(i + 1, depth + 1);
            }
        }
    }

    private static void print() {
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while ((k = scanner.nextInt()) != 0) {

            array = new int[k];
            result = new int[6];
            for (int i = 0; i < k; i++) {
                array[i] = scanner.nextInt();
            }

            backtracking(0, 0);

            System.out.println();
        }
    }
}