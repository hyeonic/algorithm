package me.hyeonic.algorithm.baekjoon.gold5;

import java.util.Scanner;

public class BOJ14179 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int h = scanner.nextInt();
        int w = scanner.nextInt();

        int[] graph = new int[w];

        for (int i = 0; i < w; i++) {
            graph[i] = scanner.nextInt();
        }

        int count = 0;
        for (int i = 1; i < w - 1; i++) {

            int right = 0;
            int left = 0;

            for (int j = 0; j < i; j++) {
                left = Math.max(left, graph[j]);
            }

            for (int j = i + 1; j < w; j++) {
                right = Math.max(right, graph[j]);
            }

            if (graph[i] < left && graph[i] < right) {
                count += Math.min(left, right) - graph[i];
            }
        }

        System.out.println(count);
    }
}