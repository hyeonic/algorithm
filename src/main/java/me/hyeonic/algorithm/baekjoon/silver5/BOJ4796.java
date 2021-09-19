package me.hyeonic.algorithm.baekjoon.silver5;

import java.util.Scanner;

public class BOJ4796 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = 1;
        while (true) {
            int p = scanner.nextInt();
            int l = scanner.nextInt();
            int v = scanner.nextInt();

            if (p == 0 && l == 0 && v == 0) {
                break;
            }

            int sum = ((v / l) * p) + Math.min(v % l, p);
            System.out.println("Case " + count + ": " + sum);
            count++;
        }
    }
}