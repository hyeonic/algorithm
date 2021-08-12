package me.hyeonic.algorithm.baekjoon.bronze2;

import java.util.Scanner;

public class BOJ2798 {

    static int n, m;
    static int[] cards;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = scanner.nextInt();
        }

        System.out.println(search());
    }

    private static int search() {
        int result = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = cards[i] + cards[j] + cards[k];

                    if (m == sum) {
                        return sum;
                    }

                    if (result < sum && sum < m) {
                        result = sum;
                    }
                }
            }
        }

        return result;
    }
}