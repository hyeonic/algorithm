package me.hyeonic.algorithm.baekjoon.silver1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1697 {

    static int n, k;
    static int[] count = new int[100_001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt(); // 수빈이의 현재점
        k = scanner.nextInt(); // 동생의 현재점

        if (n == k) {
            System.out.println(0);
        } else {
            System.out.println(bfs());
        }
    }

    private static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        count[n]++;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (int i = 0; i < 3; i++) {
                int next = 0;
                if (i == 0) {
                    next = poll - 1;
                } else if (i == 1) {
                    next = poll + 1;
                } else if (i == 2) {
                    next = poll * 2;
                }

                if (k == next) {
                    return count[poll];
                }

                if (next >= 0 && next < count.length && count[next] == 0) {
                    queue.add(next);
                    count[next] += count[poll] + 1;
                }
            }
        }

        return 0;
    }
}