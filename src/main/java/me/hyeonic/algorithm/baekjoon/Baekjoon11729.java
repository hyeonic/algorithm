package me.hyeonic.algorithm.baekjoon;

import java.util.Scanner;

public class Baekjoon11729 {

    private static int count;
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        hanoi(n, 1, 2, 3);
        System.out.println(stringBuilder.toString());
    }

    private static void hanoi(int n, int from, int by, int to) {
        ++count;

        if (n == 1) {
            stringBuilder.append(from + " " + to + "\n");
            return;
        }

        hanoi(n - 1, from, to, by);
        stringBuilder.append(from + " " + to + "\n");
        hanoi(n - 1, by, from, to);
    }
}