package me.hyeonic.algorithm.baekjoon.silver4;

import java.util.Scanner;

public class BOJ2960 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        boolean[] visited = new boolean[n + 1];

        int count = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                if (!visited[j]) {
                    count++;
                    visited[j] = true;
                }

                if (count == k) {
                    System.out.println(j);
                    return;
                }
            }
        }
    }
}