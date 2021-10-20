package me.hyeonic.algorithm.baekjoon.gold5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ12851 {

    private static int n, k;
    private static int[] time = new int[100_001];

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        int count = 0;
        int minTime = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            if (current == k) {
                minTime = time[current];
                count++;
            }

            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) {
                    next = current - 1;
                } else if (i == 1) {
                    next = current + 1;
                } else {
                    next = current * 2;
                }

                if (next >= 0
                        && next <= 100_000
                        && (time[next] == 0 || time[next] == time[current] + 1)) {
                    queue.add(next);
                    time[next] = time[current] + 1;
                }
            }
        }

        System.out.println(minTime);
        System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt(); // 수빈이의 현재점
        k = scanner.nextInt(); // 동생의 현재점

        if (n == k) {
            System.out.println(0);
            System.out.println(1);
            return;
        }

        bfs();
    }
}