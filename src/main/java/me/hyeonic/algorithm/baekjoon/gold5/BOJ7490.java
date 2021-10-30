package me.hyeonic.algorithm.baekjoon.gold5;

import java.util.Scanner;

public class BOJ7490 {

    private static int n;

    private static void backtracking(int depth, int sign, int num, int result, String s) {
        if (depth == n) {
            result = result + (num * sign);
            if (result == 0) {
                System.out.println(s);
            }
            return;
        }

        backtracking(depth + 1, sign, (num * 10) + (depth + 1), result, s + " " + (depth + 1));
        backtracking(depth + 1, 1, depth + 1, result + (num * sign), s + "+" + (depth + 1));
        backtracking(depth + 1, -1, depth + 1, result + (num * sign), s + "-" + (depth + 1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();

            backtracking(1, 1, 1, 0, "1");

            System.out.println();
        }
    }
}